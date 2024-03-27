package com.rongzi.rzlog.service.impl;

import java.util.List;
import com.rongzi.common.utils.DateUtils;
import com.rongzi.rzlog.domain.LogFinancingProjectSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rongzi.rzlog.mapper.RzlogFinancingProjectMapper;
import com.rongzi.rzlog.domain.RzlogFinancingProject;
import com.rongzi.rzlog.service.IRzlogFinancingProjectService;

/**
 * 历史融资查询Service业务层处理
 * 
 * @author rongzi
 * @date 2024-03-24
 */
@Service
public class RzlogFinancingProjectServiceImpl implements IRzlogFinancingProjectService 
{
    @Autowired
    private RzlogFinancingProjectMapper rzlogFinancingProjectMapper;

    /**
     * 查询历史融资查询
     * 
     * @param id 历史融资查询主键
     * @return 历史融资查询
     */
    @Override
    public RzlogFinancingProject selectRzlogFinancingProjectById(Long id)
    {
        return rzlogFinancingProjectMapper.selectRzlogFinancingProjectById(id);
    }

    /**
     * 查询历史融资查询列表
     * 
     * @param rzlogFinancingProject 历史融资查询
     * @return 历史融资查询
     */
    @Override
    public List<RzlogFinancingProject> selectRzlogFinancingProjectList(RzlogFinancingProject rzlogFinancingProject)
    {
        return rzlogFinancingProjectMapper.selectRzlogFinancingProjectList(rzlogFinancingProject);
    }

    /**
     * 查询历史融资查询列表
     *
     * @param rzlogFinancingProject 历史融资查询
     * @return 历史融资查询
     */
    @Override
    public List<LogFinancingProjectSummary> selectFinancingProjectSummary(RzlogFinancingProject rzlogFinancingProject)
    {
        return rzlogFinancingProjectMapper.selectFinancingProjectSummary(rzlogFinancingProject);
    }

    /**
     * 新增历史融资查询
     * 
     * @param rzlogFinancingProject 历史融资查询
     * @return 结果
     */
    @Override
    public int insertRzlogFinancingProject(RzlogFinancingProject rzlogFinancingProject)
    {
        rzlogFinancingProject.setCreateTime(DateUtils.getNowDate());
        return rzlogFinancingProjectMapper.insertRzlogFinancingProject(rzlogFinancingProject);
    }

    /**
     * 修改历史融资查询
     * 
     * @param rzlogFinancingProject 历史融资查询
     * @return 结果
     */
    @Override
    public int updateRzlogFinancingProject(RzlogFinancingProject rzlogFinancingProject)
    {
        rzlogFinancingProject.setUpdateTime(DateUtils.getNowDate());
        return rzlogFinancingProjectMapper.updateRzlogFinancingProject(rzlogFinancingProject);
    }

    /**
     * 批量删除历史融资查询
     * 
     * @param ids 需要删除的历史融资查询主键
     * @return 结果
     */
    @Override
    public int deleteRzlogFinancingProjectByIds(Long[] ids)
    {
        return rzlogFinancingProjectMapper.deleteRzlogFinancingProjectByIds(ids);
    }

    /**
     * 删除历史融资查询信息
     * 
     * @param id 历史融资查询主键
     * @return 结果
     */
    @Override
    public int deleteRzlogFinancingProjectById(Long id)
    {
        return rzlogFinancingProjectMapper.deleteRzlogFinancingProjectById(id);
    }
}
