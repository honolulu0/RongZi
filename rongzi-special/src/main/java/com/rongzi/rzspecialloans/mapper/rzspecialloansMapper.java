package com.rongzi.rzspecialloans.mapper;

import java.util.List;
import com.rongzi.rzspecialloans.domain.rzspecialloans;
import com.rongzi.appendix.domain.rzsrc2;
/**
 * 专项借款Mapper接口
 * 
 * @author rongzi
 * @date 2024-03-23
 */
public interface rzspecialloansMapper 
{
    /**
     * 查询专项借款
     * 
     * @param id 专项借款主键
     * @return 专项借款
     */
    public rzspecialloans selectrzspecialloansById(Long id);

    /**
     * 查询专项借款列表
     * 
     * @param rzspecialloans 专项借款
     * @return 专项借款集合
     */
    public List<rzspecialloans> selectrzspecialloansList(rzspecialloans rzspecialloans);

    /**
     * 新增专项借款
     * 
     * @param rzspecialloans 专项借款
     * @return 结果
     */
    public int insertrzspecialloans(rzspecialloans rzspecialloans);

    /**
     * 修改专项借款
     * 
     * @param rzspecialloans 专项借款
     * @return 结果
     */
    public int updaterzspecialloans(rzspecialloans rzspecialloans);

    /**
     * 删除专项借款
     * 
     * @param id 专项借款主键
     * @return 结果
     */
    public int deleterzspecialloansById(Long id);

    /**
     * 批量删除专项借款
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleterzspecialloansByIds(Long[] ids);

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
     * 通过专项借款主键删除附件表信息
     * 
     * @param id 专项借款ID
     * @return 结果
     */
    public int deleterzsrc2ByScrUuid(String id);
}
