package com.xuecheng;

import com.xuecheng.base.model.PageParams;
import com.xuecheng.base.model.PageResult;
import com.xuecheng.content.mapper.CourseBaseMapper;
import com.xuecheng.content.model.dto.QueryCourseParamsDto;
import com.xuecheng.content.model.po.CourseBase;
import com.xuecheng.content.service.CourseBaseService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = ContentApplication.class)
public class ServiceTest {

    @Autowired
    private CourseBaseMapper courseBaseMapper;
    @Autowired
    private CourseBaseService courseBaseService;
    @Test
    public void test(){
        CourseBase courseBase = courseBaseMapper.selectById(2);
        Assertions.assertNotNull(courseBase);
    }
    @Test
    public void testCourseBase(){
        PageResult<CourseBase> courseBasePageResult = courseBaseService.queryCourseBaseList(new PageParams(),
                new QueryCourseParamsDto());
        System.out.println(courseBasePageResult);
    }
}
