package com.mbyte.easy.admin.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mbyte.easy.admin.entity.LeaveMessage;
import com.mbyte.easy.admin.service.ILeaveMessageService;
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
@RequestMapping("/admin/leaveMessage")
public class LeaveMessageController extends BaseController  {

    private String prefix = "admin/leaveMessage/";

    @Autowired
    private ILeaveMessageService leaveMessageService;

    /**
     * 查询列表
     *
     * @param model
     * @param pageNo
     * @param pageSize
     * @param leaveMessage
     * @return
     */
    @RequestMapping
    public String index(Model model,@RequestParam(value = "pageNo", required = false, defaultValue = "1") Integer pageNo,@RequestParam(value = "pageSize", required = false, defaultValue = "20") Integer pageSize, String createtimeSpace, String updatetimeSpace, LeaveMessage leaveMessage) {
        Page<LeaveMessage> page = new Page<LeaveMessage>(pageNo, pageSize);
        QueryWrapper<LeaveMessage> queryWrapper = new QueryWrapper<LeaveMessage>();

        if(leaveMessage.getCreatetime() != null  && !"".equals(leaveMessage.getCreatetime() + "")) {
            queryWrapper = queryWrapper.like("createtime",leaveMessage.getCreatetime());
        }


        if(leaveMessage.getNums() != null  && !"".equals(leaveMessage.getNums() + "")) {
            queryWrapper = queryWrapper.like("nums",leaveMessage.getNums());
        }


        if(leaveMessage.getContent() != null  && !"".equals(leaveMessage.getContent() + "")) {
            queryWrapper = queryWrapper.like("content",leaveMessage.getContent());
        }


        if(leaveMessage.getUpdatetime() != null  && !"".equals(leaveMessage.getUpdatetime() + "")) {
            queryWrapper = queryWrapper.like("updatetime",leaveMessage.getUpdatetime());
        }


        if(leaveMessage.getNum() != null  && !"".equals(leaveMessage.getNum() + "")) {
            queryWrapper = queryWrapper.like("num",leaveMessage.getNum());
        }


        if(leaveMessage.getReply() != null  && !"".equals(leaveMessage.getReply() + "")) {
            queryWrapper = queryWrapper.like("reply",leaveMessage.getReply());
        }

        IPage<LeaveMessage> pageInfo = leaveMessageService.page(page, queryWrapper);
        model.addAttribute("createtimeSpace", createtimeSpace);
        model.addAttribute("updatetimeSpace", updatetimeSpace);
        model.addAttribute("searchInfo", leaveMessage);
        model.addAttribute("pageInfo", new PageInfo(pageInfo));
        return prefix+"leaveMessage-list";
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
     * @param leaveMessage
     * @return
     */
    @PostMapping("add")
    @ResponseBody
    public AjaxResult add(LeaveMessage leaveMessage){
        return toAjax(leaveMessageService.save(leaveMessage));
    }
    /**
     * 添加跳转页面
     * @return
     */
    @GetMapping("editBefore/{id}")
    public String editBefore(Model model,@PathVariable("id")Long id){
        model.addAttribute("leaveMessage",leaveMessageService.getById(id));
        return prefix+"edit";
    }
    /**
     * 添加
     * @param leaveMessage
     * @return
     */
    @PostMapping("edit")
    @ResponseBody
    public AjaxResult edit(LeaveMessage leaveMessage){
        return toAjax(leaveMessageService.updateById(leaveMessage));
    }
    /**
     * 删除
     * @param id
     * @return
     */
    @GetMapping("delete/{id}")
    @ResponseBody
    public AjaxResult delete(@PathVariable("id") Long id){
        return toAjax(leaveMessageService.removeById(id));
    }
    /**
     * 批量删除
     * @param ids
     * @return
     */
    @PostMapping("deleteAll")
    @ResponseBody
    public AjaxResult deleteAll(@RequestBody List<Long> ids){
        return toAjax(leaveMessageService.removeByIds(ids));
    }

}

