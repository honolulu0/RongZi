package com.rongzi.financingproject.mapper;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.rongzi.financingproject.domain.rzfinancingproject;
import com.rongzi.appendix.domain.rzsrc2;
import com.rongzi.huankuanjihua.domain.RzhkjhMingxi;


/**
 * 融资项目Mapper接口
 *
 * @author rongzi
 * @date 2024-05-28
 */
public interface rzfinancingprojectMapper {
    /**
     * 查询融资项目
     *
     * @param id 融资项目主键
     * @return 融资项目
     */
    public rzfinancingproject selectrzfinancingprojectById(Long id);


    public rzfinancingproject selectrzfinancingprojectByManagementId(String managementId);

    /**
     * 查询融资项目列表
     *
     * @param rzfinancingproject 融资项目
     * @return 融资项目集合
     */
    public List<rzfinancingproject> selectrzfinancingprojectList(rzfinancingproject rzfinancingproject);

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
     * 删除融资项目
     *
     * @param id 融资项目主键
     * @return 结果
     */
    public int deleterzfinancingprojectById(Long id);

    /**
     * 批量删除融资项目
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleterzfinancingprojectByIds(Long[] ids);

    /**
     * 批量删除附件表
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleterzsrc2ByScrUuids(Long[] ids);

    /**
     * 批量新增附件表
     *
     * @param rzsrc2List 附件表列表
     * @return 结果
     */
    public int batchrzsrc2(List<rzsrc2> rzsrc2List);


    /**
     * 通过融资项目主键删除附件表信息
     *
     * @param scrUuid 融资项目scrUuid
     * @return 结果
     */
    public int deleterzsrc2ByScrUuid(String scrUuid);



}
