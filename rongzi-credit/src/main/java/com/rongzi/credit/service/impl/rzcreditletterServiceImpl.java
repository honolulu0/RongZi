package com.rongzi.credit.service.impl;

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
import com.rongzi.credit.mapper.rzcreditletterMapper;
import com.rongzi.credit.domain.rzcreditletter;
import com.rongzi.credit.service.IrzcreditletterService;
import com.rongzi.appendix.domain.rzsrc2;
/**
 * 信用证Service业务层处理
 *
 * @author rongzi
 * @date 2024-05-30
 */
@Service
public class rzcreditletterServiceImpl implements IrzcreditletterService
{
    @Autowired
    private rzcreditletterMapper rzcreditletterMapper;

    @Autowired
    private HuankuanmingxiBatchOperationUtils huankuanmingxiBatchOperationUtils;
    /**
     * 查询信用证
     *
     * @param id 信用证主键
     * @return 信用证
     */
    @Override
    public rzcreditletter selectrzcreditletterById(Long id)
    {
        return rzcreditletterMapper.selectrzcreditletterById(id);
    }
    @Override
    public rzcreditletter selectrzcreditletterByManagementId(String managementId)
    {
        return rzcreditletterMapper.selectrzcreditletterByManagementId(managementId);
    }

    /**
     * 查询信用证列表
     *
     * @param rzcreditletter 信用证
     * @return 信用证
     */
    @Override
    public List<rzcreditletter> selectrzcreditletterList(rzcreditletter rzcreditletter)
    {
        return rzcreditletterMapper.selectrzcreditletterList(rzcreditletter);
    }
    @Override
    public Map<String, BigDecimal> selectrzcreditletterSum(rzcreditletter rzcreditletter)
    {
        return rzcreditletterMapper.selectrzcreditletterSum(rzcreditletter);
    }

    /**
     * 新增信用证
     *
     * @param rzcreditletter 信用证
     * @return 结果
     */
    @Transactional
    @Override
    public int insertrzcreditletter(rzcreditletter rzcreditletter)
    {
        rzcreditletter.setCreateTime(DateUtils.getNowDate());
        int rows = rzcreditletterMapper.insertrzcreditletter(rzcreditletter);
        insertrzsrc2(rzcreditletter);
        huankuanmingxiBatchOperationUtils.batchinserthuankuanmingxi(rzcreditletter.getHuankuanmingxi2List(), rzcreditletter.getManagementId());
        return rows;
    }

    /**
     * 修改信用证
     *
     * @param rzcreditletter 信用证
     * @return 结果
     */
    @Transactional
    @Override
    public int updaterzcreditletter(rzcreditletter rzcreditletter)
    {
        rzcreditletter.setUpdateTime(DateUtils.getNowDate());
        rzcreditletterMapper.deleterzsrc2ByScrUuid(rzcreditletter.getScrUuid());
        insertrzsrc2(rzcreditletter);
        huankuanmingxiBatchOperationUtils.deleterHuankuanmingxiByManagementId(rzcreditletter.getManagementId());
        huankuanmingxiBatchOperationUtils.batchinserthuankuanmingxi(rzcreditletter.getHuankuanmingxi2List(), rzcreditletter.getManagementId());
        return rzcreditletterMapper.updaterzcreditletter(rzcreditletter);
    }

    /**
     * 批量删除信用证
     *
     * @param ids 需要删除的信用证主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleterzcreditletterByIds(Long[] ids)
    {
        return rzcreditletterMapper.deleterzcreditletterByIds(ids);
    }

    /**
     * 删除信用证信息
     *
     * @param id 信用证主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleterzcreditletterById(Long id)
    {
        return rzcreditletterMapper.deleterzcreditletterById(id);
    }

    /**
     * 新增附件表信息
     *
     * @param rzcreditletter 信用证对象
     */
    public void insertrzsrc2(rzcreditletter rzcreditletter)
    {
        List<rzsrc2> rzsrc2List = rzcreditletter.getrzsrc2List();
//        Long id = rzcreditletter.getId();
        String uuidS = rzcreditletter.getScrUuid();
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
                rzcreditletterMapper.batchrzsrc2(list);
            }
        }
    }
}
