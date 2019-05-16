package com.wq.controller;

import com.wq.common.Result;
import com.wq.common.ResultGenerator;
import com.wq.entity.Student;
import com.wq.entity.Teacher;
import com.wq.service.StudentService;
import com.wq.service.TeacherService;
import net.sf.json.JSONArray;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 教师信息管理Controller类
 */
@Controller
@RequestMapping("/teacher")
public class TeacherController {

    @Resource
    private TeacherService teacherService;

    /**
     * 添加教师信息
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "addSave", method = RequestMethod.POST)
    @ResponseBody
    public Result addSave(@RequestBody Teacher teacher) throws Exception {
        int resultTotal;
        resultTotal = teacherService.addTeacher(teacher);
        if (resultTotal > 0) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult("FAIL");
        }
    }

    /**
     * 修改教师信息
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "updateSave", method = RequestMethod.POST)
    @ResponseBody
    public Result updateSave(@RequestBody Teacher teacher) throws Exception {
        int resultTotal;
        resultTotal = teacherService.updateTeacher(teacher);
        if (resultTotal > 0) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult("FAIL");
        }
    }

    /**
     * 删除
     *
     * @param pkids
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/delete/{pkids}", method = RequestMethod.DELETE)
    @ResponseBody
    public Result delete(@PathVariable(value = "pkids") String pkids) throws Exception {
        String[] pkidArr = pkids.split(",");
        teacherService.delete(pkidArr);
        return ResultGenerator.genSuccessResult();
    }
}
