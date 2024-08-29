package com.rongzi.rzafterloan.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
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
import com.rongzi.rzafterloan.domain.rzafterloan;
import com.rongzi.rzafterloan.service.IrzafterloanService;
import com.rongzi.common.utils.poi.ExcelUtil;
import com.rongzi.common.core.page.TableDataInfo;

/**
 * 贷后管理Controller
 * 
 * @author rongzi
 * @date 2024-03-20
 */
@RestController
@RequestMapping("/rzafterloan/loan")
public class rzafterloanController extends BaseController
{
    @Autowired
    private IrzafterloanService rzafterloanService;

    /**
     * 查询贷后管理列表
     */
    @PreAuthorize("@ss.hasPermi('rzafterloan:loan:list')")
    @GetMapping("/list")
    public TableDataInfo list(rzafterloan rzafterloan)
    {
        startPage();
        List<rzafterloan> list = rzafterloanService.selectrzafterloanList(rzafterloan);
        TableDataInfo tableDataInfo = getDataTable(list);

        Map<String, BigDecimal> data = rzafterloanService.selectRzAfterLoanSum(rzafterloan);

        // 添加合计数据
        if (data != null) {
            tableDataInfo.addTotal("totalLoanAmount", data.get("total_loan_amount") != null ? data.get("total_loan_amount").longValue() : 0L);
            // 你可以根据需要添加其他汇总字段
        } else {
            tableDataInfo.addTotal("totalLoanAmount", 0L);
        }

        return tableDataInfo;
    }

    /**
     * 导出贷后管理列表
     */
    @PreAuthorize("@ss.hasPermi('rzafterloan:loan:export')")
    @Log(title = "贷后管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, rzafterloan rzafterloan)
    {
        List<rzafterloan> list = rzafterloanService.selectrzafterloanList(rzafterloan);
        ExcelUtil<rzafterloan> util = new ExcelUtil<rzafterloan>(rzafterloan.class);
        util.exportExcel(response, list, "贷后管理数据");
    }

    /**
     * 获取贷后管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('rzafterloan:loan:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(rzafterloanService.selectrzafterloanById(id));
    }

    /**
     * 新增贷后管理
     */
    @PreAuthorize("@ss.hasPermi('rzafterloan:loan:add')")
    @Log(title = "贷后管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody rzafterloan rzafterloan)
    {
        return toAjax(rzafterloanService.insertrzafterloan(rzafterloan));
    }

    /**
     * 修改贷后管理
     */
    @PreAuthorize("@ss.hasPermi('rzafterloan:loan:edit')")
    @Log(title = "贷后管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody rzafterloan rzafterloan)
    {
        return toAjax(rzafterloanService.updaterzafterloan(rzafterloan));
    }

    /**
     * 删除贷后管理
     */
    @PreAuthorize("@ss.hasPermi('rzafterloan:loan:remove')")
    @Log(title = "贷后管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(rzafterloanService.deleterzafterloanByIds(ids));
    }
}
