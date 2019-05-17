package com.wq.service;

import com.wq.entity.Course;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

public interface CourseService {

    int updateCourse(Course course);

    int addCourse(Course course);

    int delete(String[] pkids);

    /*
    　　* @Description 获取课程列表
    　　* @param [classKey]
    　　* @return java.util.List<java.util.Map<java.lang.String,java.lang.Object>>
    　　* @throws
    　　* @author dengweiping
    　　* @date 2019/5/17 13:49
    　　*/
    List<Map<String, Object>> getCourseList(String classKey);

}
