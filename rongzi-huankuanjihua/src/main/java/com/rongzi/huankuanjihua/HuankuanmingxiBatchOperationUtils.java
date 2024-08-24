package com.rongzi.huankuanjihua;

import com.rongzi.common.utils.StringUtils;
import com.rongzi.huankuanjihua.domain.RzhkjhMingxi;
import com.rongzi.huankuanjihua.mapper.RzhkjhMingxiMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


/**
 * 批量操作还款明细信息
 *
 * @author rongzi
 */

@Component
public class HuankuanmingxiBatchOperationUtils {


    @Autowired
    private RzhkjhMingxiMapper rzhkjhMingxiMapper;

    /**
     * 批量新增还款明细信息
     */
    public void batchinserthuankuanmingxi(List<RzhkjhMingxi> repaymentDetailsList, String managementId) {

        if (StringUtils.isNotNull(repaymentDetailsList)) {
            List<RzhkjhMingxi> list = new ArrayList<RzhkjhMingxi>();
            for (RzhkjhMingxi repaymentDetail : repaymentDetailsList) {
                repaymentDetail.setManagerId(managementId);
                list.add(repaymentDetail);
            }
            if (list.size() > 0) {
                rzhkjhMingxiMapper.batchhuankuanmingxi(list);
            }
        }
    }

    public int deleterHuankuanmingxiByManagementId(String managementId) {
        return rzhkjhMingxiMapper.deleterHuankuanmingxiByManagementId(managementId);
    }


}
