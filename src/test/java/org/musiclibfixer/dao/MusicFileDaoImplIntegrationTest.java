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
public class MusicFileDaoImplIntegrationTest {

    private MongoOperations mongoOperations = null;

    @Before
    public void setUp() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringMongoConfig.class);
        mongoOperations = (MongoOperations) ctx.getBean("mongoTemplate");
    }

    @After
    public void tearDown() {
        mongoOperations.dropCollection(MongoCollectionNames.MUSIC_COLLECTION_NAME);
    }

    @Test
    public void whenMusicFileInsertedGivenMusicFileThenSavedToMongoDB() {
        MusicFileDao musicFileDao = new MusicFileDaoImpl(mongoOperations);

        MusicFile musicFile = new MusicFile("Sick Again", "Led Zeppelin", "Physical Graffiti");

        MusicFile musicFileWithObjectId = musicFileDao.insert(musicFile);

        assertThat(musicFileWithObjectId.getId()).isNotNull();
    }

}
