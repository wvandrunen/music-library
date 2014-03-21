package org.musiclibfixer.dao;

import com.mongodb.MongoClient;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Key;
import org.mongodb.morphia.Morphia;
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
        mongo = MongoDBIntegrationTestUtilities.createRemoteMongoClient();

        musicFileDao = new MongoDBMusicFileDao(mongo, new Morphia(), "integration-test-db");
    }

    @AfterClass
    public static void tearDown() {
        Datastore datastore = musicFileDao.getDatastore();
        datastore.delete(datastore.createQuery(MusicFile.class));
    }

    @Test
    public void whenMusicFileInsertedGivenMusicFileThenSavedToMongoDB() {
        MusicFile musicFile = new MusicFile("Sick Again", "Led Zeppelin", "Physical Graffiti", "File Path");

        Key<MusicFile> musicFileWithObjectId = musicFileDao.save(musicFile);

        assertThat(musicFileWithObjectId.getId()).isNotNull();
    }

}
