package com.rongzi.quartz.task.service;

import com.rongzi.quartz.mapper.FundDataBackupMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FinancingDataBackup {

    @Autowired
    private FundDataBackupMapper fundDataBackupMapper;

    public void processData() {
        //融资和担保的每日历史记录
        deleteData();
        insertData();
    }

    public void deleteData() {
        this.fundDataBackupMapper.deleteDataFinancing();
        this.fundDataBackupMapper.deleteDataGuarantee();
    }

    public void insertData() {
        this.fundDataBackupMapper.insertDataFinancing();
        this.fundDataBackupMapper.insertDataGuaranteeInternal();
        this.fundDataBackupMapper.insertDataGuaranteeExternal();
    }
}
