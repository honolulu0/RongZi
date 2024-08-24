package com.rongzi.rzinternalborrowing.service.impl;

import java.math.BigDecimal;
import java.util.List;
import com.rongzi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Map;

import com.rongzi.common.utils.StringUtils;
import org.springframework.transaction.annotation.Transactional;
import com.rongzi.rzinternalborrowing.mapper.rzinternalborrowingMapper;
import com.rongzi.rzinternalborrowing.domain.rzinternalborrowing;
import com.rongzi.rzinternalborrowing.service.IrzinternalborrowingService;
import com.rongzi.appendix.domain.rzsrc2;
/**
 * 内部借款Service业务层处理
 *
 * @author rongzi
 * @date 2024-03-20
 */
@Service
public class rzinternalborrowingServiceImpl implements IrzinternalborrowingService
{
    @Autowired
    private rzinternalborrowingMapper rzinternalborrowingMapper;

    /**
     * 查询内部借款
     *
     * @param id 内部借款主键
     * @return 内部借款
     */
    @Override
    public rzinternalborrowing selectrzinternalborrowingById(Long id)
    {
        return rzinternalborrowingMapper.selectrzinternalborrowingById(id);
    }

    /**
     * 查询内部借款列表
     *
     * @param rzinternalborrowing 内部借款
     * @return 内部借款
     */
    @Override
    public List<rzinternalborrowing> selectrzinternalborrowingList(rzinternalborrowing rzinternalborrowing)
    {
        return rzinternalborrowingMapper.selectrzinternalborrowingList(rzinternalborrowing);
    }

    /**
     * 查询内部借款SUM
     *
     * @param rzinternalborrowing 内部借款
     * @return 内部借款
     */
    @Override
    public Map<String, BigDecimal> selectrzinternalborrowingSum(rzinternalborrowing rzinternalborrowing)
    {
        return rzinternalborrowingMapper.selectrzinternalborrowingSum(rzinternalborrowing);
    }

    /**
     * 新增内部借款
     *
     * @param rzinternalborrowing 内部借款
     * @return 结果
     */
    @Transactional
    @Override
    public int insertrzinternalborrowing(rzinternalborrowing rzinternalborrowing)
    {
        rzinternalborrowing.setCreateTime(DateUtils.getNowDate());
        int rows = rzinternalborrowingMapper.insertrzinternalborrowing(rzinternalborrowing);
        insertrzsrc2(rzinternalborrowing);
        return rows;
    }

    /**
     * 修改内部借款
     *
     * @param rzinternalborrowing 内部借款
     * @return 结果
     */
    @Transactional
    @Override
    public int updaterzinternalborrowing(rzinternalborrowing rzinternalborrowing)
    {
        rzinternalborrowing.setUpdateTime(DateUtils.getNowDate());
        rzinternalborrowingMapper.deleterzsrc2ByScrUuid(rzinternalborrowing.getScrUuid());
        insertrzsrc2(rzinternalborrowing);
        return rzinternalborrowingMapper.updaterzinternalborrowing(rzinternalborrowing);
    }

    /**
     * 批量删除内部借款
     *
     * @param ids 需要删除的内部借款主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleterzinternalborrowingByIds(Long[] ids)
    {
        return rzinternalborrowingMapper.deleterzinternalborrowingByIds(ids);
    }

    /**
     * 删除内部借款信息
     *
     * @param id 内部借款主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleterzinternalborrowingById(Long id)
    {
        return rzinternalborrowingMapper.deleterzinternalborrowingById(id);
    }

    /**
     * 新增附件表信息
     *
     * @param rzinternalborrowing 内部借款对象
     */
    public void insertrzsrc2(rzinternalborrowing rzinternalborrowing)
    {
        List<rzsrc2> rzsrc2List = rzinternalborrowing.getrzsrc2List();
//        Long id = rzinternalborrowing.getId();
        String uuidS = rzinternalborrowing.getScrUuid();
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
                rzinternalborrowingMapper.batchrzsrc2(list);
            }
        }
    }

}
