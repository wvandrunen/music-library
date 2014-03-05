package org.musiclibfixer.dao;

import com.mongodb.MongoClient;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mongodb.morphia.Key;
import org.musiclibfixer.config.MongoCollectionNames;
import org.musiclibfixer.config.SpringMongoConfig;
import org.musiclibfixer.model.MusicFile;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.net.UnknownHostException;

import static org.fest.assertions.Assertions.assertThat;

/**
 * This integration test uses a MongoDB instance running on localhost on the standard port
 */
public class MongoDBMusicFileDaoIntegrationTest {

    private static MongoClient mongo;
    private static MongoDBMusicFileDao musicFileDao;

    @BeforeClass
    public static void setUp() throws UnknownHostException {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringMongoConfig.class);
        ctx.register(MongoDBMusicFileDao.class, SpringMongoConfig.class);

        musicFileDao = ctx.getBean(MongoDBMusicFileDao.class);
        mongo = ctx.getBean(MongoClient.class);
    }

    @After
    public void tearDown() {
        mongo.getDB("music-db").getCollection(MongoCollectionNames.MUSIC_COLLECTION_NAME_INTEGRATION_TEST).drop();

    }

    @Test
    public void whenMusicFileInsertedGivenMusicFileThenSavedToMongoDB() {
        MusicFile musicFile = new MusicFile("Sick Again", "Led Zeppelin", "Physical Graffiti", "File Path");

        Key<MusicFile> musicFileWithObjectId = musicFileDao.save(musicFile);

        assertThat(musicFileWithObjectId.getId()).isNotNull();
    }

}
