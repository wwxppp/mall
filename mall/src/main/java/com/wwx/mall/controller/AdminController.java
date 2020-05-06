package com.wwx.mall.controller;


import com.wwx.mall.bean.BaseRespVo;
import com.wwx.mall.service.AdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class AdminController {


    @Autowired
    AdminServiceImpl adminService;

    BaseRespVo baseRespVo=new BaseRespVo() ;

    @RequestMapping("admin/auth/login")
//    public BaseRespVo login(@RequestBody LoginBean loginBean)
    public BaseRespVo login(@RequestBody Map map){
        //没有使用shiro的情况下 ，返回任意的这个值就行了
        //errno = 0
        baseRespVo.setErrno(0);
        baseRespVo.setData("abc");
        baseRespVo.setErrmsg("成功");
        return baseRespVo;

    }

    @RequestMapping("admin/auth/info")
    public BaseRespVo info(){
        baseRespVo.setErrno(0);
        baseRespVo.setErrmsg("成功");
        HashMap<String, Object> map = new HashMap<>();
        map.put("name","admin123");
        map.put("avatar","https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        ArrayList<String> roleList = new ArrayList<>();
        roleList.add("超级管理员");
        ArrayList<String> permList = new ArrayList<>();
        permList.add("*");

        map.put("roles",roleList);
        map.put("perms",permList);
        baseRespVo.setData(map);
        return baseRespVo;
    }
    @RequestMapping("admin/dashboard")
    public BaseRespVo dashboard(){
        baseRespVo.setErrmsg("成功");
        baseRespVo.setErrno(0);
        Map map=new HashMap();
        map.put("goodsTotal",adminService.queryTotalGoods());
        map.put("userTotal",adminService.queryTotalUser());
        map.put("productTotal",adminService.queryTotalProduct());
        map.put("orderTotal",adminService.queryTotalOrder());
        baseRespVo.setData(map);
        return  baseRespVo;
    }
}
