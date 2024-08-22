package com.rongzi.glinternal.controller;

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
import com.rongzi.glinternal.domain.glinternal;
import com.rongzi.glinternal.service.IglinternalService;
import com.rongzi.common.utils.poi.ExcelUtil;
import com.rongzi.common.core.page.TableDataInfo;

/**
 * 对内担保台账Controller
 *
 * @author rongzi
 * @date 2024-05-31
 */
@RestController
@RequestMapping("/glinternal/internal")
public class glinternalController extends BaseController
{
    @Autowired
    private IglinternalService glinternalService;

    /**
     * 查询对内担保台账列表
     */
    @PreAuthorize("@ss.hasPermi('glinternal:internal:list')")
    @GetMapping("/list")
    public TableDataInfo list(glinternal glinternal)
    {
        startPage();
        List<glinternal> list = glinternalService.selectglinternalList(glinternal);
        TableDataInfo tableDataInfo = getDataTable(list);

        Map<String, BigDecimal> data = glinternalService.selectGlInternalSum(glinternal);

        // 添加合计数据
        if (data != null) {
            tableDataInfo.addTotal("totalGuaranteeAmount", data.get("total_guarantee_amount") != null ? data.get("total_guarantee_amount").longValue() : 0L);
            tableDataInfo.addTotal("totalGuaranteeBalance", data.get("total_guarantee_balance") != null ? data.get("total_guarantee_balance").longValue() : 0L);
//            tableDataInfo.addTotal("totalFinancingAmount", data.get("total_financing_amount") != null ? data.get("total_financing_amount").longValue() : 0L);
        } else {
            tableDataInfo.addTotal("totalGuaranteeAmount", 0L);
            tableDataInfo.addTotal("totalGuaranteeBalance", 0L);
//            tableDataInfo.addTotal("totalFinancingAmount", 0L);
        }

        return tableDataInfo;
    }

    /**
     * 导出对内担保台账列表
     */
    @PreAuthorize("@ss.hasPermi('glinternal:internal:export')")
    @Log(title = "对内担保台账", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, glinternal glinternal)
    {
        List<glinternal> list = glinternalService.selectglinternalList(glinternal);
        ExcelUtil<glinternal> util = new ExcelUtil<glinternal>(glinternal.class);
        util.exportExcel(response, list, "对内担保台账数据");
    }

    /**
     * 获取对内担保台账详细信息
     */
    @PreAuthorize("@ss.hasPermi('glinternal:internal:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(glinternalService.selectglinternalById(id));
    }

    /**
     * 新增对内担保台账
     */
    @PreAuthorize("@ss.hasPermi('glinternal:internal:add')")
    @Log(title = "对内担保台账", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody glinternal glinternal)
    {
        return toAjax(glinternalService.insertglinternal(glinternal));
    }

    /**
     * 修改对内担保台账
     */
    @PreAuthorize("@ss.hasPermi('glinternal:internal:edit')")
    @Log(title = "对内担保台账", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody glinternal glinternal)
    {
        return toAjax(glinternalService.updateglinternal(glinternal));
    }

    /**
     * 删除对内担保台账
     */
    @PreAuthorize("@ss.hasPermi('glinternal:internal:remove')")
    @Log(title = "对内担保台账", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(glinternalService.deleteglinternalByIds(ids));
    }
}
