package com.rongzi.rzafterloan.service.impl;

import java.util.List;
import com.rongzi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import com.rongzi.common.utils.StringUtils;
import org.springframework.transaction.annotation.Transactional;
import com.rongzi.rzafterloan.mapper.rzafterloanMapper;
import com.rongzi.rzafterloan.domain.rzafterloan;
import com.rongzi.rzafterloan.service.IrzafterloanService;
import com.rongzi.appendix.domain.rzsrc2;
/**
 * 贷后管理Service业务层处理
 * 
 * @author rongzi
 * @date 2024-03-20
 */
@Service
public class rzafterloanServiceImpl implements IrzafterloanService 
{
    @Autowired
    private rzafterloanMapper rzafterloanMapper;

    /**
     * 查询贷后管理
     * 
     * @param id 贷后管理主键
     * @return 贷后管理
     */
    @Override
    public rzafterloan selectrzafterloanById(Long id)
    {
        return rzafterloanMapper.selectrzafterloanById(id);
    }

    /**
     * 查询贷后管理列表
     * 
     * @param rzafterloan 贷后管理
     * @return 贷后管理
     */
    @Override
    public List<rzafterloan> selectrzafterloanList(rzafterloan rzafterloan)
    {
        return rzafterloanMapper.selectrzafterloanList(rzafterloan);
    }

    /**
     * 新增贷后管理
     * 
     * @param rzafterloan 贷后管理
     * @return 结果
     */
    @Transactional
    @Override
    public int insertrzafterloan(rzafterloan rzafterloan)
    {
        rzafterloan.setCreateTime(DateUtils.getNowDate());
        int rows = rzafterloanMapper.insertrzafterloan(rzafterloan);
        insertrzsrc2(rzafterloan);
        return rows;
    }

    /**
     * 修改贷后管理
     * 
     * @param rzafterloan 贷后管理
     * @return 结果
     */
    @Transactional
    @Override
    public int updaterzafterloan(rzafterloan rzafterloan)
    {
        rzafterloan.setUpdateTime(DateUtils.getNowDate());
        rzafterloanMapper.deleterzsrc2ByScrUuid(rzafterloan.getScrUuid());
        insertrzsrc2(rzafterloan);
        return rzafterloanMapper.updaterzafterloan(rzafterloan);
    }

    /**
     * 批量删除贷后管理
     * 
     * @param ids 需要删除的贷后管理主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleterzafterloanByIds(Long[] ids)
    {
        return rzafterloanMapper.deleterzafterloanByIds(ids);
    }

    /**
     * 删除贷后管理信息
     * 
     * @param id 贷后管理主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleterzafterloanById(Long id)
    {
        return rzafterloanMapper.deleterzafterloanById(id);
    }

    /**
     * 新增附件表信息
     * 
     * @param rzafterloan 贷后管理对象
     */
    public void insertrzsrc2(rzafterloan rzafterloan)
    {
        List<rzsrc2> rzsrc2List = rzafterloan.getrzsrc2List();
//        Long id = rzafterloan.getId();
        String uuidS = rzafterloan.getScrUuid();
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
                rzafterloanMapper.batchrzsrc2(list);
            }
        }
    }
}
