package com.gp16694.controller;

import com.gp16694.Service.TransactionService;
import com.gp16694.annotation.GP16694AutoWired;
import com.gp16694.annotation.GP16694Controller;
import com.gp16694.annotation.GP16694RequestMapping;
import com.gp16694.annotation.GP16694RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@GP16694Controller
@RequestMapping("/transanction")
public class TransactionController {

    @GP16694AutoWired
    TransactionService transactionService;

    @GP16694RequestMapping("/insert")
    public String insert(HttpServletRequest request, HttpServletResponse response
                        , @GP16694RequestParam("id") Integer id){

        return transactionService.process() + "  插入的事务id为" + id;

    }

    @GP16694RequestMapping("/process")
    public String process(HttpServletRequest request,HttpServletResponse response
                          ,@GP16694RequestParam("a") Integer a
                            ,@GP16694RequestParam("b") Integer b){

        return "a + b = " + (a+b);

    }
}
