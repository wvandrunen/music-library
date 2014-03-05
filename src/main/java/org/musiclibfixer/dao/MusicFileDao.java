package org.musiclibfixer.dao;

import org.musiclibfixer.model.MusicFile;

public interface MusicFileDao {

    public MusicFile upsert(MusicFile musicFile);

}
