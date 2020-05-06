package com.wwx.mall.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wwx.mall.bean.*;
import com.wwx.mall.mapper.GoodsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    GoodsMapper goodsMapper;

    @Override
    public List<Goods> queryGoods(int pageNumber, int size,int goodsSn,String name) {


        PageHelper.startPage(pageNumber,size);
        List<Goods> goods=goodsMapper.queryGoods(goodsSn,name);
        PageInfo<Goods> pageInfo=new PageInfo<>(goods);
        return goods;
    }

    @Override
    public Goods queryGood(int id) {
        return goodsMapper.selectGood(id);
    }

    @Override
    public List<Attribute> queryAttribute(int id) {
        return goodsMapper.selectattribute(id);
    }

    @Override
    public List<Product> queryProduct(int id) {
        return goodsMapper.selectProduct(id);
    }

    @Override
    public List<Specification> querySpecification(int id) {
        return goodsMapper.selectSpecification(id);
    }

    @Override
    public List<Category> queryCategory() {
        return goodsMapper.selectCategorys();
    }

    @Override
    public List<Brand> queryBrand() {
        return goodsMapper.selectBrand();
    }
}
