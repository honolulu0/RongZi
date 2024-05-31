package com.rongzi.glinternal.service;

import java.util.List;
import com.rongzi.glinternal.domain.glinternal;
import com.rongzi.appendix.domain.rzsrc2;
/**
 * 对内担保台账Service接口
 *
 * @author rongzi
 * @date 2024-05-31
 */
public interface IglinternalService
{
    /**
     * 查询对内担保台账
     *
     * @param id 对内担保台账主键
     * @return 对内担保台账
     */
    public glinternal selectglinternalById(Long id);

    /**
     * 查询对内担保台账列表
     *
     * @param glinternal 对内担保台账
     * @return 对内担保台账集合
     */
    public List<glinternal> selectglinternalList(glinternal glinternal);

    /**
     * 新增对内担保台账
     *
     * @param glinternal 对内担保台账
     * @return 结果
     */
    public int insertglinternal(glinternal glinternal);

    /**
     * 修改对内担保台账
     *
     * @param glinternal 对内担保台账
     * @return 结果
     */
    public int updateglinternal(glinternal glinternal);

    /**
     * 批量删除对内担保台账
     *
     * @param ids 需要删除的对内担保台账主键集合
     * @return 结果
     */
    public int deleteglinternalByIds(Long[] ids);

    /**
     * 删除对内担保台账信息
     *
     * @param id 对内担保台账主键
     * @return 结果
     */
    public int deleteglinternalById(Long id);
}
