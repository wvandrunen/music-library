package org.musiclibfixer.scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MusicFilesListBuilder extends SimpleFileVisitor<Path> {

    public static final String FILE_EXTENSION = ".mp3";
    private static Logger LOG = LoggerFactory.getLogger(MusicFilesListBuilder.class);
    private boolean musicFilesFound = false;
    private List<String> files;

    public MusicFilesListBuilder() {
        files = new ArrayList<String>();
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        LOG.info("Entering directory [" + dir.toAbsolutePath() + "]");

        List<String> list = Arrays.asList(dir.toFile().list());

        List<File> filesFound = new ArrayList<File>();

        list.forEach(fileInDirectory -> {
            File file = new File(fileInDirectory);
            filesFound.add(file);
        });

        list.stream().map( f -> {
            return new File(f);
        }).collect(Collectors.toList());

        filesFound.stream().filter(file -> !file.isDirectory() && file.getAbsolutePath().endsWith(FILE_EXTENSION))
            .forEach(file -> {
                LOG.debug("Checking file [" + file.getAbsolutePath() + "]");
                File deeplink = new File(dir.toString() + "\\" + file.toString());
                files.add(deeplink.getAbsolutePath());
            });

        if (files.size() > 0) {
            musicFilesFound = true;
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
