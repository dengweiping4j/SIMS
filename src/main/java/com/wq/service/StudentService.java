package com.wq.service;

import com.wq.entity.Student;

import java.util.List;
import java.util.Map;

public interface StudentService {

    /**
     * @param map
     * @return
     */
    public List<Student> findStudent(Map<String, Object> map);

    /**
     * 获取学院列表
     */
    public List<Map<String, Object>> getDepartmentList();

    /**
     * @param map
     * @return
     */
    public Long getTotalStudent(Map<String, Object> map);

    /**
     * @param student
     * @return
     */
    public int updateStudent(Student student);

    /**
     * @param student
     * @return
     */
    public int addStudent(Student student);

    /**
     * @param pkid
     * @return
     */
    public int deleteStudent(Integer pkid);

    List<Map<String,Object>> getMajorList(String departmentKey);

    List<Map<String,Object>> getClassList(String majorKey);
}
