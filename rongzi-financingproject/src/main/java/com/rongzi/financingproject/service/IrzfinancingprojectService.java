package com.rongzi.financingproject.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

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
     * 查询融资项目
     *
     * @param managementId 融资managementId
     * @return 融资项目
     */
    public rzfinancingproject selectrzfinancingprojectByManagementId(String managementId);
    ;

    /**
     * 查询融资项目列表
     *
     * @param rzfinancingproject 融资项目
     * @return 融资项目集合
     */
    public List<rzfinancingproject> selectrzfinancingprojectList(rzfinancingproject rzfinancingproject);

    /**
     * 查询融资项目Sum
     *
     * @param rzfinancingproject 融资项目
     * @return 融资项目集合
     */
    public Map<String, BigDecimal> selectrzfinancingprojectSum(rzfinancingproject rzfinancingproject);

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
