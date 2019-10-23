package com.mbyte.easy.admin.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mbyte.easy.admin.entity.Announ;
import com.mbyte.easy.admin.service.IAnnounService;
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
@RequestMapping("/admin/announ")
public class AnnounController extends BaseController  {

    private String prefix = "admin/announ/";

    @Autowired
    private IAnnounService announService;

    /**
    * 查询列表
    *
    * @param model
    * @param pageNo
    * @param pageSize
    * @param announ
    * @return
    */
    @RequestMapping
    public String index(Model model,@RequestParam(value = "pageNo", required = false, defaultValue = "1") Integer pageNo,@RequestParam(value = "pageSize", required = false, defaultValue = "20") Integer pageSize, String createtimeSpace, Announ announ) {
        Page<Announ> page = new Page<Announ>(pageNo, pageSize);
        QueryWrapper<Announ> queryWrapper = new QueryWrapper<Announ>();

        if(announ.getCreatetime() != null  && !"".equals(announ.getCreatetime() + "")) {
            queryWrapper = queryWrapper.like("createtime",announ.getCreatetime());
         }


        if(announ.getTitle() != null  && !"".equals(announ.getTitle() + "")) {
            queryWrapper = queryWrapper.like("title",announ.getTitle());
         }


        if(announ.getContent() != null  && !"".equals(announ.getContent() + "")) {
            queryWrapper = queryWrapper.like("content",announ.getContent());
         }

        IPage<Announ> pageInfo = announService.page(page, queryWrapper);
        model.addAttribute("createtimeSpace", createtimeSpace);
        model.addAttribute("searchInfo", announ);
        model.addAttribute("pageInfo", new PageInfo(pageInfo));
        return prefix+"announ-list";
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
    * @param announ
    * @return
    */
    @PostMapping("add")
    @ResponseBody
    public AjaxResult add(Announ announ){
        return toAjax(announService.save(announ));
    }
    /**
    * 添加跳转页面
    * @return
    */
    @GetMapping("editBefore/{id}")
    public String editBefore(Model model,@PathVariable("id")Long id){
        model.addAttribute("announ",announService.getById(id));
        return prefix+"edit";
    }
    /**
    * 添加
    * @param announ
    * @return
    */
    @PostMapping("edit")
    @ResponseBody
    public AjaxResult edit(Announ announ){
        return toAjax(announService.updateById(announ));
    }
    /**
    * 删除
    * @param id
    * @return
    */
    @GetMapping("delete/{id}")
    @ResponseBody
    public AjaxResult delete(@PathVariable("id") Long id){
        return toAjax(announService.removeById(id));
    }
    /**
    * 批量删除
    * @param ids
    * @return
    */
    @PostMapping("deleteAll")
    @ResponseBody
    public AjaxResult deleteAll(@RequestBody List<Long> ids){
        return toAjax(announService.removeByIds(ids));
    }

}

