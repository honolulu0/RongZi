package com.rongzi.credit.controller;

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
import com.rongzi.credit.domain.rzcreditletter;
import com.rongzi.credit.service.IrzcreditletterService;
import com.rongzi.common.utils.poi.ExcelUtil;
import com.rongzi.common.core.page.TableDataInfo;

/**
 * 信用证Controller
 * 
 * @author rongzi
 * @date 2024-03-01
 */
@RestController
@RequestMapping("/credit/letter")
public class rzcreditletterController extends BaseController
{
    @Autowired
    private IrzcreditletterService rzcreditletterService;

    /**
     * 查询信用证列表
     */
    @PreAuthorize("@ss.hasPermi('credit:letter:list')")
    @GetMapping("/list")
    public TableDataInfo list(rzcreditletter rzcreditletter)
    {
        startPage();
        List<rzcreditletter> list = rzcreditletterService.selectrzcreditletterList(rzcreditletter);
        return getDataTable(list);
    }

    /**
     * 导出信用证列表
     */
    @PreAuthorize("@ss.hasPermi('credit:letter:export')")
    @Log(title = "信用证", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, rzcreditletter rzcreditletter)
    {
        List<rzcreditletter> list = rzcreditletterService.selectrzcreditletterList(rzcreditletter);
        ExcelUtil<rzcreditletter> util = new ExcelUtil<rzcreditletter>(rzcreditletter.class);
        util.exportExcel(response, list, "信用证数据");
    }

    /**
     * 获取信用证详细信息
     */
    @PreAuthorize("@ss.hasPermi('credit:letter:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(rzcreditletterService.selectrzcreditletterById(id));
    }

    /**
     * 新增信用证
     */
    @PreAuthorize("@ss.hasPermi('credit:letter:add')")
    @Log(title = "信用证", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody rzcreditletter rzcreditletter)
    {
        return toAjax(rzcreditletterService.insertrzcreditletter(rzcreditletter));
    }

    /**
     * 修改信用证
     */
    @PreAuthorize("@ss.hasPermi('credit:letter:edit')")
    @Log(title = "信用证", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody rzcreditletter rzcreditletter)
    {
        return toAjax(rzcreditletterService.updaterzcreditletter(rzcreditletter));
    }

    /**
     * 删除信用证
     */
    @PreAuthorize("@ss.hasPermi('credit:letter:remove')")
    @Log(title = "信用证", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(rzcreditletterService.deleterzcreditletterByIds(ids));
    }
}
