package com.leading.orders.controller;

import com.leading.orders.bean.Orders;
import com.leading.orders.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrdersService ordersService;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/order")
    public Integer insertOrders(Orders orders){
        return ordersService.createOrders(orders);
    }

    @GetMapping("/eureka/{service}")
    public Integer serviceUrl(@PathVariable("service") String service){
        List<ServiceInstance> instances = discoveryClient.getInstances(service);
        ServiceInstance serviceInstance = loadBalancerClient.choose("TX-MANAGER");

        return serviceInstance.getPort();
    }
}
