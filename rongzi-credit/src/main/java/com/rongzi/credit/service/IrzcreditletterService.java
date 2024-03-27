package com.rongzi.credit.service;

import java.util.List;
import com.rongzi.credit.domain.rzcreditletter;

/**
 * 信用证Service接口
 * 
 * @author rongzi
 * @date 2024-03-01
 */
public interface IrzcreditletterService 
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
     * 批量删除信用证
     * 
     * @param ids 需要删除的信用证主键集合
     * @return 结果
     */
    public int deleterzcreditletterByIds(Long[] ids);

    /**
     * 删除信用证信息
     * 
     * @param id 信用证主键
     * @return 结果
     */
    public int deleterzcreditletterById(Long id);
}
