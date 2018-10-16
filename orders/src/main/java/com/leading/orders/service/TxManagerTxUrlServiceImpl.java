package com.leading.orders.service;

import com.codingapi.tx.config.service.TxManagerTxUrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;

/**
 * create by lorne on 2017/11/18
 */
@Service
public class TxManagerTxUrlServiceImpl implements TxManagerTxUrlService{

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Value("${tm.manager.serviceId}")
    private String serviceId;

    @Override
    public String getTxUrl() {
        System.out.println("load tm.manager.url ");
        ServiceInstance serviceInstance = loadBalancerClient.choose(serviceId);
        return "http://"+ serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/tx/manager/";
    }
}
