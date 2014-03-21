package org.musiclibfixer.web.controller;

import org.junit.Before;
import org.junit.Test;
import org.musiclibfixer.dao.MongoDBMusicFileDao;
import org.musiclibfixer.dao.QueryPager;
import org.musiclibfixer.model.MusicFile;

import java.util.ArrayList;
import java.util.List;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IndexControllerTest {

    private MongoDBMusicFileDao dao;
    private QueryPager<MusicFile> queryPager;
    private IndexController indexController;

    @Before
    public void setUp() {
        dao = mock(MongoDBMusicFileDao.class);
        queryPager = mock(QueryPager.class);

        indexController = new IndexController(dao);
    }

    @Test
    public void indexShouldReturnFirstPageWhenGivenPageOne() {
        int requestedPage = 1;
        ArrayList<MusicFile> list = new ArrayList<>();

        when(dao.getAll()).thenReturn(queryPager);
        when(queryPager.getPageCount()).thenReturn(5);
        when(queryPager.getPage(requestedPage)).thenReturn(list);

        List<MusicFile> result = indexController.index(requestedPage);

        assertThat(result).isEqualTo(list);
    }

    @Test(expected = IllegalArgumentException.class)
    public void indexShouldThrowIllegalArgumentExceptionWhenPageIsLowerThenOne() {
        indexController.index(0);
    }

}
