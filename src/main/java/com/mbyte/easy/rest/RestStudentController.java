package com.mbyte.easy.rest;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mbyte.easy.admin.entity.Student;
import com.mbyte.easy.admin.service.IStudentService;
import com.mbyte.easy.common.controller.BaseController;
import com.mbyte.easy.common.web.AjaxResult;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName RestStudentController
 * @Description 学生信息
 * @Author 张泽敏
 * @date 2019/4/26 17:41
 * @Version 1.0
 */
@Controller
@RequestMapping("/rest/student")
public class RestStudentController extends BaseController {
    
    @Autowired
    private IStudentService studentService;

    /* *
     * @Author 张泽敏
     * @Description //学生注册
     * @Param student
     * @return 
     **/
    @PostMapping("regist")
    @ResponseBody
    public AjaxResult regist(Student student) {
        return toAjax(studentService.save(student));
    }
    /* *
     * @Author 张泽敏
     * @Description //学生登录
     * @Param student_num, pwd
     * @return 
     **/
    @PostMapping("login")
    @ResponseBody
    public AjaxResult login( String studentNum , String pwd) {


        QueryWrapper<Student> queryWrapper = new QueryWrapper<Student>();
        queryWrapper = queryWrapper.eq("student_num", studentNum);
        queryWrapper = queryWrapper.eq("pwd", pwd);
        Student student = studentService.getOne(queryWrapper);
        if (student == null) {
            return error("学生不存在");
        }else if (student.getPwd().equals(pwd)) {
            return success(student);
        }
        return error("密码错误");
    }

    /* * @Author 张泽敏
     * @Description //学生查看个人信息
     * @Param student
     * @return
     **/
    @GetMapping("selectStudent")
    @ResponseBody
    public AjaxResult selectStudent(Student student) {
        QueryWrapper<Student> queryWrapper = new QueryWrapper<Student>();
        queryWrapper = queryWrapper.eq("student_num",student.getStudentNum());
        return success(queryWrapper);
    }

    /* *
     * @Author 张泽敏
     * @Description //学生修改个人信息
     * @Param student
     * @return
     **/
    @PostMapping("editStudent")
    @ResponseBody
    public AjaxResult editStudent(Student student) {
        return toAjax(studentService.updateById(student));
    }

}
