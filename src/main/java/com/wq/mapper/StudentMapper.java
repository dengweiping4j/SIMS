package com.wq.mapper;

import com.wq.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("studentMapper")
public interface StudentMapper {

    int deleteByPrimaryKey(String[] pkid);

    /**
     * 添加学生
     *
     * @param student
     * @return
     */
    int insert(Student student);

    int insertSelective(Student student);

    int updateByPrimaryKeySelective(Student student);

    List<Map<String, Object>> getDepartmentList();

    List<Map<String, Object>> getMajorList(String departmentKey);

    List<Map<String, Object>> getClassList(String majorKey);

    List<Map<String,Object>> getStudentList(String classKey);
}