package com.rongzi.financingproject.controller;

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
import com.rongzi.financingproject.domain.rzfinancingproject;
import com.rongzi.financingproject.service.IrzfinancingprojectService;
import com.rongzi.common.utils.poi.ExcelUtil;
import com.rongzi.common.core.page.TableDataInfo;

/**
 * 融资项目Controller
 *
 * @author rongzi
 * @date 2024-05-28
 */
@RestController
@RequestMapping("/financingproject/project")
public class rzfinancingprojectController extends BaseController {
    @Autowired
    private IrzfinancingprojectService rzfinancingprojectService;

    /**
     * 查询融资项目列表
     */
    @PreAuthorize("@ss.hasPermi('financingproject:project:list')")
    @GetMapping("/list")
    public TableDataInfo list(rzfinancingproject rzfinancingproject) {
        startPage();
        List<rzfinancingproject> list = rzfinancingprojectService.selectrzfinancingprojectList(rzfinancingproject);
        return getDataTable(list);
    }

    /**
     * 导出融资项目列表
     */
    @PreAuthorize("@ss.hasPermi('financingproject:project:export')")
    @Log(title = "融资项目", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, rzfinancingproject rzfinancingproject) {
        List<rzfinancingproject> list = rzfinancingprojectService.selectrzfinancingprojectList(rzfinancingproject);
        ExcelUtil<rzfinancingproject> util = new ExcelUtil<rzfinancingproject>(rzfinancingproject.class);
        util.exportExcel(response, list, "融资项目数据");
    }

    /**
     * 获取融资项目详细信息
     */
    @PreAuthorize("@ss.hasPermi('financingproject:project:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(rzfinancingprojectService.selectrzfinancingprojectById(id));
    }


    // 根据 management_id 查询融资项目信息
    @PreAuthorize("@ss.hasPermi('financingproject:project:query')")
    @GetMapping(value = "/managementId/{managementId}")
    public AjaxResult getInfoByManagementId(@PathVariable("managementId") String managementId) {
        return success(rzfinancingprojectService.selectrzfinancingprojectByManagementId(managementId));
    }



    /**
     * 新增融资项目
     */
    @PreAuthorize("@ss.hasPermi('financingproject:project:add')")
    @Log(title = "融资项目", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody rzfinancingproject rzfinancingproject) {
        return toAjax(rzfinancingprojectService.insertrzfinancingproject(rzfinancingproject));
    }

    /**
     * 修改融资项目
     */
    @PreAuthorize("@ss.hasPermi('financingproject:project:edit')")
    @Log(title = "融资项目", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody rzfinancingproject rzfinancingproject) {
        return toAjax(rzfinancingprojectService.updaterzfinancingproject(rzfinancingproject));
    }

    /**
     * 删除融资项目
     */
    @PreAuthorize("@ss.hasPermi('financingproject:project:remove')")
    @Log(title = "融资项目", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(rzfinancingprojectService.deleterzfinancingprojectByIds(ids));
    }
}
