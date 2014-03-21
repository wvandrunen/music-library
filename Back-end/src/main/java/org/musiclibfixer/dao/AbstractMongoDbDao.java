package org.musiclibfixer.dao;

import com.mongodb.Mongo;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.dao.BasicDAO;

import java.net.UnknownHostException;

abstract public class AbstractMongoDbDao<T, O> extends BasicDAO<T, O> {

    public AbstractMongoDbDao(Mongo mongo, Morphia morphia, String dbName) throws UnknownHostException {
        super(mongo, morphia, dbName);
    }


}
