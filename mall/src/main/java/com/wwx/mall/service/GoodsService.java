package com.wwx.mall.service;

import com.wwx.mall.bean.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GoodsService {
List<Goods> queryGoods(int pageNumber, int size,int goodsSn,String name);
Goods queryGood(int id);
List<Attribute> queryAttribute(int id);
List<Product> queryProduct(int id);
List<Specification> querySpecification(int id);
List<Category> queryCategory();
List<Brand> queryBrand();
}
