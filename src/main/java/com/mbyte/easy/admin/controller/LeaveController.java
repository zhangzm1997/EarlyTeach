package com.mbyte.easy.admin.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mbyte.easy.admin.entity.Leave;
import com.mbyte.easy.admin.service.ILeaveService;
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
@RequestMapping("/admin/leave")
public class LeaveController extends BaseController  {

    private String prefix = "admin/leave/";

    @Autowired
    private ILeaveService leaveService;

    /**
     * 查询列表
     *
     * @param model
     * @param pageNo
     * @param pageSize
     * @param leave
     * @return
     */
    @RequestMapping
    public String index(Model model,@RequestParam(value = "pageNo", required = false, defaultValue = "1") Integer pageNo,@RequestParam(value = "pageSize", required = false, defaultValue = "20") Integer pageSize, Leave leave) {
        Page<Leave> page = new Page<Leave>(pageNo, pageSize);
        QueryWrapper<Leave> queryWrapper = new QueryWrapper<Leave>();

        if(leave.getStudentNum() != null  && !"".equals(leave.getStudentNum() + "")) {
            queryWrapper = queryWrapper.like("student_num",leave.getStudentNum());
        }


        if(leave.getLeaveReason() != null  && !"".equals(leave.getLeaveReason() + "")) {
            queryWrapper = queryWrapper.like("leave_reason",leave.getLeaveReason());
        }


        if(leave.getCourseId() != null  && !"".equals(leave.getCourseId() + "")) {
            queryWrapper = queryWrapper.like("course_id",leave.getCourseId());
        }


        if(leave.getLeaveTime() != null  && !"".equals(leave.getLeaveTime() + "")) {
            queryWrapper = queryWrapper.like("leave_time",leave.getLeaveTime());
        }


        if(leave.getLeaveNum() != null  && !"".equals(leave.getLeaveNum() + "")) {
            queryWrapper = queryWrapper.like("leave_num",leave.getLeaveNum());
        }


        if(leave.getLeaveResult() != null  && !"".equals(leave.getLeaveResult() + "")) {
            queryWrapper = queryWrapper.like("leave_result",leave.getLeaveResult());
        }


        if(leave.getLeaveTeacherNum() != null  && !"".equals(leave.getLeaveTeacherNum() + "")) {
            queryWrapper = queryWrapper.like("leave_teacher_num",leave.getLeaveTeacherNum());
        }


        if(leave.getChangeCourseId() != null  && !"".equals(leave.getChangeCourseId() + "")) {
            queryWrapper = queryWrapper.like("change_course_id",leave.getChangeCourseId());
        }


        if(leave.getChangeTime() != null  && !"".equals(leave.getChangeTime() + "")) {
            queryWrapper = queryWrapper.like("change_time",leave.getChangeTime());
        }


        if(leave.getChangeTeacherNum() != null  && !"".equals(leave.getChangeTeacherNum() + "")) {
            queryWrapper = queryWrapper.like("change_teacher_num",leave.getChangeTeacherNum());
        }


        if(leave.getChangeResult() != null  && !"".equals(leave.getChangeResult() + "")) {
            queryWrapper = queryWrapper.like("change_result",leave.getChangeResult());
        }

        IPage<Leave> pageInfo = leaveService.page(page, queryWrapper);
        model.addAttribute("searchInfo", leave);
        model.addAttribute("pageInfo", new PageInfo(pageInfo));
        return prefix+"leave-list";
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
     * @param leave
     * @return
     */
    @PostMapping("add")
    @ResponseBody
    public AjaxResult add(Leave leave){
        return toAjax(leaveService.save(leave));
    }
    /**
     * 添加跳转页面
     * @return
     */
    @GetMapping("editBefore/{id}")
    public String editBefore(Model model,@PathVariable("id")Long id){
        model.addAttribute("leave",leaveService.getById(id));
        return prefix+"edit";
    }
    /**
     * 添加
     * @param leave
     * @return
     */
    @PostMapping("edit")
    @ResponseBody
    public AjaxResult edit(Leave leave){
        return toAjax(leaveService.updateById(leave));
    }
    /**
     * 删除
     * @param id
     * @return
     */
    @GetMapping("delete/{id}")
    @ResponseBody
    public AjaxResult delete(@PathVariable("id") Long id){
        return toAjax(leaveService.removeById(id));
    }
    /**
     * 批量删除
     * @param ids
     * @return
     */
    @PostMapping("deleteAll")
    @ResponseBody
    public AjaxResult deleteAll(@RequestBody List<Long> ids){
        return toAjax(leaveService.removeByIds(ids));
    }

}

