package com.rongzi.financingproject.service;

import java.util.List;
import com.rongzi.financingproject.domain.rzfinancingproject;

/**
 * 融资项目Service接口
 *
 * @author rongzi
 * @date 2024-05-28
 */
public interface IrzfinancingprojectService {
    /**
     * 查询融资项目
     *
     * @param id 融资项目主键
     * @return 融资项目
     */
    public rzfinancingproject selectrzfinancingprojectById(Long id);

    /**
     * 查询融资项目列表
     *
     * @param rzfinancingproject 融资项目
     * @return 融资项目集合
     */
    public List<rzfinancingproject> selectrzfinancingprojectList(rzfinancingproject rzfinancingproject);

    /**
     * 新增融资项目
     *
     * @param rzfinancingproject 融资项目
     * @return 结果
     */
    public int insertrzfinancingproject(rzfinancingproject rzfinancingproject);

    /**
     * 修改融资项目
     *
     * @param rzfinancingproject 融资项目
     * @return 结果
     */
    public int updaterzfinancingproject(rzfinancingproject rzfinancingproject);

    /**
     * 批量删除融资项目
     *
     * @param ids 需要删除的融资项目主键集合
     * @return 结果
     */
    public int deleterzfinancingprojectByIds(Long[] ids);

    /**
     * 删除融资项目信息
     *
     * @param id 融资项目主键
     * @return 结果
     */
    public int deleterzfinancingprojectById(Long id);
}
