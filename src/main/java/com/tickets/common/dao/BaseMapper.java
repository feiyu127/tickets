/*
 * 文 件 名:  BaseMapper.java
 * 版    权:  
 * 描    述:  <描述>
 * 修 改 人:  nanshouxiao
 * 修改时间:  2017年3月18日
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.tickets.common.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * <一句话功能简述>
 * 
 * @author nanshouxiao
 * @version [版本号, 2017年3月18日]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public interface BaseMapper<T, ID extends Serializable>
{
    /**
     * 保存数据实体信息
     * 
     * @param entity
     * @return
     */
    Integer saveEntity(final T entity);
    
    /**
     * 批量添加实体数据
     * 
     * @param entityList
     * @return
     */
    Integer batchSaveEntity(final List<?> entityList);
    
    /**
     * 保存新增或修改的对象.
     * 
     * @param entity
     */
    void updateEntity(final T entity);
    
    /**
     * 删除对象.
     * 
     * @param entity 对象必须是session中的对象或含id属性的transient对象.
     */
    void deleteEntity(final T entity);
    
    /**
     * 按id删除对象.
     * 
     * @param id
     */
    void deleteByKey(final ID id);
    
    /**
     * 根据主键信息，批量删除信息
     * 
     * @param ids
     */
    void batchDelete(final Collection<ID> ids);
    
    /**
     * 按id获取对象.
     * 
     * @param id
     * @return
     */
    T getEntityByKey(final ID id);
    
    /**
     * 获取全部对象.
     * 
     * @return
     */
    List<T> getAll();
    
    /**
     * 获得某个数据表中的数据总数
     * 
     * @return
     */
    int getCount();
    
    /**
     * 根据实体属性查询总数
     * 
     * @param entity
     * @return
     */
    int getCount(final T entity);
    
}
