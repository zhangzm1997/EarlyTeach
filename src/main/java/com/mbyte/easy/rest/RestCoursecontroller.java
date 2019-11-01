package com.mbyte.easy.rest;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mbyte.easy.admin.entity.Course;
import com.mbyte.easy.admin.service.ICourseService;
import com.mbyte.easy.common.controller.BaseController;
import com.mbyte.easy.common.web.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @ClassName RestCoursecontroller
 * @Description TODO
 * @Author 张泽敏
 * @date 2019/4/27 10:18
 * @Version 1.0
 */
@Controller
@RequestMapping("/rest/course")
public class RestCoursecontroller extends BaseController {

    @Autowired
    private ICourseService courseService;

    /* * @Author 张泽敏
     * @Description //学生查看推出课程信息
     * @Param
     * @return
     **/
    @GetMapping("selectAllCourse")
    @ResponseBody
    public AjaxResult selectAllCourse() {
        List<Course> courses = courseService.list();
        return success(courses);
    }

    /* * @Author 张泽敏
     * @Description //老师查看所教授课程
     * @Param
     * @return
     **/
    @GetMapping("selectTeacherCourse")
    @ResponseBody
    public AjaxResult selectTeacherCourse(Course course) {
        QueryWrapper<Course> queryWrapper = new QueryWrapper<Course>();
        queryWrapper = queryWrapper.eq("teacher_num",course.getTeacherNum());
        List<Course> courses = courseService.list(queryWrapper);
        return success(courses);
    }
}
