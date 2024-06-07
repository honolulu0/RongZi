package com.rongzi.glforeign.controller;

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
import com.rongzi.glforeign.domain.rzglforeign;
import com.rongzi.glforeign.service.IrzglforeignService;
import com.rongzi.common.utils.poi.ExcelUtil;
import com.rongzi.common.core.page.TableDataInfo;

/**
 * 对外担保台账Controller
 *
 * @author rongzi
 * @date 2024-05-30
 */
@RestController
@RequestMapping("/glforeign/foreign")
public class rzglforeignController extends BaseController
{
    @Autowired
    private IrzglforeignService rzglforeignService;

    /**
     * 查询对外担保台账列表
     */
    @PreAuthorize("@ss.hasPermi('glforeign:foreign:list')")
    @GetMapping("/list")
    public TableDataInfo list(rzglforeign rzglforeign)
    {
        startPage();
        List<rzglforeign> list = rzglforeignService.selectrzglforeignList(rzglforeign);
        TableDataInfo tableDataInfo = getDataTable(list);

        Map<String, BigDecimal> data = rzglforeignService.selectrzglforeignSum(rzglforeign);

        // 添加合计数据
        if (data != null) {
            tableDataInfo.addTotal("totalGuaranteeAmount", data.get("totalGuaranteeAmount") != null ? data.get("totalGuaranteeAmount").longValue() : 0L);
            tableDataInfo.addTotal("totalGuaranteeBalance", data.get("totalGuaranteeBalance") != null ? data.get("totalGuaranteeBalance").longValue() : 0L);
        } else {
            tableDataInfo.addTotal("totalGuaranteeAmount", 0L);
            tableDataInfo.addTotal("totalGuaranteeBalance", 0L);
        }


        return tableDataInfo;
    }

    /**
     * 导出对外担保台账列表
     */
    @PreAuthorize("@ss.hasPermi('glforeign:foreign:export')")
    @Log(title = "对外担保台账", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, rzglforeign rzglforeign)
    {
        List<rzglforeign> list = rzglforeignService.selectrzglforeignList(rzglforeign);
        ExcelUtil<rzglforeign> util = new ExcelUtil<rzglforeign>(rzglforeign.class);
        util.exportExcel(response, list, "对外担保台账数据");
    }

    /**
     * 获取对外担保台账详细信息
     */
    @PreAuthorize("@ss.hasPermi('glforeign:foreign:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(rzglforeignService.selectrzglforeignById(id));
    }

    /**
     * 新增对外担保台账
     */
    @PreAuthorize("@ss.hasPermi('glforeign:foreign:add')")
    @Log(title = "对外担保台账", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody rzglforeign rzglforeign)
    {
        return toAjax(rzglforeignService.insertrzglforeign(rzglforeign));
    }

    /**
     * 修改对外担保台账
     */
    @PreAuthorize("@ss.hasPermi('glforeign:foreign:edit')")
    @Log(title = "对外担保台账", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody rzglforeign rzglforeign)
    {
        return toAjax(rzglforeignService.updaterzglforeign(rzglforeign));
    }

    /**
     * 删除对外担保台账
     */
    @PreAuthorize("@ss.hasPermi('glforeign:foreign:remove')")
    @Log(title = "对外担保台账", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(rzglforeignService.deleterzglforeignByIds(ids));
    }
}
