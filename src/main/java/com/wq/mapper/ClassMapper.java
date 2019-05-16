package com.wq.mapper;

import com.wq.entity.Class;
import org.springframework.stereotype.Repository;

@Repository("classMapper")
public interface ClassMapper {
    int deleteByPrimaryKey(String[] pkids);

    int insert(Class record);

    int insertSelective(Class record);


    int updateByPrimaryKeySelective(Class record);

    int updateByPrimaryKey(Class record);

    String[] selectClassKeysByMajorKeys(String[] majorKeys);
}