package com.util;

import org.slf4j.LoggerFactory;
/**
 * @author sirius
 * @version 1.0
 * @created 2010-08-17
 */
public class Logger
{
    
   
    private org.slf4j.Logger logger;

    private Long nowTime;
    /**
     * 构造方法，初始化Log4j的日志对象
     */
    private Logger(org.slf4j.Logger slf4jLogger)
    {
        logger = slf4jLogger;
    }
    
    /**
     * 获取构造器，根据类初始化Logger对象
     * 
     * @param Class Class对象
     * @return Logger对象
     */
    public static Logger getLogger(Class<?> classObject)
    {
        return new Logger(LoggerFactory.getLogger(classObject));
    }
    
    /**
     * 
     * <打印对象的debug级别的日志>
     * 
     * @param object 任意对象
     */
    public void debug(Object object)
    {
        
        logger.debug(String.valueOf(object));
    }
    
    /**
     * 
     * <打印对象的debug级别的日志,并且打印异常>
     * 
     * @param object 对象
     * @param e 异常
     */
    public void debug(Object object, Throwable e)
    {
        logger.debug(String.valueOf(object), e);
    }
    
    /**
     * 
     * <打印对象的info级别的日志>
     * 
     * @param object 任何对象
     */
    public void info(Object object)
    {
        logger.info(String.valueOf(object));
    }
    
    /**
     * 
     * <打印对象的info级别的日志,并且打印异常>
     * 
     * @param object 任何对象
     * @param e 异常
     */
    public void info(Object object, Throwable e)
    {
        logger.info(String.valueOf(object), e);
    }
    
    /**
     * 
     * <打印对象的warn级别的日志>
     * 
     * @param object 任何对象
     */
    public void warn(Object object)
    {
        logger.warn(String.valueOf(object));
    }
    
    /**
     * 
     * <打印对象的warn级别的日志,并且打印异常>
     * 
     * @param object 任何对象
     * @param e 异常
     */
    public void warn(Object object, Throwable e)
    {
        logger.warn(String.valueOf(object), e);
    }
    
    /**
     * 
     * <打印对象的error级别的日志>
     * 
     * @param object 任何对象
     */
    public void error(Object object)
    {
        logger.error(String.valueOf(object));
    }
    
    /**
     * 
     * <打印对象的warn级别的日志,并且打印异常>
     * 
     * @param object 任何对象
     * @param e 异常
     */
    public void error(Object object, Throwable e)
    {
        logger.error(String.valueOf(object), e);
    }
    
   
    
    /**
     * 
     * <获取name>
     * 
     * @return 返回name
     */
    public String getName()
    {
        return logger.getName();
    }
    
   
    
    @Override
    public int hashCode()
    {
    	return super.hashCode();
    }
    
    /**
     * 
     * 记录时间
     *
     * @param message
     * @return
     */
    public Long recordRunTimeToError(Object message){
        return this.recordRunTimeToError(message, true);
    }
    
    public Long recordRunTimeToError(Object message, boolean isRecord){
        if(this.nowTime == null){
            this.nowTime = System.currentTimeMillis();
            this.error(message + "记录时间戳: " + this.nowTime);
        }else{
            Long currentTime = System.currentTimeMillis();
            this.error(message + "记录时间戳 : " + (isRecord ? (currentTime + ", 用时 : " + (currentTime - this.nowTime)) : ""));
            this.nowTime = currentTime;
        }
        return this.nowTime;
    }
}