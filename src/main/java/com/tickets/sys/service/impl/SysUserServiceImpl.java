package com.tickets.sys.service.impl;

import org.springframework.stereotype.Service;

import com.tickets.common.service.impl.PSBaseServiceMyBatisImpl;
import com.tickets.sys.bean.SysUser;
import com.tickets.sys.service.SysUserService;

@Service
public class SysUserServiceImpl extends PSBaseServiceMyBatisImpl<SysUser, Integer> implements SysUserService
{

}
