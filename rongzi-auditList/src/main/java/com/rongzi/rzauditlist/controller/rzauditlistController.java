package com.rongzi.rzauditlist.controller;

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
import com.rongzi.rzauditlist.domain.rzauditlist;
import com.rongzi.rzauditlist.service.IrzauditlistService;
import com.rongzi.common.utils.poi.ExcelUtil;
import com.rongzi.common.core.page.TableDataInfo;

/**
 * 审核项目Controller
 * 
 * @author rongzi
 * @date 2024-02-19
 */
@RestController
@RequestMapping("/rzauditlist/list")
public class rzauditlistController extends BaseController
{
    @Autowired
    private IrzauditlistService rzauditlistService;

    /**
     * 查询审核项目列表
     */
    @PreAuthorize("@ss.hasPermi('rzauditlist:list:list')")
    @GetMapping("/list")
    public TableDataInfo list(rzauditlist rzauditlist)
    {
        startPage();
        List<rzauditlist> list = rzauditlistService.selectrzauditlistList(rzauditlist);
        return getDataTable(list);
    }

    /**
     * 导出审核项目列表
     */
    @PreAuthorize("@ss.hasPermi('rzauditlist:list:export')")
    @Log(title = "审核项目", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, rzauditlist rzauditlist)
    {
        List<rzauditlist> list = rzauditlistService.selectrzauditlistList(rzauditlist);
        ExcelUtil<rzauditlist> util = new ExcelUtil<rzauditlist>(rzauditlist.class);
        util.exportExcel(response, list, "审核项目数据");
    }

    /**
     * 获取审核项目详细信息
     */
    @PreAuthorize("@ss.hasPermi('rzauditlist:list:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(rzauditlistService.selectrzauditlistById(id));
    }

    /**
     * 新增审核项目
     */
    @PreAuthorize("@ss.hasPermi('rzauditlist:list:add')")
    @Log(title = "审核项目", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody rzauditlist rzauditlist)
    {
        return toAjax(rzauditlistService.insertrzauditlist(rzauditlist));
    }

    /**
     * 修改审核项目
     */
    @PreAuthorize("@ss.hasPermi('rzauditlist:list:edit')")
    @Log(title = "审核项目", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody rzauditlist rzauditlist)
    {
        return toAjax(rzauditlistService.updaterzauditlist(rzauditlist));
    }

    /**
     * 删除审核项目
     */
    @PreAuthorize("@ss.hasPermi('rzauditlist:list:remove')")
    @Log(title = "审核项目", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(rzauditlistService.deleterzauditlistByIds(ids));
    }
}
