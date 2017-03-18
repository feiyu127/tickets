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
import com.tickets.common.service.PSBaseService;

/**
 * 
 * @see
 * @author sun.peiwen@ustcinfo.com
 * @date 2013-2-4 下午9:38:53
 * @version
 * @desc
 */
public abstract class PSBaseServiceMyBatisImpl<T, ID extends Serializable> implements PSBaseService<T, ID>
{
    
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    protected BaseMapper<T, ID> baseMapper;
    
    public BaseMapper<T, ID> getBaseMapper()
    {
        return baseMapper;
    };
    
    @SuppressWarnings("unchecked")
    @Override
    public ID saveEntity(T entity)
    {
        try
        {
            
            return (ID)this.getBaseMapper().saveEntity(entity);
        }
        catch (Exception e)
        {
            logger.error("", e);
            throw new RuntimeException();
        }
    }
    
    @Override
    public void updateEntity(T entity)
    {
        try
        {
            this.getBaseMapper().updateEntity(entity);
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
            this.getBaseMapper().deleteEntity(entity);
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
            this.getBaseMapper().deleteByKey(id);
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
            this.getBaseMapper().batchDelete(ids);
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
            return this.getBaseMapper().getEntityByKey(id);
        }
        catch (Exception e)
        {
            logger.error("", e);
            throw new RuntimeException();
        }
    }
    
    @Override
    public List<T> getAll()
    {
        try
        {
            return this.getBaseMapper().getAll();
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
            return this.getBaseMapper().getCount();
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
            return this.getBaseMapper().getCount(entity);
        }
        catch (Exception e)
        {
            logger.error("", e);
            throw new RuntimeException();
        }
    }
    
}
