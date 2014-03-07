package org.musiclibfixer.web.controller;

import org.mongodb.morphia.query.QueryResults;
import org.musiclibfixer.dao.MongoDBMusicFileDao;
import org.musiclibfixer.model.MusicFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    private MongoDBMusicFileDao mongoDBMusicFileDao;

    @Autowired
    public IndexController(MongoDBMusicFileDao mongoDBMusicFileDao) {
        this.mongoDBMusicFileDao = mongoDBMusicFileDao;
    }

    @RequestMapping(value="/")
    public String index() {

        QueryResults<MusicFile> musicFiles = this.mongoDBMusicFileDao.find();

        System.out.println(musicFiles.countAll());

        return "index";
    }

}
