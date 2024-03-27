package com.rongzi.rzlog.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.rongzi.rzlog.domain.LogFinancingProjectSummary;
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
import com.rongzi.rzlog.domain.RzlogFinancingProject;
import com.rongzi.rzlog.service.IRzlogFinancingProjectService;
import com.rongzi.common.utils.poi.ExcelUtil;
import com.rongzi.common.core.page.TableDataInfo;

/**
 * 历史融资查询Controller
 * 
 * @author rongzi
 * @date 2024-03-24
 */
@RestController
@RequestMapping("/rzlog/historyFinancing")
public class RzlogFinancingProjectController extends BaseController
{
    @Autowired
    private IRzlogFinancingProjectService rzlogFinancingProjectService;

    /**
     * 查询历史融资查询列表
     */
    @PreAuthorize("@ss.hasPermi('rzlog:historyFinancing:list')")
    @GetMapping("/list")
    public TableDataInfo list(RzlogFinancingProject rzlogFinancingProject)
    {
        startPage();
        List<RzlogFinancingProject> list = rzlogFinancingProjectService.selectRzlogFinancingProjectList(rzlogFinancingProject);
        return getDataTable(list);
    }

    /**
     * 查询历史融资查询列表
     */
    @PreAuthorize("@ss.hasPermi('rzlog:historyFinancing:summary')")
    @GetMapping("/summary")
    public TableDataInfo summary(RzlogFinancingProject rzlogFinancingProject)
    {
        startPage();
        List<LogFinancingProjectSummary> list = rzlogFinancingProjectService.selectFinancingProjectSummary(rzlogFinancingProject);
        return getDataTable(list);
    }

    /**
     * 导出历史融资查询列表
     */
    @PreAuthorize("@ss.hasPermi('rzlog:historyFinancing:export')")
    @Log(title = "历史融资查询", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, RzlogFinancingProject rzlogFinancingProject)
    {
        List<RzlogFinancingProject> list = rzlogFinancingProjectService.selectRzlogFinancingProjectList(rzlogFinancingProject);
        ExcelUtil<RzlogFinancingProject> util = new ExcelUtil<RzlogFinancingProject>(RzlogFinancingProject.class);
        util.exportExcel(response, list, "历史融资查询数据");
    }

    /**
     * 获取历史融资查询详细信息
     */
    @PreAuthorize("@ss.hasPermi('rzlog:historyFinancing:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(rzlogFinancingProjectService.selectRzlogFinancingProjectById(id));
    }

    /**
     * 新增历史融资查询
     */
    @PreAuthorize("@ss.hasPermi('rzlog:historyFinancing:add')")
    @Log(title = "历史融资查询", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody RzlogFinancingProject rzlogFinancingProject)
    {
        return toAjax(rzlogFinancingProjectService.insertRzlogFinancingProject(rzlogFinancingProject));
    }

    /**
     * 修改历史融资查询
     */
    @PreAuthorize("@ss.hasPermi('rzlog:historyFinancing:edit')")
    @Log(title = "历史融资查询", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody RzlogFinancingProject rzlogFinancingProject)
    {
        return toAjax(rzlogFinancingProjectService.updateRzlogFinancingProject(rzlogFinancingProject));
    }

    /**
     * 删除历史融资查询
     */
    @PreAuthorize("@ss.hasPermi('rzlog:historyFinancing:remove')")
    @Log(title = "历史融资查询", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(rzlogFinancingProjectService.deleteRzlogFinancingProjectByIds(ids));
    }
}
