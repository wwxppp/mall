package com.wwx.mall.service;

import com.wwx.mall.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl  implements   AdminService{
    @Autowired
    UserMapper userMapper;
    @Override
    public int queryTotalGoods() {
        return userMapper.selectTotalGoods();
    }

    @Override
    public int queryTotalUser() {
        return userMapper.selectTotalUser();
    }

    @Override
    public int queryTotalOrder() {
        return userMapper.selectTotalOrder();
    }

    @Override
    public int queryTotalProduct() {
        return userMapper.selectTotalProduct();
    }
}
