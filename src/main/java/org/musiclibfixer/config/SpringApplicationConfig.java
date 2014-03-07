package org.musiclibfixer.config;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import org.mongodb.morphia.Morphia;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.net.UnknownHostException;

import static java.util.Arrays.asList;

@Configuration
@ComponentScan({"org.musiclibfixer"})
public class SpringApplicationConfig extends WebMvcConfigurerAdapter {

    public @Bean Morphia createMorphia() {
        return new Morphia().mapPackage("org.musiclibfixer");
    }

    public @Bean
    Mongo createMongo() throws UnknownHostException {
        return createLocalMongoClient();
    }

    private Mongo createRemoteMongoClient() throws UnknownHostException {
        MongoCredential credential = MongoCredential.createMongoCRCredential("admin", "music-db", "admin".toCharArray());
        return new MongoClient(new ServerAddress("ds057877.mongolab.com", 57877), asList(credential));
    }


    public MongoClient createLocalMongoClient() throws UnknownHostException {
        return new MongoClient();
    }

}
