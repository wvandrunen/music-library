package org.musiclibfixer.mapper;

import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.Mp3File;
import com.mpatric.mp3agic.UnsupportedTagException;
import org.junit.Before;
import org.junit.Test;
import org.musiclibrayfixer.model.MusicFile;

import java.io.IOException;

import static org.fest.assertions.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

public class MusicFileMapperTest {

    private Mp3File mp3File;
    private MusicFileMapper musicFileMapper;

    @Before
    public void setUp() throws InvalidDataException, IOException, UnsupportedTagException {
        mp3File = new Mp3File("c:\\project\\01-track.mp3");

        musicFileMapper = new MusicFileMapper();
    }

    @Test
    public void shouldSetArtistWhenGivenMp3File() throws InvalidDataException, IOException, UnsupportedTagException {
        MusicFile musicFile = musicFileMapper.map(mp3File);
        assertThat(musicFile.getArtist()).isNotNull();
    }

    @Test
    public void shouldSetTrackTitleWhenGivenMp3File() throws InvalidDataException, IOException, UnsupportedTagException {
        MusicFile musicFile = musicFileMapper.map(mp3File);
        assertThat(musicFile.getTrackTitle()).isNotNull();
    }

    @Test
    public void shouldSetReleaseTitleWhenGivenMp3File() throws InvalidDataException, IOException, UnsupportedTagException {
        MusicFile musicFile = musicFileMapper.map(mp3File);
        assertThat(musicFile.getReleaseTitle()).isNotNull();
    }
}
