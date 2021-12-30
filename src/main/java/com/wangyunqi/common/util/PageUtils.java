package com.wangyunqi.common.util;

import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.Data;

import java.util.Collections;
import java.util.List;

/**
 * @author nolimits
 * @since 2019-08-01
 */
@Data
public class PageUtils<T> {

    private List<T> datas = Collections.emptyList();
    /**
     * 总数
     */
    private long total = 0;
    /**
     * 每页显示条数，默认 10
     */
    private long size = 10;
    /**
     * 当前页
     */
    private long current = 1;

    /**
     * 总页数
     */
    private long pages;

    /**
     * 合计行
     */
    private T summary;

    public PageUtils() {
    }

    public PageUtils(List<T> list, long totalCount, long pageSize, long currPage) {
        this.datas = list;
        this.total = totalCount;
        this.size = pageSize;
        this.current = currPage;
        this.pages = (int) Math.ceil((double) totalCount / pageSize);
    }


    public PageUtils(List<T> list, int totalCount, int pageSize, int currPage) {
        this.datas = list;
        this.total = totalCount;
        this.size = pageSize;
        this.current = currPage;
        this.pages = (int) Math.ceil((double) totalCount / pageSize);
    }

    public PageUtils(List<T> list, long totalCount, long pageSize, long currPage, T summary) {
        this.datas = list;
        this.total = totalCount;
        this.size = pageSize;
        this.current = currPage;
        this.pages = (int) Math.ceil((double) totalCount / pageSize);
        this.summary = summary;
    }

    public PageUtils(IPage<T> page) {
        this.datas = page.getRecords();
        this.total = page.getTotal();
        this.size = page.getSize();
        this.current = page.getCurrent();
        this.pages = (int) Math.ceil((double) this.total / this.size);
    }
}
