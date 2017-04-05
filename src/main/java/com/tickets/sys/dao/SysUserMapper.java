/*
 * 文 件 名:  SysUserMapper.java
 * 版    权:  
 * 描    述:  <描述>
 * 修 改 人:  nanshouxiao
 * 修改时间:  2017年3月18日
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.tickets.sys.dao;

import com.tickets.common.dao.BaseMapper;
import com.tickets.sys.bean.SysUser;

/**
 * <一句话功能简述>
 * 
 * @author nanshouxiao
 * @version [版本号, 2017年3月18日]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public interface SysUserMapper extends BaseMapper<SysUser> {
	/**
	 * 根据用户名查询用户
	 * 
	 * @param user
	 * @return
	 */
	SysUser getUserByLoginName(SysUser user);
}
