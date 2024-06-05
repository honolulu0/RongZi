package com.rongzi.creditmanagement.controller;

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
import com.rongzi.creditmanagement.domain.rzcreditmanagement;
import com.rongzi.creditmanagement.service.IrzcreditmanagementService;
import com.rongzi.common.utils.poi.ExcelUtil;
import com.rongzi.common.core.page.TableDataInfo;

/**
 * 授信管理Controller
 *
 * @author rongzi
 * @date 2024-03-05
 */
@RestController
@RequestMapping("/creditmanagement/grant")
public class rzcreditmanagementController extends BaseController {
    @Autowired
    private IrzcreditmanagementService rzcreditmanagementService;


    /**
     * 查询授信管理列表
     */
    @PreAuthorize("@ss.hasPermi('creditmanagement:grant:list')")
    @GetMapping("/list")
    public TableDataInfo list(rzcreditmanagement rzcreditmanagement) {
        startPage();
        List<rzcreditmanagement> list = rzcreditmanagementService.selectrzcreditmanagementList(rzcreditmanagement);
        TableDataInfo tableDataInfo = getDataTable(list);

        Map<String, BigDecimal> data = rzcreditmanagementService.selectrzcreditmanagementSum(rzcreditmanagement);

        // 添加合计数据
        tableDataInfo.addTotal("totalCreditAmount", data.get("total_credit_amount").longValue());
        tableDataInfo.addTotal("totalUsedCreditAmount", data.get("total_used_credit_amount").longValue());
        tableDataInfo.addTotal("totalRemainingCreditAmount", data.get("total_remaining_credit_amount").longValue());

        return tableDataInfo;
    }

    /**
     * 导出授信管理列表
     */
    @PreAuthorize("@ss.hasPermi('creditmanagement:grant:export')")
    @Log(title = "授信管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, rzcreditmanagement rzcreditmanagement) {
        List<rzcreditmanagement> list = rzcreditmanagementService.selectrzcreditmanagementList(rzcreditmanagement);
        ExcelUtil<rzcreditmanagement> util = new ExcelUtil<rzcreditmanagement>(rzcreditmanagement.class);
        util.exportExcel(response, list, "授信管理数据");
    }

    /**
     * 获取授信管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('creditmanagement:grant:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(rzcreditmanagementService.selectrzcreditmanagementById(id));
    }

    /**
     * 新增授信管理
     */
    @PreAuthorize("@ss.hasPermi('creditmanagement:grant:add')")
    @Log(title = "授信管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody rzcreditmanagement rzcreditmanagement) {
        return toAjax(rzcreditmanagementService.insertrzcreditmanagement(rzcreditmanagement));
    }

    /**
     * 修改授信管理
     */
    @PreAuthorize("@ss.hasPermi('creditmanagement:grant:edit')")
    @Log(title = "授信管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody rzcreditmanagement rzcreditmanagement) {
        return toAjax(rzcreditmanagementService.updaterzcreditmanagement(rzcreditmanagement));
    }

    /**
     * 删除授信管理
     */
    @PreAuthorize("@ss.hasPermi('creditmanagement:grant:remove')")
    @Log(title = "授信管理", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(rzcreditmanagementService.deleterzcreditmanagementByIds(ids));
    }

    /**
     * 获取信用管理统计信息
     */

    @Log(title = "授信管理汇总", businessType = BusinessType.OTHER)
    @GetMapping("/summary")

    public AjaxResult getCreditManagementSummary() {
        String creditState = "已授信";  // 默认类型为 已授信
        Map<String, Map<String, Object>> summaryMap = rzcreditmanagementService.selectCreditManagementSummary(creditState);
        return success(summaryMap);
    }


    /**
     * 获取融资统计信息
     */

    @Log(title = "融资汇总", businessType = BusinessType.OTHER)
    @GetMapping("/finance/summary")

    public AjaxResult getFinanceSummary() {
        Map<String, Map<String, BigDecimal>> summary = rzcreditmanagementService.getFinanceSummary();
        return success(summary);
    }

    /**
     * 获取内外担保统计信息
     */

    @Log(title = "内外担保汇总", businessType = BusinessType.OTHER)
    @GetMapping("/guarantee/summary")

    public AjaxResult getGuaranteeSummary() {
        Map<String, Map<String, BigDecimal>> summary = rzcreditmanagementService.getGuaranteeSummary();
        return success(summary);
    }


}
