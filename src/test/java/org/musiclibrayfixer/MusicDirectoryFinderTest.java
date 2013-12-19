package org.musiclibrayfixer;

import org.junit.Test;
import org.musiclibfixer.MusicDirectoryFinder;
import org.musiclibrayfixer.model.MusicDirectory;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.List;

import static org.fest.assertions.Assertions.assertThat;

public class MusicDirectoryFinderTest {

    @Test
    public void shouldBuildListOfOneMusicDirectoryModel() throws IOException {
        Path basePath = createPath();

        MusicDirectoryFinder musicDirectoryFinder = new MusicDirectoryFinder();

        List<MusicDirectory> directoriesWithMusicFiles = musicDirectoryFinder.findDirectoriesContainingMusicFiles(basePath);

        assertThat(directoriesWithMusicFiles.size()).isEqualTo(1);
    }

    @Test
    public void shouldReturnOneMusicFileWhenGivenDirectoryWithOneMusicFile() throws IOException {
        Path basePath = createPath();

        MusicDirectoryFinder musicDirectoryFinder = new MusicDirectoryFinder();

        List<MusicDirectory> directoriesWithMusicFiles = musicDirectoryFinder.findDirectoriesContainingMusicFiles(basePath);

        assertThat(directoriesWithMusicFiles.get(0).getMusicFiles().size()).isEqualTo(1);
    }

    @Test
    public void shouldReturnPathToMusicFileWhenGivenDirectoryWithOneMusicFile() throws IOException {
        Path basePath = createPath();

        MusicDirectoryFinder musicDirectoryFinder = new MusicDirectoryFinder();

        List<MusicDirectory> directoriesWithMusicFiles = musicDirectoryFinder.findDirectoriesContainingMusicFiles(basePath);

        assertThat(directoriesWithMusicFiles.get(0).getPath().toString()).endsWith("src\\test\\resources\\test-directory2");
    }

    @Test
    public void shouldReturnReadableStringWhenGivenDirectoryWithOneMusicFile() throws IOException {
        Path basePath = createPath();

        MusicDirectoryFinder musicDirectoryFinder = new MusicDirectoryFinder();

        List<MusicDirectory> directoriesWithMusicFiles = musicDirectoryFinder.findDirectoriesContainingMusicFiles(basePath);

        assertThat(directoriesWithMusicFiles.get(0).toString()).isEqualToIgnoringCase("MusicDirectory{Amout of Music files found = 1, path=C:\\project\\music-library-fixer\\src\\test\\resources\\test-directory2}\n");
    }

    private Path createPath() {
        return FileSystems.getDefault().getPath("C:\\project\\music-library-fixer\\src\\test\\resources");
    }
}
