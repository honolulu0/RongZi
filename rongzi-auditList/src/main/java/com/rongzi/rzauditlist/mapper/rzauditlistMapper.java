package com.rongzi.rzauditlist.mapper;

import java.util.List;
import com.rongzi.rzauditlist.domain.rzauditlist;

/**
 * 审核项目Mapper接口
 * 
 * @author rongzi
 * @date 2024-02-19
 */
public interface rzauditlistMapper 
{
    /**
     * 查询审核项目
     * 
     * @param id 审核项目主键
     * @return 审核项目
     */
    public rzauditlist selectrzauditlistById(Long id);

    /**
     * 查询审核项目列表
     * 
     * @param rzauditlist 审核项目
     * @return 审核项目集合
     */
    public List<rzauditlist> selectrzauditlistList(rzauditlist rzauditlist);

    /**
     * 新增审核项目
     * 
     * @param rzauditlist 审核项目
     * @return 结果
     */
    public int insertrzauditlist(rzauditlist rzauditlist);

    /**
     * 修改审核项目
     * 
     * @param rzauditlist 审核项目
     * @return 结果
     */
    public int updaterzauditlist(rzauditlist rzauditlist);

    /**
     * 删除审核项目
     * 
     * @param id 审核项目主键
     * @return 结果
     */
    public int deleterzauditlistById(Long id);

    /**
     * 批量删除审核项目
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleterzauditlistByIds(Long[] ids);
}
