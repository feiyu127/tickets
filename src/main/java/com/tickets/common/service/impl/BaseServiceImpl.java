/**
 * @单位名称：科大国创—电信资源事业部
 *            USTC Sinovate Software Co.,Ltd.
 * 		      Copyright (c) 2013 All Rights Reserved.
 * @系统名称：NGRMS—下一代网络资源管理系统
 * @工程名称：cptlifts.platformcore
 * @文件名称: PSBaseServiceImpl.java
 * @类路径: com.sinovate.ngrms.cptlifts.platformcore.bsbusvc.impl
 */

package com.tickets.common.service.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.tickets.common.dao.BaseMapper;
import com.tickets.common.service.BaseService;

/**
 * 
 * @see
 * @author sun.peiwen@ustcinfo.com
 * @date 2013-2-4 下午9:38:53
 * @version
 * @desc
 */
public abstract class BaseServiceImpl<T, ID extends Serializable> implements BaseService<T, ID>
{
    
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    protected BaseMapper<T, ID> baseMapper;
    
    @Override
    public Integer saveEntity(T entity)
    {
            return (Integer)baseMapper.saveEntity(entity);
    }
    
    @Override
    public void updateEntity(T entity)
    {
        try
        {
            baseMapper.updateEntity(entity);
        }
        catch (Exception e)
        {
            logger.error("", e);
            throw new RuntimeException();
        }
    }
    
    @Override
    public void deleteEntity(T entity)
    {
        try
        {
            baseMapper.deleteEntity(entity);
        }
        catch (Exception e)
        {
            logger.error("", e);
            throw new RuntimeException();
        }
    }
    
    @Override
    public void deleteByKey(ID id)
    {
        try
        {
            baseMapper.deleteByKey(id);
        }
        catch (Exception e)
        {
            logger.error("", e);
            throw new RuntimeException();
        }
    }
    
    @Override
    public void batchDelete(Collection<ID> ids)
    {
        try
        {
            baseMapper.batchDelete(ids);
        }
        catch (Exception e)
        {
            logger.error("", e);
            throw new RuntimeException();
        }
    }
    
    @Override
    public T getEntityByKey(ID id)
    {
        try
        {
            return baseMapper.getEntityByKey(id);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
    
    @Override
    public List<T> getAll()
    {
        try
        {
            return baseMapper.getAll();
        }
        catch (Exception e)
        {
            logger.error("", e);
            throw new RuntimeException();
        }
    }
    
    @Override
    public int getCount()
    {
        try
        {
            return baseMapper.getCount();
        }
        catch (Exception e)
        {
            logger.error("", e);
            throw new RuntimeException();
        }
    }
    
    @Override
    public int getCount(T entity)
    {
        try
        {
            return baseMapper.getCount(entity);
        }
        catch (Exception e)
        {
            logger.error("", e);
            throw new RuntimeException();
        }
    }
    
}
