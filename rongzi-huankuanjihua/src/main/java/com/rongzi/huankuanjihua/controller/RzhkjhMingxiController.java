package com.rongzi.huankuanjihua.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.rongzi.huankuanjihua.domain.TotalRzhkjhMingxi;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.rongzi.common.annotation.Log;
import com.rongzi.common.core.controller.BaseController;
import com.rongzi.common.core.domain.AjaxResult;
import com.rongzi.common.enums.BusinessType;
import com.rongzi.huankuanjihua.domain.RzhkjhMingxi;
import com.rongzi.huankuanjihua.service.IRzhkjhMingxiService;
import com.rongzi.common.utils.poi.ExcelUtil;
import com.rongzi.common.core.page.TableDataInfo;

/**
 * 还款计划明细Controller
 *
 * @author rongzi
 * @date 2024-05-28
 */
@RestController
@RequestMapping("/huankuanjihua/mingxi")
public class RzhkjhMingxiController extends BaseController {
    @Autowired
    private IRzhkjhMingxiService rzhkjhMingxiService;

    /**
     * 查询还款计划明细列表
     */
    @PreAuthorize("@ss.hasPermi('huankuanjihua:mingxi:list')")
    @GetMapping("/list")
    public AjaxResult list(RzhkjhMingxi rzhkjhMingxi) {

        TotalRzhkjhMingxi totalRzhkjhMingxi = rzhkjhMingxiService.totalRzhkjhMingxi(rzhkjhMingxi);
        if (totalRzhkjhMingxi != null) {
            startPage();
            List<RzhkjhMingxi> list = rzhkjhMingxiService.selectRzhkjhMingxiList(rzhkjhMingxi);
            totalRzhkjhMingxi.setTableDataInfo(getDataTable(list));
        }

        return success(totalRzhkjhMingxi);
    }

    /**
     * 查询还款计划明细列表
     */
    @PreAuthorize("@ss.hasPermi('huankuanjihua:mingxi:list')")
    @GetMapping("/all")
    public TableDataInfo listAll(RzhkjhMingxi rzhkjhMingxi) {
        List<RzhkjhMingxi> list = rzhkjhMingxiService.selectRzhkjhMingxiList(rzhkjhMingxi);
        return getDataTable(list);
    }

    /**
     * 导出还款计划明细列表
     */
    @PreAuthorize("@ss.hasPermi('huankuanjihua:mingxi:export')")
    @Log(title = "还款计划明细", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, RzhkjhMingxi rzhkjhMingxi) {
        List<RzhkjhMingxi> list = rzhkjhMingxiService.selectRzhkjhMingxiList(rzhkjhMingxi);
        ExcelUtil<RzhkjhMingxi> util = new ExcelUtil<RzhkjhMingxi>(RzhkjhMingxi.class);
        util.exportExcel(response, list, "还款计划明细数据");
    }

    /**
     * 获取还款计划明细详细信息
     */
    @PreAuthorize("@ss.hasPermi('huankuanjihua:mingxi:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(rzhkjhMingxiService.selectRzhkjhMingxiById(id));
    }

    /**
     * 新增还款计划明细
     */
    @PreAuthorize("@ss.hasPermi('huankuanjihua:mingxi:add')")
    @Log(title = "还款计划明细", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody RzhkjhMingxi rzhkjhMingxi) {
        return toAjax(rzhkjhMingxiService.insertRzhkjhMingxi(rzhkjhMingxi));
    }

    /**
     * 修改还款计划明细
     */
    @PreAuthorize("@ss.hasPermi('huankuanjihua:mingxi:edit')")
    @Log(title = "还款计划明细", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody RzhkjhMingxi rzhkjhMingxi) {
        return toAjax(rzhkjhMingxiService.updateRzhkjhMingxi(rzhkjhMingxi));
    }

    /**
     * 删除还款计划明细
     */
    @PreAuthorize("@ss.hasPermi('huankuanjihua:mingxi:remove')")
    @Log(title = "还款计划明细", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(rzhkjhMingxiService.deleteRzhkjhMingxiByIds(ids));
    }


    @GetMapping(value = "/paymentSummary")
    public AjaxResult paymentSummary(
            @RequestParam(value = "startDate", required = false) String startDate,
            @RequestParam(value = "endDate", required = false) String endDate) {
        return success(rzhkjhMingxiService.getPaymentSummary(startDate, endDate));
    }

    @GetMapping(value = {"/financialSummaryByMonth", "/financialSummaryByMonth/{specifiedYearMonth}"})
    public AjaxResult getFinancialSummaryByMonth(@PathVariable(required = false) String specifiedYearMonth) {
        // 如果没有提供月份，则使用当前月份
        if (specifiedYearMonth == null) {
            specifiedYearMonth = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM"));
        }
        return success(rzhkjhMingxiService.getFinancialSummaryByMonth(specifiedYearMonth));
    }

    @GetMapping(value = {"/financialSummaryByDate", "/financialSummaryByDate/{specifiedDate}"})
    public AjaxResult getFinancialSummaryByDate(@PathVariable(required = false) String specifiedDate) {
//        筛选传入月份，但是小于传入日期的数据
        // 如果没有提供月份，则使用当前月份
        if (specifiedDate == null) {
            specifiedDate = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        }
        return success(rzhkjhMingxiService.getFinancialSummaryByDate(specifiedDate));
    }

    @GetMapping(value = {"/paymentSummaryByMonth", "/paymentSummaryByMonth/{specifiedYearMonth}"})
    public AjaxResult getPaymentSummaryByMonth(@PathVariable(required = false) String specifiedYearMonth) {
        // 如果没有提供月份，则使用当前月份
        if (specifiedYearMonth == null) {
            LocalDate nextMonth = LocalDate.now().with(TemporalAdjusters.firstDayOfNextMonth());
            specifiedYearMonth = nextMonth.format(DateTimeFormatter.ofPattern("yyyy-MM"));
        }
        return success(rzhkjhMingxiService.getPaymentSummaryByMonth(specifiedYearMonth));
    }

}
