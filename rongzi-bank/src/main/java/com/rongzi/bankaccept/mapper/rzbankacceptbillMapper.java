package com.rongzi.bankaccept.mapper;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.rongzi.bankaccept.domain.rzbankacceptbill;
import com.rongzi.appendix.domain.rzsrc2;

/**
 * 银行承兑汇票Mapper接口
 *
 * @author rongzi
 * @date 2024-05-30
 */
public interface rzbankacceptbillMapper {
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
     * 删除银行承兑汇票
     *
     * @param id 银行承兑汇票主键
     * @return 结果
     */
    public int deleterzbankacceptbillById(Long id);

    /**
     * 批量删除银行承兑汇票
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleterzbankacceptbillByIds(Long[] ids);

    /**
     * 批量删除附件表
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleterzsrc2ByScrUuids(Long[] ids);

    /**
     * 批量新增附件表
     *
     * @param rzsrc2List 附件表列表
     * @return 结果
     */
    public int batchrzsrc2(List<rzsrc2> rzsrc2List);


    /**
     * 通过银行承兑汇票主键删除附件表信息
     *
     * @param id 银行承兑汇票ID
     * @return 结果
     */
    public int deleterzsrc2ByScrUuid(String id);
}
