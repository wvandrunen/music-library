package org.musiclibfixer.dao;

import org.musiclibfixer.config.MongoCollectionNames;
import org.musiclibfixer.model.MusicFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Component;

@Component
public class MongoDBMusicFileDao implements MusicFileDao {

    private MongoOperations mongoOperations;
    private String targetCollection;

    @Autowired
    public MongoDBMusicFileDao(MongoOperations mongoOperations) {
        this(mongoOperations, MongoCollectionNames.MUSIC_COLLECTION_NAME);
    }

    public MongoDBMusicFileDao(MongoOperations mongoOperations, String targetCollection) {
        this.mongoOperations = mongoOperations;
        this.targetCollection = targetCollection;
    }

    @Override
    public MusicFile insert(MusicFile musicFile) {
        mongoOperations.insert(musicFile, targetCollection);
        return musicFile;
    }
}
