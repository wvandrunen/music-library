package org.musiclibfixer.dao;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;

import java.net.UnknownHostException;

import static java.util.Arrays.asList;

public class MongoDBIntegrationTestUtilities {

    public static MongoClient createRemoteMongoClient() throws UnknownHostException {
        MongoCredential credential = MongoCredential.createMongoCRCredential("wouter", "integration-test-db", "wouter".toCharArray());
        return new MongoClient(new ServerAddress("ds057867.mongolab.com", 57867), asList(credential));
    }
}
