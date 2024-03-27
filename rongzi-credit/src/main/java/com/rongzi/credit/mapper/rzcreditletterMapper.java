package com.rongzi.credit.mapper;

import java.util.List;
import com.rongzi.credit.domain.rzcreditletter;
import com.rongzi.appendix.domain.rzsrc2;
/**
 * 信用证Mapper接口
 * 
 * @author rongzi
 * @date 2024-03-01
 */
public interface rzcreditletterMapper 
{
    /**
     * 查询信用证
     * 
     * @param id 信用证主键
     * @return 信用证
     */
    public rzcreditletter selectrzcreditletterById(Long id);

    /**
     * 查询信用证列表
     * 
     * @param rzcreditletter 信用证
     * @return 信用证集合
     */
    public List<rzcreditletter> selectrzcreditletterList(rzcreditletter rzcreditletter);

    /**
     * 新增信用证
     * 
     * @param rzcreditletter 信用证
     * @return 结果
     */
    public int insertrzcreditletter(rzcreditletter rzcreditletter);

    /**
     * 修改信用证
     * 
     * @param rzcreditletter 信用证
     * @return 结果
     */
    public int updaterzcreditletter(rzcreditletter rzcreditletter);

    /**
     * 删除信用证
     * 
     * @param id 信用证主键
     * @return 结果
     */
    public int deleterzcreditletterById(Long id);

    /**
     * 批量删除信用证
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleterzcreditletterByIds(Long[] ids);

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
     * 通过信用证主键删除附件表信息
     * 
     * @param id 信用证ID
     * @return 结果
     */
    public int deleterzsrc2ByScrUuid(String id);
}
