package com.wq.controller;

import com.wq.common.Result;
import com.wq.common.ResultGenerator;
import com.wq.entity.Course;
import com.wq.entity.Teacher;
import com.wq.service.CourseService;
import com.wq.service.TeacherService;
import net.sf.json.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 教师信息管理Controller类
 */
@Controller
@RequestMapping("/course")
public class CourseController {

    @Resource
    private CourseService courseService;

    /**
     * 添加课程信息
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "addSave", method = RequestMethod.POST)
    @ResponseBody
    public Result addSave(@RequestBody Course course) throws Exception {
        int resultTotal;
        resultTotal = courseService.addCourse(course);
        if (resultTotal > 0) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult("FAIL");
        }
    }

    /**
     * 修改课程信息
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "updateSave", method = RequestMethod.POST)
    @ResponseBody
    public Result updateSave(@RequestBody Course course) throws Exception {
        int resultTotal;
        resultTotal = courseService.updateCourse(course);
        if (resultTotal > 0) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult("FAIL");
        }
    }

    /**
     * 获取课程列表Controller
     */
    @RequestMapping(value = "/getCourseList", method = RequestMethod.POST)
    @ResponseBody
    public JSONArray getCourseList(String classKey) {
        List<Map<String, Object>> list = courseService.getCourseList(classKey);
        if (list.size() > 0) {
            JSONArray jsonArray = JSONArray.fromObject(list);
            return jsonArray;
        }
        return null;
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
        courseService.delete(pkidArr);
        return ResultGenerator.genSuccessResult();
    }

}
