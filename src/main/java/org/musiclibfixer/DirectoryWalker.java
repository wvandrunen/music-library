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

public class DirectoryWalker extends SimpleFileVisitor<Path> {

    private static Logger LOG = Logger.getLogger(DirectoryWalker.class);
    public static final String FILE_EXTENSION = "mp3";

    private List<Path> directories;

    public DirectoryWalker() {
        directories = new ArrayList<Path>();
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        LOG.info("Entering directory [" + dir.toAbsolutePath() + "]");

        String[] filesInDirectory = dir.toFile().list();

        for(String fileInDirectory : filesInDirectory) {
            File file = new File(fileInDirectory);
            String extension = fileInDirectory.substring(fileInDirectory.lastIndexOf('.') + 1);

            LOG.debug("Checking file [" + file + "]");

            if(!file.isDirectory() && extension.contains(FILE_EXTENSION)) {
                LOG.debug("Adding directory to list [" + file + "]");

                directories.add(dir);
            }
        }

        return FileVisitResult.CONTINUE;
    }

    public List<Path> getDirectories() {
        return directories;
    }
}
