package com.mbyte.easy.rest;

import com.mbyte.easy.admin.entity.LeaveMessage;
import com.mbyte.easy.admin.service.ILeaveMessageService;
import com.mbyte.easy.common.controller.BaseController;
import com.mbyte.easy.common.web.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @ClassName RestLeaveMessageController
 * @Description TODO
 * @Author Administrator  闫志行
 * @date 2019/4/27 10:20
 * @Version 1.0
 */

@Controller
@RequestMapping("/rest/leaveMessage")
public class RestLeaveMessageController extends BaseController {

    @Autowired
    private ILeaveMessageService leaveMessageService;

    /* * @Author 闫志行
     * @Description //学生或老师查看留言
     * @Param
     * @return
     **/
    @GetMapping("selectAllLeaveMessage")
    @ResponseBody
    public AjaxResult selectAllLeaveMessage() {
        List<LeaveMessage> leaveMessages = leaveMessageService.list();
        return success(leaveMessages);
    }

    /* * @Author 闫志行
     * @Description //学生或老师添加留言
     * @Param
     * @return
     **/
    @PostMapping("addLeaveMessage")
    @ResponseBody
    public AjaxResult addLeaveMessage(LeaveMessage leaveMessage) {
        return toAjax(leaveMessageService.save(leaveMessage));
    }

    /* * @Author 闫志行
     * @Description //学生或老师回复留言(相当于修改留言这一条数据内容，已经回复则不可再次回复)
     * @Param
     * @return
     **/
    @PostMapping ("editLeaveMessage")
    @ResponseBody
    public AjaxResult editLeaveMessage(LeaveMessage leaveMessage){
        if (leaveMessage.getReply() !=null){
            return error("抱歉，留言只能回复一次");
        }else{
        return toAjax(leaveMessageService.updateById(leaveMessage));
        }
    }
}
