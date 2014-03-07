package org.musiclibfixer.dao;

import com.mongodb.MongoClient;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mongodb.morphia.Key;
import org.mongodb.morphia.Morphia;
import org.musiclibfixer.config.MongoCollectionNames;
import org.musiclibfixer.config.SpringApplicationConfig;
import org.musiclibfixer.model.MusicFile;

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
        SpringApplicationConfig springApplicationConfig = new SpringApplicationConfig();

        mongo = (MongoClient) springApplicationConfig.createMongo();
        musicFileDao = new MongoDBMusicFileDao(mongo, new Morphia());

    }

    @AfterClass
    public static void tearDown() {
        mongo.getDB("music-db").getCollection(MongoCollectionNames.MUSIC_COLLECTION_NAME_INTEGRATION_TEST).drop();
    }

    @Test
    public void whenMusicFileInsertedGivenMusicFileThenSavedToMongoDB() {
        MusicFile musicFile = new MusicFile("Sick Again", "Led Zeppelin", "Physical Graffiti", "File Path");

        Key<MusicFile> musicFileWithObjectId = musicFileDao.save(musicFile);

        assertThat(musicFileWithObjectId.getId()).isNotNull();
    }

    @Test
    public void getAllShouldReturnOneMusicFile() {
        //assertThat(musicFileDao.getAll().getPageCount()).isEqualTo(1);
    }

}
