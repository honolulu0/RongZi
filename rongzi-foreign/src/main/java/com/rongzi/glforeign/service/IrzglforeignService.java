package com.rongzi.glforeign.service;

import java.util.List;
import com.rongzi.glforeign.domain.rzglforeign;
import com.rongzi.appendix.domain.rzsrc2;
/**
 * 对外担保台账Service接口
 *
 * @author rongzi
 * @date 2024-05-30
 */
public interface IrzglforeignService
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
     * 批量删除对外担保台账
     *
     * @param ids 需要删除的对外担保台账主键集合
     * @return 结果
     */
    public int deleterzglforeignByIds(Long[] ids);

    /**
     * 删除对外担保台账信息
     *
     * @param id 对外担保台账主键
     * @return 结果
     */
    public int deleterzglforeignById(Long id);
}
