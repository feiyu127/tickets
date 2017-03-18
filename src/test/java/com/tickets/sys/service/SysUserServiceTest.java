/*
 * 文 件 名:  SysUserServiceTest.java
 * 版    权:  
 * 描    述:  <描述>
 * 修 改 人:  nanshouxiao
 * 修改时间:  2017年3月18日
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.tickets.sys.service;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tickets.sys.bean.SysUser;
import com.tickets.sys.service.impl.SysUserServiceImpl;

/**
 * <一句话功能简述>
 * 
 * @author nanshouxiao
 * @version [版本号, 2017年3月18日]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring-bean.xml"})
public class SysUserServiceTest
{
    @Resource(name = "sysUserServiceImpl")
    private SysUserServiceImpl sysUserServiceImpl;
    
    private SysUser user;
    
    @Before
    public void initSysUser()
    {
        user = new SysUser();
        user.setUserName("南守孝");
        user.setLoginName("feiyu127");
        user.setNickName("飞羽");
        user.setPhoneNum("13934377673");
        user.setQq("1119290647");
    }
    
    @Test
    public void testAdd()
    {
        sysUserServiceImpl.saveEntity(user);
    }
}
