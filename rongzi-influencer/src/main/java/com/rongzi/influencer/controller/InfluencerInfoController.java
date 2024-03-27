package com.rongzi.influencer.controller;

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
import com.rongzi.influencer.domain.InfluencerInfo;
import com.rongzi.influencer.service.IInfluencerInfoService;
import com.rongzi.common.utils.poi.ExcelUtil;
import com.rongzi.common.core.page.TableDataInfo;

/**
 * 红人Controller
 * 
 * @author rongzi
 * @date 2023-07-26
 */
@RestController
@RequestMapping("/influencer/info")
public class InfluencerInfoController extends BaseController
{
    @Autowired
    private IInfluencerInfoService influencerInfoService;

    /**
     * 查询红人列表
     */
    @PreAuthorize("@ss.hasPermi('influencer:info:list')")
    @GetMapping("/list")
    public TableDataInfo list(InfluencerInfo influencerInfo)
    {
        startPage();
        List<InfluencerInfo> list = influencerInfoService.selectInfluencerInfoList(influencerInfo);
        return getDataTable(list);
    }

    /**
     * 导出红人列表
     */
    @PreAuthorize("@ss.hasPermi('influencer:info:export')")
    @Log(title = "红人", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, InfluencerInfo influencerInfo)
    {
        List<InfluencerInfo> list = influencerInfoService.selectInfluencerInfoList(influencerInfo);
        ExcelUtil<InfluencerInfo> util = new ExcelUtil<InfluencerInfo>(InfluencerInfo.class);
        util.exportExcel(response, list, "红人数据");
    }

    /**
     * 获取红人详细信息
     */
    @PreAuthorize("@ss.hasPermi('influencer:info:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(influencerInfoService.selectInfluencerInfoById(id));
    }

    /**
     * 新增红人
     */
    @PreAuthorize("@ss.hasPermi('influencer:info:add')")
    @Log(title = "红人", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody InfluencerInfo influencerInfo)
    {
        return toAjax(influencerInfoService.insertInfluencerInfo(influencerInfo));
    }

    /**
     * 修改红人
     */
    @PreAuthorize("@ss.hasPermi('influencer:info:edit')")
    @Log(title = "红人", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody InfluencerInfo influencerInfo)
    {
        return toAjax(influencerInfoService.updateInfluencerInfo(influencerInfo));
    }

    /**
     * 删除红人
     */
    @PreAuthorize("@ss.hasPermi('influencer:info:remove')")
    @Log(title = "红人", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(influencerInfoService.deleteInfluencerInfoByIds(ids));
    }
}
