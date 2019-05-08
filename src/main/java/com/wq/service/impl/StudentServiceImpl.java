package com.wq.service.impl;

import com.wq.entity.Student;
import com.wq.mapper.StudentMapper;
import com.wq.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service("studentService")
public class StudentServiceImpl implements StudentService {
    @Resource
    private StudentMapper studentMapper;

    @Override
    public List<Student> findStudent(Map<String, Object> map) {
        return studentMapper.findStudent(map);
    }

    @Override
    public Long getTotalStudent(Map<String, Object> map) {
        return studentMapper.getTotalStudent(map);
    }

    @Override
    public int updateStudent(Student student) {
        return 0;
    }

    @Override
    public int addStudent(Student student) {
       return studentMapper.insert(student);
    }

    @Override
    public int deleteStudent(Integer pkid) {
        return 0;
    }
}
