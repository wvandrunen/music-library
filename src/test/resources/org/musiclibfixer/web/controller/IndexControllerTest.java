package org.musiclibfixer.web.controller;

import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.internal.matchers.Any;
import org.mongodb.morphia.query.Query;
import org.musiclibfixer.dao.MongoDBMusicFileDao;
import org.musiclibfixer.dao.QueryPager;
import org.musiclibfixer.model.MusicFile;

import java.util.ArrayList;
import java.util.List;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IndexControllerTest {

    @Test
    public void indexShouldReturnFirstPageWhenGivenPageOne() {
        int requestedPage = 1;
        ArrayList<MusicFile> list = new ArrayList<>();

        MongoDBMusicFileDao dao = mock(MongoDBMusicFileDao.class);
        QueryPager<MusicFile> queryPager = mock(QueryPager.class);

        when(dao.getAll()).thenReturn(queryPager);
        when(queryPager.getPageCount()).thenReturn(5);
        when(queryPager.getPage(requestedPage)).thenReturn(list);

        IndexController indexController = new IndexController(dao);
        List<MusicFile> result = indexController.index(requestedPage);

        assertThat(result).isEqualTo(list);
    }

}
