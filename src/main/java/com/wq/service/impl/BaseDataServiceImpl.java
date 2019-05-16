package com.wq.service.impl;

import com.wq.entity.Class;
import com.wq.entity.Department;
import com.wq.entity.Major;
import com.wq.entity.Teacher;
import com.wq.mapper.ClassMapper;
import com.wq.mapper.DepartmentMapper;
import com.wq.mapper.MajorMapper;
import com.wq.mapper.TeacherMapper;
import com.wq.service.BaseDataService;
import com.wq.service.TeacherService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * Created by dengweiping on 2019/5/16.
 */
@Service("baseDataService")
public class BaseDataServiceImpl implements BaseDataService {
    @Resource
    private DepartmentMapper departmentMapper;
    @Resource
    private MajorMapper majorMapper;
    @Resource
    private ClassMapper classMapper;

    @Override
    public int updateDepartment(Department department) {
        return departmentMapper.updateByPrimaryKey(department);
    }

    @Override
    public int addDepartment(Department department) {
        department.setPkid(UUID.randomUUID().toString());
        return departmentMapper.insert(department);
    }

    @Override
    public int deleteDepartment(String[] pkids) {
        String[] majorPkids = majorMapper.selectMajorKeysByDepartmentKeys(pkids);//根据学院ID查询专业ID
        if (majorPkids.length > 0) {
            deleteMajor(majorPkids);//删除学院时同时删除该学院下面的专业
        }
        return departmentMapper.deleteByPrimaryKey(pkids);
    }

    @Override
    public int updateMajor(Major major) {
        return majorMapper.updateByPrimaryKey(major);
    }

    @Override
    public int addMajor(Major major) {
        major.setPkid(UUID.randomUUID().toString());
        return majorMapper.insert(major);
    }

    @Override
    public int deleteMajor(String[] pkids) {
        String[] classPkids = classMapper.selectClassKeysByMajorKeys(pkids);//根据专业ID查询班级ID
        if (classPkids.length > 0) {
            deleteClass(classPkids);//删除专业时同时删除该班级下面的班级
        }
        return majorMapper.deleteByPrimaryKey(pkids);
    }

    @Override
    public int updateClass(Class cls) {
        return classMapper.updateByPrimaryKey(cls);
    }

    @Override
    public int addClass(Class cls) {
        cls.setPkid(UUID.randomUUID().toString());
        return classMapper.insert(cls);
    }

    @Override
    public int deleteClass(String[] pkids) {
        return classMapper.deleteByPrimaryKey(pkids);
    }
}
