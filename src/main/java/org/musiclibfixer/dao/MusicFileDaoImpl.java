package org.musiclibfixer.dao;

import org.musiclibfixer.config.MongoCollectionNames;
import org.musiclibfixer.model.MusicFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Component;

@Component
public class MusicFileDaoImpl implements MusicFileDao {

    private MongoOperations mongoOperations;

    @Autowired
    public MusicFileDaoImpl(MongoOperations mongoOperations) {
        this.mongoOperations = mongoOperations;
    }

    @Override
    public MusicFile insert(MusicFile musicFile) {
        mongoOperations.insert(musicFile, MongoCollectionNames.MUSIC_COLLECTION_NAME);
        return musicFile;
    }
}
