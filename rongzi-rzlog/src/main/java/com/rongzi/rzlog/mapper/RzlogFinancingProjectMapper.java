package com.rongzi.rzlog.mapper;

import java.util.List;

import com.rongzi.rzlog.domain.LogFinancingProjectSummary;
import com.rongzi.rzlog.domain.RzlogFinancingProject;

/**
 * 历史融资查询Mapper接口
 * 
 * @author rongzi
 * @date 2024-03-24
 */
public interface RzlogFinancingProjectMapper 
{
    /**
     * 查询历史融资查询
     * 
     * @param id 历史融资查询主键
     * @return 历史融资查询
     */
    public RzlogFinancingProject selectRzlogFinancingProjectById(Long id);

    /**
     * 查询历史融资查询列表
     * 
     * @param rzlogFinancingProject 历史融资查询
     * @return 历史融资查询集合
     */
    public List<RzlogFinancingProject> selectRzlogFinancingProjectList(RzlogFinancingProject rzlogFinancingProject);

    /**
     * 查询历史融资查询列表
     *
     * @param rzlogFinancingProject 历史融资查询
     * @return 历史融资查询集合
     */
    public List<LogFinancingProjectSummary> selectFinancingProjectSummary(RzlogFinancingProject rzlogFinancingProject);

    /**
     * 新增历史融资查询
     * 
     * @param rzlogFinancingProject 历史融资查询
     * @return 结果
     */
    public int insertRzlogFinancingProject(RzlogFinancingProject rzlogFinancingProject);

    /**
     * 修改历史融资查询
     * 
     * @param rzlogFinancingProject 历史融资查询
     * @return 结果
     */
    public int updateRzlogFinancingProject(RzlogFinancingProject rzlogFinancingProject);

    /**
     * 删除历史融资查询
     * 
     * @param id 历史融资查询主键
     * @return 结果
     */
    public int deleteRzlogFinancingProjectById(Long id);

    /**
     * 批量删除历史融资查询
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteRzlogFinancingProjectByIds(Long[] ids);
}
