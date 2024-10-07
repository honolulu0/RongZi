package com.rongzi.credit.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.rongzi.credit.domain.rzcreditletter;
import com.rongzi.appendix.domain.rzsrc2;
/**
 * 信用证Service接口
 *
 * @author rongzi
 * @date 2024-05-30
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
    public rzcreditletter selectrzcreditletterByManagementId(String managementId);

    /**
     * 查询信用证列表
     *
     * @param rzcreditletter 信用证
     * @return 信用证集合
     */
    public List<rzcreditletter> selectrzcreditletterList(rzcreditletter rzcreditletter);

    public Map<String, BigDecimal> selectrzcreditletterSum(rzcreditletter rzcreditletter);

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
