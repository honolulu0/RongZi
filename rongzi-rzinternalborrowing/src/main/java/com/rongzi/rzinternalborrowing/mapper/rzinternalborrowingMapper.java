package com.rongzi.rzinternalborrowing.mapper;

import java.util.List;
import com.rongzi.rzinternalborrowing.domain.rzinternalborrowing;
import com.rongzi.appendix.domain.rzsrc2;
/**
 * 内部借款Mapper接口
 * 
 * @author rongzi
 * @date 2024-03-20
 */
public interface rzinternalborrowingMapper 
{
    /**
     * 查询内部借款
     * 
     * @param id 内部借款主键
     * @return 内部借款
     */
    public rzinternalborrowing selectrzinternalborrowingById(Long id);

    /**
     * 查询内部借款列表
     * 
     * @param rzinternalborrowing 内部借款
     * @return 内部借款集合
     */
    public List<rzinternalborrowing> selectrzinternalborrowingList(rzinternalborrowing rzinternalborrowing);

    /**
     * 新增内部借款
     * 
     * @param rzinternalborrowing 内部借款
     * @return 结果
     */
    public int insertrzinternalborrowing(rzinternalborrowing rzinternalborrowing);

    /**
     * 修改内部借款
     * 
     * @param rzinternalborrowing 内部借款
     * @return 结果
     */
    public int updaterzinternalborrowing(rzinternalborrowing rzinternalborrowing);

    /**
     * 删除内部借款
     * 
     * @param id 内部借款主键
     * @return 结果
     */
    public int deleterzinternalborrowingById(Long id);

    /**
     * 批量删除内部借款
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleterzinternalborrowingByIds(Long[] ids);

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
     * 通过内部借款主键删除附件表信息
     * 
     * @param id 内部借款ID
     * @return 结果
     */
    public int deleterzsrc2ByScrUuid(String id);
}
