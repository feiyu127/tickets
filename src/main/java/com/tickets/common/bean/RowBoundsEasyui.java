package com.tickets.common.bean;

import org.apache.ibatis.session.RowBounds;

public class RowBoundsEasyui extends RowBounds
{
    private int page = 1;
    
    private int rows = Integer.MAX_VALUE;

    public int getPage()
    {
        return page;
    }

    public void setPage(int page)
    {
        this.page = page;
    }

    public int getRows()
    {
        return rows;
    }

    public void setRows(int rows)
    {
        this.rows = rows;
    }
    
    @Override
    public int getLimit()
    {
        return this.rows;
    }
    @Override
    public int getOffset()
    {
        return this.page - 1;
    }
    
}
