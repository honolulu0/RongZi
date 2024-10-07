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
        SpecialLoansSummary specialLoansSummary = rzcreditmanagementMapper.selectSpecialLoansSummary();
        GovernmentSpecialBondsSummary governmentSpecialBondsSummary = rzcreditmanagementMapper.selectGovernmentSpecialBondsSummary();

        RzFinancingProjectSummary financingSummary = rzcreditmanagementMapper.selectRzFinancingProjectSummary();
        RzReverseFactoringSummary factoringSummary = rzcreditmanagementMapper.selectRzReverseFactoringSummary();
        BillSummary bussSummary = rzcreditmanagementMapper.selectRzBusinessAcceptBillSummary();
        BillSummary bankSummary = rzcreditmanagementMapper.selectRzBankAcceptBillSummary();
        BillSummary creditSummary = rzcreditmanagementMapper.selectRzCreditLetterSummary();

        Map<String, Map<String, BigDecimal>> result = new HashMap<>();
        Map<String, BigDecimal> financedAmount = new HashMap<>();
        Map<String, BigDecimal> financeBalance = new HashMap<>();

        // Calculate amounts for "金融负债" subcategories
        BigDecimal financedAmountFinancing = getValidBigDecimal(financingSummary != null ? financingSummary.getTotalFinancingAmount() : null);
        BigDecimal financeBalanceFinancing = getValidBigDecimal(financingSummary != null ? financingSummary.getTotalRemainingAmount() : null);

        BigDecimal financedAmountFactoring = getValidBigDecimal(factoringSummary != null ? factoringSummary.getTotalLoanAmount() : null);
        BigDecimal financeBalanceFactoring = getValidBigDecimal(factoringSummary != null ? factoringSummary.getTotalInProgressLoanAmount() : null);

        BigDecimal financedAmountBuss = getValidBigDecimal(bussSummary != null ? bussSummary.getTotalChangkouedu() : null);
        BigDecimal financeBalanceBuss = getValidBigDecimal(bussSummary != null ? bussSummary.getTotalInProgressChangkouedu() : null);

        BigDecimal financedAmountBank = getValidBigDecimal(bankSummary != null ? bankSummary.getTotalChangkouedu() : null);
        BigDecimal financeBalanceBank = getValidBigDecimal(bankSummary != null ? bankSummary.getTotalInProgressChangkouedu() : null);

        BigDecimal financedAmountCredit = getValidBigDecimal(creditSummary != null ? creditSummary.getTotalChangkouedu() : null);
        BigDecimal financeBalanceCredit = getValidBigDecimal(creditSummary != null ? creditSummary.getTotalInProgressChangkouedu() : null);

        // Sum up the "金融负债" amounts
        BigDecimal totalFinancedAmountFinancialLiabilities = financedAmountFinancing
                .add(financedAmountFactoring)
                .add(financedAmountBuss)
                .add(financedAmountBank)
                .add(financedAmountCredit);

        BigDecimal totalFinanceBalanceFinancialLiabilities = financeBalanceFinancing
                .add(financeBalanceFactoring)
                .add(financeBalanceBuss)
                .add(financeBalanceBank)
                .add(financeBalanceCredit);

        // "专项债"
        BigDecimal financedAmountSpecialBonds = getValidBigDecimal(governmentSpecialBondsSummary != null ? governmentSpecialBondsSummary.getTotalApprovedAmount() : null);
        BigDecimal financeBalanceSpecialBonds = getValidBigDecimal(governmentSpecialBondsSummary != null ? governmentSpecialBondsSummary.getTotalRemainingAmount() : null);

        // "专项借款"
        BigDecimal financedAmountSpecialLoans = getValidBigDecimal(specialLoansSummary != null ? specialLoansSummary.getTotalLoanAmount() : null);
        BigDecimal financeBalanceSpecialLoans = getValidBigDecimal(specialLoansSummary != null ? specialLoansSummary.getTotalBalance() : null);

        // Populate the maps
        financedAmount.put("金融负债", totalFinancedAmountFinancialLiabilities);
        financeBalance.put("金融负债", totalFinanceBalanceFinancialLiabilities);

        financedAmount.put("专项债", financedAmountSpecialBonds);
        financeBalance.put("专项债", financeBalanceSpecialBonds);

        financedAmount.put("专项借款", financedAmountSpecialLoans);
        financeBalance.put("专项借款", financeBalanceSpecialLoans);

        result.put("已融资金额", financedAmount);
        result.put("融资余额", financeBalance);

        return result;
    }

    private BigDecimal getValidBigDecimal(BigDecimal value) {
        return value != null ? value : BigDecimal.ZERO;
    }



    public Map<String, Map<String, BigDecimal>> getFinanceSummary2() {
        SpecialLoansSummary specialLoansSummary = rzcreditmanagementMapper.selectSpecialLoansSummary();
        GovernmentSpecialBondsSummary governmentSpecialBondsSummary = rzcreditmanagementMapper.selectGovernmentSpecialBondsSummary();


        RzFinancingProjectSummary financingSummary = rzcreditmanagementMapper.selectRzFinancingProjectSummary();
        RzReverseFactoringSummary factioringSummary = rzcreditmanagementMapper.selectRzReverseFactoringSummary();
        BillSummary bussSummary = rzcreditmanagementMapper.selectRzBusinessAcceptBillSummary();
        BillSummary bankSummary = rzcreditmanagementMapper.selectRzBankAcceptBillSummary();
        BillSummary creditSummary = rzcreditmanagementMapper.selectRzCreditLetterSummary();

        Map<String, Map<String, BigDecimal>> result = new HashMap<>();
        Map<String, BigDecimal> financedAmount = new HashMap<>();
        Map<String, BigDecimal> financeBalance = new HashMap<>();

        if (financingSummary != null) {

            financedAmount.put("有息贷款", financingSummary.getTotalFinancingAmount());
            financeBalance.put("有息贷款", financingSummary.getTotalRemainingAmount());
        }

        if (factioringSummary != null) {
            financedAmount.put("反向保理", factioringSummary.getTotalLoanAmount());
            financeBalance.put("反向保理", factioringSummary.getTotalInProgressLoanAmount());
        }

        if (bussSummary != null) {
            financedAmount.put("商业承兑", bussSummary.getTotalChangkouedu());
            financeBalance.put("商业承兑", bussSummary.getTotalInProgressChangkouedu());
        }
        if (bankSummary != null) {
            financedAmount.put("银行承兑", bankSummary.getTotalChangkouedu());
            financeBalance.put("银行承兑", bankSummary.getTotalInProgressChangkouedu());
        }

        if (creditSummary != null) {
            financedAmount.put("信用证", creditSummary.getTotalChangkouedu());
            financeBalance.put("信用证", creditSummary.getTotalInProgressChangkouedu());
        }

        if (creditSummary != null) {
            financedAmount.put("专项债", governmentSpecialBondsSummary.getTotalApprovedAmount());
            financeBalance.put("专项债", governmentSpecialBondsSummary.getTotalRemainingAmount());
        }

        if (creditSummary != null) {
            financedAmount.put("专项借款", specialLoansSummary.getTotalLoanAmount());
            financeBalance.put("专项借款", specialLoansSummary.getTotalBalance());
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
