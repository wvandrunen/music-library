package org.musiclibfixer.dao;

import com.mongodb.Mongo;
import config.MongoNames;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Morphia;
import org.musiclibfixer.model.ApiUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.net.UnknownHostException;

@Component
public class MongoDBUserDao extends AbstractMongoDbDao<ApiUser, ObjectId> {

    @Autowired
    public MongoDBUserDao(Mongo mongo, Morphia morphia, @Value(value = MongoNames.MUSIC_DB) String dbName) throws UnknownHostException {
        super(mongo, morphia, dbName);


    }


}
