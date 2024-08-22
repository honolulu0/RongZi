package com.rongzi.government.controller;

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
import com.rongzi.government.domain.rzgovernmentspecialbonds;
import com.rongzi.government.service.IrzgovernmentspecialbondsService;
import com.rongzi.common.utils.poi.ExcelUtil;
import com.rongzi.common.core.page.TableDataInfo;

/**
 * 政府专项债Controller
 * 
 * @author rongzi
 * @date 2024-03-23
 */
@RestController
@RequestMapping("/government/bonds")
public class rzgovernmentspecialbondsController extends BaseController
{
    @Autowired
    private IrzgovernmentspecialbondsService rzgovernmentspecialbondsService;

    /**
     * 查询政府专项债列表
     */
    @PreAuthorize("@ss.hasPermi('government:bonds:list')")
    @GetMapping("/list")
    public TableDataInfo list(rzgovernmentspecialbonds rzgovernmentspecialbonds)
    {
        startPage();
        List<rzgovernmentspecialbonds> list = rzgovernmentspecialbondsService.selectrzgovernmentspecialbondsList(rzgovernmentspecialbonds);

        TableDataInfo tableDataInfo = getDataTable(list);

        Map<String, BigDecimal> data = rzgovernmentspecialbondsService.selectrzgovernmentspecialbondsSum(rzgovernmentspecialbonds);

        // 添加合计数据
        if (data != null) {
            tableDataInfo.addTotal("totalApprovedAmount", data.get("total_approved_amount") != null ? data.get("total_approved_amount").longValue() : 0L);
            tableDataInfo.addTotal("totalAccumulatedAmountReceived", data.get("total_accumulated_amount_received") != null ? data.get("total_accumulated_amount_received").longValue() : 0L);
            tableDataInfo.addTotal("totalRepaidAmount", data.get("total_repaid_amount") != null ? data.get("total_repaid_amount").longValue() : 0L);
            tableDataInfo.addTotal("totalRemainingAmount", data.get("total_remaining_amount") != null ? data.get("total_remaining_amount").longValue() : 0L);
        } else {
            tableDataInfo.addTotal("totalApprovedAmount", 0L);
            tableDataInfo.addTotal("totalAccumulatedAmountReceived", 0L);
            tableDataInfo.addTotal("totalRepaidAmount", 0L);
            tableDataInfo.addTotal("totalRemainingAmount", 0L);
        }

        return tableDataInfo;

    }


    /**
     * 导出政府专项债列表
     */
    @PreAuthorize("@ss.hasPermi('government:bonds:export')")
    @Log(title = "政府专项债", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, rzgovernmentspecialbonds rzgovernmentspecialbonds)
    {
        List<rzgovernmentspecialbonds> list = rzgovernmentspecialbondsService.selectrzgovernmentspecialbondsList(rzgovernmentspecialbonds);
        ExcelUtil<rzgovernmentspecialbonds> util = new ExcelUtil<rzgovernmentspecialbonds>(rzgovernmentspecialbonds.class);
        util.exportExcel(response, list, "政府专项债数据");
    }

    /**
     * 获取政府专项债详细信息
     */
    @PreAuthorize("@ss.hasPermi('government:bonds:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(rzgovernmentspecialbondsService.selectrzgovernmentspecialbondsById(id));
    }

    /**
     * 新增政府专项债
     */
    @PreAuthorize("@ss.hasPermi('government:bonds:add')")
    @Log(title = "政府专项债", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody rzgovernmentspecialbonds rzgovernmentspecialbonds)
    {
        return toAjax(rzgovernmentspecialbondsService.insertrzgovernmentspecialbonds(rzgovernmentspecialbonds));
    }

    /**
     * 修改政府专项债
     */
    @PreAuthorize("@ss.hasPermi('government:bonds:edit')")
    @Log(title = "政府专项债", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody rzgovernmentspecialbonds rzgovernmentspecialbonds)
    {
        return toAjax(rzgovernmentspecialbondsService.updaterzgovernmentspecialbonds(rzgovernmentspecialbonds));
    }

    /**
     * 删除政府专项债
     */
    @PreAuthorize("@ss.hasPermi('government:bonds:remove')")
    @Log(title = "政府专项债", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(rzgovernmentspecialbondsService.deleterzgovernmentspecialbondsByIds(ids));
    }
}
