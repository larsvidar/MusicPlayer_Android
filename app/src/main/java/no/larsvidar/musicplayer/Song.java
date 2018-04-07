package no.larsvidar.musicplayer;

/**
 * Class for holding song information.
 */
public class Song {

    private String mSongName;   //variable for name of song
    private String mArtist;     //variable for name of artist
    private String mSource;     //variable for source of song file.
    private String mAlbumArt;   //Variable for source of AlbumArt image.


    public Song(String songName, String artist, String source, String albumArt) {
        mSongName = songName;
        mArtist = artist;
        mSource = source;
        mAlbumArt = albumArt;
    }

    /*** GETTERS ***/
    public String getSongName() {
        return mSongName;
    }

    public String getArtist() {
        return mArtist;
    }

    public String getSource() {
        return mSource;
    }

    public String getAlbumArt() {
        return mAlbumArt;
    }
}
