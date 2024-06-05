package com.rongzi.quartz.task;

import com.rongzi.quartz.task.service.FinancingDataBackup;
import com.rongzi.quartz.task.service.FinancingProjectTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.rongzi.common.utils.StringUtils;

/**
 * 定时任务调度测试
 *
 * @author rongzi
 */
@Component("ryTask")
public class RyTask {

    @Autowired
    private FinancingDataBackup financingDataBackup;
    @Autowired
    private FinancingProjectTask financingProjectTask;


    public void ryMultipleParams(String s, Boolean b, Long l, Double d, Integer i) {
        System.out.println(StringUtils.format("执行多参方法： 字符串类型{}，布尔类型{}，长整型{}，浮点型{}，整形{}", s, b, l, d, i));
    }

    public void ryParams(String params) {
        System.out.println("执行有参方法：" + params);
    }

    public void ryNoParams() {
        System.out.println("执行无参方法");
    }


    public void financingDataBackup() {
        //先更新每日的融资余额等信息，再记录每天的融资担保等记录
        financingProjectTask.updateFinancingProjectAmountData();
        financingDataBackup.processData();

    }
}
