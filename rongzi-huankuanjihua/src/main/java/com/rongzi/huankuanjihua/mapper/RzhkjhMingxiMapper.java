package com.rongzi.huankuanjihua.mapper;

import java.util.List;

import com.rongzi.huankuanjihua.domain.FinancialSummary;
import com.rongzi.huankuanjihua.domain.PaymentSummary;
import com.rongzi.huankuanjihua.domain.RzhkjhMingxi;
import com.rongzi.huankuanjihua.domain.TotalRzhkjhMingxi;
import io.lettuce.core.dynamic.annotation.Param;

/**
 * 还款计划明细Mapper接口
 *
 * @author rongzi
 * @date 2024-05-28
 */
public interface RzhkjhMingxiMapper
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
    /**
     * 查询还款计划明细列表
     *
     * @param rzhkjhMingxi 还款计划明细
     * @return 还款计划明细集合
     */
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
     * 删除还款计划明细
     *
     * @param id 还款计划明细主键
     * @return 结果
     */
    public int deleteRzhkjhMingxiById(Long id);

    /**
     * 批量删除还款计划明细
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteRzhkjhMingxiByIds(Long[] ids);


    public List<PaymentSummary> selectPaymentSummary(String startDate,String endDate);


    public FinancialSummary selectFinancialSummaryByMonth(String specifiedYearMonth);
    public FinancialSummary selectFinancialSummaryByDate(String specifiedDate);

    public PaymentSummary selectPaymentSummaryByMonth(String specifiedYearMonth);
}
