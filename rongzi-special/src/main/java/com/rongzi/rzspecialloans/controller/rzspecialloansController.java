package com.rongzi.rzspecialloans.controller;

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
import com.rongzi.rzspecialloans.domain.rzspecialloans;
import com.rongzi.rzspecialloans.service.IrzspecialloansService;
import com.rongzi.common.utils.poi.ExcelUtil;
import com.rongzi.common.core.page.TableDataInfo;

/**
 * 专项借款Controller
 * 
 * @author rongzi
 * @date 2024-03-23
 */
@RestController
@RequestMapping("/rzspecialloans/special")
public class rzspecialloansController extends BaseController
{
    @Autowired
    private IrzspecialloansService rzspecialloansService;

    /**
     * 查询专项借款列表
     */
    @PreAuthorize("@ss.hasPermi('rzspecialloans:special:list')")
    @GetMapping("/list")
    public TableDataInfo list(rzspecialloans rzspecialloans)
    {
        startPage();
        List<rzspecialloans> list = rzspecialloansService.selectrzspecialloansList(rzspecialloans);
        TableDataInfo tableDataInfo = getDataTable(list);

        Map<String, BigDecimal> data = rzspecialloansService.selectrzspecialloansSum(rzspecialloans);

        // 添加合计数据
        tableDataInfo.addTotal("totalLoanAmount", data.get("totalLoanAmount").longValue());
        tableDataInfo.addTotal("totalRepaidAmount", data.get("totalRepaidAmount").longValue());
        tableDataInfo.addTotal("totalBalance", data.get("totalBalance").longValue());

        return tableDataInfo;
    }

    /**
     * 导出专项借款列表
     */
    @PreAuthorize("@ss.hasPermi('rzspecialloans:special:export')")
    @Log(title = "专项借款", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, rzspecialloans rzspecialloans)
    {
        List<rzspecialloans> list = rzspecialloansService.selectrzspecialloansList(rzspecialloans);
        ExcelUtil<rzspecialloans> util = new ExcelUtil<rzspecialloans>(rzspecialloans.class);
        util.exportExcel(response, list, "专项借款数据");
    }

    /**
     * 获取专项借款详细信息
     */
    @PreAuthorize("@ss.hasPermi('rzspecialloans:special:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(rzspecialloansService.selectrzspecialloansById(id));
    }

    /**
     * 新增专项借款
     */
    @PreAuthorize("@ss.hasPermi('rzspecialloans:special:add')")
    @Log(title = "专项借款", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody rzspecialloans rzspecialloans)
    {
        return toAjax(rzspecialloansService.insertrzspecialloans(rzspecialloans));
    }

    /**
     * 修改专项借款
     */
    @PreAuthorize("@ss.hasPermi('rzspecialloans:special:edit')")
    @Log(title = "专项借款", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody rzspecialloans rzspecialloans)
    {
        return toAjax(rzspecialloansService.updaterzspecialloans(rzspecialloans));
    }

    /**
     * 删除专项借款
     */
    @PreAuthorize("@ss.hasPermi('rzspecialloans:special:remove')")
    @Log(title = "专项借款", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(rzspecialloansService.deleterzspecialloansByIds(ids));
    }
}
