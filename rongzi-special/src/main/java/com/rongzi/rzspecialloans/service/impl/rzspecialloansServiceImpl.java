package com.rongzi.rzspecialloans.service.impl;

import java.util.List;
import com.rongzi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import com.rongzi.common.utils.StringUtils;
import org.springframework.transaction.annotation.Transactional;
import com.rongzi.rzspecialloans.mapper.rzspecialloansMapper;
import com.rongzi.rzspecialloans.domain.rzspecialloans;
import com.rongzi.rzspecialloans.service.IrzspecialloansService;
import com.rongzi.appendix.domain.rzsrc2;
/**
 * 专项借款Service业务层处理
 * 
 * @author rongzi
 * @date 2024-03-23
 */
@Service
public class rzspecialloansServiceImpl implements IrzspecialloansService 
{
    @Autowired
    private rzspecialloansMapper rzspecialloansMapper;

    /**
     * 查询专项借款
     * 
     * @param id 专项借款主键
     * @return 专项借款
     */
    @Override
    public rzspecialloans selectrzspecialloansById(Long id)
    {
        return rzspecialloansMapper.selectrzspecialloansById(id);
    }

    /**
     * 查询专项借款列表
     * 
     * @param rzspecialloans 专项借款
     * @return 专项借款
     */
    @Override
    public List<rzspecialloans> selectrzspecialloansList(rzspecialloans rzspecialloans)
    {
        return rzspecialloansMapper.selectrzspecialloansList(rzspecialloans);
    }

    /**
     * 新增专项借款
     * 
     * @param rzspecialloans 专项借款
     * @return 结果
     */
    @Transactional
    @Override
    public int insertrzspecialloans(rzspecialloans rzspecialloans)
    {
        rzspecialloans.setCreateTime(DateUtils.getNowDate());
        int rows = rzspecialloansMapper.insertrzspecialloans(rzspecialloans);
        insertrzsrc2(rzspecialloans);
        return rows;
    }

    /**
     * 修改专项借款
     * 
     * @param rzspecialloans 专项借款
     * @return 结果
     */
    @Transactional
    @Override
    public int updaterzspecialloans(rzspecialloans rzspecialloans)
    {
        rzspecialloans.setUpdateTime(DateUtils.getNowDate());
        rzspecialloansMapper.deleterzsrc2ByScrUuid(rzspecialloans.getScrUuid());
        insertrzsrc2(rzspecialloans);
        return rzspecialloansMapper.updaterzspecialloans(rzspecialloans);
    }

    /**
     * 批量删除专项借款
     * 
     * @param ids 需要删除的专项借款主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleterzspecialloansByIds(Long[] ids)
    {
        return rzspecialloansMapper.deleterzspecialloansByIds(ids);
    }

    /**
     * 删除专项借款信息
     * 
     * @param id 专项借款主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleterzspecialloansById(Long id)
    {
        return rzspecialloansMapper.deleterzspecialloansById(id);
    }

    /**
     * 新增附件表信息
     * 
     * @param rzspecialloans 专项借款对象
     */
    public void insertrzsrc2(rzspecialloans rzspecialloans)
    {
        List<rzsrc2> rzsrc2List = rzspecialloans.getrzsrc2List();
//        Long id = rzspecialloans.getId();
        String uuidS = rzspecialloans.getScrUuid();
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
                rzspecialloansMapper.batchrzsrc2(list);
            }
        }
    }
}
