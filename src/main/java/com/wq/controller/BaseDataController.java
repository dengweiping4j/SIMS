package com.wq.controller;

import com.wq.common.Result;
import com.wq.common.ResultGenerator;
import com.wq.entity.Class;
import com.wq.entity.Department;
import com.wq.entity.Major;
import com.wq.service.BaseDataService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**Ø
 * 教师信息管理Controller类
 */
@Controller
@RequestMapping("/baseData")
public class BaseDataController {

    @Resource
    private BaseDataService baseDataService;

    /**
     * 添加学院信息
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "addDepartment", method = RequestMethod.POST)
    @ResponseBody
    public Result addDepartment(@RequestBody Department department) throws Exception {
        int resultTotal;
        resultTotal = baseDataService.addDepartment(department);
        if (resultTotal > 0) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult("FAIL");
        }
    }

    /**
     * 修改学院信息
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "updateDepartment", method = RequestMethod.POST)
    @ResponseBody
    public Result updateDepartment(@RequestBody Department department) throws Exception {
        int resultTotal;
        resultTotal = baseDataService.updateDepartment(department);
        if (resultTotal > 0) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult("FAIL");
        }
    }

    /**
     * 删除学院信息
     *
     * @param pkids
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/deleteDepartment/{pkids}", method = RequestMethod.DELETE)
    @ResponseBody
    public Result deleteDepartment(@PathVariable(value = "pkids") String pkids) throws Exception {
        String[] pkidArr = pkids.split(",");
        baseDataService.deleteDepartment(pkidArr);
        return ResultGenerator.genSuccessResult();
    }

    /**
     * 添加专业信息
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "addMajor", method = RequestMethod.POST)
    @ResponseBody
    public Result addMajor(@RequestBody Major major) throws Exception {
        int resultTotal;
        resultTotal = baseDataService.addMajor(major);
        if (resultTotal > 0) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult("FAIL");
        }
    }

    /**
     * 修改专业信息
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "updateMajor", method = RequestMethod.POST)
    @ResponseBody
    public Result updateMajor(@RequestBody Major major) throws Exception {
        int resultTotal;
        resultTotal = baseDataService.updateMajor(major);
        if (resultTotal > 0) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult("FAIL");
        }
    }

    /**
     * 删除专业信息
     *
     * @param pkids
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/deleteMajor/{pkids}", method = RequestMethod.DELETE)
    @ResponseBody
    public Result deleteMajor(@PathVariable(value = "pkids") String pkids) throws Exception {
        String[] pkidArr = pkids.split(",");
        baseDataService.deleteMajor(pkidArr);
        return ResultGenerator.genSuccessResult();
    }

    /**
     * 添加班级信息
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "addClass", method = RequestMethod.POST)
    @ResponseBody
    public Result addClass(@RequestBody Class cls) throws Exception {
        int resultTotal;
        resultTotal = baseDataService.addClass(cls);
        if (resultTotal > 0) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult("FAIL");
        }
    }

    /**
     * 修改班级信息
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "updateClass", method = RequestMethod.POST)
    @ResponseBody
    public Result updateClass(@RequestBody Class cls) throws Exception {
        int resultTotal;
        resultTotal = baseDataService.updateClass(cls);
        if (resultTotal > 0) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult("FAIL");
        }
    }

    /**
     * 删除班级信息
     *
     * @param pkids
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/deleteClass/{pkids}", method = RequestMethod.DELETE)
    @ResponseBody
    public Result deleteClass(@PathVariable(value = "pkids") String pkids) throws Exception {
        String[] pkidArr = pkids.split(",");
        baseDataService.deleteClass(pkidArr);
        return ResultGenerator.genSuccessResult();
    }

}
