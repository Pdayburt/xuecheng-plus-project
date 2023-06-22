package com.xuecheng.content.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xuecheng.base.model.PageParams;
import com.xuecheng.base.model.PageResult;
import com.xuecheng.content.model.dto.QueryCourseParamsDto;
import com.xuecheng.content.model.po.CourseBase;
import com.xuecheng.content.service.CourseBaseService;
import com.xuecheng.content.mapper.CourseBaseMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author anatkh
* @description 针对表【course_base(课程基本信息)】的数据库操作Service实现
* @createDate 2023-06-22 01:13:48
*/
@Slf4j
@Service
public class CourseBaseServiceImpl extends ServiceImpl<CourseBaseMapper, CourseBase>
    implements CourseBaseService {

    @Autowired
    private CourseBaseMapper courseBaseMapper;

    @Override
    public PageResult<CourseBase> queryCourseBaseList(PageParams pageParams, QueryCourseParamsDto queryCourseParamsDto) {

        LambdaQueryWrapper<CourseBase> courseBaseLambdaQueryWrapper = new LambdaQueryWrapper<>();
        courseBaseLambdaQueryWrapper
                .like(StrUtil.isNotBlank(queryCourseParamsDto.getCourseName()),
                CourseBase::getName,queryCourseParamsDto.getCourseName())
                .eq(StrUtil.isNotBlank(queryCourseParamsDto.getAuditStatus()),
                        CourseBase::getAuditStatus,queryCourseParamsDto.getAuditStatus())
                .eq(StrUtil.isNotBlank(queryCourseParamsDto.getPublishStatus()),
                        CourseBase::getStatus,queryCourseParamsDto.getPublishStatus());
        Page<CourseBase> page = new Page<>(pageParams.getPageNo(), pageParams.getPageSize());

        Page<CourseBase> courseBasePage = courseBaseMapper.selectPage(page, courseBaseLambdaQueryWrapper);

        return new PageResult<>(courseBasePage.getRecords(),courseBasePage.getTotal(),
                courseBasePage.getCurrent(),courseBasePage.getSize());

    }
}




