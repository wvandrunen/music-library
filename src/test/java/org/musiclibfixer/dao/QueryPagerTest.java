package org.musiclibfixer.dao;

import org.junit.Test;
import org.mockito.Mockito;
import org.mongodb.morphia.query.Query;
import org.musiclibfixer.model.MusicFile;

import java.util.ArrayList;
import java.util.List;

import static org.fest.assertions.Assertions.assertThat;

public class QueryPagerTest {

    @Test
    public void getPageWhenGivenPageSizeAndPageThenReturnList() {
        int pageSize = 25;
        int page = 10;
        ArrayList<MusicFile> mockedList = new ArrayList<>();

        Query<MusicFile> query = Mockito.mock(Query.class);

        Mockito.when(query.offset(page*pageSize)).thenReturn(query);
        Mockito.when(query.limit(pageSize)).thenReturn(query);
        Mockito.when(query.asList()).thenReturn(mockedList);

        QueryPager<MusicFile> queryBuilder = new QueryPager<>(query, pageSize);

        List<MusicFile> list = queryBuilder.getPage(page);

        assertThat(list).isEqualTo(mockedList);
    }

    @Test
    public void GetPageCountShouldReturn5WhenCountIs99AndPageSizeIs20() {

        Query<MusicFile> query = Mockito.mock(Query.class);
        long totalCount = 99;
        Mockito.when(query.countAll()).thenReturn(totalCount);

        int pageSize = 20;

        QueryPager<MusicFile> queryPager = new QueryPager<>(query, pageSize);

        int count = queryPager.getPageCount();

        assertThat(count).isEqualTo(5);
    }

}
