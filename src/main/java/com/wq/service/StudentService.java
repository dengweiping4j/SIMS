package com.wq.service;

import com.wq.entity.Student;

import java.util.List;
import java.util.Map;

public interface StudentService {

    /**
     * @param map
     * @return
     */
    List<Student> findStudent(Map<String, Object> map);

    /**
     * 获取学院列表
     */
    List<Map<String, Object>> getDepartmentList();

    /**
     * @param map
     * @return
     */
    Long getTotalStudent(Map<String, Object> map);

    /**
     * @param student
     * @return
     */
    int updateStudent(Student student);

    /**
     * @param student
     * @return
     */
    int addStudent(Student student);

    /*
    　　* @Description 删除学生
    　　* @param pkids
    　　* @return int
    　　* @throws
    　　* @author dengweiping
    　　* @date 2019/5/11 16:18
    　　*/
    int deleteStudent(String pkids);

    List<Map<String, Object>> getMajorList(String departmentKey);

    List<Map<String, Object>> getClassList(String majorKey);
}
