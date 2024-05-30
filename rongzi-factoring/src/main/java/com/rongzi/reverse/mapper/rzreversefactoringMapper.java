package com.rongzi.reverse.mapper;

import java.util.List;
import com.rongzi.reverse.domain.rzreversefactoring;
import com.rongzi.appendix.domain.rzsrc2;
/**
 * 反向保理Mapper接口
 *
 * @author rongzi
 * @date 2024-05-29
 */
public interface rzreversefactoringMapper
{
    /**
     * 查询反向保理
     *
     * @param id 反向保理主键
     * @return 反向保理
     */
    public rzreversefactoring selectrzreversefactoringById(Long id);

    /**
     * 查询反向保理列表
     *
     * @param rzreversefactoring 反向保理
     * @return 反向保理集合
     */
    public List<rzreversefactoring> selectrzreversefactoringList(rzreversefactoring rzreversefactoring);

    /**
     * 新增反向保理
     *
     * @param rzreversefactoring 反向保理
     * @return 结果
     */
    public int insertrzreversefactoring(rzreversefactoring rzreversefactoring);

    /**
     * 修改反向保理
     *
     * @param rzreversefactoring 反向保理
     * @return 结果
     */
    public int updaterzreversefactoring(rzreversefactoring rzreversefactoring);

    /**
     * 删除反向保理
     *
     * @param id 反向保理主键
     * @return 结果
     */
    public int deleterzreversefactoringById(Long id);

    /**
     * 批量删除反向保理
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleterzreversefactoringByIds(Long[] ids);

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
     * 通过反向保理主键删除附件表信息
     *
     * @param id 反向保理ID
     * @return 结果
     */
    public int deleterzsrc2ByScrUuid(String id);
}
