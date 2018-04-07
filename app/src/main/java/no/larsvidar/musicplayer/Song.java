package no.larsvidar.musicplayer;

/**
 * Class for holding song information.
 */
public class Song {

    private String mSongName;   //variable for name of song
    private String mArtist;     //variable for name of artist
    private String mUrl;        //variable for url to song file.


    public Song(String songName, String artist, String url) {
        mSongName = songName;
        mArtist = artist;
        mUrl = url;
    }

    public String getSongName() {
        return mSongName;
    }

    public String getArtist() {
        return mArtist;
    }

    public String getUrl() {
        return mUrl;
    }
}
