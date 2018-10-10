package com.leading.orders.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "server-product",fallback = ProductClientHystric.class)
public interface ProductClient {

    @PutMapping(value = "/dept/{id}")
    int updateProduct(@PathVariable("id") Integer id, @RequestParam(value = "nums") Integer nums);
}
