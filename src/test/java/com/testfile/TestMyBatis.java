package com.testfile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * 
 * 测试mybatis的mapper.xml 和 mapperDAO 是否有不匹配的地方
 * 
 * @author  nanshouxiao
 * @version  [版本号, 2017年4月25日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class TestMyBatis
{
    private static final String rootDir = "D:/workspace/pms_crm/resource/mapper";
    
    private static final Pattern NAMESPACE_PATTERN = Pattern.compile("<mapper.*?namespace.*?=\"(.*?)\">");
    
    private static final Pattern FUNCTION_ID_PATTERN = Pattern.compile("<(insert|delete|update|select).*?id.*?=\"(.*?)\".*?>");
    public static void main(String[] args) throws ClassNotFoundException
    {
        List<String> uselessMethod = getUselessMethod();
        for(String str : uselessMethod)System.out.println(str);
    }
    public static List<String> getUselessMethod(){
        List<String> useless = new ArrayList<>();
        Map<String, List<String>> list = getAllFile(null, "D:/workspace/pms_crm/resource/mapper");
        for(Entry<String, List<String>> entry : list.entrySet()){
            String key = entry.getKey();
            List<String> tempList = entry.getValue();
            Class<?> clazz;
            try
            {
                clazz = Class.forName(key.substring(key.lastIndexOf(":") + 1));
            }
            catch (ClassNotFoundException e)
            {
                System.out.println("class " + key + "not exits");
                continue;
            }
            Method[] declaredFields = clazz.getMethods();
            Set<String> javaMethod = new HashSet<>();
            for(Method field : declaredFields){
                javaMethod.add(field.getName());
            }
            tempList.removeAll(javaMethod);
            if(tempList.size() > 0){
                for(String str : tempList){
                    useless.add(key.substring(0,key.lastIndexOf(":")) + "." + str);
                }
            }
        }
        return useless;
    }
    
    public static Map<String, List<String>> getAllFile(Map<String, List<String>> list, String path)
    {
        if (list == null)
        {
            list = new HashMap<>();
        }
        File baseFile = new File(path);
        if (!baseFile.exists())
        {
            return list;
        }
        if (baseFile.isFile())
        {
            getAllFunctionFromMapper(list, baseFile);
        }
        else
        {
            File[] childFiles = baseFile.listFiles();
            for (File file : childFiles)
            {
                getAllFile(list, file.getAbsolutePath());
            }
        }
        return list;
    }
    public static Map<String, List<String>> getAllFunctionFromMapper(Map<String, List<String>> map, File file)
    {
        if (!file.exists())
        {
            return null;
        }
        if(map == null){
            map = new HashMap<>();
        }
        InputStreamReader reader = null;
        List<String> list = new ArrayList<>();
        try
        {
            reader = new InputStreamReader(new FileInputStream(file), "utf-8");
            BufferedReader bufferReader = new BufferedReader(reader);
            String lineTxt = null;
            String javaName = null;
            while ((lineTxt = bufferReader.readLine()) != null)
            {
                if (javaName == null)
                {
                    Matcher namespaceMatcher = NAMESPACE_PATTERN.matcher(lineTxt);
                    while (namespaceMatcher.find())
                    {
                        javaName = file.getAbsolutePath() + ":" + namespaceMatcher.group(1);
                    }
                }
                Matcher mat = FUNCTION_ID_PATTERN.matcher(lineTxt);
                while (mat.find())
                {
                    list.add(mat.group(2));
                }
            }
            map.put(javaName, list);
            return map;
        }
        catch (IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        finally
        {
            try
            {
                reader.close();
            }
            catch (IOException e)
            {
            }
        }
        return null;
    }
}
