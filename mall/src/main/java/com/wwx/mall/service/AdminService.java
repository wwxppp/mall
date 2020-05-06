package com.wwx.mall.service;

import org.springframework.stereotype.Service;

@Service
public interface AdminService {
    int queryTotalGoods();
    int queryTotalUser();
    int queryTotalOrder();
    int queryTotalProduct();
}
