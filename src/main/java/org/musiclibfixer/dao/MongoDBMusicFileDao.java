package org.musiclibfixer.dao;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.DatastoreImpl;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.dao.BasicDAO;
import org.mongodb.morphia.mapping.Mapper;
import org.mongodb.morphia.mapping.MapperOptions;
import org.mongodb.morphia.query.UpdateOperator;
import org.musiclibfixer.config.MongoCollectionNames;
import org.musiclibfixer.model.MusicFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.UnknownHostException;

import static java.util.Arrays.asList;

@Component
public class MongoDBMusicFileDao extends BasicDAO<MusicFile, ObjectId> {

    @Autowired
    public MongoDBMusicFileDao(Mongo mongo, Morphia morphia) throws UnknownHostException {
        super(mongo, morphia, "music-db");
    }

}
