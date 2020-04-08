package com.lock.combine.impl;

import com.lock.combine.dto.CombineOrder;
import com.lock.combine.dto.CombineOrderRes;
import com.lock.combine.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toMap;

/**
 * @author yeyulin
 * @description:
 * @date 2019/12/13 13:35
 * @since 2.0.7
 **/
@Service
public class OrderServiceImpl implements OrderService {
    private ArrayBlockingQueue<CombineOrder> blockingQueue = new ArrayBlockingQueue(100);
    ExecutorService service = Executors.newFixedThreadPool(1);

    @Override
    public void queryOrderByIdCombine() {
        List<CombineOrder> param = new ArrayList<>();
        Iterator<CombineOrder> iterator = blockingQueue.iterator();
        while (iterator.hasNext()) {
            param.add(iterator.next());
            iterator.remove();
        }
        List<Long> orderIds = param.stream().map(CombineOrder::getId).collect(Collectors.toList());
        //查询数据库，并封装结果
        System.out.println("查询数据库");
        List<CombineOrderRes> result = new ArrayList<>();
        result.add(new CombineOrderRes(1L, "11"));
        result.add(new CombineOrderRes(2L, "22"));
        result.add(new CombineOrderRes(3L, "33"));
        result.add(new CombineOrderRes(4L, "44"));
        result.add(new CombineOrderRes(5L, "55"));
        Map<Long, String> resMap = result.stream().collect(toMap(CombineOrderRes::getId, CombineOrderRes::getValue));
        for (CombineOrder combineOrder : param) {
            String value = resMap.get(combineOrder.getId());
            combineOrder.setValue(value);
        }
        //唤醒线程响应结果
        for (CombineOrder combineOrder : param) {
            combineOrder.notifyResult();
        }
    }

    @Override
    public String queryOrderById(Long id) {
        CombineOrder combineOrder = new CombineOrder();
        combineOrder.setId(id);
        blockingQueue.add(combineOrder);
        combineOrder.waitResult();
        System.out.println("请求参数:" + combineOrder);
        return combineOrder.getValue();
    }
}
