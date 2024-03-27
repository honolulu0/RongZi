package com.rongzi.appendix.controller;

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
import com.rongzi.appendix.domain.rzsrc2;
import com.rongzi.appendix.service.Irzsrc2Service;
import com.rongzi.common.utils.poi.ExcelUtil;
import com.rongzi.common.core.page.TableDataInfo;

/**
 * 附件表Controller
 * 
 * @author rongzi
 * @date 2024-02-08
 */
@RestController
@RequestMapping("/appendix/atta")
public class rzsrc2Controller extends BaseController
{
    @Autowired
    private Irzsrc2Service rzsrc2Service;

    /**
     * 查询附件表列表
     */
    @PreAuthorize("@ss.hasPermi('appendix:atta:list')")
    @GetMapping("/list")
    public TableDataInfo list(rzsrc2 rzsrc2)
    {
        startPage();
        List<rzsrc2> list = rzsrc2Service.selectrzsrc2List(rzsrc2);
        return getDataTable(list);
    }

    /**
     * 导出附件表列表
     */
    @PreAuthorize("@ss.hasPermi('appendix:atta:export')")
    @Log(title = "附件表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, rzsrc2 rzsrc2)
    {
        List<rzsrc2> list = rzsrc2Service.selectrzsrc2List(rzsrc2);
        ExcelUtil<rzsrc2> util = new ExcelUtil<rzsrc2>(rzsrc2.class);
        util.exportExcel(response, list, "附件表数据");
    }

    /**
     * 获取附件表详细信息
     */
    @PreAuthorize("@ss.hasPermi('appendix:atta:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(rzsrc2Service.selectrzsrc2ById(id));
    }

    /**
     * 新增附件表
     */
    @PreAuthorize("@ss.hasPermi('appendix:atta:add')")
    @Log(title = "附件表", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody rzsrc2 rzsrc2)
    {
        return toAjax(rzsrc2Service.insertrzsrc2(rzsrc2));
    }

    /**
     * 修改附件表
     */
    @PreAuthorize("@ss.hasPermi('appendix:atta:edit')")
    @Log(title = "附件表", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody rzsrc2 rzsrc2)
    {
        return toAjax(rzsrc2Service.updaterzsrc2(rzsrc2));
    }

    /**
     * 删除附件表
     */
    @PreAuthorize("@ss.hasPermi('appendix:atta:remove')")
    @Log(title = "附件表", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(rzsrc2Service.deleterzsrc2ByIds(ids));
    }



}
