package com.rongzi.financingproject.service.impl;

import java.math.BigDecimal;
import java.util.List;

import com.rongzi.common.utils.DateUtils;
import com.rongzi.huankuanjihua.HuankuanmingxiBatchOperationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Map;

import com.rongzi.common.utils.StringUtils;
import org.springframework.transaction.annotation.Transactional;
import com.rongzi.financingproject.mapper.rzfinancingprojectMapper;
import com.rongzi.financingproject.domain.rzfinancingproject;
import com.rongzi.financingproject.service.IrzfinancingprojectService;
import com.rongzi.appendix.domain.rzsrc2;

/**
 * 融资项目Service业务层处理
 *
 * @author rongzi
 * @date 2024-05-28
 */
@Service
public class rzfinancingprojectServiceImpl implements IrzfinancingprojectService {
    @Autowired
    private rzfinancingprojectMapper rzfinancingprojectMapper;

    @Autowired
    private HuankuanmingxiBatchOperationUtils huankuanmingxiBatchOperationUtils;

    /**
     * 查询融资项目
     *
     * @param id 融资项目主键
     * @return 融资项目
     */
    @Override
    public rzfinancingproject selectrzfinancingprojectById(Long id) {
        return rzfinancingprojectMapper.selectrzfinancingprojectById(id);
    }

    /**
     * 查询融资项目
     *
     * @param managementId 融资managementId
     * @return 融资项目
     */
    @Override
    public rzfinancingproject selectrzfinancingprojectByManagementId(String managementId) {
        return rzfinancingprojectMapper.selectrzfinancingprojectByManagementId(managementId);
    }

    /**
     * 查询融资项目列表
     *
     * @param rzfinancingproject 融资项目
     * @return 融资项目
     */
    @Override
    public List<rzfinancingproject> selectrzfinancingprojectList(rzfinancingproject rzfinancingproject) {
        return rzfinancingprojectMapper.selectrzfinancingprojectList(rzfinancingproject);
    }

    /**
     * 查询融资项目SUM
     *
     * @param rzfinancingproject 融资项目
     * @return 融资项目
     */
    @Override
    public Map<String, BigDecimal> selectrzfinancingprojectSum(rzfinancingproject rzfinancingproject) {
        return rzfinancingprojectMapper.selectrzfinancingprojectSum(rzfinancingproject);
    }

    /**
     * 新增融资项目
     *
     * @param rzfinancingproject 融资项目
     * @return 结果
     */
    @Transactional
    @Override
    public int insertrzfinancingproject(rzfinancingproject rzfinancingproject) {
        rzfinancingproject.setCreateTime(DateUtils.getNowDate());
        int rows = rzfinancingprojectMapper.insertrzfinancingproject(rzfinancingproject);
        insertrzsrc2(rzfinancingproject);
        huankuanmingxiBatchOperationUtils.batchinserthuankuanmingxi(rzfinancingproject.getHuankuanmingxi2List(), rzfinancingproject.getManagementId());
        return rows;
    }

    /**
     * 修改融资项目
     *
     * @param rzfinancingproject 融资项目
     * @return 结果
     */
    @Transactional
    @Override
    public int updaterzfinancingproject(rzfinancingproject rzfinancingproject) {
        rzfinancingproject.setUpdateTime(DateUtils.getNowDate());
        rzfinancingprojectMapper.deleterzsrc2ByScrUuid(rzfinancingproject.getScrUuid());
        insertrzsrc2(rzfinancingproject);
        huankuanmingxiBatchOperationUtils.deleterHuankuanmingxiByManagementId(rzfinancingproject.getManagementId());
        huankuanmingxiBatchOperationUtils.batchinserthuankuanmingxi(rzfinancingproject.getHuankuanmingxi2List(), rzfinancingproject.getManagementId());
        return rzfinancingprojectMapper.updaterzfinancingproject(rzfinancingproject);
    }

    /**
     * 批量删除融资项目
     *
     * @param ids 需要删除的融资项目主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleterzfinancingprojectByIds(Long[] ids) {
        return rzfinancingprojectMapper.deleterzfinancingprojectByIds(ids);
    }

    /**
     * 删除融资项目信息
     *
     * @param id 融资项目主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleterzfinancingprojectById(Long id) {
        return rzfinancingprojectMapper.deleterzfinancingprojectById(id);
    }

    /**
     * 新增附件表信息
     *
     * @param rzfinancingproject 融资项目对象
     */
    public void insertrzsrc2(rzfinancingproject rzfinancingproject) {
        List<rzsrc2> rzsrc2List = rzfinancingproject.getrzsrc2List();
//        Long id = rzfinancingproject.getId();
        String uuidS = rzfinancingproject.getScrUuid();
        if (StringUtils.isNotNull(rzsrc2List)) {
            List<rzsrc2> list = new ArrayList<rzsrc2>();
            for (rzsrc2 rzsrc2 : rzsrc2List) {
                rzsrc2.setScrUuid(uuidS);
                list.add(rzsrc2);
            }
            if (list.size() > 0) {
                rzfinancingprojectMapper.batchrzsrc2(list);
            }
        }
    }


}
