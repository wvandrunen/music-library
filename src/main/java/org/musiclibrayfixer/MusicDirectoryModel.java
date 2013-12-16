package org.musiclibrayfixer;

import java.nio.file.Path;
import java.util.List;

public class MusicDirectoryModel {

    private List<String> musicFiles;
    private Path path;

    public void setPath(Path next) {
        this.path = next;
    }

    public void setMusicFiles(List<String> files) {
        this.musicFiles = files;
    }

    public List<String> getMusicFiles() {
        return musicFiles;
    }

    public Path getPath() {
        return path;
    }
}
