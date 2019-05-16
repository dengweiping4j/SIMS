package com.wq.service;

import com.wq.entity.Teacher;
import org.springframework.stereotype.Service;

@Service("teacherService")
public interface TeacherService {

    int updateTeacher(Teacher teacher);

    int addTeacher(Teacher teacher);

    int delete(String[] pkids);

}
