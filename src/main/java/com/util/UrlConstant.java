/*
 * 文 件 名:  UrlConstant.java
 * 版    权:  
 * 描    述:  <描述>
 * 修 改 人:  nanshouxiao
 * 修改时间:  2017年3月15日
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.util;

/**
 * <一句话功能简述>
 * 
 * @author nanshouxiao
 * @version [版本号, 2017年3月15日]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public interface UrlConstant
{
    /**
     * 获取猫眼城市的jsonUrl
     */
    String MAOYAN_CITY_URL = "http://m.maoyan.com/changecity.json";
    
    /**
     * 获取猫眼当前最热的电影 type=hot 类型 offset : 数据开始位置 limit ：偏移量
     */
    String MAOYAN_HOT_MOVIE = "http://m.maoyan.com/movie/list.json?type=hot&offset=0&limit=100";
    
    /**
     * 查出电影详情(包含评论)
     */
    String MAOYAN_MOVIE_COMMENT = "http://m.maoyan.com/movie/{movieId}.json";
    
    /**
     * 加载更多评论
     */
    String MAOYAN_MORE_COMMENT = "http://m.maoyan.com/comments.json?movieid={0}&limit=5&offset=5";
    
    /**
     * 根据你的ip段加载出你本地的影院
     */
    String MAOYAN_LOCAL_CINEMAS = "http://m.maoyan.com/cinemas.json";
    
    /**
     * 查询出影院详情
     */
    String MAOYAN_CINEMAL_DETAIL = "http://m.maoyan.com/showtime/wrap.json?cinemaid={0}&movieid={1}";
    
    /**
     * 座位预定信息
     */
    String MAOYAN_SEAT_INFO = "http://m.maoyan.com/show/seats?showId={0}&showDate={1}";
    
    static String getUrlByParam(String url, String... keys){
        int paramIndex = url.indexOf("?");
        if(paramIndex < 0){
            return url;
        }else{
            String mainUrl = url.substring(0, paramIndex+1);
            String queryParam = url.substring(paramIndex + 1);
            String[] queryParamArray = queryParam.split("&");
            String[] finalQueryParamArray = new String[keys.length];
            for(int i = 0; i < keys.length; i++){
                finalQueryParamArray[i] = queryParamArray[i].replace("{" + i + "}", keys[i]);
            }
            return mainUrl + String.join("&", finalQueryParamArray);
        }
    }
    
}
