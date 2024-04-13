package com.rongzi.huankuanjihua.service.impl;

import java.util.List;

import com.rongzi.common.utils.DateUtils;
import com.rongzi.huankuanjihua.domain.FinancialSummary;
import com.rongzi.huankuanjihua.domain.PaymentSummary;
import com.rongzi.huankuanjihua.domain.TotalRzhkjhMingxi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rongzi.huankuanjihua.mapper.RzhkjhMingxiMapper;
import com.rongzi.huankuanjihua.domain.RzhkjhMingxi;
import com.rongzi.huankuanjihua.service.IRzhkjhMingxiService;

/**
 * 还款计划明细Service业务层处理
 *
 * @author rongzi
 * @date 2024-03-27
 */
@Service
public class RzhkjhMingxiServiceImpl implements IRzhkjhMingxiService {
    @Autowired
    private RzhkjhMingxiMapper rzhkjhMingxiMapper;

    /**
     * 查询还款计划明细
     *
     * @param id 还款计划明细主键
     * @return 还款计划明细
     */
    @Override
    public RzhkjhMingxi selectRzhkjhMingxiById(Long id) {
        return rzhkjhMingxiMapper.selectRzhkjhMingxiById(id);
    }

    /**
     * 查询还款计划明细列表
     *
     * @param rzhkjhMingxi 还款计划明细
     * @return 还款计划明细
     */
    @Override
    public List<RzhkjhMingxi> selectRzhkjhMingxiList(RzhkjhMingxi rzhkjhMingxi) {
        return rzhkjhMingxiMapper.selectRzhkjhMingxiList(rzhkjhMingxi);
    }

    /**
     * 查询还款计划明细列表
     *
     * @param rzhkjhMingxi 还款计划明细
     * @return 还款计划明细
     */
    @Override
    public TotalRzhkjhMingxi totalRzhkjhMingxi(RzhkjhMingxi rzhkjhMingxi) {
        return rzhkjhMingxiMapper.totalRzhkjhMingxi(rzhkjhMingxi);
    }

    /**
     * 新增还款计划明细
     *
     * @param rzhkjhMingxi 还款计划明细
     * @return 结果
     */
    @Override
    public int insertRzhkjhMingxi(RzhkjhMingxi rzhkjhMingxi) {
        rzhkjhMingxi.setCreateTime(DateUtils.getNowDate());
        return rzhkjhMingxiMapper.insertRzhkjhMingxi(rzhkjhMingxi);
    }

    /**
     * 修改还款计划明细
     *
     * @param rzhkjhMingxi 还款计划明细
     * @return 结果
     */
    @Override
    public int updateRzhkjhMingxi(RzhkjhMingxi rzhkjhMingxi) {
        rzhkjhMingxi.setUpdateTime(DateUtils.getNowDate());
        return rzhkjhMingxiMapper.updateRzhkjhMingxi(rzhkjhMingxi);
    }

    /**
     * 批量删除还款计划明细
     *
     * @param ids 需要删除的还款计划明细主键
     * @return 结果
     */
    @Override
    public int deleteRzhkjhMingxiByIds(Long[] ids) {
        return rzhkjhMingxiMapper.deleteRzhkjhMingxiByIds(ids);
    }

    /**
     * 删除还款计划明细信息
     *
     * @param id 还款计划明细主键
     * @return 结果
     */
    @Override
    public int deleteRzhkjhMingxiById(Long id) {
        return rzhkjhMingxiMapper.deleteRzhkjhMingxiById(id);
    }

    @Override
    public List<PaymentSummary> getPaymentSummary(String startDate, String endDate) {
        return rzhkjhMingxiMapper.selectPaymentSummary(startDate, endDate);
    }

    @Override
    public FinancialSummary getFinancialSummaryByMonth(String specifiedYearMonth) {
        return rzhkjhMingxiMapper.selectFinancialSummaryByMonth(specifiedYearMonth);
    }

    @Override
    public PaymentSummary getPaymentSummaryByMonth(String specifiedYearMonth) {
        return rzhkjhMingxiMapper.selectPaymentSummaryByMonth(specifiedYearMonth);
    }
}
