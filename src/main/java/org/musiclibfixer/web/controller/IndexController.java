package org.musiclibfixer.web.controller;

import org.musiclibfixer.dao.MongoDBMusicFileDao;
import org.musiclibfixer.dao.QueryPager;
import org.musiclibfixer.model.MusicFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class IndexController {

    private MongoDBMusicFileDao mongoDBMusicFileDao;

    @Autowired
    public IndexController(MongoDBMusicFileDao mongoDBMusicFileDao) {
        this.mongoDBMusicFileDao = mongoDBMusicFileDao;
    }

    @RequestMapping(value="/", produces="application/json")
    public @ResponseBody List<MusicFile> index(@RequestParam(value = "page", defaultValue = "1") int page) {
        QueryPager<MusicFile> queryPager = mongoDBMusicFileDao.getAll();

        return queryPager.getPage(page);
    }

}
