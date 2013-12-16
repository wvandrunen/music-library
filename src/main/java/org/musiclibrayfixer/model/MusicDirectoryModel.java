package org.musiclibrayfixer.model;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class MusicDirectoryModel {

    private List<String> musicFiles = new ArrayList<String>();
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

    @Override
    public String toString() {
        return "MusicDirectoryModel{" +
                "Amout of Music files found = " + musicFiles.size() +
                ", path=" + path +
                "}\n";
    }
}
