package org.musiclibfixer;

import org.musiclibrayfixer.model.MusicDirectoryModel;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class MusicDirectoryFinder {

    public List<MusicDirectoryModel> findDirectoriesContainingMusicFiles(Path basePath) throws IOException {
        List<MusicDirectoryModel> directoriesWithMusicFiles = new ArrayList<MusicDirectoryModel>();

        DirectoryStream<Path> directoryStream = Files.newDirectoryStream(basePath);

        for(Path next : directoryStream) {

            MusicFilesListBuilder musicFilesListBuilder = new MusicFilesListBuilder();

            Files.walkFileTree(next, musicFilesListBuilder);

            if(musicFilesListBuilder.isMusicFilesFound()) {
                MusicDirectoryModel musicDirectoryModel = new MusicDirectoryModel();

                musicDirectoryModel.setPath(next);
                musicDirectoryModel.setMusicFiles(musicFilesListBuilder.getFiles());

                directoriesWithMusicFiles.add(musicDirectoryModel);
            }
        }

        return directoriesWithMusicFiles;
    }


}
