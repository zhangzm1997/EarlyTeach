package com.mbyte.easy.admin.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mbyte.easy.admin.entity.Student;
import com.mbyte.easy.admin.service.IStudentService;
import com.mbyte.easy.common.controller.BaseController;
import com.mbyte.easy.common.web.AjaxResult;
import com.mbyte.easy.util.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * <p>
 * 前端控制器
 * </p>
 * @author 黄润宣
 * @since 2019-03-11
 */
@Controller
@RequestMapping("/admin/student")
public class StudentController extends BaseController  {

    private String prefix = "admin/student/";

    @Autowired
    private IStudentService studentService;

    /**
     * 查询列表
     *
     * @param model
     * @param pageNo
     * @param pageSize
     * @param student
     * @return
     */
    @RequestMapping
    public String index(Model model,@RequestParam(value = "pageNo", required = false, defaultValue = "1") Integer pageNo,@RequestParam(value = "pageSize", required = false, defaultValue = "20") Integer pageSize, Student student) {
        Page<Student> page = new Page<Student>(pageNo, pageSize);
        QueryWrapper<Student> queryWrapper = new QueryWrapper<Student>();

        if(student.getStudentNum() != null  && !"".equals(student.getStudentNum() + "")) {
            queryWrapper = queryWrapper.like("student_num",student.getStudentNum());
        }


        if(student.getPwd() != null  && !"".equals(student.getPwd() + "")) {
            queryWrapper = queryWrapper.like("pwd",student.getPwd());
        }


        if(student.getName() != null  && !"".equals(student.getName() + "")) {
            queryWrapper = queryWrapper.like("name",student.getName());
        }


        if(student.getGender() != null  && !"".equals(student.getGender() + "")) {
            queryWrapper = queryWrapper.like("gender",student.getGender());
        }


        if(student.getBorn() != null  && !"".equals(student.getBorn() + "")) {
            queryWrapper = queryWrapper.like("born",student.getBorn());
        }


        if(student.getBalance() != null  && !"".equals(student.getBalance() + "")) {
            queryWrapper = queryWrapper.like("balance",student.getBalance());
        }

        IPage<Student> pageInfo = studentService.page(page, queryWrapper);
        model.addAttribute("searchInfo", student);
        model.addAttribute("pageInfo", new PageInfo(pageInfo));
        return prefix+"student-list";
    }

    /**
     * 添加跳转页面
     * @return
     */
    @GetMapping("addBefore")
    public String addBefore(){
        return prefix+"add";
    }
    /**
     * 添加
     * @param student
     * @return
     */
    @PostMapping("add")
    @ResponseBody
    public AjaxResult add(Student student){
        return toAjax(studentService.save(student));
    }
    /**
     * 添加跳转页面
     * @return
     */
    @GetMapping("editBefore/{id}")
    public String editBefore(Model model,@PathVariable("id")Long id){
        model.addAttribute("student",studentService.getById(id));
        return prefix+"edit";
    }
    /**
     * 添加
     * @param student
     * @return
     */
    @PostMapping("edit")
    @ResponseBody
    public AjaxResult edit(Student student){
        return toAjax(studentService.updateById(student));
    }
    /**
     * 删除
     * @param id
     * @return
     */
    @GetMapping("delete/{id}")
    @ResponseBody
    public AjaxResult delete(@PathVariable("id") Long id){
        return toAjax(studentService.removeById(id));
    }
    /**
     * 批量删除
     * @param ids
     * @return
     */
    @PostMapping("deleteAll")
    @ResponseBody
    public AjaxResult deleteAll(@RequestBody List<Long> ids){
        return toAjax(studentService.removeByIds(ids));
    }

}

