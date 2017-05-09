package com.util;

import java.util.Collection;

public class ExcelUtils
{
    public static void saveAsCvs(String filePath, Iterable<? extends Iterable<?>> dataObj){
        StringBuilder sbr = new StringBuilder();
        dataObj.forEach((dataList) -> {
            dataList.forEach((data) -> {
                sbr.append("\"").append(String.valueOf(data).replace("\"", "\"\"")).append("\",");
            });
            sbr.append("\n");
        });
        FileUtils.WriteContentToFile(filePath, sbr);
    }
}
