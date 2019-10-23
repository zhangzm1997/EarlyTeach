package com.mbyte.easy.admin.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mbyte.easy.admin.entity.Income;
import com.mbyte.easy.admin.service.IIncomeService;
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
@RequestMapping("/admin/income")
public class IncomeController extends BaseController  {

    private String prefix = "admin/income/";

    @Autowired
    private IIncomeService incomeService;

    /**
     * 查询列表
     *
     * @param model
     * @param pageNo
     * @param pageSize
     * @param income
     * @return
     */
    @RequestMapping
    public String index(Model model,@RequestParam(value = "pageNo", required = false, defaultValue = "1") Integer pageNo,@RequestParam(value = "pageSize", required = false, defaultValue = "20") Integer pageSize, Income income) {
        Page<Income> page = new Page<Income>(pageNo, pageSize);
        QueryWrapper<Income> queryWrapper = new QueryWrapper<Income>();

        if(income.getCourseId() != null  && !"".equals(income.getCourseId() + "")) {
            queryWrapper = queryWrapper.like("course_id",income.getCourseId());
        }


        if(income.getCheckNum() != null  && !"".equals(income.getCheckNum() + "")) {
            queryWrapper = queryWrapper.like("check_num",income.getCheckNum());
        }


        if(income.getCheckPer() != null  && !"".equals(income.getCheckPer() + "")) {
            queryWrapper = queryWrapper.like("check_per",income.getCheckPer());
        }


        if(income.getSell() != null  && !"".equals(income.getSell() + "")) {
            queryWrapper = queryWrapper.like("sell",income.getSell());
        }


        if(income.getCourseIncome() != null  && !"".equals(income.getCourseIncome() + "")) {
            queryWrapper = queryWrapper.like("course_income",income.getCourseIncome());
        }

        IPage<Income> pageInfo = incomeService.page(page, queryWrapper);
        model.addAttribute("searchInfo", income);
        model.addAttribute("pageInfo", new PageInfo(pageInfo));
        return prefix+"income-list";
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
     * @param income
     * @return
     */
    @PostMapping("add")
    @ResponseBody
    public AjaxResult add(Income income){
        return toAjax(incomeService.save(income));
    }
    /**
     * 添加跳转页面
     * @return
     */
    @GetMapping("editBefore/{id}")
    public String editBefore(Model model,@PathVariable("id")Long id){
        model.addAttribute("income",incomeService.getById(id));
        return prefix+"edit";
    }
    /**
     * 添加
     * @param income
     * @return
     */
    @PostMapping("edit")
    @ResponseBody
    public AjaxResult edit(Income income){
        return toAjax(incomeService.updateById(income));
    }
    /**
     * 删除
     * @param id
     * @return
     */
    @GetMapping("delete/{id}")
    @ResponseBody
    public AjaxResult delete(@PathVariable("id") Long id){
        return toAjax(incomeService.removeById(id));
    }
    /**
     * 批量删除
     * @param ids
     * @return
     */
    @PostMapping("deleteAll")
    @ResponseBody
    public AjaxResult deleteAll(@RequestBody List<Long> ids){
        return toAjax(incomeService.removeByIds(ids));
    }

}

