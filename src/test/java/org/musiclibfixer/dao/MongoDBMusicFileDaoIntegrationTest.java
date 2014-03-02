package org.musiclibfixer.dao;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.musiclibfixer.config.MongoCollectionNames;
import org.musiclibfixer.config.SpringMongoConfig;
import org.musiclibfixer.model.MusicFile;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;

import static org.fest.assertions.Assertions.assertThat;

/**
 * This integration test uses a MongoDB instance running on localhost on the standard port
 */
public class MongoDBMusicFileDaoIntegrationTest {

    private MongoOperations mongoOperations = null;
    private String musicCollection;

    @Before
    public void setUp() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringMongoConfig.class);
        mongoOperations = (MongoOperations) ctx.getBean("mongoTemplate");

        musicCollection = MongoCollectionNames.MUSIC_COLLECTION_NAME_INTEGRATION_TEST;
    }

    @After
    public void tearDown() {
        mongoOperations.dropCollection(musicCollection);
    }

    @Test
    public void whenMusicFileInsertedGivenMusicFileThenSavedToMongoDB() {
        MusicFileDao musicFileDao = new MongoDBMusicFileDao(mongoOperations, musicCollection);

        MusicFile musicFile = new MusicFile("Sick Again", "Led Zeppelin", "Physical Graffiti", "File Path");

        MusicFile musicFileWithObjectId = musicFileDao.insert(musicFile);

        assertThat(musicFileWithObjectId.getId()).isNotNull();
    }

}
