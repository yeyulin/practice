package com.jvm.abstracts;

/**
 * @author yeyulin
 * @description:
 * @date 2019/11/12 10:19
 * @since 2.0.7
 **/
public abstract class InspectionSolver {
    public abstract void solve(Long orderId, Long userId);

    /**
     * 支持处理的类型
     * @return
     */
    public abstract String[] supports();
}
