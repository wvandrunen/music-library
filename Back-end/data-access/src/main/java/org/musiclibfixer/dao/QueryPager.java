package org.musiclibfixer.dao;

import org.mongodb.morphia.query.Query;

import java.util.List;

public class QueryPager<T> {

    private final Query<T> query;
    private final int pageSize;
    private final int pageCount;

    public QueryPager(Query<T> query, int pageSize) {
        this.query = query;
        this.pageSize = pageSize;
        this.pageCount = calculatePageCount();
    }

    public List<T> getPage(int page) {
        int currentRecord = page * pageSize;

        return query.offset(currentRecord).limit(pageSize).asList();
    }

    public int getPageCount() {
        return pageCount;
    }

    private int calculatePageCount() {
        long totalSize = query.countAll();
        return (int) Math.ceil((double) totalSize / pageSize);
    }
}
