package org.musiclibrayfixer;

import org.junit.Test;
import org.musiclibfixer.MusicDirectoryFinder;
import org.musiclibfixer.MusicFilesListBuilder;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.fest.assertions.Assertions.assertThat;

public class MusicFilesListBuilderTest {

    @Test
    public void shouldReturnListOfOneFile() throws IOException {
        MusicFilesListBuilder musicFilesListBuilder = new MusicFilesListBuilder();

        Files.walkFileTree(createPath(), musicFilesListBuilder);

        List<String> files = musicFilesListBuilder.getFiles();

        assertThat(files.size()).isEqualTo(1);
    }

    @Test
    public void shouldReturnTrueWhenFileIsFound() throws IOException {
        MusicFilesListBuilder musicFilesListBuilder = new MusicFilesListBuilder();

        Files.walkFileTree(createPath(), musicFilesListBuilder);

        assertThat(musicFilesListBuilder.isMusicFilesFound()).isTrue();
    }

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
