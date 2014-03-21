package org.musiclibfixer.config;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import org.mongodb.morphia.Morphia;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.net.UnknownHostException;

import static java.util.Arrays.asList;

@Configuration
@ComponentScan({"org.musiclibfixer"})
public class SpringApplicationConfig {

    @Bean
    public Morphia createMorphia() {
        return new Morphia().mapPackage("org.musiclibfixer");
    }

    @Bean
    public Mongo createMongo() throws UnknownHostException {
        return createRemoteMongoClient();
    }

    private Mongo createRemoteMongoClient() throws UnknownHostException {
        MongoCredential credential = MongoCredential.createMongoCRCredential("admin", "music-db", "admin".toCharArray());
        return new MongoClient(new ServerAddress("ds057877.mongolab.com", 57877), asList(credential));
    }

    public MongoClient createLocalMongoClient() throws UnknownHostException {
        return new MongoClient();
    }

}
