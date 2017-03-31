package com.util;

public class StringUtils
{
    
    public static Integer subStringToInteger(String src, String start, String to)
    {
        return stringToInteger(subString(src, start, to));
    }
    
    public static String subString(String src, String start, String to)
    {
        int indexFrom = start == null ? 0 : src.indexOf(start);
        int indexTo = to == null ? src.length() : src.indexOf(to);
        if ((indexFrom < 0) || (indexTo < 0) || (indexFrom > indexTo))
        {
            return null;
        }
        if (null != start)
        {
            indexFrom += start.length();
        }
        return src.substring(indexFrom, indexTo);
    }
    
    public static Integer stringToInteger(String in)
    {
        if (in == null)
        {
            return null;
        }
        in = in.trim();
        if (in.length() == 0)
        {
            return null;
        }
        try
        {
            return Integer.valueOf(Integer.parseInt(in));
        }
        catch (NumberFormatException e)
        {
            e.printStackTrace();
        }
        return null;
    }
    
    public static boolean equals(String a, String b)
    {
        if (a == null)
        {
            return b == null;
        }
        return a.equals(b);
    }
    
    public static boolean equalsIgnoreCase(String a, String b)
    {
        if (a == null)
        {
            return b == null;
        }
        return a.equalsIgnoreCase(b);
    }
    
    public static boolean isEmpty(String value)
    {
        if ((value == null) || (value.length() == 0))
        {
            return true;
        }
        return false;
    }
    
    public static int lowerHashCode(String text)
    {
        if (text == null)
        {
            return 0;
        }
        int h = 0;
        for (int i = 0; i < text.length(); i++)
        {
            char ch = text.charAt(i);
            if ((ch >= 'A') && (ch <= 'Z'))
            {
                ch = (char)(ch + ' ');
            }
            h = 31 * h + ch;
        }
        return h;
    }
    
    public static String join(String[] strings, String spilt)
    {
        if (strings == null || spilt == null)
        {
            return null;
        }
        StringBuffer sbr = new StringBuffer();
        
        for (int i = 0, length = strings.length; i < length; i++)
        {
            sbr.append(spilt).append(strings[i]);
        }
        int spiltLength = spilt.length();
        return sbr.length() > spiltLength ? sbr.substring(spiltLength) : sbr.toString();
    }
}
