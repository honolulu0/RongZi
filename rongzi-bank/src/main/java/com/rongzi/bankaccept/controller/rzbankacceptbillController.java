package com.rongzi.bankaccept.controller;

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
import com.rongzi.bankaccept.domain.rzbankacceptbill;
import com.rongzi.bankaccept.service.IrzbankacceptbillService;
import com.rongzi.common.utils.poi.ExcelUtil;
import com.rongzi.common.core.page.TableDataInfo;

/**
 * 银行承兑汇票Controller
 *
 * @author rongzi
 * @date 2024-05-30
 */
@RestController
@RequestMapping("/bankaccept/bank")
public class rzbankacceptbillController extends BaseController
{
    @Autowired
    private IrzbankacceptbillService rzbankacceptbillService;

    /**
     * 查询银行承兑汇票列表
     */
    @PreAuthorize("@ss.hasPermi('bankaccept:bank:list')")
    @GetMapping("/list")
    public TableDataInfo list(rzbankacceptbill rzbankacceptbill)
    {
        startPage();
        List<rzbankacceptbill> list = rzbankacceptbillService.selectrzbankacceptbillList(rzbankacceptbill);
        TableDataInfo tableDataInfo = getDataTable(list);

        Map<String, BigDecimal> data = rzbankacceptbillService.selectrzbankacceptbillSum(rzbankacceptbill);

        // 添加合计数据
        if (data != null) {
            tableDataInfo.addTotal("totalInvoiceAmount", data.get("total_invoice_amount") != null ? data.get("total_invoice_amount").longValue() : 0L);
            tableDataInfo.addTotal("totalChangkouedu", data.get("total_changkouedu") != null ? data.get("total_changkouedu").longValue() : 0L);
//            tableDataInfo.addTotal("totalMarginIncomeAmount", data.get("total_margin_income_amount") != null ? data.get("total_margin_income_amount").longValue() : 0L);
        } else {
            tableDataInfo.addTotal("totalInvoiceAmount", 0L);
            tableDataInfo.addTotal("totalChangkouedu", 0L);
//            tableDataInfo.addTotal("totalMarginIncomeAmount", 0L);
        }

        return tableDataInfo;
    }

    /**
     * 导出银行承兑汇票列表
     */
    @PreAuthorize("@ss.hasPermi('bankaccept:bank:export')")
    @Log(title = "银行承兑汇票", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, rzbankacceptbill rzbankacceptbill)
    {
        List<rzbankacceptbill> list = rzbankacceptbillService.selectrzbankacceptbillList(rzbankacceptbill);
        ExcelUtil<rzbankacceptbill> util = new ExcelUtil<rzbankacceptbill>(rzbankacceptbill.class);
        util.exportExcel(response, list, "银行承兑汇票数据");
    }

    /**
     * 获取银行承兑汇票详细信息
     */
    @PreAuthorize("@ss.hasPermi('bankaccept:bank:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(rzbankacceptbillService.selectrzbankacceptbillById(id));
    }

    @PreAuthorize("@ss.hasPermi('bankaccept:bank:query')")
    @GetMapping(value = "/managementId/{managementId}")
    public AjaxResult getInfoByManagementId(@PathVariable("managementId") String managementId) {
        return success(rzbankacceptbillService.selectrzbankacceptbillByManagementId(managementId));
    }


    /**
     * 新增银行承兑汇票
     */
    @PreAuthorize("@ss.hasPermi('bankaccept:bank:add')")
    @Log(title = "银行承兑汇票", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody rzbankacceptbill rzbankacceptbill)
    {
        return toAjax(rzbankacceptbillService.insertrzbankacceptbill(rzbankacceptbill));
    }

    /**
     * 修改银行承兑汇票
     */
    @PreAuthorize("@ss.hasPermi('bankaccept:bank:edit')")
    @Log(title = "银行承兑汇票", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody rzbankacceptbill rzbankacceptbill)
    {
        return toAjax(rzbankacceptbillService.updaterzbankacceptbill(rzbankacceptbill));
    }

    /**
     * 删除银行承兑汇票
     */
    @PreAuthorize("@ss.hasPermi('bankaccept:bank:remove')")
    @Log(title = "银行承兑汇票", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(rzbankacceptbillService.deleterzbankacceptbillByIds(ids));
    }
}
