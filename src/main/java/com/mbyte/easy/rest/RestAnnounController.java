package com.mbyte.easy.rest;

import com.mbyte.easy.admin.entity.Announ;
import com.mbyte.easy.admin.service.IAnnounService;
import com.mbyte.easy.common.controller.BaseController;
import com.mbyte.easy.common.web.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @ClassName RestAnnounController
 * @Description TODO
 * @Author 张泽敏
 * @date 2019/4/27 10:17
 * @Version 1.0
 */
@Controller
@RequestMapping("/rest/announ")
public class RestAnnounController extends BaseController {
    @Autowired
    private IAnnounService announService;
    /* * @Author 张泽敏
     * @Description //老师或学生查看公告
     * @Param
     * @return
     **/
    @GetMapping("selectAllAnnoun")
    @ResponseBody
    public AjaxResult selectAllAnnoun() {
        List<Announ> announs = announService.list();
        return success(announs);
    }
}
