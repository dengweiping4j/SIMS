package com.wq.mapper;

import com.wq.entity.Course;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("courseMapper")
public interface CourseMapper {
    int insert(Course course);

    int insertSelective(Course course);

    int update(Course course);

    int deleteByPrimaryKey(String[] pkids);

    List<Map<String,Object>> getCourseList(String classKey);
}