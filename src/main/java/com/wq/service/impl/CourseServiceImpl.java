package com.wq.service.impl;

import com.wq.entity.Course;
import com.wq.mapper.CourseMapper;
import com.wq.service.CourseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by dengweiping on 2019/5/16.
 */
@Service("courseService")
public class CourseServiceImpl implements CourseService {
    @Resource
    private CourseMapper courseMapper;

    @Override
    public int updateCourse(Course course) {
        return courseMapper.update(course);
    }

    @Override
    public int addCourse(Course course) {
        course.setPkid(UUID.randomUUID().toString());
        return courseMapper.insert(course);
    }

    @Override
    public int delete(String[] pkids) {
        return courseMapper.deleteByPrimaryKey(pkids);
    }

    @Override
    public List<Map<String, Object>> getCourseList(String classKey) {
        return courseMapper.getCourseList(classKey);
    }
}
