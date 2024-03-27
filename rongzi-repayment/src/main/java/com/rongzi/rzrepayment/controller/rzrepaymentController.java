package com.rongzi.rzrepayment.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.rongzi.common.annotation.Log;
import com.rongzi.common.core.controller.BaseController;
import com.rongzi.common.core.domain.AjaxResult;
import com.rongzi.common.enums.BusinessType;
import com.rongzi.rzrepayment.domain.rzrepayment;
import com.rongzi.rzrepayment.service.IrzrepaymentService;
import com.rongzi.common.utils.poi.ExcelUtil;
import com.rongzi.common.core.page.TableDataInfo;

/**
 * 还款计划Controller
 * 
 * @author rongzi
 * @date 2024-03-01
 */
@RestController
@RequestMapping("/rzrepayment/repayment")
public class rzrepaymentController extends BaseController
{
    @Autowired
    private IrzrepaymentService rzrepaymentService;

    /**
     * 查询还款计划列表
     */
    @PreAuthorize("@ss.hasPermi('rzrepayment:repayment:list')")
    @GetMapping("/list")
    public TableDataInfo list(rzrepayment rzrepayment)
    {
        startPage();
        List<rzrepayment> list = rzrepaymentService.selectrzrepaymentList(rzrepayment);
        return getDataTable(list);
    }

    /**
     * 导出还款计划列表
     */
    @PreAuthorize("@ss.hasPermi('rzrepayment:repayment:export')")
    @Log(title = "还款计划", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, rzrepayment rzrepayment)
    {
        List<rzrepayment> list = rzrepaymentService.selectrzrepaymentList(rzrepayment);
        ExcelUtil<rzrepayment> util = new ExcelUtil<rzrepayment>(rzrepayment.class);
        util.exportExcel(response, list, "还款计划数据");
    }

    /**
     * 获取还款计划详细信息
     */
    @PreAuthorize("@ss.hasPermi('rzrepayment:repayment:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(rzrepaymentService.selectrzrepaymentById(id));
    }

    /**
     * 新增还款计划
     */
    @PreAuthorize("@ss.hasPermi('rzrepayment:repayment:add')")
    @Log(title = "还款计划", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody rzrepayment rzrepayment)
    {
        return toAjax(rzrepaymentService.insertrzrepayment(rzrepayment));
    }

    /**
     * 修改还款计划
     */
    @PreAuthorize("@ss.hasPermi('rzrepayment:repayment:edit')")
    @Log(title = "还款计划", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody rzrepayment rzrepayment)
    {
        return toAjax(rzrepaymentService.updaterzrepayment(rzrepayment));
    }

    /**
     * 删除还款计划
     */
    @PreAuthorize("@ss.hasPermi('rzrepayment:repayment:remove')")
    @Log(title = "还款计划", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(rzrepaymentService.deleterzrepaymentByIds(ids));
    }
}
