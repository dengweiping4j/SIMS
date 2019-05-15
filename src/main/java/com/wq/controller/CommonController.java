package com.wq.controller;

import com.wq.common.Result;
import com.wq.common.ResultGenerator;
import com.wq.entity.User;
import com.wq.util.DataGridUtil;
import com.wq.util.MD5Util;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * 学生信息管理Controller类
 */
@Controller
@RequestMapping("/common")
public class CommonController {

    @Autowired
    private DataGridUtil dataGridUtil;
    private static final Logger log = Logger.getLogger(CommonController.class);// 日志文件

    /**
     * @param page
     * @param rows
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/dataGrid", method = RequestMethod.POST)
    public String list(@RequestParam(value = "page", required = false) String page, @RequestParam(value = "rows", required = false) String rows,
                       @RequestParam(value = "table") String table, HttpServletResponse response) throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("where", "1");
        map.put("page", page);
        map.put("size", rows);
        map.put("table", table);
        dataGridUtil.selectDataGrid(response, map);
        return null;
    }

    /*
    　　* @Description 公共添加方法
    　　* @param [dataMap]
    　　* @return com.wq.common.Result
    　　* @throws
    　　* @author dengweiping
    　　* @date 2019/5/15 15:13
    　　*/
    @RequestMapping(value = "addSave", method = RequestMethod.POST)
    @ResponseBody
    public Result save(@RequestBody Map<String, Object> dataMap) throws Exception {
        int resultTotal = 0;
        if (resultTotal > 0) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult("FAIL");
        }
    }

}
