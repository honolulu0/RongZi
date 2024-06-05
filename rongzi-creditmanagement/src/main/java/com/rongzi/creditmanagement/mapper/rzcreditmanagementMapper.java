package com.rongzi.creditmanagement.mapper;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.rongzi.creditmanagement.domain.*;
import com.rongzi.appendix.domain.rzsrc2;

/**
 * 授信管理Mapper接口
 *
 * @author rongzi
 * @date 2024-03-05
 */
public interface rzcreditmanagementMapper {
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
     * 查询授信管理列表
     *
     * @param rzcreditmanagement 授信管理
     * @return 授信管理集合
     */
    public Map<String, BigDecimal> selectrzcreditmanagementSum(rzcreditmanagement rzcreditmanagement);

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
     * 删除授信管理
     *
     * @param id 授信管理主键
     * @return 结果
     */
    public int deleterzcreditmanagementById(Long id);

    /**
     * 批量删除授信管理
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleterzcreditmanagementByIds(Long[] ids);

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
     * 通过授信管理主键删除附件表信息
     *
     * @param id 授信管理ID
     * @return 结果
     */
    public int deleterzsrc2ByScrUuid(String id);


    public List<rzcreditmanagementsummary> selectCreditManagementSummary(String creditState);


    public RzFinancingProjectSummary selectRzFinancingProjectSummary();
    public GovernmentSpecialBondsSummary selectGovernmentSpecialBondsSummary();


    public SpecialLoansSummary selectSpecialLoansSummary();

    public InternalGuaranteeSummary selectInternalGuaranteeSummary();


    public ForeignGuaranteeSummary selectForeignGuaranteeSummary();

}
