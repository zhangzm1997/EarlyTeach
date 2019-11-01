package com.mbyte.easy.rest;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mbyte.easy.admin.entity.Course;
import com.mbyte.easy.admin.entity.StudentCourse;
import com.mbyte.easy.admin.entity.StudentCourseVO;
import com.mbyte.easy.admin.service.IStudentCourseService;
import com.mbyte.easy.common.controller.BaseController;
import com.mbyte.easy.common.web.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName RestStudentCourseController
 * @Description TODO
 * @Author 张泽敏
 * @date 2019/4/27 10:21
 * @Version 1.0
 */
@Controller
@RequestMapping("/rest/studentCourse")
public class RestStudentCourseController extends BaseController {

    @Autowired
    private IStudentCourseService studentCourseService;

    /* * @Author 张泽敏
     * @Description //学生添加预约课程
     * @return
     **/
    @RequestMapping("addReserveCourse")
    @ResponseBody
    public AjaxResult addReserveCourse(@ModelAttribute StudentCourse studentCourse){
        System.out.println(studentCourse.toString());
            return toAjax(studentCourseService.save(studentCourse));
    }

    /* * @Author 张泽敏
     * @Description //学生添加购买课程
     * @Param
     * @return
     **/
    @PostMapping("addBuyCourse")
    @ResponseBody
    public AjaxResult addBuyCourse(StudentCourse studentCourse){
            return toAjax(studentCourseService.save(studentCourse));
    }

    /* * @Author 张泽敏
     * @Description //学生添加签到课程
     * @Param   先查看是否添加该课程，已经添加则可签订，否则error
     * @return
     **/
    @PostMapping("addCheckCourse")
    @ResponseBody
    public AjaxResult addCheckCourse(StudentCourse studentCourse){
        return toAjax(studentCourseService.updateById(studentCourse));
    }
    /* * @Author 张泽敏
     * @Description //学生查看所选课程信息，包括预约、购买、签到
     * @Param
     * @return
     **/
    @GetMapping("selectAllStudentCouse")
    @ResponseBody
    public AjaxResult selectAllStudentCouse(StudentCourse studentNum) {
        List<StudentCourseVO> lists = studentCourseService.selectAllStudentCouse(studentNum);
        return success(lists);
    }
}
