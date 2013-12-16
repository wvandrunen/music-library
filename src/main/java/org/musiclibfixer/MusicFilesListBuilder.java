package org.musiclibfixer;

import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class MusicFilesListBuilder extends SimpleFileVisitor<Path> {

    private static Logger LOG = Logger.getLogger(MusicFilesListBuilder.class);
    public static final String FILE_EXTENSION = ".mp3";

    private boolean musicFilesFound = false;
    private List<String> files;

    public MusicFilesListBuilder() {
        files = new ArrayList<String>();
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        LOG.info("Entering directory [" + dir.toAbsolutePath() + "]");

        String[] filesInDirectory = dir.toFile().list();

        for(String fileInDirectory : filesInDirectory) {
            File file = new File(fileInDirectory);

            LOG.debug("Checking file [" + file + "]");

            if(!file.isDirectory() && fileInDirectory.endsWith(FILE_EXTENSION)) {
                LOG.info("Adding directory to list [" + file + "]");

                musicFilesFound = true;

                File deeplink = new File(dir.toString() + "\\" + file.toString());
                files.add(deeplink.getAbsolutePath());
            }
        }

        return FileVisitResult.CONTINUE;
    }

    public List<String> getFiles() {
        return files;
    }

    public boolean isMusicFilesFound() {
        return musicFilesFound;
    }
}
