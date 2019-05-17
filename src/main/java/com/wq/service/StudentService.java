package com.wq.service;

import com.wq.entity.Student;

import java.util.List;
import java.util.Map;

public interface StudentService {

    /**
     * 获取学院列表
     */
    List<Map<String, Object>> getDepartmentList();

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
    int deleteStudent(String[] pkids);

    /*
    　　* @Description 获取专业列表
    　　* @param [departmentKey]
    　　* @return java.util.List<java.util.Map<java.lang.String,java.lang.Object>>
    　　* @throws
    　　* @author dengweiping
    　　* @date 2019/5/17 13:48
    　　*/
    List<Map<String, Object>> getMajorList(String departmentKey);

    /*
    　　* @Description 获取班级列表
    　　* @param [majorKey]
    　　* @return java.util.List<java.util.Map<java.lang.String,java.lang.Object>>
    　　* @throws
    　　* @author dengweiping
    　　* @date 2019/5/17 13:48
    　　*/
    List<Map<String, Object>> getClassList(String majorKey);

    /*
    　　* @Description 获取学生列表
    　　* @param [classKey]
    　　* @return java.util.List<java.util.Map<java.lang.String,java.lang.Object>>
    　　* @throws
    　　* @author dengweiping
    　　* @date 2019/5/17 13:48
    　　*/
    List<Map<String, Object>> getStudentList(String classKey);
}
