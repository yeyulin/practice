package com.lock.combine.service;

/**
 * @author yeyulin
 * @description:
 * @date 2019/12/13 13:31
 * @since 2.0.7
 **/
public interface OrderService {
    void queryOrderByIdCombine();

    String queryOrderById(Long id);
}
