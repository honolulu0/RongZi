package com.rongzi.reverse.controller;

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
import com.rongzi.reverse.domain.rzreversefactoring;
import com.rongzi.reverse.service.IrzreversefactoringService;
import com.rongzi.common.utils.poi.ExcelUtil;
import com.rongzi.common.core.page.TableDataInfo;

/**
 * 反向保理Controller
 *
 * @author rongzi
 * @date 2024-05-30
 */
@RestController
@RequestMapping("/reverse/factoring")
public class rzreversefactoringController extends BaseController
{
    @Autowired
    private IrzreversefactoringService rzreversefactoringService;

    /**
     * 查询反向保理列表
     */
    @PreAuthorize("@ss.hasPermi('reverse:factoring:list')")
    @GetMapping("/list")
    public TableDataInfo list(rzreversefactoring rzreversefactoring)
    {
        startPage();
        List<rzreversefactoring> list = rzreversefactoringService.selectrzreversefactoringList(rzreversefactoring);
        TableDataInfo tableDataInfo = getDataTable(list);

        Map<String, BigDecimal> data = rzreversefactoringService.selectrzreversefactoringSum(rzreversefactoring);

        // 添加合计数据
        if (data != null) {
            tableDataInfo.addTotal("totalLoanAmount", data.get("total_loan_amount") != null ? data.get("total_loan_amount").longValue() : 0L);
            // 你可以根据需要添加其他合计数据
        } else {
            tableDataInfo.addTotal("totalLoanAmount", 0L);
        }

        return tableDataInfo;
    }

    /**
     * 导出反向保理列表
     */
    @PreAuthorize("@ss.hasPermi('reverse:factoring:export')")
    @Log(title = "反向保理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, rzreversefactoring rzreversefactoring)
    {
        List<rzreversefactoring> list = rzreversefactoringService.selectrzreversefactoringList(rzreversefactoring);
        ExcelUtil<rzreversefactoring> util = new ExcelUtil<rzreversefactoring>(rzreversefactoring.class);
        util.exportExcel(response, list, "反向保理数据");
    }

    /**
     * 获取反向保理详细信息
     */
    @PreAuthorize("@ss.hasPermi('reverse:factoring:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(rzreversefactoringService.selectrzreversefactoringById(id));
    }

    /**
     * 新增反向保理
     */
    @PreAuthorize("@ss.hasPermi('reverse:factoring:add')")
    @Log(title = "反向保理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody rzreversefactoring rzreversefactoring)
    {
        return toAjax(rzreversefactoringService.insertrzreversefactoring(rzreversefactoring));
    }

    /**
     * 修改反向保理
     */
    @PreAuthorize("@ss.hasPermi('reverse:factoring:edit')")
    @Log(title = "反向保理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody rzreversefactoring rzreversefactoring)
    {
        return toAjax(rzreversefactoringService.updaterzreversefactoring(rzreversefactoring));
    }

    /**
     * 删除反向保理
     */
    @PreAuthorize("@ss.hasPermi('reverse:factoring:remove')")
    @Log(title = "反向保理", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(rzreversefactoringService.deleterzreversefactoringByIds(ids));
    }
}
