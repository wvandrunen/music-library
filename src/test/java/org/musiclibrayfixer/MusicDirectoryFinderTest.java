package org.musiclibrayfixer;

import org.junit.Test;
import org.musiclibfixer.MusicDirectoryFinder;
import org.musiclibrayfixer.model.MusicDirectoryModel;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.List;

import static org.fest.assertions.Assertions.assertThat;

public class MusicDirectoryFinderTest {

    @Test
    public void shouldBuildListOfDirectoriesContainingMusicFiles() throws IOException {
        Path basePath = createPath();

        MusicDirectoryFinder musicDirectoryFinder = new MusicDirectoryFinder();

        List<MusicDirectoryModel> directoriesWithMusicFiles = musicDirectoryFinder.findDirectoriesContainingMusicFiles(basePath);

        assertThat(directoriesWithMusicFiles.size()).isEqualTo(1);
    }

    private Path createPath() {
        return FileSystems.getDefault().getPath("C:\\project\\music-library-fixer\\src\\test\\resources");
    }
}
