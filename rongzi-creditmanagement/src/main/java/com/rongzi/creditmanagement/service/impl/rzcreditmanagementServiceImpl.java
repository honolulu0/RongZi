package com.rongzi.creditmanagement.service.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

import com.rongzi.common.utils.DateUtils;
import com.rongzi.creditmanagement.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Map;

import com.rongzi.common.utils.StringUtils;
import org.springframework.transaction.annotation.Transactional;
import com.rongzi.creditmanagement.mapper.rzcreditmanagementMapper;
import com.rongzi.creditmanagement.service.IrzcreditmanagementService;
import com.rongzi.appendix.domain.rzsrc2;

/**
 * 授信管理Service业务层处理
 *
 * @author rongzi
 * @date 2024-03-05
 */
@Service
public class rzcreditmanagementServiceImpl implements IrzcreditmanagementService {
    @Autowired
    private rzcreditmanagementMapper rzcreditmanagementMapper;


    /**
     * 查询授信管理
     *
     * @param id 授信管理主键
     * @return 授信管理
     */
    @Override
    public rzcreditmanagement selectrzcreditmanagementById(Long id) {
        return rzcreditmanagementMapper.selectrzcreditmanagementById(id);
    }

    /**
     * 查询授信管理列表
     *
     * @param rzcreditmanagement 授信管理
     * @return 授信管理
     */
    @Override
    public List<rzcreditmanagement> selectrzcreditmanagementList(rzcreditmanagement rzcreditmanagement) {
        return rzcreditmanagementMapper.selectrzcreditmanagementList(rzcreditmanagement);
    }

    /**
     * 查询授信管理SUM
     *
     * @param rzcreditmanagement 授信管理
     * @return 授信管理
     */
    @Override
    public Map<String, BigDecimal> selectrzcreditmanagementSum(rzcreditmanagement rzcreditmanagement) {
        return rzcreditmanagementMapper.selectrzcreditmanagementSum(rzcreditmanagement);
    }

    /**
     * 新增授信管理
     *
     * @param rzcreditmanagement 授信管理
     * @return 结果
     */
    @Transactional
    @Override
    public int insertrzcreditmanagement(rzcreditmanagement rzcreditmanagement) {
        rzcreditmanagement.setCreateTime(DateUtils.getNowDate());
        int rows = rzcreditmanagementMapper.insertrzcreditmanagement(rzcreditmanagement);
        insertrzsrc2(rzcreditmanagement);
        return rows;
    }

    /**
     * 修改授信管理
     *
     * @param rzcreditmanagement 授信管理
     * @return 结果
     */
    @Transactional
    @Override
    public int updaterzcreditmanagement(rzcreditmanagement rzcreditmanagement) {
        rzcreditmanagement.setUpdateTime(DateUtils.getNowDate());
        rzcreditmanagementMapper.deleterzsrc2ByScrUuid(rzcreditmanagement.getScrUuid());
        insertrzsrc2(rzcreditmanagement);
        return rzcreditmanagementMapper.updaterzcreditmanagement(rzcreditmanagement);
    }

    /**
     * 批量删除授信管理
     *
     * @param ids 需要删除的授信管理主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleterzcreditmanagementByIds(Long[] ids) {
        return rzcreditmanagementMapper.deleterzcreditmanagementByIds(ids);
    }

    /**
     * 删除授信管理信息
     *
     * @param id 授信管理主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleterzcreditmanagementById(Long id) {
        return rzcreditmanagementMapper.deleterzcreditmanagementById(id);
    }

    /**
     * 新增附件表信息
     *
     * @param rzcreditmanagement 授信管理对象
     */
    public void insertrzsrc2(rzcreditmanagement rzcreditmanagement) {
        List<rzsrc2> rzsrc2List = rzcreditmanagement.getrzsrc2List();
//        Long id = rzcreditmanagement.getId();
        String uuidS = rzcreditmanagement.getScrUuid();
        if (StringUtils.isNotNull(rzsrc2List)) {
            List<rzsrc2> list = new ArrayList<rzsrc2>();
            for (rzsrc2 rzsrc2 : rzsrc2List) {
                rzsrc2.setScrUuid(uuidS);
                list.add(rzsrc2);
            }
            if (list.size() > 0) {
                rzcreditmanagementMapper.batchrzsrc2(list);
            }
        }
    }

