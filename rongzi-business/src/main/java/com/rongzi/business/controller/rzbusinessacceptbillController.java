package com.rongzi.business.controller;

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
import com.rongzi.business.domain.rzbusinessacceptbill;
import com.rongzi.business.service.IrzbusinessacceptbillService;
import com.rongzi.common.utils.poi.ExcelUtil;
import com.rongzi.common.core.page.TableDataInfo;

/**
 * 商业承兑汇票Controller
 *
 * @author rongzi
 * @date 2024-05-30
 */
@RestController
@RequestMapping("/business/bill")
public class rzbusinessacceptbillController extends BaseController
{
    @Autowired
    private IrzbusinessacceptbillService rzbusinessacceptbillService;

    /**
     * 查询商业承兑汇票列表
     */
    @PreAuthorize("@ss.hasPermi('business:bill:list')")
    @GetMapping("/list")
    public TableDataInfo list(rzbusinessacceptbill rzbusinessacceptbill)
    {
        startPage();
        List<rzbusinessacceptbill> list = rzbusinessacceptbillService.selectrzbusinessacceptbillList(rzbusinessacceptbill);
        return getDataTable(list);
    }

    /**
     * 导出商业承兑汇票列表
     */
    @PreAuthorize("@ss.hasPermi('business:bill:export')")
    @Log(title = "商业承兑汇票", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, rzbusinessacceptbill rzbusinessacceptbill)
    {
        List<rzbusinessacceptbill> list = rzbusinessacceptbillService.selectrzbusinessacceptbillList(rzbusinessacceptbill);
        ExcelUtil<rzbusinessacceptbill> util = new ExcelUtil<rzbusinessacceptbill>(rzbusinessacceptbill.class);
        util.exportExcel(response, list, "商业承兑汇票数据");
    }

    /**
     * 获取商业承兑汇票详细信息
     */
    @PreAuthorize("@ss.hasPermi('business:bill:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(rzbusinessacceptbillService.selectrzbusinessacceptbillById(id));
    }

    /**
     * 新增商业承兑汇票
     */
    @PreAuthorize("@ss.hasPermi('business:bill:add')")
    @Log(title = "商业承兑汇票", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody rzbusinessacceptbill rzbusinessacceptbill)
    {
        return toAjax(rzbusinessacceptbillService.insertrzbusinessacceptbill(rzbusinessacceptbill));
    }

    /**
     * 修改商业承兑汇票
     */
    @PreAuthorize("@ss.hasPermi('business:bill:edit')")
    @Log(title = "商业承兑汇票", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody rzbusinessacceptbill rzbusinessacceptbill)
    {
        return toAjax(rzbusinessacceptbillService.updaterzbusinessacceptbill(rzbusinessacceptbill));
    }

    /**
     * 删除商业承兑汇票
     */
    @PreAuthorize("@ss.hasPermi('business:bill:remove')")
    @Log(title = "商业承兑汇票", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(rzbusinessacceptbillService.deleterzbusinessacceptbillByIds(ids));
    }
}
