package org.musiclibfixer.config;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.UnknownHostException;

import static java.util.Arrays.asList;

@Configuration
public class SpringMongoConfig {

    public @Bean Morphia createMorphia() {
        return new Morphia().mapPackage("org.musiclibfixer");
    }

    public @Bean MongoClient createMongo() throws UnknownHostException {
        MongoCredential credential = MongoCredential.createMongoCRCredential("admin", "music-db", "admin".toCharArray());
        return new MongoClient(new ServerAddress("ds057877.mongolab.com", 57877), asList(credential));
    }

}
