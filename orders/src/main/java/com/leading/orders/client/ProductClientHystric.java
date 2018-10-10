package com.leading.orders.client;

public class ProductClientHystric implements ProductClient {
    @Override
    public int updateProduct(Integer id, Integer nums) {
        System.out.println("订单创建失败");
        throw new RuntimeException("订单创建失败");
    }
}
