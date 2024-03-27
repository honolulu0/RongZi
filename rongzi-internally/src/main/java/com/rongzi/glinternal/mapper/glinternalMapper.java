package com.rongzi.glinternal.mapper;

import java.util.List;
import com.rongzi.glinternal.domain.glinternal;
import com.rongzi.appendix.domain.rzsrc2;
/**
 * 对内担保台账Mapper接口
 * 
 * @author rongzi
 * @date 2024-03-11
 */
public interface glinternalMapper 
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
     * 删除对内担保台账
     * 
     * @param id 对内担保台账主键
     * @return 结果
     */
    public int deleteglinternalById(Long id);

    /**
     * 批量删除对内担保台账
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteglinternalByIds(Long[] ids);

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
     * 通过对内担保台账主键删除附件表信息
     * 
     * @param id 对内担保台账ID
     * @return 结果
     */
    public int deleterzsrc2ByScrUuid(String id);
}
