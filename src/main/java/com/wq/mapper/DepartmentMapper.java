package com.wq.mapper;

import com.wq.entity.Department;
import org.springframework.stereotype.Repository;

@Repository("departmentMapper")
public interface DepartmentMapper {

    int deleteByPrimaryKey(String[] pkids);

    int insert(Department record);

    int insertSelective(Department record);

    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);
}