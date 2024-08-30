package com.rongzi.business.mapper;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.rongzi.appendix.domain.rzsrc2;
import com.rongzi.business.domain.rzbusinessacceptbill;

/**
 * 商业承兑汇票Mapper接口
 * 
 * @author rongzi
 * @date 2024-08-27
 */
public interface rzbusinessacceptbillMapper 
{
    /**
     * 查询商业承兑汇票
     * 
     * @param id 商业承兑汇票主键
     * @return 商业承兑汇票
     */
    public rzbusinessacceptbill selectrzbusinessacceptbillById(Long id);

    public rzbusinessacceptbill selectrzbusinessacceptbillByManagementId(String managementId);


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
     * 删除商业承兑汇票
     * 
     * @param id 商业承兑汇票主键
     * @return 结果
     */
    public int deleterzbusinessacceptbillById(Long id);

    /**
     * 批量删除商业承兑汇票
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleterzbusinessacceptbillByIds(Long[] ids);

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
     * 通过商业承兑汇票主键删除附件表信息
     * 
     * @param id 商业承兑汇票ID
     * @return 结果
     */
    public int deleterzsrc2ByScrUuid(String id);
}
