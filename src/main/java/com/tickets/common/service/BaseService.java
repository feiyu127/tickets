/**
 * @单位名称：科大国创—电信资源事业部
 *            USTC Sinovate Software Co.,Ltd.
 * 		      Copyright (c) 2013 All Rights Reserved.
 * @系统名称：NGRMS—下一代网络资源管理系统
 * @工程名称：cptlifts.platformcore
 * @文件名称: PSBaseService.java
 * @类路径: com.sinovate.ngrms.cptlifts.platformcore.bsbusvc
 */

package com.tickets.common.service;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * 
 * @see		
 * @author  sun.peiwen@ustcinfo.com
 * @date	2013-2-4 下午9:17:22
 * @version	 
 * @desc    TODO
 */
public interface BaseService<T, ID extends Serializable> {
	
	/**
	 * 新增实体数据模型
	 * @param entity
	 * @throws AppBaseRuntimeException
	 */
	Integer saveEntity(final T entity);
	
	/**
	 * 更新实体数据模型
	 * @param entity
	 * @throws AppBaseRuntimeException
	 */
	void updateEntity(final T entity);
	
	/**
	 * 删除实体
	 * @param entity
	 * @throws AppBaseRuntimeException
	 */
	void deleteEntity(final T entity);
	
	/**
	 * 根据主键信息删除实体
	 * @param id
	 * @throws AppBaseRuntimeException
	 */
	void deleteByKey(final ID id);
	
	/**
	 * 根据主键实体批量删除实体
	 * @param ids
	 * @throws AppBaseRuntimeException
	 */
	void batchDelete(final Collection<ID> ids);
	
	/**
	 * 根据主键获得实体信息
	 * @param id
	 * @return
	 * @throws AppBaseRuntimeException
	 */
	T getEntityByKey(final ID id);
	
	/**
	 * 获得所有实体信息
	 * @return
	 * @throws AppBaseRuntimeException
	 */
	List<T> getAll();
	
	/**
	 * 获得实体总数
	 * @return
	 * @throws AppBaseRuntimeException
	 */
	int getCount();
	
	/**
	 * 根据条件获得实体总数
	 * @param entity
	 * @return
	 * @throws AppBaseRuntimeException
	 */
	int getCount(final T entity);
	
}

