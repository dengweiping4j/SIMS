package com.wq.service.impl;

import com.wq.entity.User;
import com.wq.mapper.UserMapper;
import com.wq.service.UserService;
import com.wq.util.AntiXssUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User login(User user) {
        return userMapper.login(user);
    }

    @Override
    public List<User> findUser(Map<String, Object> map) {
        return userMapper.findUsers(map);
    }

    @Override
    public int updateUser(User user) {
        //防止有人胡乱修改导致其他人无法正常登陆
        if ("controller".equals(user.getUserName())) {
            return 0;
        }
        user.setUserName(AntiXssUtil.replaceHtmlCode(user.getUserName()));
        return userMapper.updateUser(user);
    }

    @Override
    public Long getTotalUser(Map<String, Object> map) {
        return userMapper.getTotalUser(map);
    }

    @Override
    public int addUser(User user) {
        if (user.getUserName() == null || user.getPassword() == null || getTotalUser(null) > 90) {
            return 0;
        }
        user.setUserName(AntiXssUtil.replaceHtmlCode(user.getUserName()));
        return userMapper.addUser(user);
    }

    @Override
    public int deleteUser(Integer id) {
        //防止有人胡乱修改导致其他人无法正常登陆
        if (2 == id) {
            return 0;
        }
        return userMapper.deleteUser(id);
    }

}
