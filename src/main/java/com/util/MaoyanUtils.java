package com.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;


public class MaoyanUtils
{
    public static final Map<String, String> JavaTypeToJdbcTypeMap = new HashMap<>();
    static{
        JavaTypeToJdbcTypeMap.put("String", "varchar(32)");
        JavaTypeToJdbcTypeMap.put("Boolean", "int(11)");
        JavaTypeToJdbcTypeMap.put("Integer", "int(11)");
        JavaTypeToJdbcTypeMap.put("BigDecimal", "decimal");
        JavaTypeToJdbcTypeMap.put("Double", "double");
    }
    public static void initCreateTableInfo(Map<String, Object> map){
        StringBuilder sbr = new StringBuilder();
        
        for(Entry<String, Object> entry : map.entrySet()){
            String type = JavaTypeToJdbcTypeMap.get(entry.getValue().getClass().getSimpleName());
            sbr.append("`").append(entry.getKey()).append("` ").append(type).append(" DEFAULT NULL COMMENT ''").append(";\n");
//            sbr.append(entry.getKey()).append("--").append(entry.getValue()).append("--").append(entry.getValue().getClass().getSimpleName()).append("\n");
        }
        System.out.println(sbr);
//        `dis` varchar(64) DEFAULT NULL,

    }
}
