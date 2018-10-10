package com.leading.orders.mapper;

import com.leading.orders.bean.Orders;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface OrdersMapper {

    @Select("select * from orders where id=#{id}")
    Orders getOrdersById(Integer id);

    @Insert("insert into orders(product_id,nums) values(#{productId},#{nums})")
    int insertOrders(Orders orders);
}
