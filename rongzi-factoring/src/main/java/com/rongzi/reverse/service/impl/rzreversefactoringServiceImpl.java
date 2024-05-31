package com.rongzi.reverse.service.impl;

import java.util.List;
import com.rongzi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import com.rongzi.common.utils.StringUtils;
import org.springframework.transaction.annotation.Transactional;
import com.rongzi.reverse.mapper.rzreversefactoringMapper;
import com.rongzi.reverse.domain.rzreversefactoring;
import com.rongzi.reverse.service.IrzreversefactoringService;
import com.rongzi.appendix.domain.rzsrc2;
/**
 * 反向保理Service业务层处理
 *
 * @author rongzi
 * @date 2024-05-30
 */
@Service
public class rzreversefactoringServiceImpl implements IrzreversefactoringService
{
    @Autowired
    private rzreversefactoringMapper rzreversefactoringMapper;

    /**
     * 查询反向保理
     *
     * @param id 反向保理主键
     * @return 反向保理
     */
    @Override
    public rzreversefactoring selectrzreversefactoringById(Long id)
    {
        return rzreversefactoringMapper.selectrzreversefactoringById(id);
    }

    /**
     * 查询反向保理列表
     *
     * @param rzreversefactoring 反向保理
     * @return 反向保理
     */
    @Override
    public List<rzreversefactoring> selectrzreversefactoringList(rzreversefactoring rzreversefactoring)
    {
        return rzreversefactoringMapper.selectrzreversefactoringList(rzreversefactoring);
    }

    /**
     * 新增反向保理
     *
     * @param rzreversefactoring 反向保理
     * @return 结果
     */
    @Transactional
    @Override
    public int insertrzreversefactoring(rzreversefactoring rzreversefactoring)
    {
        rzreversefactoring.setCreateTime(DateUtils.getNowDate());
        int rows = rzreversefactoringMapper.insertrzreversefactoring(rzreversefactoring);
        insertrzsrc2(rzreversefactoring);
        return rows;
    }

    /**
     * 修改反向保理
     *
     * @param rzreversefactoring 反向保理
     * @return 结果
     */
    @Transactional
    @Override
    public int updaterzreversefactoring(rzreversefactoring rzreversefactoring)
    {
        rzreversefactoring.setUpdateTime(DateUtils.getNowDate());
        rzreversefactoringMapper.deleterzsrc2ByScrUuid(rzreversefactoring.getScrUuid());
        insertrzsrc2(rzreversefactoring);
        return rzreversefactoringMapper.updaterzreversefactoring(rzreversefactoring);
    }

    /**
     * 批量删除反向保理
     *
     * @param ids 需要删除的反向保理主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleterzreversefactoringByIds(Long[] ids)
    {
        return rzreversefactoringMapper.deleterzreversefactoringByIds(ids);
    }

    /**
     * 删除反向保理信息
     *
     * @param id 反向保理主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleterzreversefactoringById(Long id)
    {
        return rzreversefactoringMapper.deleterzreversefactoringById(id);
    }

    /**
     * 新增附件表信息
     *
     * @param rzreversefactoring 反向保理对象
     */
    public void insertrzsrc2(rzreversefactoring rzreversefactoring)
    {
        List<rzsrc2> rzsrc2List = rzreversefactoring.getrzsrc2List();
//        Long id = rzreversefactoring.getId();
        String uuidS = rzreversefactoring.getScrUuid();
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
                rzreversefactoringMapper.batchrzsrc2(list);
            }
        }
    }
}
