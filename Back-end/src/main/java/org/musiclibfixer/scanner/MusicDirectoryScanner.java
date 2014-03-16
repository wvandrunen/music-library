package org.musiclibfixer.scanner;

import org.musiclibfixer.model.MusicDirectory;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class MusicDirectoryScanner {

    public List<MusicDirectory> findDirectoriesContainingMusicFiles(Path basePath) throws IOException {
        List<MusicDirectory> directoriesWithMusicFiles = new ArrayList<MusicDirectory>();

        DirectoryStream<Path> directoryStream = Files.newDirectoryStream(basePath);

        directoryStream.forEach( next -> {

            MusicFilesListBuilder musicFilesListBuilder = new MusicFilesListBuilder();

            try {
                Files.walkFileTree(next, musicFilesListBuilder);

                if(musicFilesListBuilder.isMusicFilesFound()) {
                    MusicDirectory musicDirectory = new MusicDirectory();

                    musicDirectory.setPath(next);
                    musicDirectory.setMusicFiles(musicFilesListBuilder.getFiles());

                    directoriesWithMusicFiles.add(musicDirectory);
                }

            } catch (IOException e) {}

        });

        return directoriesWithMusicFiles;
    }


}
