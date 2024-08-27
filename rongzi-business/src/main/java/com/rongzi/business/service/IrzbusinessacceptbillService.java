package com.rongzi.business.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.rongzi.business.domain.rzbusinessacceptbill;

/**
 * 商业承兑汇票Service接口
 * 
 * @author rongzi
 * @date 2024-08-27
 */
public interface IrzbusinessacceptbillService 
{
    /**
     * 查询商业承兑汇票
     * 
     * @param id 商业承兑汇票主键
     * @return 商业承兑汇票
     */
    public rzbusinessacceptbill selectrzbusinessacceptbillById(Long id);

    /**
     * 查询商业承兑汇票列表
     * 
     * @param rzbusinessacceptbill 商业承兑汇票
     * @return 商业承兑汇票集合
     */
    public List<rzbusinessacceptbill> selectrzbusinessacceptbillList(rzbusinessacceptbill rzbusinessacceptbill);
    public Map<String, BigDecimal> selectrzbusinessacceptbillSum(rzbusinessacceptbill rzbusinessacceptbill);


    /**
     * 新增商业承兑汇票
     * 
     * @param rzbusinessacceptbill 商业承兑汇票
     * @return 结果
     */
    public int insertrzbusinessacceptbill(rzbusinessacceptbill rzbusinessacceptbill);

    /**
     * 修改商业承兑汇票
     * 
     * @param rzbusinessacceptbill 商业承兑汇票
     * @return 结果
     */
    public int updaterzbusinessacceptbill(rzbusinessacceptbill rzbusinessacceptbill);

    /**
     * 批量删除商业承兑汇票
     * 
     * @param ids 需要删除的商业承兑汇票主键集合
     * @return 结果
     */
    public int deleterzbusinessacceptbillByIds(Long[] ids);

    /**
     * 删除商业承兑汇票信息
     * 
     * @param id 商业承兑汇票主键
     * @return 结果
     */
    public int deleterzbusinessacceptbillById(Long id);
}
