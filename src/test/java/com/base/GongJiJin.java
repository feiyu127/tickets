package com.base;

import java.io.FileWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.util.ExcelUtils;
import com.util.HttpUtils;

public class GongJiJin
{
    private static final double FINAL_ROWS = 1724;
    
    private static ExecutorService executorService = Executors.newCachedThreadPool();
    
    private static CountDownLatch cdl;
    
    private static Map<Integer, List<Map<String, String>>> pageContent = new HashMap<>();
    
    public static void main(String[] args)
    {
        GongJiJin c = new GongJiJin();
        int i = 140;
        // 分别传递int类型和Integer类型
        c.testMethod(i);
        c.testMethod(new Integer(i));
    }
    
    public void testMethod(long a)
    {
        System.out.println(" 基本类型的方法被调用");
    }
    
    public void testMethod(Long a)
    {
        System.out.println(" 包装类型的方法被调用");
    }
    
    private static void writeGongjijin()
    {
        long startTime = System.currentTimeMillis();
        int numPerPage = 50;
        int pageNum = (int)Math.ceil(FINAL_ROWS / numPerPage);
        cdl = new CountDownLatch(pageNum);
        
        for (int i = 0; i < pageNum; i++)
        {
            final int page = i + 1;
            executorService.execute(() -> {
                List<Map<String, String>> list = initGongjijinData(numPerPage, page);
                pageContent.put(page, list);
                cdl.countDown();
            });
        }
        try
        {
            cdl.await();
        }
        catch (InterruptedException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        executorService.shutdown();
        System.out.println(pageContent);
        List<Map<String, String>> finalContentList = new ArrayList<>();
        for (int i = 0; i < pageNum; i++)
        {
            int page = i + 1;
            finalContentList.addAll(pageContent.get(page));
        }
        
        List<List<String>> data = finalContentList.stream().map(map -> {
            List<String> list = new ArrayList<>();
            list.add(map.get("projectName"));
            list.add(map.get("detail"));
            list.add(map.get("buildingType"));
            list.add(map.get("company"));
            return list;
        }).collect(Collectors.toList());
        String file = "d:\\公积金.csv";
        ExcelUtils.saveAsCvs(file, data);
        System.out.println("use time :" + (System.currentTimeMillis() - startTime));
        // List<Map<String, String>> initGongjijinData = initGongjijinData(99, 1);
        // System.out.println(initGongjijinData);
    }
    
    /**
     * 
     * 获取第几页的数据
     *
     * @param numPerPage 每页行数
     * @param pageIndex 页数
     * @return
     */
    private static List<Map<String, String>> initGongjijinData(int numPerPage, int pageIndex)
    {
        String url = "http://www.xazfgjj.gov.cn/xazxkdkxm.jsp?urltype=tree.TreeTempUrl&wbtreeid=1068";
        String param =
            "videoattformCURURI=2FE6F58EC2BC22E9B44BFF116B182B8C&videoattformKEYTYPES=12,12,12,12&videoattformCountNo={0}&videoattformNOWPAGE={1}&videoattformPAGE={0}";
        String finalParam = java.text.MessageFormat.format(param, numPerPage, pageIndex);
        String str = HttpUtils.post(url, finalParam);
        Document parse = Jsoup.parse(str);
        Element body = parse.select("form[name=\"videoattform\"] table table tbody").get(0);
        Elements trHtml = body.select("tr");
        List<Map<String, String>> list = new ArrayList<>();
        for (Element e : trHtml)
        {
            Map<String, String> map = new HashMap<>();
            map.put("projectName", e.select("td:eq(0)").get(0).text());
            map.put("detail", e.select("td:eq(1)").get(0).text());
            map.put("buildingType", e.select("td:eq(2)").get(0).text());
            map.put("company", e.select("td:eq(3)").get(0).text());
            list.add(map);
        }
        return list.subList(1, list.size());
    }
}
