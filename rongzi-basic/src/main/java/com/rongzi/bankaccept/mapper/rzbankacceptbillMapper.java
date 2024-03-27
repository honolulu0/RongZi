package com.rongzi.bankaccept.mapper;

import java.util.List;
import com.rongzi.bankaccept.domain.rzbankacceptbill;
import com.rongzi.bankaccept.domain.RzScr;

/**
 * 银行承兑汇票Mapper接口
 * 
 * @author rongzi
 * @date 2024-02-08
 */
public interface rzbankacceptbillMapper 
{
    /**
     * 查询银行承兑汇票
     * 
     * @param managementId 银行承兑汇票主键
     * @return 银行承兑汇票
     */
    public rzbankacceptbill selectrzbankacceptbillByManagementId(String managementId);

    /**
     * 查询银行承兑汇票列表
     * 
     * @param rzbankacceptbill 银行承兑汇票
     * @return 银行承兑汇票集合
     */
    public List<rzbankacceptbill> selectrzbankacceptbillList(rzbankacceptbill rzbankacceptbill);

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
     * @param managementId 银行承兑汇票主键
     * @return 结果
     */
    public int deleterzbankacceptbillByManagementId(String managementId);

    /**
     * 批量删除银行承兑汇票
     * 
     * @param managementIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleterzbankacceptbillByManagementIds(String[] managementIds);

    /**
     * 批量删除${subTable.functionName}
     * 
     * @param managementIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteRzScrByScrUuids(String[] managementIds);
    
    /**
     * 批量新增${subTable.functionName}
     * 
     * @param rzScrList ${subTable.functionName}列表
     * @return 结果
     */
    public int batchRzScr(List<RzScr> rzScrList);
    

    /**
     * 通过银行承兑汇票主键删除${subTable.functionName}信息
     * 
     * @param managementId 银行承兑汇票ID
     * @return 结果
     */
    public int deleteRzScrByScrUuid(String managementId);
}
