package com.jandan;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class JanDanMain
{
    private static final String JAN_DAN_URL = "http://jandan.net";
    private static final String JAN_DAN_SAVE_PATH = "E:/jandan/";
    private static final String SPIT = ",";
    
    private static List<String> getList(String url){
        List<String> list = null;
        Document doc;
        try
        {
            doc = Jsoup.parse(new URL("http://jandan.net/page/100"), 5000);
            doc.setBaseUri(JAN_DAN_URL);
            
            Elements typeElements = doc.select(".column .time_s a");
            Elements titleElements = doc.select(".column .title2 a");
            int length = typeElements.size();
            list = new ArrayList<>();
            for(int i = 0; i < length; i++){
                String type = typeElements.get(i).text();
                String title = titleElements.get(i).text();
                String href = titleElements.get(i).attr("href");
                list.add(type + SPIT + title + SPIT + href);
            }
            return list;
        }
        catch (IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list;
    }
    
    public static void writeListToFile(String filePath, List<String> list){
        try
        {
            FileUtils.write(new File(filePath), String.join("\n", list), "GBK");
        }
        catch (IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public static void downloadJanDan(String url, int pageId){
        List<String> list = getList(JAN_DAN_URL);
        String filePath = JAN_DAN_SAVE_PATH + "jandan_" + pageId + ".csv";
        writeListToFile(filePath, list);
    }
}
