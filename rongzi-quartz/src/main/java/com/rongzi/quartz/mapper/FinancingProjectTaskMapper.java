package com.rongzi.quartz.mapper;


public interface FinancingProjectTaskMapper {

    void createTempRepaidAmount();


    void updateRepaidAmountAndState();

    void dropTempRepaidAmount();
}
