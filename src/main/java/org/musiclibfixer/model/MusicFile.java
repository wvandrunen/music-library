package org.musiclibfixer.model;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

@Entity
public class MusicFile {

    @Id
    private String id;

    private String trackTitle;
    private String artist;
    private String releaseTitle;
    private String path;

    public MusicFile() {
    }

    public MusicFile(String trackTitle, String artist, String releaseTitle, String path) {
        this.trackTitle = trackTitle;
        this.artist = artist;
        this.releaseTitle = releaseTitle;
        this.path = path;
    }






    /*
    private String releaseArtist= "";
    private String releaseDate= "";
    private String originalReleaseDate= "";
    private String composer= "";
    private String lyricist= "";
    private String writer= "";
    private String conductor= "";
    private String performer= "";
    private String trackNumber= "";
    private String totalTracks= "";
    private String discNumber= "";
    private String totalDiscs= "";
    private String compilation= "";
    private String comment= "";
    private String genre= "";
    private String rating= "";
    private String BPM= "";
    private String mood= "";
    */

    /*
    private String musicBrainzTrackId= "";
    private String musicBrainzReleaseId= "";
    private String musicBrainzArtistId= "";
    private String musicBrainzReleaseArtistId= "";
    private String musicBrainzTRMId= "";
    private String musicBrainzDiscId= "";
    private String musicIPPUID= "";
    private String musicIPFingerprint= "";
    */

    //private String releaseStatus= "";
    //private String releaseType= "";
    //private String releaseCountry= "";
    //private String ASIN= "";
    //private String gaplessPlayback= "";
    //private String podcast= "";
    //private String language= "";
    //private String podcastURL= "";
    //private String showName= "";
    //private String script= "";
    // private String musicBrainzWorkId = "";
    // private String musicBrainzReleaseGroupId= "";
    //private String ISRC= "";
    //private String copyright= "";
    //private String lyrics= "";
    //private String releaseFormat= "";
    //private String labelName= "";
    //private String releaseCatalogNumber= "";
    //private String barcode= "";
    //private String encodedBy= "";
    //private String albumSortOrder= "";
    //private String albumArtistSortOrder= "";
    //private String artistSortOrder= "";
    //private String titleSortOrder= "";
    //private String composerSortOrder= "";
    //private String showNameSortOrder= "";
    //private String remixer= "";
    //private String arranger= "";
    //private String engineer= "";
    //private String producer= "";
    //private String mixDJ= "";
    //private String mixengineer= "";
    //private String grouping= "";
    //private String subtitle= "";
    //private String discSubtitle= "";


    public String getTrackTitle() {
        return trackTitle;
    }

    public String getArtist() {
        return artist;
    }

    public void setTrackTitle(String trackTitle) {
        this.trackTitle = trackTitle;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getReleaseTitle() {
        return releaseTitle;
    }

    public void setReleaseTitle(String releaseTitle) {
        this.releaseTitle = releaseTitle;
    }

    public String getId() {
        return id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
