package com.jandan;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.commons.io.FileUtils;

public class MainTest
{
    private static final String JAN_DAN_SAVE_PATH = "E:/jandan/";

    
    public static void main(String[] args)
    {
        combi();
    }
    public static void download(){
        ExecutorService pool = Executors.newFixedThreadPool(10);
        long startTime = System.currentTimeMillis();
        String baseUrl = "http://jandan.net/page/";
        for(int i = 2; i < 100; i++){
            String url = baseUrl + i;
            int pageId = i;
            pool.execute(()->JanDanMain.downloadJanDan(url, pageId));
        }
        System.out.println("user time " + (System.currentTimeMillis() - startTime));
    }
    
    public static void combi(){
        File fileDest = new File(JAN_DAN_SAVE_PATH + "jandan" + ".csv");
        for(int i = 2; i < 100; i++){
            String filePath = JAN_DAN_SAVE_PATH + "jandan_" + i + ".csv";
            try
            {
                FileUtils.copyFile(new File(filePath), fileDest);
            }
            catch (IOException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
    
}
