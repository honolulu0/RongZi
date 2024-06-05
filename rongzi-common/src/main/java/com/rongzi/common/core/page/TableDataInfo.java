package com.rongzi.common.core.page;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 表格分页数据对象
 *
 * @autho rongzi
 */
public class TableDataInfo implements Serializable
{
    private static final long serialVersionUID = 1L;

    /** 总记录数 */
    private long total;

    /** 列表数据 */
    private List<?> rows;

    /** 消息状态码 */
    private int code;

    /** 消息内容 */
    private String msg;

    /** 合计数据 */
    private Map<String, Long> totals;

    /**
     * 表格数据对象
     */
    public TableDataInfo()
    {
        this.totals = new HashMap<>();
    }

    /**
     * 分页
     *
     * @param list 列表数据
     * @param total 总记录数
     */
    public TableDataInfo(List<?> list, long total)
    {
        this.rows = list;
        this.total = total;
        this.totals = new HashMap<>();
    }

    public long getTotal()
    {
        return total;
    }

    public void setTotal(long total)
    {
        this.total = total;
    }

    public List<?> getRows()
    {
        return rows;
    }

    public void setRows(List<?> rows)
    {
        this.rows = rows;
    }

    public int getCode()
    {
        return code;
    }

    public void setCode(int code)
    {
        this.code = code;
    }

    public String getMsg()
    {
        return msg;
    }

    public void setMsg(String msg)
    {
        this.msg = msg;
    }

    public Map<String, Long> getTotals()
    {
        return totals;
    }

    public void setTotals(Map<String, Long> totals)
    {
        this.totals = totals;
    }

    public void addTotal(String key, Long value)
    {
        this.totals.put(key, value);
    }
}
