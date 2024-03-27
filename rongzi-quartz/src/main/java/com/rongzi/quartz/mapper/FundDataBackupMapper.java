package com.rongzi.quartz.mapper;

public interface FundDataBackupMapper {
    void deleteDataFinancing();
    void insertDataFinancing();
    void deleteDataGuarantee();
    void insertDataGuaranteeInternal();
    void insertDataGuaranteeExternal();
}
