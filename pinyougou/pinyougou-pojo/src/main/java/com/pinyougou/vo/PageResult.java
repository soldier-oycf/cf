package com.pinyougou.vo;

/**
 * Date:2018/9/7
 */

import java.io.Serializable;
import java.util.List;

/**
 * 查询分页封装返回数据
 */
public class PageResult implements Serializable {

    private List<?> rows;//当前页数据
    private long total;//总记录数


    public PageResult(List<?> rows, long total) {
        this.rows = rows;
        this.total = total;
    }

    public List<?> getRows() {
        return rows;
    }

    public void setRows(List<?> rows) {
        this.rows = rows;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }
}
