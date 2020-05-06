package com.wwx.mall.bean;

import lombok.Data;

import java.util.List;

@Data
public class Cate {
    private List children;
    private int value;
    private String label;

}
