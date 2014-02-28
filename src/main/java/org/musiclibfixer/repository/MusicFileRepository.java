package org.musiclibfixer.repository;

import org.musiclibrayfixer.model.MusicFile;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MusicFileRepository extends MongoRepository<MusicFile, String> {

    boolean insert(MusicFile musicFile);

}
