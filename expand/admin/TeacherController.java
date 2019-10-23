package com.mbyte.easy.admin.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mbyte.easy.admin.entity.Teacher;
import com.mbyte.easy.admin.service.ITeacherService;
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
@RequestMapping("/admin/teacher")
public class TeacherController extends BaseController  {

    private String prefix = "admin/teacher/";

    @Autowired
    private ITeacherService teacherService;

    /**
    * 查询列表
    *
    * @param model
    * @param pageNo
    * @param pageSize
    * @param teacher
    * @return
    */
    @RequestMapping
    public String index(Model model,@RequestParam(value = "pageNo", required = false, defaultValue = "1") Integer pageNo,@RequestParam(value = "pageSize", required = false, defaultValue = "20") Integer pageSize, Teacher teacher) {
        Page<Teacher> page = new Page<Teacher>(pageNo, pageSize);
        QueryWrapper<Teacher> queryWrapper = new QueryWrapper<Teacher>();

        if(teacher.getTeacherNum() != null  && !"".equals(teacher.getTeacherNum() + "")) {
            queryWrapper = queryWrapper.like("teacher_num",teacher.getTeacherNum());
         }


        if(teacher.getPwd() != null  && !"".equals(teacher.getPwd() + "")) {
            queryWrapper = queryWrapper.like("pwd",teacher.getPwd());
         }


        if(teacher.getName() != null  && !"".equals(teacher.getName() + "")) {
            queryWrapper = queryWrapper.like("name",teacher.getName());
         }


        if(teacher.getGender() != null  && !"".equals(teacher.getGender() + "")) {
            queryWrapper = queryWrapper.like("gender",teacher.getGender());
         }

        IPage<Teacher> pageInfo = teacherService.page(page, queryWrapper);
        model.addAttribute("searchInfo", teacher);
        model.addAttribute("pageInfo", new PageInfo(pageInfo));
        return prefix+"teacher-list";
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
    * @param teacher
    * @return
    */
    @PostMapping("add")
    @ResponseBody
    public AjaxResult add(Teacher teacher){
        return toAjax(teacherService.save(teacher));
    }
    /**
    * 添加跳转页面
    * @return
    */
    @GetMapping("editBefore/{id}")
    public String editBefore(Model model,@PathVariable("id")Long id){
        model.addAttribute("teacher",teacherService.getById(id));
        return prefix+"edit";
    }
    /**
    * 添加
    * @param teacher
    * @return
    */
    @PostMapping("edit")
    @ResponseBody
    public AjaxResult edit(Teacher teacher){
        return toAjax(teacherService.updateById(teacher));
    }
    /**
    * 删除
    * @param id
    * @return
    */
    @GetMapping("delete/{id}")
    @ResponseBody
    public AjaxResult delete(@PathVariable("id") Long id){
        return toAjax(teacherService.removeById(id));
    }
    /**
    * 批量删除
    * @param ids
    * @return
    */
    @PostMapping("deleteAll")
    @ResponseBody
    public AjaxResult deleteAll(@RequestBody List<Long> ids){
        return toAjax(teacherService.removeByIds(ids));
    }

}

