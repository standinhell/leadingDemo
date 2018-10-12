package com.leading.orders.service;

import com.codingapi.tx.annotation.TxTransaction;
import com.leading.orders.bean.Orders;
import com.leading.orders.client.ProductClient;
import com.leading.orders.mapper.OrdersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrdersService {

    @Autowired
    private OrdersMapper ordersMapper;

    @Autowired
    private ProductClient productClient;

    @TxTransaction(isStart = true)
    @Transactional
    public Integer createOrders(Orders orders){

        int r1 = 0;
        int r2 = 0;
        try {
            r1 = productClient.updateProduct(orders.getProductId(),orders.getNums());
            r2 = ordersMapper.insertOrders(orders);
            int i = 1/0;
        } catch (Exception e) {
            throw e;
        }


        return r1+r2;
    }
}
