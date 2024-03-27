package com.rongzi.bankaccept.service.impl;

import java.util.List;
import com.rongzi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import com.rongzi.common.utils.StringUtils;
import org.springframework.transaction.annotation.Transactional;
import com.rongzi.bankaccept.domain.RzScr;
import com.rongzi.bankaccept.mapper.rzbankacceptbillMapper;
import com.rongzi.bankaccept.domain.rzbankacceptbill;
import com.rongzi.bankaccept.service.IrzbankacceptbillService;

/**
 * 银行承兑汇票Service业务层处理
 * 
 * @author rongzi
 * @date 2024-02-08
 */
@Service
public class rzbankacceptbillServiceImpl implements IrzbankacceptbillService 
{
    @Autowired
    private rzbankacceptbillMapper rzbankacceptbillMapper;

    /**
     * 查询银行承兑汇票
     * 
     * @param managementId 银行承兑汇票主键
     * @return 银行承兑汇票
     */
    @Override
    public rzbankacceptbill selectrzbankacceptbillByManagementId(String managementId)
    {
        return rzbankacceptbillMapper.selectrzbankacceptbillByManagementId(managementId);
    }

    /**
     * 查询银行承兑汇票列表
     * 
     * @param rzbankacceptbill 银行承兑汇票
     * @return 银行承兑汇票
     */
    @Override
    public List<rzbankacceptbill> selectrzbankacceptbillList(rzbankacceptbill rzbankacceptbill)
    {
        return rzbankacceptbillMapper.selectrzbankacceptbillList(rzbankacceptbill);
    }

    /**
     * 新增银行承兑汇票
     * 
     * @param rzbankacceptbill 银行承兑汇票
     * @return 结果
     */
    @Transactional
    @Override
    public int insertrzbankacceptbill(rzbankacceptbill rzbankacceptbill)
    {
        rzbankacceptbill.setCreateTime(DateUtils.getNowDate());
        int rows = rzbankacceptbillMapper.insertrzbankacceptbill(rzbankacceptbill);
        insertRzScr(rzbankacceptbill);
        return rows;
    }

    /**
     * 修改银行承兑汇票
     * 
     * @param rzbankacceptbill 银行承兑汇票
     * @return 结果
     */
    @Transactional
    @Override
    public int updaterzbankacceptbill(rzbankacceptbill rzbankacceptbill)
    {
        rzbankacceptbill.setUpdateTime(DateUtils.getNowDate());
        rzbankacceptbillMapper.deleteRzScrByScrUuid(rzbankacceptbill.getManagementId());
        insertRzScr(rzbankacceptbill);
        return rzbankacceptbillMapper.updaterzbankacceptbill(rzbankacceptbill);
    }

    /**
     * 批量删除银行承兑汇票
     * 
     * @param managementIds 需要删除的银行承兑汇票主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleterzbankacceptbillByManagementIds(String[] managementIds)
    {
        rzbankacceptbillMapper.deleteRzScrByScrUuids(managementIds);
        return rzbankacceptbillMapper.deleterzbankacceptbillByManagementIds(managementIds);
    }

    /**
     * 删除银行承兑汇票信息
     * 
     * @param managementId 银行承兑汇票主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleterzbankacceptbillByManagementId(String managementId)
    {
        rzbankacceptbillMapper.deleteRzScrByScrUuid(managementId);
        return rzbankacceptbillMapper.deleterzbankacceptbillByManagementId(managementId);
    }

    /**
     * 新增${subTable.functionName}信息
     * 
     * @param rzbankacceptbill 银行承兑汇票对象
     */
    public void insertRzScr(rzbankacceptbill rzbankacceptbill)
    {
        List<RzScr> rzScrList = rzbankacceptbill.getRzScrList();
        String managementId = rzbankacceptbill.getManagementId();
        if (StringUtils.isNotNull(rzScrList))
        {
            List<RzScr> list = new ArrayList<RzScr>();
            for (RzScr rzScr : rzScrList)
            {
                rzScr.setScrUuid(managementId);
                list.add(rzScr);
            }
            if (list.size() > 0)
            {
                rzbankacceptbillMapper.batchRzScr(list);
            }
        }
    }
}