    public Map<String, Map<String, Object>> selectCreditManagementSummary(String creditState) {
        List<rzcreditmanagementsummary> summaries = rzcreditmanagementMapper.selectCreditManagementSummary(creditState);
        Map<String, Map<String, Object>> formattedSummaries = new HashMap<>();

        Map<String, Object> summaryDetails1 = new HashMap<>();
        Map<String, Object> summaryDetails2 = new HashMap<>();

        for (rzcreditmanagementsummary summary : summaries) {
            if (summary != null) { // 非空检查
                summaryDetails1.put(summary.getCreditType(), summary.getTotalAmount());
                summaryDetails2.put(summary.getCreditType(), summary.getTotalRemainingAmount());
            }
        }

        formattedSummaries.put("已授信金额", summaryDetails1);
        formattedSummaries.put("授信余额", summaryDetails2);

        return formattedSummaries;
    }

    public Map<String, Map<String, BigDecimal>> getFinanceSummary() {
        RzFinancingProjectSummary financingSummary = rzcreditmanagementMapper.selectRzFinancingProjectSummary();
        GovernmentSpecialBondsSummary bondsSummary = rzcreditmanagementMapper.selectGovernmentSpecialBondsSummary();
        SpecialLoansSummary loansSummary = rzcreditmanagementMapper.selectSpecialLoansSummary();

        Map<String, Map<String, BigDecimal>> result = new HashMap<>();
        Map<String, BigDecimal> financedAmount = new HashMap<>();
        if (financingSummary != null) {

            financedAmount.put("金融负债", financingSummary.getTotalFinancingAmount());
        }

        if (bondsSummary != null) {
            financedAmount.put("政府专项债", bondsSummary.getTotalApprovedAmount());
        }
        if (loansSummary != null) {

            financedAmount.put("专项借款", loansSummary.getTotalLoanAmount());
        }

        Map<String, BigDecimal> financeBalance = new HashMap<>();
        //正常情况下    融资项目 = 金融负债+政府专项债+专项借款
        //由于融资项目里没有包含 政府专项债 专项借款 所以 融资项目就是 金融负债
        if (financingSummary != null) {

            financeBalance.put("金融负债", financingSummary.getTotalRemainingAmount());
        }

        if (bondsSummary != null) {

            financeBalance.put("政府专项债", bondsSummary.getTotalRemainingAmount());
        }

        if (loansSummary != null) {

            financeBalance.put("专项借款", loansSummary.getTotalBalance());
        }


        result.put("已融资金额", financedAmount);
        result.put("融资余额", financeBalance);

        return result;
    }

    public Map<String, Map<String, BigDecimal>> getGuaranteeSummary() {
        InternalGuaranteeSummary bondsSummary = rzcreditmanagementMapper.selectInternalGuaranteeSummary();
        ForeignGuaranteeSummary loansSummary = rzcreditmanagementMapper.selectForeignGuaranteeSummary();

        Map<String, Map<String, BigDecimal>> result = new HashMap<>();
        Map<String, BigDecimal> financedAmount = new HashMap<>();
        if (bondsSummary != null) {

            financedAmount.put("对内担保", bondsSummary.getTotalGuaranteeAmount());
        }
        if (loansSummary != null) {

            financedAmount.put("对外担保", loansSummary.getTotalGuaranteeAmount());
        }


        Map<String, BigDecimal> financeBalance = new HashMap<>();
        if (bondsSummary != null) {

            financeBalance.put("对内担保", bondsSummary.getTotalGuaranteeBalance());
        }
        if (loansSummary != null) {

            financeBalance.put("对外担保", loansSummary.getTotalGuaranteeBalance());
        }


        result.put("已担保金额", financedAmount);
        result.put("担保余额", financeBalance);

        return result;
    }

}
