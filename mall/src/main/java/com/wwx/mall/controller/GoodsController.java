package com.wwx.mall.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wwx.mall.bean.*;
import com.wwx.mall.service.GoodsService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sun.rmi.runtime.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@RestController
public class GoodsController {
    BaseRespVo baseRespVo=new BaseRespVo() ;
    @Autowired
    GoodsService goodsService;
    @RequestMapping(value="admin/goods/list" ,params = {"page","limit","sort","order"})
    public BaseRespVo goodsList(int page,  int limit,
     String sort,String order
    ){

        List<Goods> goods=goodsService.queryGoods(page,limit,0,null);
        PageInfo<Goods> pageInfo=new PageInfo<>(goods);
        baseRespVo.setErrno(0);
        baseRespVo.setErrmsg("成功");
        Map map=new HashMap();
        map.put("total",pageInfo.getTotal());
        map.put("items",goods);
        baseRespVo.setData(map);

        return baseRespVo;

    }
    @RequestMapping(value = "admin/goods/list",method= RequestMethod.GET,params = {"page","limit","sort","order","goodsSn","name"})
    public BaseRespVo goodsList1( int page,  int limit, String sort, String order, int goodsSn, String name )
    {List<Goods> goods=goodsService.queryGoods(page,limit,goodsSn,name);
        PageInfo<Goods> pageInfo=new PageInfo<>(goods);
        baseRespVo.setErrno(0);
        baseRespVo.setErrmsg("成功");
        Map map=new HashMap();
        map.put("total",pageInfo.getTotal());
        map.put("items",goods);
        baseRespVo.setData(map);
        return baseRespVo;
    }
    @RequestMapping(value = "admin/goods/list",method= RequestMethod.GET,params = {"page","limit","sort","order","goodsSn"})
    public BaseRespVo goodsList1( int page,  int limit, String sort, String order, int goodsSn )
    {List<Goods> goods=goodsService.queryGoods(page,limit,goodsSn,null);
        PageInfo<Goods> pageInfo=new PageInfo<>(goods);
        baseRespVo.setErrno(0);
        baseRespVo.setErrmsg("成功");
        Map map=new HashMap();
        map.put("total",pageInfo.getTotal());
        map.put("items",goods);
        baseRespVo.setData(map);
        return baseRespVo;
    }
    @RequestMapping(value = "admin/goods/list",method= RequestMethod.GET,params = {"page","limit","sort","order","goodsSn=","name"})
    public BaseRespVo goodsList1( int page,  int limit, String sort, String order,  String name )
    {List<Goods> goods=goodsService.queryGoods(page,limit,0,name);
        PageInfo<Goods> pageInfo=new PageInfo<>(goods);
        baseRespVo.setErrno(0);
        baseRespVo.setErrmsg("成功");
        Map map=new HashMap();
        map.put("total",pageInfo.getTotal());
        map.put("items",goods);
        baseRespVo.setData(map);
        return baseRespVo;
    }

    @RequestMapping("admin/goods/detail")
    public BaseRespVo goodsDetail(@RequestParam("id") int id){
     Goods goods=goodsService.queryGood(id);

       // System.out.println(goods.getGallery().replace("\\",""));
        System.out.println(goods.getGallery());
List<Specification> specification=goodsService.querySpecification(id);
        List<Product> product=goodsService.queryProduct(id);
        List<Attribute> attribute=goodsService.queryAttribute(id);
        baseRespVo.setErrno(0);
        baseRespVo.setErrmsg("成功");
        List list=new ArrayList();
        list.add(goods.getCategoryId());
        Map map=new HashMap();
        map.put("categoryIds",list);
        map.put("attributes",attribute);
        map.put("specifications",specification);
        map.put("goods",goods);
        map.put("products",product);
baseRespVo.setData(map);
        return baseRespVo;
    }
    @RequestMapping("admin/goods/catAndBrand")
    public BaseRespVo catAndBrand(){
        List<Category> categories=goodsService.queryCategory();
        List<Brand> brands=goodsService.queryBrand();
        baseRespVo.setErrno(0);
        baseRespVo.setErrmsg("成功");
        Map map=new HashMap();
        map.put("categoryList",categories);
        map.put("brandList",brands);
        baseRespVo.setData(map);
        return baseRespVo;
    }

}
