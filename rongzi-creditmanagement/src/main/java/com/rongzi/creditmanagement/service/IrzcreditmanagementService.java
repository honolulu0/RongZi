package com.rongzi.creditmanagement.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.rongzi.creditmanagement.domain.rzcreditmanagement;

/**
 * 授信管理Service接口
 *
 * @author rongzi
 * @date 2024-03-05
 */
public interface IrzcreditmanagementService {
    /**
     * 查询授信管理
     *
     * @param id 授信管理主键
     * @return 授信管理
     */
    public rzcreditmanagement selectrzcreditmanagementById(Long id);

    /**
     * 查询授信管理列表
     *
     * @param rzcreditmanagement 授信管理
     * @return 授信管理集合
     */
    public List<rzcreditmanagement> selectrzcreditmanagementList(rzcreditmanagement rzcreditmanagement);

    /**
     * 新增授信管理
     *
     * @param rzcreditmanagement 授信管理
     * @return 结果
     */
    public int insertrzcreditmanagement(rzcreditmanagement rzcreditmanagement);

    /**
     * 修改授信管理
     *
     * @param rzcreditmanagement 授信管理
     * @return 结果
     */
    public int updaterzcreditmanagement(rzcreditmanagement rzcreditmanagement);

    /**
     * 批量删除授信管理
     *
     * @param ids 需要删除的授信管理主键集合
     * @return 结果
     */
    public int deleterzcreditmanagementByIds(Long[] ids);

    /**
     * 删除授信管理信息
     *
     * @param id 授信管理主键
     * @return 结果
     */
    public int deleterzcreditmanagementById(Long id);

    /**
     * 信用管理Service接口
     */

    public Map<String, Map<String, Object>> selectCreditManagementSummary(String creditState);


    public Map<String, Map<String, BigDecimal>> getFinanceSummary();

    public Map<String, Map<String, BigDecimal>> getGuaranteeSummary();

}
