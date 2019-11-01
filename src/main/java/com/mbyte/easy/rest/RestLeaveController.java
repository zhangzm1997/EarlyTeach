package com.mbyte.easy.rest;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mbyte.easy.admin.entity.Leave;
import com.mbyte.easy.admin.service.ILeaveService;
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
 * @ClassName RestLeaveController
 * @Description TODO
 * @Author 张泽敏
 * @date 2019/4/27 10:20
 * @Version 1.0
 */
@Controller
@RequestMapping("/rest/leave")
public class RestLeaveController extends BaseController {

    @Autowired
    private ILeaveService leaveService;

    /* * @Author 张泽敏
     * @Description // 学生添加调课信息，如果该课调课已经有两次，则不准予调课能收到消息、乙收不到消息
     * @Param
     * @return
     **/
    @PostMapping("addStudentLeave")
    @ResponseBody
    public AjaxResult addStudentLeave(Leave leave){
            return toAjax(leaveService.save(leave));
    }

    /* * @Author 张泽敏
     * @Description // 老师甲查看请假信息
     * @Param
     * @return
     **/
    @RequestMapping("selectAllLeave")
    @ResponseBody
    public AjaxResult selectAllLeave(Leave leave){
        QueryWrapper<Leave> queryWrapper = new QueryWrapper<Leave>();
        queryWrapper = queryWrapper.eq("leave_teacher_num",leave.getLeaveTeacherNum());
        List<Leave> leaves = leaveService.list(queryWrapper);
        return success(leaves);
    }

    /* * @Author 张泽敏
     * @Description //老师甲编辑请假信息(0失败1成功)
     * @Param
     * @return
     **/
    @PostMapping("editLeave")
    @ResponseBody
    public AjaxResult editLeave(Leave leave) {
        System.out.println(leave.toString());
            return toAjax(leaveService.updateById(leave));
    }

    /* * @Author 张泽敏
     * @Description // 学生查看全部请假信息，包括请假结果
     * @Param
     * @return
     **/
    @GetMapping("selectStudentLeave")
    @ResponseBody
    public AjaxResult selectStudentLeave(Leave leave) {
        QueryWrapper<Leave> queryWrapper = new QueryWrapper<Leave>();
        queryWrapper = queryWrapper.eq("student_num",leave.getStudentNum());
        List<Leave> leaves = leaveService.list(queryWrapper);
        return success(leaves);
    }

//    /* * @Author 张泽敏
//     * @Description // 老师乙查看调课信息
//     * @Param
//     * @return
//     **/
//    @GetMapping("selectAllChange")
//    @ResponseBody
//    public AjaxResult selectAllChange(Leave leave) {
//            QueryWrapper<Leave> queryWrapper = new QueryWrapper<Leave>();
//            queryWrapper = queryWrapper.eq("change_teacher_num",leave.getChangeTeacherNum());
//            List<Leave> leaves = leaveService.list(queryWrapper);
//        if (leave.getLeaveResult() == 1) {
//            return success(leaves);
//        }else {
//            return error("暂无调课信息");
//        }
//    }
//
//    /* * @Author 张泽敏
//     * @Description // 老师乙回复请假信息，是否同意(0失败1成功),同意与否，则甲老师和学生都能看到结果，请假次数要自动加一
//     * @Param
//     * @return
//     **/
//    @PostMapping("editChangeLeave")
//    @ResponseBody
//    public AjaxResult editChangeLeave(Leave leave) {
//        return toAjax(leaveService.updateById(leave));
//    }


}
