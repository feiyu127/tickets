package com.tickets.common.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import com.github.pagehelper.Page;

public class PageEasyui<T> implements Iterable<T>, Serializable
{
    
    private static final long serialVersionUID = -7935463601423327106L;
    
    protected List<T> rows = null;
    
    /**
     * 总数
     */
    protected long total = -1;
    
    /**
     * 总页数
     */
    protected int pages = 1;
    
    /**
     * 当前页数
     */
    protected int pageNo = 1;
    
    /**
     * 每页行数
     */
    protected int pageSize = 10;
    
    protected boolean countTotal = true;
    
    public PageEasyui()
    {
    }
    
    // Page{count=true, pageNum=2, pageSize=12, startRow=12, endRow=24, total=83, pages=7, reasonable=true,
    // pageSizeZero=false}
    // Page{count=true, pageNum=1, pageSize=2147483647, startRow=0, endRow=2147483647, total=83, pages=1,
    // reasonable=true, pageSizeZero=false}
    
    public PageEasyui(List<T> list)
    {
        if (list instanceof Page)
        {
            Page<T> page = (Page<T>)list;
            
            this.rows = list;
            this.total = page.getTotal();
            this.pageNo = page.getPageNum();
            this.pageSize = page.getPageSize();
            this.pages = page.getPages();
            this.countTotal = this.pages == 1;
        }
        else if (list instanceof Collection)
        {
            this.rows = list;
            this.total = list.size();
            this.pageSize = list.size();
            this.countTotal = true;
        }
    }
    
    /**
     * 获得页内的记录列表.
     */
    public List<T> getRows()
    {
        return rows;
    }
    
    /**
     * 设置页内的记录列表.
     */
    public void setRows(final List<T> rows)
    {
        this.rows = rows;
    }
    
    /**
     * 获得总记录数, 默认值为-1.
     */
    public long getTotal()
    {
        return total;
    }
    
    /**
     * 设置总记录数.
     */
    public void setTotal(final long total)
    {
        this.total = total;
    }
    
    /**
     * 实现Iterable接口, 可以for(Object item : page)遍历使用
     */
    @Override
    public Iterator<T> iterator()
    {
        return rows.iterator();
    }
    
    /**
     * 重写setPageSize()方法，防止临界删除
     * */
    public void setPageNo(final int pageNo)
    {
        this.pageNo = pageNo;
        
        if (pageNo < 1)
        {
            this.pageNo = 1;
        }
    }
    
    /**
     * 根据pageSize与totalItems计算总页数.
     */
    public int getTotalPages()
    {
        return (int)Math.ceil((double)total / (double)getPageSize());
    }
    
    /**
     * 是否还有下一页.
     */
    public boolean hasNextPage()
    {
        return (getPageNo() + 1 <= getTotalPages());
    }
    
    /**
     * 是否最后一页.
     */
    public boolean isLastPage()
    {
        return !hasNextPage();
    }
    
    /**
     * 取得下页的页号, 序号从1开始. 当前页为尾页时仍返回尾页序号.
     */
    public int getNextPage()
    {
        if (hasNextPage())
        {
            return getPageNo() + 1;
        }
        else
        {
            return getPageNo();
        }
    }
    
    /**
     * 是否还有上一页.
     */
    public boolean hasPrePage()
    {
        return (getPageNo() > 1);
    }
    
    /**
     * 是否第一页.
     */
    public boolean isFirstPage()
    {
        return !hasPrePage();
    }
    
    /**
     * 取得上页的页号, 序号从1开始. 当前页为首页时返回首页序号.
     */
    public int getPrePage()
    {
        if (hasPrePage())
        {
            return getPageNo() - 1;
        }
        else
        {
            return getPageNo();
        }
    }
    
    /**
     * 计算以当前页为中心的页面列表,如"首页,23,24,25,26,27,末页"
     * 
     * @param count 需要计算的列表大小
     * @return pageNo列表
     */
    public List<Integer> getSlider(int count)
    {
        int halfSize = count / 2;
        int totalPage = getTotalPages();
        
        int startPageNo = Math.max(getPageNo() - halfSize, 1);
        int endPageNo = Math.min(startPageNo + count - 1, totalPage);
        
        if (endPageNo - startPageNo < count)
        {
            startPageNo = Math.max(endPageNo - count, 1);
        }
        
        List<Integer> result = new ArrayList<>();
        for (int i = startPageNo; i <= endPageNo; i++)
        {
            result.add(i);
        }
        return result;
    }
    
    public int getPages()
    {
        return pages;
    }
    
    public void setPages(int pages)
    {
        this.pages = pages;
    }
    
    public int getPageSize()
    {
        return pageSize;
    }
    
    public void setPageSize(int pageSize)
    {
        this.pageSize = pageSize;
    }
    
    public int getPageNo()
    {
        return pageNo;
    }
    
    @Override
    public String toString()
    {
        List<T> result = this.rows.stream().collect(Collectors.toList());
        return new StringBuilder("{total:").append(this.total).append(", rows:").append(result).append("}").toString();
    }
    
}
