package org.musiclibfixer.scanner;

import org.musiclibfixer.model.MusicDirectory;
import org.musiclibfixer.scanner.MusicFilesListBuilder;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class MusicDirectoryFinder {

    public List<MusicDirectory> findDirectoriesContainingMusicFiles(Path basePath) throws IOException {
        List<MusicDirectory> directoriesWithMusicFiles = new ArrayList<MusicDirectory>();

        DirectoryStream<Path> directoryStream = Files.newDirectoryStream(basePath);

        for(Path next : directoryStream) {

            MusicFilesListBuilder musicFilesListBuilder = new MusicFilesListBuilder();

            Files.walkFileTree(next, musicFilesListBuilder);

            if(musicFilesListBuilder.isMusicFilesFound()) {
                MusicDirectory musicDirectory = new MusicDirectory();

                musicDirectory.setPath(next);
                musicDirectory.setMusicFiles(musicFilesListBuilder.getFiles());

                directoriesWithMusicFiles.add(musicDirectory);
            }
        }

        return directoriesWithMusicFiles;
    }


}
