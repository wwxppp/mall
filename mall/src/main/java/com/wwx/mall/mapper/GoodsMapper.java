package com.wwx.mall.mapper;

import com.wwx.mall.bean.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoodsMapper {
    List<Goods> queryGoods(@Param("goodsSn") int GoodsSn, @Param("name") String name);
    Goods selectGood(int id);
   List< Attribute> selectattribute(int goodsId);
    List<Specification> selectSpecification(int goodsId);
    List<Product> selectProduct(int goodsId);
    List<Category> selectCategorys();
    List<Brand> selectBrand();

}
