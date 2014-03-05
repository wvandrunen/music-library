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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.util.List;

public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws IOException, InvalidDataException, UnsupportedTagException {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.scan("org.musiclibfixer");
        ctx.refresh();

        MongoDBMusicFileDao musicFileDao = ctx.getBean(MongoDBMusicFileDao.class);
        MusicFileMapper musicFileMapper = new MusicFileMapper();
        MusicDirectoryScanner musicDirectoryScanner = new MusicDirectoryScanner();

        long startScanning = System.currentTimeMillis();
        List<MusicDirectory> musicDirectories = musicDirectoryScanner.findDirectoriesContainingMusicFiles(FileSystems.getDefault().getPath("C:\\Users\\wvandrunen"));
        logger.info("Scanning done... took ["+ (System.currentTimeMillis() - startScanning) + "] ms");

        musicDirectories.forEach(dir -> {
            dir.getMusicFiles().forEach(file -> {
                try {
                    long startReadingFile = System.currentTimeMillis();

                    MusicFile musicFile = musicFileDao.findOne("path", file);

                    System.out.println(musicFile.getArtist());

                    musicFile = musicFileMapper.map(new Mp3File(file));

                    musicFileDao.save(musicFile);

                    long endReadingFile = System.currentTimeMillis();
                    long endWritingToMongo = System.currentTimeMillis();

                    System.out.println("MusicFile [" + musicFile + "]");
                    System.out.println("Reading file took [" + (endReadingFile - startReadingFile) + " ms]");
                    System.out.println("Write file to MongoDB took [" + (endWritingToMongo - endReadingFile) + "ms]");
                } catch (Exception e) {
                    logger.error("Error while trying to insert [" + file + "]", e);
                }
            });
        });
    }
}
