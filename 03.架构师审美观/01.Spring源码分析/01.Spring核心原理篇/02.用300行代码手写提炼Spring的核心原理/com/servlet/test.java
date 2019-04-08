package com.servlet;

public class test {
    public static void main(String[] args) {
        String[] strs = new String[]{"123"};

        String reqvalue =  org.apache.commons.lang3.StringUtils.join(strs,",");

        System.out.println(reqvalue);
    }
}
