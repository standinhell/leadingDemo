package com.leading.product.mapper;

import com.leading.product.bean.Product;
import org.apache.ibatis.annotations.*;

@Mapper
public interface ProductMapper {

    @Select("select * from product where id=#{id}")
    Product getProductById(Integer id);

    @Delete("delete from product where id=#{id}")
    int deleteProductById(Integer id);

    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into product(product_name,nums) values(#{productName},#{nums})")
    int insertProduct(Product product);

    @Update("update product set nums=#{nums} where id=#{id}")
    int updateProductById(Product product);
}
