package com.mbyte.easy.admin.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mbyte.easy.admin.entity.StudentCourse;
import com.mbyte.easy.admin.service.IStudentCourseService;
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
 * @author 张泽敏
 * @since 2019-03-11
 */
@Controller
@RequestMapping("/admin/studentCourse")
public class StudentCourseController extends BaseController  {

    private String prefix = "admin/studentCourse/";

    @Autowired
    private IStudentCourseService studentCourseService;

    /**
     * 查询列表
     *
     * @param model
     * @param pageNo
     * @param pageSize
     * @param studentCourse
     * @return
     */
    @RequestMapping
    public String index(Model model,@RequestParam(value = "pageNo", required = false, defaultValue = "1") Integer pageNo,@RequestParam(value = "pageSize", required = false, defaultValue = "20") Integer pageSize, String buyTimeSpace, StudentCourse studentCourse) {
        Page<StudentCourse> page = new Page<StudentCourse>(pageNo, pageSize);
        QueryWrapper<StudentCourse> queryWrapper = new QueryWrapper<StudentCourse>();

        if(studentCourse.getCourseId() != null  && !"".equals(studentCourse.getCourseId() + "")) {
            queryWrapper = queryWrapper.like("course_id",studentCourse.getCourseId());
        }


        if(studentCourse.getStudentNum() != null  && !"".equals(studentCourse.getStudentNum() + "")) {
            queryWrapper = queryWrapper.like("student_num",studentCourse.getStudentNum());
        }


        if(studentCourse.getIsReserve() != null  && !"".equals(studentCourse.getIsReserve() + "")) {
            queryWrapper = queryWrapper.like("is_reserve",studentCourse.getIsReserve());
        }


        if(studentCourse.getIsBuy() != null  && !"".equals(studentCourse.getIsBuy() + "")) {
            queryWrapper = queryWrapper.like("is_buy",studentCourse.getIsBuy());
        }


        if(studentCourse.getBuyTime() != null  && !"".equals(studentCourse.getBuyTime() + "")) {
            queryWrapper = queryWrapper.like("buy_time",studentCourse.getBuyTime());
        }


        if(studentCourse.getIsCheck() != null  && !"".equals(studentCourse.getIsCheck() + "")) {
            queryWrapper = queryWrapper.like("is_check",studentCourse.getIsCheck());
        }

        IPage<StudentCourse> pageInfo = studentCourseService.page(page, queryWrapper);
        model.addAttribute("buyTimeSpace", buyTimeSpace);
        model.addAttribute("searchInfo", studentCourse);
        model.addAttribute("pageInfo", new PageInfo(pageInfo));
        return prefix+"studentCourse-list";
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
     * @param studentCourse
     * @return
     */
    @PostMapping("add")
    @ResponseBody
    public AjaxResult add(StudentCourse studentCourse){
        return toAjax(studentCourseService.save(studentCourse));
    }
    /**
     * 添加跳转页面
     * @return
     */
    @GetMapping("editBefore/{id}")
    public String editBefore(Model model,@PathVariable("id")Long id){
        model.addAttribute("studentCourse",studentCourseService.getById(id));
        return prefix+"edit";
    }
    /**
     * 添加
     * @param studentCourse
     * @return
     */
    @PostMapping("edit")
    @ResponseBody
    public AjaxResult edit(StudentCourse studentCourse){
        return toAjax(studentCourseService.updateById(studentCourse));
    }
    /**
     * 删除
     * @param id
     * @return
     */
    @GetMapping("delete/{id}")
    @ResponseBody
    public AjaxResult delete(@PathVariable("id") Long id){
        return toAjax(studentCourseService.removeById(id));
    }
    /**
     * 批量删除
     * @param ids
     * @return
     */
    @PostMapping("deleteAll")
    @ResponseBody
    public AjaxResult deleteAll(@RequestBody List<Long> ids){
        return toAjax(studentCourseService.removeByIds(ids));
    }

}

