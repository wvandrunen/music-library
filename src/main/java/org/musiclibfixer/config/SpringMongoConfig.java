package org.musiclibfixer.config;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import java.net.UnknownHostException;

import static java.util.Arrays.asList;

@Configuration
public class SpringMongoConfig {

    public @Bean
    MongoDbFactory mongoDbFactory() throws UnknownHostException {
        MongoCredential credential = MongoCredential.createMongoCRCredential("admin", "music-db", "admin".toCharArray());
        MongoClient mongoClient = new MongoClient(new ServerAddress("ds057877.mongolab.com", 57877), asList(credential));
        return new SimpleMongoDbFactory(mongoClient, "music-db");
    }

    public @Bean
    MongoTemplate mongoTemplate() throws UnknownHostException {
        return new MongoTemplate(mongoDbFactory());
    }

}
