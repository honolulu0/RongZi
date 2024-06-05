package com.rongzi.quartz.task.service;


import com.rongzi.quartz.mapper.FinancingProjectTaskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FinancingProjectTask {

    @Autowired
    private FinancingProjectTaskMapper financingProjectTaskMapper;

    public void updateFinancingProjectAmountData() {
//        每日更新融资项目的还款金额，余额，还款状态
        try {
            dropTempRepaidAmount();
        } catch (Exception e) {
            // 捕获其他SQL异常并处理
            System.err.println("SQL Exception: " + e.getMessage());
            e.printStackTrace();
        }
        createTempRepaidAmount();
        updateRepaidAmountAndState();
        dropTempRepaidAmount();
    }

    public void createTempRepaidAmount() {
        this.financingProjectTaskMapper.createTempRepaidAmount();
    }

    public void updateRepaidAmountAndState() {
        this.financingProjectTaskMapper.updateRepaidAmountAndState();
    }

    public void dropTempRepaidAmount() {
        this.financingProjectTaskMapper.dropTempRepaidAmount();
    }
}
