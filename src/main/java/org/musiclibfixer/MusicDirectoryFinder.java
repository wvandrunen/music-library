package org.musiclibfixer;

import org.musiclibrayfixer.MusicDirectoryModel;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MusicDirectoryFinder {

    public List<MusicDirectoryModel> findDirectoriesContainingMusicFiles(Path basePath) throws IOException {
        List<MusicDirectoryModel> directoriesWithMusicFiles = new ArrayList<MusicDirectoryModel>();

        Iterator<Path> pathIterator = Files.newDirectoryStream(basePath).iterator();

        while(pathIterator.hasNext()) {
            Path next = pathIterator.next();

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
