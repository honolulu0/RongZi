package com.rongzi.glforeign.mapper;

import java.util.List;
import com.rongzi.glforeign.domain.rzglforeign;
import com.rongzi.appendix.domain.rzsrc2;
/**
 * 对外担保台账Mapper接口
 *
 * @author rongzi
 * @date 2024-05-30
 */
public interface rzglforeignMapper
{
    /**
     * 查询对外担保台账
     *
     * @param id 对外担保台账主键
     * @return 对外担保台账
     */
    public rzglforeign selectrzglforeignById(Long id);

    /**
     * 查询对外担保台账列表
     *
     * @param rzglforeign 对外担保台账
     * @return 对外担保台账集合
     */
    public List<rzglforeign> selectrzglforeignList(rzglforeign rzglforeign);

    /**
     * 新增对外担保台账
     *
     * @param rzglforeign 对外担保台账
     * @return 结果
     */
    public int insertrzglforeign(rzglforeign rzglforeign);

    /**
     * 修改对外担保台账
     *
     * @param rzglforeign 对外担保台账
     * @return 结果
     */
    public int updaterzglforeign(rzglforeign rzglforeign);

    /**
     * 删除对外担保台账
     *
     * @param id 对外担保台账主键
     * @return 结果
     */
    public int deleterzglforeignById(Long id);

    /**
     * 批量删除对外担保台账
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleterzglforeignByIds(Long[] ids);

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
     * 通过对外担保台账主键删除附件表信息
     *
     * @param id 对外担保台账ID
     * @return 结果
     */
    public int deleterzsrc2ByScrUuid(String id);
}
