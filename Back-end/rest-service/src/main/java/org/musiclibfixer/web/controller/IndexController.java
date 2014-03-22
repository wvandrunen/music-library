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

    private final MongoDBMusicFileDao mongoDBMusicFileDao;

    @Autowired
    public IndexController(MongoDBMusicFileDao mongoDBMusicFileDao) {
        this.mongoDBMusicFileDao = mongoDBMusicFileDao;
    }

    @RequestMapping(value = "/", produces = "application/json")
    @ResponseBody
    public List<MusicFile> index(@RequestParam(value = "page", defaultValue = "1") int page) {
        if (page < 1) {
            throw new IllegalArgumentException();
        }

        QueryPager<MusicFile> queryPager = mongoDBMusicFileDao.getAll();
        
        return queryPager.getPage(page);
    }

}
