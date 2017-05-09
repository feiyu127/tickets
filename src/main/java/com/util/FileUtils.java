package com.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class FileUtils
{
    public static final String APPEND = "append";
    public static File createFile(String filePath){
        File file = new File(filePath);
        if(!file.exists()){
            File fileDir = file.getParentFile();
            if (!fileDir.exists())
            {
                fileDir.mkdirs();
            }
            file = new File(filePath);
        }
        return file;
    }
    
    public static void WriteContentToFile(String filePath, Object content){
        WriteContentToFile(filePath, content, false);
    }
    
    public static void WriteContentToFile(String filePath, Object content, boolean append){
        File file = createFile(filePath);
        try
        {
            BufferedWriter fw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, append), "GBK"));
            fw.write(String.valueOf(content));
            fw.flush();
            fw.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
