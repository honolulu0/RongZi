package com.rongzi.business.service.impl;

import java.math.BigDecimal;
import java.util.List;

import com.rongzi.appendix.domain.rzsrc2;
import com.rongzi.common.utils.DateUtils;
import com.rongzi.huankuanjihua.HuankuanmingxiBatchOperationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Map;

import com.rongzi.common.utils.StringUtils;
import org.springframework.transaction.annotation.Transactional;
import com.rongzi.business.mapper.rzbusinessacceptbillMapper;
import com.rongzi.business.domain.rzbusinessacceptbill;
import com.rongzi.business.service.IrzbusinessacceptbillService;

/**
 * 商业承兑汇票Service业务层处理
 * 
 * @author rongzi
 * @date 2024-08-27
 */
@Service
public class rzbusinessacceptbillServiceImpl implements IrzbusinessacceptbillService 
{
    @Autowired
    private rzbusinessacceptbillMapper rzbusinessacceptbillMapper;

    @Autowired
    private HuankuanmingxiBatchOperationUtils huankuanmingxiBatchOperationUtils;

    /**
     * 查询商业承兑汇票
     * 
     * @param id 商业承兑汇票主键
     * @return 商业承兑汇票
     */
    @Override
    public rzbusinessacceptbill selectrzbusinessacceptbillById(Long id)
    {
        return rzbusinessacceptbillMapper.selectrzbusinessacceptbillById(id);
    }
    @Override
    public rzbusinessacceptbill selectrzbusinessacceptbillByManagementId(String managementId)
    {
        return rzbusinessacceptbillMapper.selectrzbusinessacceptbillByManagementId(managementId);
    }


    /**
     * 查询商业承兑汇票列表
     * 
     * @param rzbusinessacceptbill 商业承兑汇票
     * @return 商业承兑汇票
     */
    @Override
    public List<rzbusinessacceptbill> selectrzbusinessacceptbillList(rzbusinessacceptbill rzbusinessacceptbill)
    {
        return rzbusinessacceptbillMapper.selectrzbusinessacceptbillList(rzbusinessacceptbill);
    }

    @Override
    public Map<String, BigDecimal> selectrzbusinessacceptbillSum(rzbusinessacceptbill rzbusinessacceptbill) {
        return rzbusinessacceptbillMapper.selectrzbusinessacceptbillSum(rzbusinessacceptbill);
    }

    /**
     * 新增商业承兑汇票
     * 
     * @param rzbusinessacceptbill 商业承兑汇票
     * @return 结果
     */
    @Transactional
    @Override
    public int insertrzbusinessacceptbill(rzbusinessacceptbill rzbusinessacceptbill)
    {
        rzbusinessacceptbill.setCreateTime(DateUtils.getNowDate());
        int rows = rzbusinessacceptbillMapper.insertrzbusinessacceptbill(rzbusinessacceptbill);
        insertrzsrc2(rzbusinessacceptbill);
        huankuanmingxiBatchOperationUtils.batchinserthuankuanmingxi(rzbusinessacceptbill.getHuankuanmingxi2List(), rzbusinessacceptbill.getManagementId());
        return rows;
    }

    /**
     * 修改商业承兑汇票
     * 
     * @param rzbusinessacceptbill 商业承兑汇票
     * @return 结果
     */
    @Transactional
    @Override
    public int updaterzbusinessacceptbill(rzbusinessacceptbill rzbusinessacceptbill)
    {
        rzbusinessacceptbill.setUpdateTime(DateUtils.getNowDate());
        rzbusinessacceptbillMapper.deleterzsrc2ByScrUuid(rzbusinessacceptbill.getScrUuid());
        insertrzsrc2(rzbusinessacceptbill);
        huankuanmingxiBatchOperationUtils.deleterHuankuanmingxiByManagementId(rzbusinessacceptbill.getManagementId());
        huankuanmingxiBatchOperationUtils.batchinserthuankuanmingxi(rzbusinessacceptbill.getHuankuanmingxi2List(), rzbusinessacceptbill.getManagementId());
        return rzbusinessacceptbillMapper.updaterzbusinessacceptbill(rzbusinessacceptbill);
    }

    /**
     * 批量删除商业承兑汇票
     * 
     * @param ids 需要删除的商业承兑汇票主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleterzbusinessacceptbillByIds(Long[] ids)
    {
        rzbusinessacceptbillMapper.deleterzsrc2ByScrUuids(ids);
        return rzbusinessacceptbillMapper.deleterzbusinessacceptbillByIds(ids);
    }

    /**
     * 删除商业承兑汇票信息
     * 
     * @param id 商业承兑汇票主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleterzbusinessacceptbillById(Long id)
    {
        return rzbusinessacceptbillMapper.deleterzbusinessacceptbillById(id);
    }

    /**
     * 新增附件表信息
     * 
     * @param rzbusinessacceptbill 商业承兑汇票对象
     */
    public void insertrzsrc2(rzbusinessacceptbill rzbusinessacceptbill) {
        List<rzsrc2> rzsrc2List = rzbusinessacceptbill.getrzsrc2List();
//        Long id = rzbusinessacceptbill.getId();
        String uuidS = rzbusinessacceptbill.getScrUuid();
        if (StringUtils.isNotNull(rzsrc2List)) {
            List<rzsrc2> list = new ArrayList<rzsrc2>();
            for (rzsrc2 rzsrc2 : rzsrc2List) {
                rzsrc2.setScrUuid(uuidS);
                list.add(rzsrc2);
            }
            if (list.size() > 0) {
                rzbusinessacceptbillMapper.batchrzsrc2(list);
            }
        }
    }
}
