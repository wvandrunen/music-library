package org.musiclibfixer;

import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.Mp3File;
import com.mpatric.mp3agic.UnsupportedTagException;
import org.musiclibfixer.dao.MongoDBMusicFileDao;
import org.musiclibfixer.dao.MusicFileDao;
import org.musiclibfixer.mapper.MusicFileMapper;
import org.musiclibfixer.model.MusicDirectory;
import org.musiclibfixer.model.MusicFile;
import org.musiclibfixer.scanner.MusicDirectoryScanner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException, InvalidDataException, UnsupportedTagException {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.scan("org.musiclibfixer");
        ctx.refresh();

        MusicFileDao musicFileDao = ctx.getBean(MongoDBMusicFileDao.class);
        MusicFileMapper musicFileMapper = new MusicFileMapper();
        MusicDirectoryScanner musicDirectoryScanner = new MusicDirectoryScanner();

        List<MusicDirectory> musicDirectories = musicDirectoryScanner.findDirectoriesContainingMusicFiles(FileSystems.getDefault().getPath("Y:\\"));

        musicDirectories.forEach(dir -> {
            dir.getMusicFiles().forEach(file -> {

                long startReadingFile = System.currentTimeMillis();
                MusicFile musicFile = null;
                try {
                    musicFile = musicFileMapper.map(new Mp3File(file));
                } catch (IOException | UnsupportedTagException | InvalidDataException e) {
                    e.printStackTrace();
                }
                long endReadingFile = System.currentTimeMillis();
                musicFileDao.insert(musicFile);
                long endWritingToMongo = System.currentTimeMillis();

                System.out.println("Reading file took [" + (endReadingFile - startReadingFile) + "] Write file took [" + (endWritingToMongo - endReadingFile) + "]");
            });
        });
    }
}
