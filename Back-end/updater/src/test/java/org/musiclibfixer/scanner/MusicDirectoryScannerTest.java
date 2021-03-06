package org.musiclibfixer.scanner;

import org.junit.Test;
import org.musiclibfixer.model.MusicDirectory;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.List;

import static org.fest.assertions.Assertions.assertThat;

public class MusicDirectoryScannerTest {

    @Test
    public void shouldBuildListOfOneMusicDirectoryModel() throws IOException {
        Path basePath = createPath();

        MusicDirectoryScanner musicDirectoryScanner = new MusicDirectoryScanner();

        List<MusicDirectory> directoriesWithMusicFiles = musicDirectoryScanner.findDirectoriesContainingMusicFiles(basePath);

        assertThat(directoriesWithMusicFiles.size()).isEqualTo(1);
    }

    @Test
    public void shouldReturnOneMusicFileWhenGivenDirectoryWithOneMusicFile() throws IOException {
        Path basePath = createPath();

        MusicDirectoryScanner musicDirectoryScanner = new MusicDirectoryScanner();

        List<MusicDirectory> directoriesWithMusicFiles = musicDirectoryScanner.findDirectoriesContainingMusicFiles(basePath);

        assertThat(directoriesWithMusicFiles.get(0).getMusicFiles().size()).isEqualTo(1);
    }

    @Test
    public void shouldReturnPathToMusicFileWhenGivenDirectoryWithOneMusicFile() throws IOException {
        Path basePath = createPath();

        MusicDirectoryScanner musicDirectoryScanner = new MusicDirectoryScanner();

        List<MusicDirectory> directoriesWithMusicFiles = musicDirectoryScanner.findDirectoriesContainingMusicFiles(basePath);

        assertThat(directoriesWithMusicFiles.get(0).getPath()).isNotNull();
    }

    @Test
    public void shouldReturnReadableStringWhenGivenDirectoryWithOneMusicFile() throws IOException {
        Path basePath = createPath();

        MusicDirectoryScanner musicDirectoryScanner = new MusicDirectoryScanner();

        List<MusicDirectory> directoriesWithMusicFiles = musicDirectoryScanner.findDirectoriesContainingMusicFiles(basePath);

        assertThat(directoriesWithMusicFiles.size()).isEqualTo(1);
    }

    private Path createPath() {
        return FileSystems.getDefault().getPath("./src/test/resources");
    }
}
