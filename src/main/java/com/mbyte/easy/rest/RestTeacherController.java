package com.mbyte.easy.rest;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mbyte.easy.admin.entity.Teacher;
import com.mbyte.easy.admin.service.ITeacherService;
import com.mbyte.easy.common.controller.BaseController;
import com.mbyte.easy.common.web.AjaxResult;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName RestStudentController
 * @Description 老师信息
 * @Author 张泽敏
 * @date 2019/4/26 17:41
 * @Version 1.0
 */
@Controller
@RequestMapping("/rest/teacher")
public class RestTeacherController extends BaseController {

    @Autowired
    private ITeacherService teacherService;

    /* *
     * @Author 张泽敏
     * @Description //老师注册
     * @Param teacher
     * @return
     **/
    @PostMapping("regist")
    @ResponseBody
    public AjaxResult regist(Teacher teacher) {
        return toAjax(teacherService.save(teacher));
    }

    /* *
     * @Author 张泽敏
     * @Description //老师登录
     * @Param teacher_num, pwd
     * @return
     **/
    @PostMapping("login")
    @ResponseBody
    public AjaxResult login(@Param("teacherNum") String teacherNum,@Param("pwd") String pwd) {
        QueryWrapper<Teacher> queryWrapper = new QueryWrapper<Teacher>();
        queryWrapper = queryWrapper.eq("teacher_num", teacherNum);
        Teacher teacher = teacherService.getOne(queryWrapper);
        if (teacher == null) {
            return error("老师不存在");
        } else if (teacher.getPwd().equals(pwd)) {
            return success(teacher);
        }
        return error("密码错误");
    }

    /* *
     * @Author 张泽敏
     * @Description //老师修改个人信息
     * @Param teacher
     * @return
     **/
    @PostMapping("editTeacher")
    @ResponseBody
    public AjaxResult editTeacher(Teacher teacher) {
        return toAjax(teacherService.updateById(teacher));
    }

    /* * @Author 张泽敏
     * @Description //老师查看个人信息
     * @Param student
     * @return
     **/
    @GetMapping("selectTeacher")
    @ResponseBody
    public AjaxResult selectTeacher(Teacher teacher) {
        QueryWrapper<Teacher> queryWrapper = new QueryWrapper<Teacher>();
        queryWrapper = queryWrapper.eq("teacher_num",teacher.getTeacherNum());
        return success(queryWrapper);
    }
}