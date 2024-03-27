package com.rongzi.glinternal.service.impl;

import java.util.List;
import com.rongzi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import com.rongzi.common.utils.StringUtils;
import org.springframework.transaction.annotation.Transactional;
import com.rongzi.glinternal.mapper.glinternalMapper;
import com.rongzi.glinternal.domain.glinternal;
import com.rongzi.glinternal.service.IglinternalService;
import com.rongzi.appendix.domain.rzsrc2;
/**
 * 对内担保台账Service业务层处理
 * 
 * @author rongzi
 * @date 2024-03-11
 */
@Service
public class glinternalServiceImpl implements IglinternalService 
{
    @Autowired
    private glinternalMapper glinternalMapper;

    /**
     * 查询对内担保台账
     * 
     * @param id 对内担保台账主键
     * @return 对内担保台账
     */
    @Override
    public glinternal selectglinternalById(Long id)
    {
        return glinternalMapper.selectglinternalById(id);
    }

    /**
     * 查询对内担保台账列表
     * 
     * @param glinternal 对内担保台账
     * @return 对内担保台账
     */
    @Override
    public List<glinternal> selectglinternalList(glinternal glinternal)
    {
        return glinternalMapper.selectglinternalList(glinternal);
    }

    /**
     * 新增对内担保台账
     * 
     * @param glinternal 对内担保台账
     * @return 结果
     */
    @Transactional
    @Override
    public int insertglinternal(glinternal glinternal)
    {
        glinternal.setCreateTime(DateUtils.getNowDate());
        int rows = glinternalMapper.insertglinternal(glinternal);
        insertrzsrc2(glinternal);
        return rows;
    }

    /**
     * 修改对内担保台账
     * 
     * @param glinternal 对内担保台账
     * @return 结果
     */
    @Transactional
    @Override
    public int updateglinternal(glinternal glinternal)
    {
        glinternal.setUpdateTime(DateUtils.getNowDate());
        glinternalMapper.deleterzsrc2ByScrUuid(glinternal.getScrUuid());
        insertrzsrc2(glinternal);
        return glinternalMapper.updateglinternal(glinternal);
    }

    /**
     * 批量删除对内担保台账
     * 
     * @param ids 需要删除的对内担保台账主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteglinternalByIds(Long[] ids)
    {
//        glinternalMapper.deleterzsrc2ByScrUuids(ids);
        return glinternalMapper.deleteglinternalByIds(ids);
    }

    /**
     * 删除对内担保台账信息
     * 
     * @param id 对内担保台账主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteglinternalById(Long id)
    {
//        glinternalMapper.deleterzsrc2ByScrUuid(id);
        return glinternalMapper.deleteglinternalById(id);
    }

    /**
     * 新增附件表信息
     * 
     * @param glinternal 对内担保台账对象
     */
    public void insertrzsrc2(glinternal glinternal)
    {
        List<rzsrc2> rzsrc2List = glinternal.getrzsrc2List();
//        Long id = glinternal.getId();
        String uuidS = glinternal.getScrUuid();
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
                glinternalMapper.batchrzsrc2(list);
            }
        }
    }
}
