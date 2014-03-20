package org.musiclibfixer.dao;

import com.mongodb.Mongo;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.dao.BasicDAO;
import org.musiclibfixer.model.MusicFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.UnknownHostException;

@Component
public class MongoDBMusicFileDao extends AbstractMongoDbDao<MusicFile, ObjectId> {

    private int pageSize = 20;

    @Autowired
    public MongoDBMusicFileDao(Mongo mongo, Morphia morphia, String collectionName) throws UnknownHostException {
        super(mongo, morphia, collectionName);
    }

    public QueryPager<MusicFile> getAll() {
        return new QueryPager<>(createQuery(), pageSize);
    }

}
