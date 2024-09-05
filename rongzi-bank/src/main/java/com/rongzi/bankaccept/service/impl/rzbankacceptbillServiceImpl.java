package com.rongzi.bankaccept.service.impl;

import java.math.BigDecimal;
import java.util.List;
import com.rongzi.common.utils.DateUtils;
import com.rongzi.huankuanjihua.HuankuanmingxiBatchOperationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Map;

import com.rongzi.common.utils.StringUtils;
import org.springframework.transaction.annotation.Transactional;
import com.rongzi.bankaccept.mapper.rzbankacceptbillMapper;
import com.rongzi.bankaccept.domain.rzbankacceptbill;
import com.rongzi.bankaccept.service.IrzbankacceptbillService;
import com.rongzi.appendix.domain.rzsrc2;
/**
 * 银行承兑汇票Service业务层处理
 *
 * @author rongzi
 * @date 2024-05-30
 */
@Service
public class rzbankacceptbillServiceImpl implements IrzbankacceptbillService
{
    @Autowired
    private rzbankacceptbillMapper rzbankacceptbillMapper;

    @Autowired
    private HuankuanmingxiBatchOperationUtils huankuanmingxiBatchOperationUtils;
    /**
     * 查询银行承兑汇票
     *
     * @param id 银行承兑汇票主键
     * @return 银行承兑汇票
     */
    @Override
    public rzbankacceptbill selectrzbankacceptbillById(Long id)
    {
        return rzbankacceptbillMapper.selectrzbankacceptbillById(id);
    }
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
    @Override
    public Map<String, BigDecimal> selectrzbankacceptbillSum(rzbankacceptbill rzbankacceptbill)
    {
        return rzbankacceptbillMapper.selectrzbankacceptbillSum(rzbankacceptbill);
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
        insertrzsrc2(rzbankacceptbill);
        huankuanmingxiBatchOperationUtils.batchinserthuankuanmingxi(rzbankacceptbill.getHuankuanmingxi2List(), rzbankacceptbill.getManagementId());
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
        rzbankacceptbillMapper.deleterzsrc2ByScrUuid(rzbankacceptbill.getScrUuid());
        insertrzsrc2(rzbankacceptbill);
        huankuanmingxiBatchOperationUtils.deleterHuankuanmingxiByManagementId(rzbankacceptbill.getManagementId());
        huankuanmingxiBatchOperationUtils.batchinserthuankuanmingxi(rzbankacceptbill.getHuankuanmingxi2List(), rzbankacceptbill.getManagementId());
        return rzbankacceptbillMapper.updaterzbankacceptbill(rzbankacceptbill);
    }

    /**
     * 批量删除银行承兑汇票
     *
     * @param ids 需要删除的银行承兑汇票主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleterzbankacceptbillByIds(Long[] ids)
    {
        return rzbankacceptbillMapper.deleterzbankacceptbillByIds(ids);
    }

    /**
     * 删除银行承兑汇票信息
     *
     * @param id 银行承兑汇票主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleterzbankacceptbillById(Long id)
    {
        return rzbankacceptbillMapper.deleterzbankacceptbillById(id);
    }

    /**
     * 新增附件表信息
     *
     * @param rzbankacceptbill 银行承兑汇票对象
     */
    public void insertrzsrc2(rzbankacceptbill rzbankacceptbill)
    {
        List<rzsrc2> rzsrc2List = rzbankacceptbill.getrzsrc2List();
//        Long id = rzbankacceptbill.getId();
        String uuidS = rzbankacceptbill.getScrUuid();
        if (StringUtils.isNotNull(rzsrc2List))
        {
            List<rzsrc2> list = new ArrayList<rzsrc2>();
            for (rzsrc2 rzsrc2 : rzsrc2List)
            {
                rzsrc2.setScrUuid(uuidS);
                list.add(rzsrc2);
            }
            if (list.size() > 0)
            {
                rzbankacceptbillMapper.batchrzsrc2(list);
            }
        }
    }
}
