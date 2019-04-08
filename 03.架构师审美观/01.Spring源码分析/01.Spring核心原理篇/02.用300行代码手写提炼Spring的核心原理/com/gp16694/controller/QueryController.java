package com.gp16694.controller;

import com.gp16694.Service.QueryService;
import com.gp16694.annotation.GP16694AutoWired;
import com.gp16694.annotation.GP16694Controller;
import com.gp16694.annotation.GP16694RequestMapping;
import com.gp16694.annotation.GP16694RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@GP16694Controller
@GP16694RequestMapping("/search")
public class QueryController {

    @GP16694AutoWired
    QueryService queryService;

    @GP16694RequestMapping("/query")
    public String query(@GP16694RequestParam("conditon") String conditong){

        return queryService.query() + " 查询条件为：" + conditong;
    }
}
