package org.musiclibfixer.mapper;

import com.mpatric.mp3agic.Mp3File;
import org.musiclibrayfixer.model.MusicFile;

public class MusicFileMapper {

    public MusicFile map(Mp3File mp3File) {
        MusicFile musicFile = new MusicFile();

        musicFile.setArtist(mp3File.getId3v2Tag().getArtist());

        return musicFile;
    }
}
