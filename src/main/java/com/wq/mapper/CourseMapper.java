package com.wq.mapper;

import com.wq.entity.Course;
import org.springframework.stereotype.Repository;

@Repository("courseMapper")
public interface CourseMapper {
    int insert(Course record);

    int insertSelective(Course record);
}