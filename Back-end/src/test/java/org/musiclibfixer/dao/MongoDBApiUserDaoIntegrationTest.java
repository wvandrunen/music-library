package org.musiclibfixer.dao;

import com.mongodb.MongoClient;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Key;
import org.mongodb.morphia.Morphia;
import org.musiclibfixer.config.MongoNames;
import org.musiclibfixer.model.ApiUser;

import java.net.UnknownHostException;
import java.util.ArrayList;

import static org.fest.assertions.Assertions.assertThat;

public class MongoDBApiUserDaoIntegrationTest {

    private static MongoDBUserDao userDao;

    @BeforeClass
    public static void setUp() throws UnknownHostException {
        MongoClient mongo = MongoDBIntegrationTestUtilities.createRemoteMongoClient();
        userDao = new MongoDBUserDao(mongo, new Morphia(), MongoNames.INTEGRATION_TEST_DB);
    }

    @AfterClass
    public static void tearDown() {
        Datastore datastore = userDao.getDatastore();
        datastore.delete(datastore.createQuery(ApiUser.class));
    }

    @Test
    public void whenMusicFileInsertedGivenMusicFileThenSavedToMongoDB() {
        ApiUser apiUser = new ApiUser("test", "password", true, true, true, true, new ArrayList<>());

        Key<ApiUser> userKey = userDao.save(apiUser);

        assertThat(userKey.getId()).isNotNull();

        System.out.println(userKey);
    }


}
