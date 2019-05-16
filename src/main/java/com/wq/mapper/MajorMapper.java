package com.wq.mapper;

import com.wq.entity.Major;
import org.springframework.stereotype.Repository;

@Repository("majorMapper")
public interface MajorMapper {

    int deleteByPrimaryKey(String[] pkids);

    int insert(Major record);

    int insertSelective(Major record);

    int updateByPrimaryKeySelective(Major record);

    int updateByPrimaryKey(Major record);

    String[] selectMajorKeysByDepartmentKeys(String[] departmentKeys);
}