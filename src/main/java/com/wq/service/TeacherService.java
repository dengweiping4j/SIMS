package com.wq.service;

import com.wq.entity.Teacher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("teacherService")
public interface TeacherService {

    int updateTeacher(Teacher teacher);

    int addTeacher(Teacher teacher);

    int delete(String[] pkids);

    /**
     * 获取学院列表
     */
    List<Map<String, Object>> getTeacherList();

}
