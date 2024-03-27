package com.rongzi.government.service.impl;

import java.util.List;
import com.rongzi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import com.rongzi.common.utils.StringUtils;
import org.springframework.transaction.annotation.Transactional;
import com.rongzi.government.mapper.rzgovernmentspecialbondsMapper;
import com.rongzi.government.domain.rzgovernmentspecialbonds;
import com.rongzi.government.service.IrzgovernmentspecialbondsService;
import com.rongzi.appendix.domain.rzsrc2;
/**
 * 政府专项债Service业务层处理
 * 
 * @author rongzi
 * @date 2024-03-23
 */
@Service
public class rzgovernmentspecialbondsServiceImpl implements IrzgovernmentspecialbondsService 
{
    @Autowired
    private rzgovernmentspecialbondsMapper rzgovernmentspecialbondsMapper;

    /**
     * 查询政府专项债
     * 
     * @param id 政府专项债主键
     * @return 政府专项债
     */
    @Override
    public rzgovernmentspecialbonds selectrzgovernmentspecialbondsById(Long id)
    {
        return rzgovernmentspecialbondsMapper.selectrzgovernmentspecialbondsById(id);
    }

    /**
     * 查询政府专项债列表
     * 
     * @param rzgovernmentspecialbonds 政府专项债
     * @return 政府专项债
     */
    @Override
    public List<rzgovernmentspecialbonds> selectrzgovernmentspecialbondsList(rzgovernmentspecialbonds rzgovernmentspecialbonds)
    {
        return rzgovernmentspecialbondsMapper.selectrzgovernmentspecialbondsList(rzgovernmentspecialbonds);
    }

    /**
     * 新增政府专项债
     * 
     * @param rzgovernmentspecialbonds 政府专项债
     * @return 结果
     */
    @Transactional
    @Override
    public int insertrzgovernmentspecialbonds(rzgovernmentspecialbonds rzgovernmentspecialbonds)
    {
        rzgovernmentspecialbonds.setCreateTime(DateUtils.getNowDate());
        int rows = rzgovernmentspecialbondsMapper.insertrzgovernmentspecialbonds(rzgovernmentspecialbonds);
        insertrzsrc2(rzgovernmentspecialbonds);
        return rows;
    }

    /**
     * 修改政府专项债
     * 
     * @param rzgovernmentspecialbonds 政府专项债
     * @return 结果
     */
    @Transactional
    @Override
    public int updaterzgovernmentspecialbonds(rzgovernmentspecialbonds rzgovernmentspecialbonds)
    {
        rzgovernmentspecialbonds.setUpdateTime(DateUtils.getNowDate());
        rzgovernmentspecialbondsMapper.deleterzsrc2ByScrUuid(rzgovernmentspecialbonds.getScrUuid());
        insertrzsrc2(rzgovernmentspecialbonds);
        return rzgovernmentspecialbondsMapper.updaterzgovernmentspecialbonds(rzgovernmentspecialbonds);
    }

    /**
     * 批量删除政府专项债
     * 
     * @param ids 需要删除的政府专项债主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleterzgovernmentspecialbondsByIds(Long[] ids)
    {
        return rzgovernmentspecialbondsMapper.deleterzgovernmentspecialbondsByIds(ids);
    }

    /**
     * 删除政府专项债信息
     * 
     * @param id 政府专项债主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleterzgovernmentspecialbondsById(Long id)
    {
        return rzgovernmentspecialbondsMapper.deleterzgovernmentspecialbondsById(id);
    }

    /**
     * 新增附件表信息
     * 
     * @param rzgovernmentspecialbonds 政府专项债对象
     */
    public void insertrzsrc2(rzgovernmentspecialbonds rzgovernmentspecialbonds)
    {
        List<rzsrc2> rzsrc2List = rzgovernmentspecialbonds.getrzsrc2List();
//        Long id = rzgovernmentspecialbonds.getId();
        String uuidS = rzgovernmentspecialbonds.getScrUuid();
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
                rzgovernmentspecialbondsMapper.batchrzsrc2(list);
            }
        }
    }
}
