package com.tickets.sys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tickets.common.service.impl.BaseServiceImpl;
import com.tickets.sys.bean.SysUser;
import com.tickets.sys.dao.SysUserMapper;
import com.tickets.sys.service.SysUserService;

@Service
public class SysUserServiceImpl extends BaseServiceImpl<SysUser, Integer> implements SysUserService
{
	
	@Autowired
	private SysUserMapper sysUserMapper;

	@Override
	public SysUser getUserByLoginName(SysUser user) {
		return sysUserMapper.getUserByLoginName(user);
	}

}
