package com.tickets.base;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.spring.conf.AppConfig;
import com.tickets.task.TestTask;

public class MainTest
{
    public static void main(String[] args)
    {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/spring_bean.xml");
        testConfigBean();
    }
    
    private static void testConfigBean()
    {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        TestTask mySomeBean = ctx.getBean(TestTask.class);
        System.out.println(mySomeBean);
    }
    private static void testRegisterConfigBean()
    {
        AnnotationConfigApplicationContext  ctx = new AnnotationConfigApplicationContext();
        ctx.register(AppConfig.class);
        ctx.refresh();
//        SomeBean mySomeBean = ctx.getBean(SomeBean.class);
//        System.out.println(mySomeBean);
    }
}
