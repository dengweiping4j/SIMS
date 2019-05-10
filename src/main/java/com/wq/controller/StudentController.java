package com.wq.controller;

import com.wq.common.Result;
import com.wq.common.ResultGenerator;
import com.wq.entity.PageBean;
import com.wq.entity.Student;
import com.wq.service.StudentService;
import com.wq.util.DataGridUtil;
import com.wq.util.ResponseUtil;
import com.wq.util.StringUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.collections.map.HashedMap;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 学生信息管理Controller类
 */
@Controller
@RequestMapping("/student")
public class StudentController {

    @Resource
    private StudentService studentService;
    @Autowired
    private DataGridUtil dataGridUtil;
    private static final Logger log = Logger.getLogger(StudentController.class);// 日志文件

    /**
     * @param page
     * @param rows
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/datagrid", method = RequestMethod.POST)
    public String list(@RequestParam(value = "page", required = false) String page,
                       @RequestParam(value = "rows", required = false) String rows,
                       HttpServletResponse response) throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("where", "1");
        map.put("page", page);
        map.put("size", rows);
        map.put("table", "student");
        dataGridUtil.selectDataGrid(response, map);
        return null;
    }

    /**
     * 获取学院列表Controller
     */
    @RequestMapping(value = "/getDepartmentList", method = RequestMethod.POST)
    @ResponseBody
    public JSONArray getDepartmentList() {
        List<Map<String, Object>> list = studentService.getDepartmentList();
        if (list.size() > 0) {
            JSONArray jsonArray = JSONArray.fromObject(list);
            return jsonArray;
        }
        return null;
    }

    /**
     * 获取专业列表Controller
     */
    @RequestMapping(value = "/getMajorList", method = RequestMethod.POST)
    @ResponseBody
    public JSONArray getMajorList(String departmentKey) {
        List<Map<String, Object>> list = studentService.getMajorList(departmentKey);
        Map<String, Object> map = new HashedMap();
        map.put("value", "");
        map.put("text", "请选择...");
        list.add(map);
        if (list.size() > 0) {
            JSONArray jsonArray = JSONArray.fromObject(list);
            return jsonArray;
        }
        return null;
    }

    /**
     * 获取班级列表Controller
     */
    @RequestMapping(value = "/getClassList", method = RequestMethod.POST)
    @ResponseBody
    public JSONArray getClassList(String majorKey) {
        List<Map<String, Object>> list = studentService.getClassList(majorKey);
        Map<String, Object> map = new HashedMap();
        map.put("value", "");
        map.put("text", "请选择...");
        list.add(map);
        if (list.size() > 0) {
            JSONArray jsonArray = JSONArray.fromObject(list);
            return jsonArray;
        }
        return null;
    }

    /**
     * 添加或修改学生信息
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public Result save(@RequestBody Student student) throws Exception {
        int resultTotal = 0;
        resultTotal = studentService.addStudent(student);
        if (resultTotal > 0) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult("FAIL");
        }
    }

    /**
     * 修改
     *
     * @param student
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "", method = RequestMethod.PUT)
    @ResponseBody
    public Result update(@RequestBody Student student) throws Exception {
        int resultTotal = studentService.updateStudent(student);
        if (resultTotal > 0) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult("FAIL");
        }
    }

    /**
     * 删除
     *
     * @param ids
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/{ids}", method = RequestMethod.DELETE)
    @ResponseBody
    public Result delete(@PathVariable(value = "ids") String ids) throws Exception {
        if (ids.length() > 20) {
            return ResultGenerator.genFailResult("ERROR");
        }
        String[] idsStr = ids.split(",");
        for (int i = 0; i < idsStr.length; i++) {
            studentService.deleteStudent(Integer.valueOf(idsStr[i]));
        }
        log.info("request: article/delete , ids: " + ids);
        return ResultGenerator.genSuccessResult();
    }
}
