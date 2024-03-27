package com.rongzi.huankuanjihua.controller;

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
import com.rongzi.huankuanjihua.domain.RzhkjhMingxi;
import com.rongzi.huankuanjihua.service.IRzhkjhMingxiService;
import com.rongzi.common.utils.poi.ExcelUtil;
import com.rongzi.common.core.page.TableDataInfo;

/**
 * 还款计划明细Controller
 * 
 * @author rongzi
 * @date 2024-03-27
 */
@RestController
@RequestMapping("/huankuanjihua/mingxi")
public class RzhkjhMingxiController extends BaseController
{
    @Autowired
    private IRzhkjhMingxiService rzhkjhMingxiService;

    /**
     * 查询还款计划明细列表
     */
    @PreAuthorize("@ss.hasPermi('huankuanjihua:mingxi:list')")
    @GetMapping("/list")
    public TableDataInfo list(RzhkjhMingxi rzhkjhMingxi)
    {
        startPage();
        List<RzhkjhMingxi> list = rzhkjhMingxiService.selectRzhkjhMingxiList(rzhkjhMingxi);
        return getDataTable(list);
    }

    /**
     * 导出还款计划明细列表
     */
    @PreAuthorize("@ss.hasPermi('huankuanjihua:mingxi:export')")
    @Log(title = "还款计划明细", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, RzhkjhMingxi rzhkjhMingxi)
    {
        List<RzhkjhMingxi> list = rzhkjhMingxiService.selectRzhkjhMingxiList(rzhkjhMingxi);
        ExcelUtil<RzhkjhMingxi> util = new ExcelUtil<RzhkjhMingxi>(RzhkjhMingxi.class);
        util.exportExcel(response, list, "还款计划明细数据");
    }

    /**
     * 获取还款计划明细详细信息
     */
    @PreAuthorize("@ss.hasPermi('huankuanjihua:mingxi:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(rzhkjhMingxiService.selectRzhkjhMingxiById(id));
    }

    /**
     * 新增还款计划明细
     */
    @PreAuthorize("@ss.hasPermi('huankuanjihua:mingxi:add')")
    @Log(title = "还款计划明细", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody RzhkjhMingxi rzhkjhMingxi)
    {
        return toAjax(rzhkjhMingxiService.insertRzhkjhMingxi(rzhkjhMingxi));
    }

    /**
     * 修改还款计划明细
     */
    @PreAuthorize("@ss.hasPermi('huankuanjihua:mingxi:edit')")
    @Log(title = "还款计划明细", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody RzhkjhMingxi rzhkjhMingxi)
    {
        return toAjax(rzhkjhMingxiService.updateRzhkjhMingxi(rzhkjhMingxi));
    }

    /**
     * 删除还款计划明细
     */
    @PreAuthorize("@ss.hasPermi('huankuanjihua:mingxi:remove')")
    @Log(title = "还款计划明细", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(rzhkjhMingxiService.deleteRzhkjhMingxiByIds(ids));
    }
}
