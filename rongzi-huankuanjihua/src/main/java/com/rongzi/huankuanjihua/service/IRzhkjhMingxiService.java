package com.rongzi.huankuanjihua.service;

import java.util.List;

import com.rongzi.huankuanjihua.domain.FinancialSummary;
import com.rongzi.huankuanjihua.domain.PaymentSummary;
import com.rongzi.huankuanjihua.domain.RzhkjhMingxi;
import com.rongzi.huankuanjihua.domain.TotalRzhkjhMingxi;

/**
 * 还款计划明细Service接口
 *
 * @author rongzi
 * @date 2024-05-28
 */
public interface IRzhkjhMingxiService
{
    /**
     * 查询还款计划明细
     *
     * @param id 还款计划明细主键
     * @return 还款计划明细
     */
    public RzhkjhMingxi selectRzhkjhMingxiById(Long id);

    /**
     * 查询还款计划明细列表
     *
     * @param rzhkjhMingxi 还款计划明细
     * @return 还款计划明细集合
     */
    public List<RzhkjhMingxi> selectRzhkjhMingxiList(RzhkjhMingxi rzhkjhMingxi);

    public TotalRzhkjhMingxi totalRzhkjhMingxi(RzhkjhMingxi rzhkjhMingxi);

    /**
     * 新增还款计划明细
     *
     * @param rzhkjhMingxi 还款计划明细
     * @return 结果
     */
    public int insertRzhkjhMingxi(RzhkjhMingxi rzhkjhMingxi);

    /**
     * 修改还款计划明细
     *
     * @param rzhkjhMingxi 还款计划明细
     * @return 结果
     */
    public int updateRzhkjhMingxi(RzhkjhMingxi rzhkjhMingxi);

    /**
     * 批量删除还款计划明细
     *
     * @param ids 需要删除的还款计划明细主键集合
     * @return 结果
     */
    public int deleteRzhkjhMingxiByIds(Long[] ids);

    /**
     * 删除还款计划明细信息
     *
     * @param id 还款计划明细主键
     * @return 结果
     */
    public int deleteRzhkjhMingxiById(Long id);

    public List<PaymentSummary> getPaymentSummary(String startDate, String endDate);

    public FinancialSummary getFinancialSummaryByMonth(String specifiedYearMonth);
    public FinancialSummary getFinancialSummaryByDate(String specifiedDate);

    public PaymentSummary getPaymentSummaryByMonth(String specifiedYearMonth);

}
