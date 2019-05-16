package com.wq.mapper;

import com.wq.entity.Teacher;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("teacherMapper")
public interface TeacherMapper {

    int insert(Teacher teacher);

    int update(Teacher teacher);

    int deleteByPrimaryKey(String[] pkids);

    List<Map<String,Object>> getTeacherList();
}