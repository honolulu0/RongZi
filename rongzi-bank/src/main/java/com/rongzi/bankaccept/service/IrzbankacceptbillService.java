package com.rongzi.bankaccept.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.rongzi.bankaccept.domain.rzbankacceptbill;
import com.rongzi.appendix.domain.rzsrc2;
/**
 * 银行承兑汇票Service接口
 *
 * @author rongzi
 * @date 2024-05-30
 */
public interface IrzbankacceptbillService
{
    /**
     * 查询银行承兑汇票
     *
     * @param id 银行承兑汇票主键
     * @return 银行承兑汇票
     */
    public rzbankacceptbill selectrzbankacceptbillById(Long id);
    public rzbankacceptbill selectrzbankacceptbillByManagementId(String managementId);

    /**
     * 查询银行承兑汇票列表
     *
     * @param rzbankacceptbill 银行承兑汇票
     * @return 银行承兑汇票集合
     */
    public List<rzbankacceptbill> selectrzbankacceptbillList(rzbankacceptbill rzbankacceptbill);

    public Map<String, BigDecimal> selectrzbankacceptbillSum(rzbankacceptbill rzbankacceptbill);

    /**
     * 新增银行承兑汇票
     *
     * @param rzbankacceptbill 银行承兑汇票
     * @return 结果
     */
    public int insertrzbankacceptbill(rzbankacceptbill rzbankacceptbill);

    /**
     * 修改银行承兑汇票
     *
     * @param rzbankacceptbill 银行承兑汇票
     * @return 结果
     */
    public int updaterzbankacceptbill(rzbankacceptbill rzbankacceptbill);

    /**
     * 批量删除银行承兑汇票
     *
     * @param ids 需要删除的银行承兑汇票主键集合
     * @return 结果
     */
    public int deleterzbankacceptbillByIds(Long[] ids);

    /**
     * 删除银行承兑汇票信息
     *
     * @param id 银行承兑汇票主键
     * @return 结果
     */
    public int deleterzbankacceptbillById(Long id);
}
