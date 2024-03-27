package com.rongzi.basicData.controller;

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
import com.rongzi.basicData.domain.ChildDataTable;
import com.rongzi.basicData.service.IChildDataTableService;
import com.rongzi.common.utils.poi.ExcelUtil;
import com.rongzi.common.core.page.TableDataInfo;

/**
 * 基本数据详情Controller
 * 
 * @author rongzi
 * @date 2024-02-02
 */
@RestController
@RequestMapping("/basicData/dataInfo")
public class ChildDataTableController extends BaseController
{
    @Autowired
    private IChildDataTableService childDataTableService;

    /**
     * 查询基本数据详情列表
     */
    @PreAuthorize("@ss.hasPermi('basicData:dataInfo:list')")
    @GetMapping("/list")
    public TableDataInfo list(ChildDataTable childDataTable)
    {
        startPage();
        List<ChildDataTable> list = childDataTableService.selectChildDataTableList(childDataTable);
        return getDataTable(list);
    }

    /**
     * 导出基本数据详情列表
     */
    @PreAuthorize("@ss.hasPermi('basicData:dataInfo:export')")
    @Log(title = "基本数据详情", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ChildDataTable childDataTable)
    {
        List<ChildDataTable> list = childDataTableService.selectChildDataTableList(childDataTable);
        ExcelUtil<ChildDataTable> util = new ExcelUtil<ChildDataTable>(ChildDataTable.class);
        util.exportExcel(response, list, "基本数据详情数据");
    }

    /**
     * 获取基本数据详情详细信息
     */
    @PreAuthorize("@ss.hasPermi('basicData:dataInfo:query')")
    @GetMapping(value = "/{childDataId}")
    public AjaxResult getInfo(@PathVariable("childDataId") Long childDataId)
    {
        return success(childDataTableService.selectChildDataTableByChildDataId(childDataId));
    }

    /**
     * 新增基本数据详情
     */
    @PreAuthorize("@ss.hasPermi('basicData:dataInfo:add')")
    @Log(title = "基本数据详情", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ChildDataTable childDataTable)
    {
        return toAjax(childDataTableService.insertChildDataTable(childDataTable));
    }

    /**
     * 修改基本数据详情
     */
    @PreAuthorize("@ss.hasPermi('basicData:dataInfo:edit')")
    @Log(title = "基本数据详情", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ChildDataTable childDataTable)
    {
        return toAjax(childDataTableService.updateChildDataTable(childDataTable));
    }

    /**
     * 删除基本数据详情
     */
    @PreAuthorize("@ss.hasPermi('basicData:dataInfo:remove')")
    @Log(title = "基本数据详情", businessType = BusinessType.DELETE)
	@DeleteMapping("/{childDataIds}")
    public AjaxResult remove(@PathVariable Long[] childDataIds)
    {
        return toAjax(childDataTableService.deleteChildDataTableByChildDataIds(childDataIds));
    }
}
