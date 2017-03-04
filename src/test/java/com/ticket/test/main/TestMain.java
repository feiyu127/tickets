package com.ticket.test.main;

import com.tickets.util.HttpUtils;


public class TestMain
{
    public static void main(String[] args)
    {
        test1();
    }
    
    public static void test1(){
        String nuomiCityListUrl = "http://dianying.nuomi.com/common/city/citylist?hasLetter=false&isjson=true";
        String result = HttpUtils.doGet(nuomiCityListUrl);
        System.out.println(result);
    }
}
