package com.wwx.mall.mapper;

import com.wwx.mall.bean.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

    int selectTotalGoods();
    int selectTotalUser();
    int selectTotalProduct();
    int selectTotalOrder();
}
