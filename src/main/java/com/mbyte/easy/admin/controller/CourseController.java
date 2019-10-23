package com.mbyte.easy.admin.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mbyte.easy.admin.entity.Course;
import com.mbyte.easy.admin.service.ICourseService;
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
@RequestMapping("/admin/course")
public class CourseController extends BaseController  {

    private String prefix = "admin/course/";

    @Autowired
    private ICourseService courseService;

    /**
     * 查询列表
     *
     * @param model
     * @param pageNo
     * @param pageSize
     * @param course
     * @return
     */
    @RequestMapping
    public String index(Model model,@RequestParam(value = "pageNo", required = false, defaultValue = "1") Integer pageNo,@RequestParam(value = "pageSize", required = false, defaultValue = "20") Integer pageSize, Course course) {
        Page<Course> page = new Page<Course>(pageNo, pageSize);
        QueryWrapper<Course> queryWrapper = new QueryWrapper<Course>();

        if(course.getSubject() != null  && !"".equals(course.getSubject() + "")) {
            queryWrapper = queryWrapper.like("subject",course.getSubject());
        }


        if(course.getCourseInfor() != null  && !"".equals(course.getCourseInfor() + "")) {
            queryWrapper = queryWrapper.like("course_infor",course.getCourseInfor());
        }


        if(course.getCourseTimePeriod() != null  && !"".equals(course.getCourseTimePeriod() + "")) {
            queryWrapper = queryWrapper.like("course_time_period",course.getCourseTimePeriod());
        }


        if(course.getTeacherNum() != null  && !"".equals(course.getTeacherNum() + "")) {
            queryWrapper = queryWrapper.like("teacher_num",course.getTeacherNum());
        }


        if(course.getClassTime() != null  && !"".equals(course.getClassTime() + "")) {
            queryWrapper = queryWrapper.like("class_time",course.getClassTime());
        }


        if(course.getClassRoom() != null  && !"".equals(course.getClassRoom() + "")) {
            queryWrapper = queryWrapper.like("class_room",course.getClassRoom());
        }


        if(course.getNumLimit() != null  && !"".equals(course.getNumLimit() + "")) {
            queryWrapper = queryWrapper.like("num_limit",course.getNumLimit());
        }


        if(course.getAgeLimit() != null  && !"".equals(course.getAgeLimit() + "")) {
            queryWrapper = queryWrapper.like("age_limit",course.getAgeLimit());
        }


        if(course.getStartTime() != null  && !"".equals(course.getStartTime() + "")) {
            queryWrapper = queryWrapper.like("start_time",course.getStartTime());
        }


        if(course.getCourseFee() != null  && !"".equals(course.getCourseFee() + "")) {
            queryWrapper = queryWrapper.like("course_fee",course.getCourseFee());
        }

        IPage<Course> pageInfo = courseService.page(page, queryWrapper);
        model.addAttribute("searchInfo", course);
        model.addAttribute("pageInfo", new PageInfo(pageInfo));
        return prefix+"course-list";
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
     * @param course
     * @return
     */
    @PostMapping("add")
    @ResponseBody
    public AjaxResult add(Course course){
        return toAjax(courseService.save(course));
    }
    /**
     * 添加跳转页面
     * @return
     */
    @GetMapping("editBefore/{id}")
    public String editBefore(Model model,@PathVariable("id")Long id){
        model.addAttribute("course",courseService.getById(id));
        return prefix+"edit";
    }
    /**
     * 添加
     * @param course
     * @return
     */
    @PostMapping("edit")
    @ResponseBody
    public AjaxResult edit(Course course){
        return toAjax(courseService.updateById(course));
    }
    /**
     * 删除
     * @param id
     * @return
     */
    @GetMapping("delete/{id}")
    @ResponseBody
    public AjaxResult delete(@PathVariable("id") Long id){
        return toAjax(courseService.removeById(id));
    }
    /**
     * 批量删除
     * @param ids
     * @return
     */
    @PostMapping("deleteAll")
    @ResponseBody
    public AjaxResult deleteAll(@RequestBody List<Long> ids){
        return toAjax(courseService.removeByIds(ids));
    }

}

