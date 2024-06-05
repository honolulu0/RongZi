package com.rongzi.rzinternalborrowing.controller;

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
import com.rongzi.rzinternalborrowing.domain.rzinternalborrowing;
import com.rongzi.rzinternalborrowing.service.IrzinternalborrowingService;
import com.rongzi.common.utils.poi.ExcelUtil;
import com.rongzi.common.core.page.TableDataInfo;

/**
 * 内部借款Controller
 * 
 * @author rongzi
 * @date 2024-03-20
 */
@RestController
@RequestMapping("/rzinternalborrowing/borrowing")
public class rzinternalborrowingController extends BaseController
{
    @Autowired
    private IrzinternalborrowingService rzinternalborrowingService;

    /**
     * 查询内部借款列表
     */
    @PreAuthorize("@ss.hasPermi('rzinternalborrowing:borrowing:list')")
    @GetMapping("/list")
    public TableDataInfo list(rzinternalborrowing rzinternalborrowing)
    {
        startPage();
        List<rzinternalborrowing> list = rzinternalborrowingService.selectrzinternalborrowingList(rzinternalborrowing);
        TableDataInfo tableDataInfo = getDataTable(list);

        Map<String, BigDecimal> data = rzinternalborrowingService.selectrzinternalborrowingSum(rzinternalborrowing);

        // 添加合计数据
        tableDataInfo.addTotal("totalLoanAmount", data.get("totalLoanAmount").longValue());

        return tableDataInfo;
    }

    /**
     * 导出内部借款列表
     */
    @PreAuthorize("@ss.hasPermi('rzinternalborrowing:borrowing:export')")
    @Log(title = "内部借款", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, rzinternalborrowing rzinternalborrowing)
    {
        List<rzinternalborrowing> list = rzinternalborrowingService.selectrzinternalborrowingList(rzinternalborrowing);
        ExcelUtil<rzinternalborrowing> util = new ExcelUtil<rzinternalborrowing>(rzinternalborrowing.class);
        util.exportExcel(response, list, "内部借款数据");
    }

    /**
     * 获取内部借款详细信息
     */
    @PreAuthorize("@ss.hasPermi('rzinternalborrowing:borrowing:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(rzinternalborrowingService.selectrzinternalborrowingById(id));
    }

    /**
     * 新增内部借款
     */
    @PreAuthorize("@ss.hasPermi('rzinternalborrowing:borrowing:add')")
    @Log(title = "内部借款", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody rzinternalborrowing rzinternalborrowing)
    {
        return toAjax(rzinternalborrowingService.insertrzinternalborrowing(rzinternalborrowing));
    }

    /**
     * 修改内部借款
     */
    @PreAuthorize("@ss.hasPermi('rzinternalborrowing:borrowing:edit')")
    @Log(title = "内部借款", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody rzinternalborrowing rzinternalborrowing)
    {
        return toAjax(rzinternalborrowingService.updaterzinternalborrowing(rzinternalborrowing));
    }

    /**
     * 删除内部借款
     */
    @PreAuthorize("@ss.hasPermi('rzinternalborrowing:borrowing:remove')")
    @Log(title = "内部借款", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(rzinternalborrowingService.deleterzinternalborrowingByIds(ids));
    }
}
