package com.wq.service;

import com.wq.entity.Class;
import com.wq.entity.Department;
import com.wq.entity.Major;
import com.wq.entity.Teacher;
import org.springframework.stereotype.Service;

@Service("teacherService")
public interface BaseDataService {

    int updateDepartment(Department department);

    int addDepartment(Department department);

    int deleteDepartment(String[] pkids);

    int updateMajor(Major major);

    int addMajor(Major major);

    int deleteMajor(String[] pkids);

    int updateClass(Class cls);

    int addClass(Class cls);

    int deleteClass(String[] pkids);

}
