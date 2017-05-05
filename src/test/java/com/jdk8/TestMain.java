package com.jdk8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class TestMain
{
    public static void main(String[] args) {
        final String text = "Hallo world!";
        Optional.ofNullable(text)//显示创建一个Optional壳
            .map(TestMain::print)
            .map(TestMain::print)
            .ifPresent(System.out::println);

        Optional.ofNullable(text)
            .map(s ->{ 
                System.out.println(s);
                return s.substring(6);
            })
            .map(s -> null)//返回 null
            .ifPresent(System.out::println);
    }
    // 打印并截取str[5]之后的字符串
    private static String print(String str) {
        System.out.println(str);
        return str.substring(6);
    }
    public TestMain(Map<String, Object> m)
    {
        System.out.println("aaaaaaaaa");
    }
    
    @SuppressWarnings("serial")
    public static void TestListGroupBy(){
        List<Map<String, String>> ls = new ArrayList<>();
        ls.add(new HashMap<String, String>(){{
            put("name","nan");
            put("age","19");
        }});
        ls.add(new HashMap<String, String>(){{
            put("name","nan1");
            put("age","19");
        }});
        ls.add(new HashMap<String, String>(){{
            put("name","nan2");
            put("age","192");
        }});
        Map<String, List<Map<String, String>>> collect = ls.stream().collect(Collectors.groupingBy(map -> map.get("age")));
        System.out.println(collect);
    }
}
