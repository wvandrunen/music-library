package org.musiclibfixer.mapper;

import com.mpatric.mp3agic.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.musiclibfixer.model.MusicFile;

import java.io.IOException;

import static org.fest.assertions.Assertions.assertThat;

public class MusicFileMapperTest {

    private Mp3File mp3File;
    private MusicFileMapper musicFileMapper;

    @Before
    public void setUp() throws InvalidDataException, IOException, UnsupportedTagException {
        mp3File = Mockito.mock(Mp3File.class);

        Mockito.when(mp3File.getFilename()).thenReturn("Test Filename");
        Mockito.when(mp3File.getId3v2Tag()).thenReturn(createID3v2Tag());

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

    @Test
    public void whenMappingFilePathGivenMp3FileWithFilePathThenMapFilePath() {
        MusicFile musicFile = musicFileMapper.map(mp3File);
        assertThat(musicFile.getPath()).isNotNull();
    }

    private ID3v2 createID3v2Tag() {
        ID3v2 id3v2 = new ID3v24Tag();

        id3v2.setAlbum("Test Album");
        id3v2.setArtist("Test Artist");
        id3v2.setTitle("Test Release Title");

        return id3v2;
    }
}
