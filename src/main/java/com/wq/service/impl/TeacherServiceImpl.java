package com.wq.service.impl;

import com.wq.entity.Teacher;
import com.wq.mapper.TeacherMapper;
import com.wq.service.TeacherService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * Created by dengweiping on 2019/5/16.
 */
@Service("teacherService")
public class TeacherServiceImpl implements TeacherService {
    @Resource
    private TeacherMapper teacherMapper;

    @Override
    public int updateTeacher(Teacher teacher) {
        return teacherMapper.update(teacher);
    }

    @Override
    public int addTeacher(Teacher teacher) {
        teacher.setPkid(UUID.randomUUID().toString());
        return teacherMapper.insert(teacher);
    }

    @Override
    public int delete(String[] pkids) {
        return teacherMapper.deleteByPrimaryKey(pkids);
    }
}
