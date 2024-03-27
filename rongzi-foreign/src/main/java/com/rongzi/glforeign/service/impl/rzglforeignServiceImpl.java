package com.rongzi.glforeign.service.impl;

import java.util.List;
import com.rongzi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import com.rongzi.common.utils.StringUtils;
import org.springframework.transaction.annotation.Transactional;
import com.rongzi.glforeign.mapper.rzglforeignMapper;
import com.rongzi.glforeign.domain.rzglforeign;
import com.rongzi.glforeign.service.IrzglforeignService;
import com.rongzi.appendix.domain.rzsrc2;
/**
 * 对外担保台账Service业务层处理
 * 
 * @author rongzi
 * @date 2024-03-12
 */
@Service
public class rzglforeignServiceImpl implements IrzglforeignService 
{
    @Autowired
    private rzglforeignMapper rzglforeignMapper;

    /**
     * 查询对外担保台账
     * 
     * @param id 对外担保台账主键
     * @return 对外担保台账
     */
    @Override
    public rzglforeign selectrzglforeignById(Long id)
    {
        return rzglforeignMapper.selectrzglforeignById(id);
    }

    /**
     * 查询对外担保台账列表
     * 
     * @param rzglforeign 对外担保台账
     * @return 对外担保台账
     */
    @Override
    public List<rzglforeign> selectrzglforeignList(rzglforeign rzglforeign)
    {
        return rzglforeignMapper.selectrzglforeignList(rzglforeign);
    }

    /**
     * 新增对外担保台账
     * 
     * @param rzglforeign 对外担保台账
     * @return 结果
     */
    @Transactional
    @Override
    public int insertrzglforeign(rzglforeign rzglforeign)
    {
        rzglforeign.setCreateTime(DateUtils.getNowDate());
        int rows = rzglforeignMapper.insertrzglforeign(rzglforeign);
        insertrzsrc2(rzglforeign);
        return rows;
    }

    /**
     * 修改对外担保台账
     * 
     * @param rzglforeign 对外担保台账
     * @return 结果
     */
    @Transactional
    @Override
    public int updaterzglforeign(rzglforeign rzglforeign)
    {
        rzglforeign.setUpdateTime(DateUtils.getNowDate());
        rzglforeignMapper.deleterzsrc2ByScrUuid(rzglforeign.getScrUuid());
        insertrzsrc2(rzglforeign);
        return rzglforeignMapper.updaterzglforeign(rzglforeign);
    }

    /**
     * 批量删除对外担保台账
     * 
     * @param ids 需要删除的对外担保台账主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleterzglforeignByIds(Long[] ids)
    {
        return rzglforeignMapper.deleterzglforeignByIds(ids);
    }

    /**
     * 删除对外担保台账信息
     * 
     * @param id 对外担保台账主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleterzglforeignById(Long id)
    {
        return rzglforeignMapper.deleterzglforeignById(id);
    }

    /**
     * 新增附件表信息
     * 
     * @param rzglforeign 对外担保台账对象
     */
    public void insertrzsrc2(rzglforeign rzglforeign)
    {
        List<rzsrc2> rzsrc2List = rzglforeign.getrzsrc2List();
//        Long id = rzglforeign.getId();
        String uuidS = rzglforeign.getScrUuid();
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
                rzglforeignMapper.batchrzsrc2(list);
            }
        }
    }
}
