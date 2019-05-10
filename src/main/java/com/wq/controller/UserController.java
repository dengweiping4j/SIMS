package com.wq.controller;

import com.wq.common.Result;
import com.wq.common.ResultGenerator;
import com.wq.entity.PageBean;
import com.wq.entity.User;
import com.wq.service.UserService;
import com.wq.util.MD5Util;
import com.wq.util.ResponseUtil;
import com.wq.util.StringUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
　　* @Description 用户管理Controller类
　　* @author dengweiping
　　* @date 2019/5/10 10:32
　　*/
@Controller
@RequestMapping("/users")
public class UserController {

    @Resource
    private UserService userService;
    private static final Logger log = Logger.getLogger(UserController.class);// 日志文件

    /*
    　　* @Description 登录
    　　* @param [user]
    　　* @return com.wq.common.Result
    　　* @throws
    　　* @author dengweiping
    　　* @date 2019/5/10 10:32
    　　*/
    @RequestMapping(value = "/cookie", method = RequestMethod.POST)
    @ResponseBody
    public Result login(User user) {
        try {
            String MD5pwd = MD5Util.MD5Encode(user.getPassword(), "UTF-8");
            user.setPassword(MD5pwd);
        } catch (Exception e) {
            user.setPassword("");
        }
        User resultUser = userService.login(user);
        log.info("request: user/login , user: " + user.toString());
        if (resultUser == null) {
            return ResultGenerator.genFailResult("账号或密码错误,请重新登录！");
        } else {
            resultUser.setPassword("PASSWORD");
            Map data = new HashMap();
            data.put("currentUser", resultUser);
            return ResultGenerator.genSuccessResult(data);
        }
    }

    /*
    　　* @Description 用户列表查询
    　　* @param [page, rows, s_user, response]
    　　* @return java.lang.String
    　　* @throws
    　　* @author dengweiping
    　　* @date 2019/5/10 10:33
    　　*/
    @RequestMapping(value = "/datagrid", method = RequestMethod.POST)
    public String list(@RequestParam(value = "page", required = false) String page,
                       @RequestParam(value = "rows", required = false) String rows, User s_user, HttpServletResponse response) throws Exception {
        PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
        Map<String, Object> map = new HashMap<>();
        map.put("userName", StringUtil.formatLike(s_user.getUserName()));
        map.put("start", pageBean.getStart());
        map.put("size", pageBean.getPageSize());
        List<User> userList = userService.findUser(map);
        Long total = userService.getTotalUser(map);
        JSONObject result = new JSONObject();
        JSONArray jsonArray = JSONArray.fromObject(userList);
        result.put("rows", jsonArray);
        result.put("total", total);
        log.info("request: user/list , map: " + map.toString());
        ResponseUtil.write(response, result);
        return null;
    }

    /*
    　　* @Description 添加用户
    　　* @param [user]
    　　* @return com.wq.common.Result
    　　* @throws
    　　* @author dengweiping
    　　* @date 2019/5/10 10:34
    　　*/
    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public Result save(@RequestBody User user) throws Exception {
        int resultTotal = 0;
        String MD5pwd = MD5Util.MD5Encode(user.getPassword(), "UTF-8");
        user.setPassword(MD5pwd);
        resultTotal = userService.addUser(user);
        if (resultTotal > 0) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult("FAIL");
        }
    }

    /*
    　　* @Description 修改用户
    　　* @param [user]
    　　* @return com.wq.common.Result
    　　* @throws
    　　* @author dengweiping
    　　* @date 2019/5/10 10:34
    　　*/
    @RequestMapping(value = "", method = RequestMethod.PUT)
    @ResponseBody
    public Result update(@RequestBody User user) throws Exception {
        String MD5pwd = MD5Util.MD5Encode(user.getPassword(), "UTF-8");
        user.setPassword(MD5pwd);
        int resultTotal = userService.updateUser(user);
        log.info("request: user/update , user: " + user.toString());
        if (resultTotal > 0) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult("FAIL");
        }
    }

    /*
    　　* @Description 删除用户
    　　* @param [ids]
    　　* @return com.wq.common.Result
    　　* @throws
    　　* @author dengweiping
    　　* @date 2019/5/10 10:34
    　　*/
    @RequestMapping(value = "/{ids}", method = RequestMethod.DELETE)
    @ResponseBody
    public Result delete(@PathVariable(value = "ids") String ids) throws Exception {
        if (ids.length() > 20) {
            return ResultGenerator.genFailResult("ERROR");
        }
        String[] idsStr = ids.split(",");
        for (int i = 0; i < idsStr.length; i++) {
            userService.deleteUser(Integer.valueOf(idsStr[i]));
        }
        log.info("request: article/delete , ids: " + ids);
        return ResultGenerator.genSuccessResult();
    }
}
