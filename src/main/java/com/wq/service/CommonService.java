package com.wq.service;

import com.wq.entity.User;

import java.util.List;
import java.util.Map;

/**
 * @author dengweiping
 * @Description 公共service接口
 * @date 2019/5/15 15:16
 */
public interface CommonService<T> {

    /*
    　　* @Description 查询单条数据
    　　* @param [map]
    　　* @return java.util.List<T>
    　　* @throws
    　　* @author dengweiping
    　　* @date 2019/5/15 15:18
    　　*/
    public List<T> find(Map<String, Object> map);

    /*
    　　* @Description 公共修改方法
    　　* @param [map]
    　　* @return int
    　　* @throws
    　　* @author dengweiping
    　　* @date 2019/5/15 15:18
    　　*/
    public int update(Map<String, Object> map);

    /*
    　　* @Description 公共新增方法
    　　* @param
    　　* @return
    　　* @throws
    　　* @author dengweiping
    　　* @date 2019/5/15 15:19
    　　*/
    public int addSave(Map<String, Object> map);

    /*
    　　* @Description 公共批量删除方法
    　　* @param [pkids]
    　　* @return int
    　　* @throws
    　　* @author dengweiping
    　　* @date 2019/5/15 15:20
    　　*/
    public int delete(String[] pkids);
}
