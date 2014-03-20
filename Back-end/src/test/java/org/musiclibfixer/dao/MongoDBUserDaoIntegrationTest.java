package org.musiclibfixer.dao;

import com.mongodb.MongoClient;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mongodb.morphia.Key;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.mapping.MapperOptions;
import org.musiclibfixer.config.MongoCollectionNames;
import org.musiclibfixer.config.SpringApplicationConfig;
import org.musiclibfixer.model.User;

import java.net.UnknownHostException;
import java.util.ArrayList;

import static org.fest.assertions.Assertions.assertThat;

public class MongoDBUserDaoIntegrationTest {

    private static MongoClient mongo;
    private static MongoDBUserDao userDao;

    @BeforeClass
    public static void setUp() throws UnknownHostException {
        SpringApplicationConfig springApplicationConfig = new SpringApplicationConfig();

        mongo = (MongoClient) springApplicationConfig.createMongo();
        userDao = new MongoDBUserDao(mongo, new Morphia());
    }

    @AfterClass
    public static void tearDown() {
        mongo.getDB("music-db").getCollection(MongoCollectionNames.USERNAME_COLLECTION_NAME_INTEGRATION_TEST).drop();
    }

    @Test
    public void whenMusicFileInsertedGivenMusicFileThenSavedToMongoDB() {
        User user = new User("test", "password", true, true, true, true, new ArrayList<>());

        Key<User> userKey = userDao.save(user);

        assertThat(userKey.getId()).isNotNull();

        System.out.println(userKey);
    }


}
