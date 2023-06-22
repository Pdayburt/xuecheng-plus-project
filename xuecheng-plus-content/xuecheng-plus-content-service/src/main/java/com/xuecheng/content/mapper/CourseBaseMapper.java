package com.xuecheng.content.mapper;

import com.xuecheng.content.model.po.CourseBase;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author anatkh
* @description 针对表【course_base(课程基本信息)】的数据库操作Mapper
* @createDate 2023-06-22 01:13:48
* @Entity com.xuecheng.content.model.po.CourseBase
*/
@Mapper
public interface CourseBaseMapper extends BaseMapper<CourseBase> {

}




