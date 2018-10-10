package com.leading.orders.controller;

import com.leading.orders.bean.Orders;
import com.leading.orders.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    private OrdersService ordersService;

    @GetMapping("/order")
    public Integer insertOrders(Orders orders){
        return ordersService.createOrders(orders);
    }
}
