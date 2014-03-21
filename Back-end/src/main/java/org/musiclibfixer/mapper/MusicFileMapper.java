package org.musiclibfixer.mapper;

import com.mpatric.mp3agic.Mp3File;
import org.apache.commons.io.FilenameUtils;
import org.musiclibfixer.model.MusicFile;

public class MusicFileMapper {

    public MusicFile map(Mp3File mp3File) {
        MusicFile musicFile = new MusicFile();

        musicFile.setFilename(FilenameUtils.getName(mp3File.getFilename()));
        musicFile.setPath(FilenameUtils.getPath(mp3File.getFilename()));
        musicFile.setArtist(mp3File.getId3v2Tag().getArtist());
        musicFile.setTrackTitle(mp3File.getId3v2Tag().getTitle());
        musicFile.setReleaseTitle(mp3File.getId3v2Tag().getAlbum());

        return musicFile;
    }
}
