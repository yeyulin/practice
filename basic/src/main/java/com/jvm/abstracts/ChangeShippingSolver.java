package com.jvm.abstracts;

import org.springframework.stereotype.Component;

/**
 * @author yeyulin
 * @description:
 * @date 2019/11/12 10:48
 * @since 2.0.7
 **/
@Component
public class ChangeShippingSolver extends InspectionSolver{
    @Override
    public void solve(Long orderId, Long userId) {
        System.out.println("订单"+orderId+"开始进行转快递了。。");
    }

    @Override
    public String[] supports() {
        return new String[]{InspectionConstant.INSPECTION_TASK_TYPE_BATCH_CHANGE_SHIPPING};
    }
}
