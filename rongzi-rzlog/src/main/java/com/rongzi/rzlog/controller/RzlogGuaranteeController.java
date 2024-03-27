package com.rongzi.rzlog.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.rongzi.rzlog.domain.LogGuaranteeSummary;
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
import com.rongzi.rzlog.domain.RzlogGuarantee;
import com.rongzi.rzlog.service.IRzlogGuaranteeService;
import com.rongzi.common.utils.poi.ExcelUtil;
import com.rongzi.common.core.page.TableDataInfo;

/**
 * 历史担保Controller
 *
 * @author rongzi
 * @date 2024-03-24
 */
@RestController
@RequestMapping("/rzlog/historyGuarantee")
public class RzlogGuaranteeController extends BaseController {
    @Autowired
    private IRzlogGuaranteeService rzlogGuaranteeService;

    /**
     * 查询历史担保列表
     */
    @PreAuthorize("@ss.hasPermi('rzlog:historyGuarantee:list')")
    @GetMapping("/list")
    public TableDataInfo list(RzlogGuarantee rzlogGuarantee) {
        startPage();
        List<RzlogGuarantee> list = rzlogGuaranteeService.selectRzlogGuaranteeList(rzlogGuarantee);
        return getDataTable(list);
    }

    /**
     * 查询历史担保列表
     */
    @PreAuthorize("@ss.hasPermi('rzlog:historyGuarantee:summary')")
    @GetMapping("/summary")
    public TableDataInfo summary(RzlogGuarantee rzlogGuarantee) {
        startPage();
        List<LogGuaranteeSummary> list = rzlogGuaranteeService.getGuaranteeSummary(rzlogGuarantee);
        return getDataTable(list);
    }

    /**
     * 导出历史担保列表
     */
    @PreAuthorize("@ss.hasPermi('rzlog:historyGuarantee:export')")
    @Log(title = "历史担保", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, RzlogGuarantee rzlogGuarantee) {
        List<RzlogGuarantee> list = rzlogGuaranteeService.selectRzlogGuaranteeList(rzlogGuarantee);
        ExcelUtil<RzlogGuarantee> util = new ExcelUtil<RzlogGuarantee>(RzlogGuarantee.class);
        util.exportExcel(response, list, "历史担保数据");
    }

    /**
     * 获取历史担保详细信息
     */
    @PreAuthorize("@ss.hasPermi('rzlog:historyGuarantee:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(rzlogGuaranteeService.selectRzlogGuaranteeById(id));
    }

    /**
     * 新增历史担保
     */
    @PreAuthorize("@ss.hasPermi('rzlog:historyGuarantee:add')")
    @Log(title = "历史担保", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody RzlogGuarantee rzlogGuarantee) {
        return toAjax(rzlogGuaranteeService.insertRzlogGuarantee(rzlogGuarantee));
    }

    /**
     * 修改历史担保
     */
    @PreAuthorize("@ss.hasPermi('rzlog:historyGuarantee:edit')")
    @Log(title = "历史担保", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody RzlogGuarantee rzlogGuarantee) {
        return toAjax(rzlogGuaranteeService.updateRzlogGuarantee(rzlogGuarantee));
    }

    /**
     * 删除历史担保
     */
    @PreAuthorize("@ss.hasPermi('rzlog:historyGuarantee:remove')")
    @Log(title = "历史担保", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(rzlogGuaranteeService.deleteRzlogGuaranteeByIds(ids));
    }
}
