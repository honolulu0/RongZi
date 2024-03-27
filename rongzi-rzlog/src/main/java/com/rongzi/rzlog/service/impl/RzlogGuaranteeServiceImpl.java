package com.rongzi.rzlog.service.impl;

import java.util.List;
import com.rongzi.common.utils.DateUtils;
import com.rongzi.rzlog.domain.LogGuaranteeSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rongzi.rzlog.mapper.RzlogGuaranteeMapper;
import com.rongzi.rzlog.domain.RzlogGuarantee;
import com.rongzi.rzlog.service.IRzlogGuaranteeService;

/**
 * 历史担保Service业务层处理
 * 
 * @author rongzi
 * @date 2024-03-24
 */
@Service
public class RzlogGuaranteeServiceImpl implements IRzlogGuaranteeService 
{
    @Autowired
    private RzlogGuaranteeMapper rzlogGuaranteeMapper;

    /**
     * 查询历史担保
     * 
     * @param id 历史担保主键
     * @return 历史担保
     */
    @Override
    public RzlogGuarantee selectRzlogGuaranteeById(Long id)
    {
        return rzlogGuaranteeMapper.selectRzlogGuaranteeById(id);
    }

    /**
     * 查询历史担保列表
     * 
     * @param rzlogGuarantee 历史担保
     * @return 历史担保
     */
    @Override
    public List<RzlogGuarantee> selectRzlogGuaranteeList(RzlogGuarantee rzlogGuarantee)
    {
        return rzlogGuaranteeMapper.selectRzlogGuaranteeList(rzlogGuarantee);
    }

    /**
     * 查询历史担保列表
     *
     * @param rzlogGuarantee 历史担保
     * @return 历史担保
     */
    @Override
    public List<LogGuaranteeSummary> getGuaranteeSummary(RzlogGuarantee rzlogGuarantee)
    {
        return rzlogGuaranteeMapper.selectGuaranteeSummary(rzlogGuarantee);
    }

    /**
     * 新增历史担保
     * 
     * @param rzlogGuarantee 历史担保
     * @return 结果
     */
    @Override
    public int insertRzlogGuarantee(RzlogGuarantee rzlogGuarantee)
    {
        rzlogGuarantee.setCreateTime(DateUtils.getNowDate());
        return rzlogGuaranteeMapper.insertRzlogGuarantee(rzlogGuarantee);
    }

    /**
     * 修改历史担保
     * 
     * @param rzlogGuarantee 历史担保
     * @return 结果
     */
    @Override
    public int updateRzlogGuarantee(RzlogGuarantee rzlogGuarantee)
    {
        rzlogGuarantee.setUpdateTime(DateUtils.getNowDate());
        return rzlogGuaranteeMapper.updateRzlogGuarantee(rzlogGuarantee);
    }

    /**
     * 批量删除历史担保
     * 
     * @param ids 需要删除的历史担保主键
     * @return 结果
     */
    @Override
    public int deleteRzlogGuaranteeByIds(Long[] ids)
    {
        return rzlogGuaranteeMapper.deleteRzlogGuaranteeByIds(ids);
    }

    /**
     * 删除历史担保信息
     * 
     * @param id 历史担保主键
     * @return 结果
     */
    @Override
    public int deleteRzlogGuaranteeById(Long id)
    {
        return rzlogGuaranteeMapper.deleteRzlogGuaranteeById(id);
    }
}
