package org.musiclibfixer.model;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class MusicDirectory {

    private List<String> musicFiles = new ArrayList<>();
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
