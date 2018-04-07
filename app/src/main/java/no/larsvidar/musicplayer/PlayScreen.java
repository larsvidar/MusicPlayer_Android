package no.larsvidar.musicplayer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.view.View.OnClickListener;
import android.widget.TextView;

// Importing the songs ArrayList from MainActivity
import static no.larsvidar.musicplayer.MainActivity.songs;

public class PlayScreen extends AppCompatActivity {
    private String mTitle;
    private String mArtist;
    private Song mCurrentSong;
    private int mSongIndex;             //Variable for the index of the songs array.
    private Boolean mIsPlaying = false; //Variable for checking if a track is being played.


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play_screen);

        //Getting extras from intent.
        Bundle extras = getIntent().getExtras();
        //Getting the song index from extras.
        mSongIndex = extras.getInt("songIndex");

        //Saving TextViews for artist and songtitle to variables.
        final TextView playTitle = findViewById(R.id.play_song);
        final TextView playArtist = findViewById(R.id.play_artist);

        //Displaying song info.
        setSongInfo(playTitle, playArtist);

        //Setting onClickListener for Play-button.
        final ImageView playButton = findViewById(R.id.play);
        playButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mIsPlaying) {
                    playButton.setImageResource(R.drawable.play);
                    mIsPlaying = false;
                } else {
                    playButton.setImageResource(R.drawable.pause);
                    mIsPlaying = true;
                }
            }
        });

        //Setting onClickListener for Forward-button.
        final ImageView forwardButton = findViewById(R.id.fast_forward);
        forwardButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mSongIndex == songs.size() - 1) {
                    mSongIndex = 0;
                    setSongInfo(playTitle, playArtist);
                } else {
                    mSongIndex++;
                    setSongInfo(playTitle, playArtist);
                }
            }
        });

        //Setting onClickListener for Back-button.
        final ImageView backButton = findViewById(R.id.fast_bacwards);
        backButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mSongIndex == 0) {
                    mSongIndex = songs.size() - 1;
                    setSongInfo(playTitle, playArtist);
                } else {
                    mSongIndex--;
                    setSongInfo(playTitle, playArtist);
                }
            }
        });
    }

    /**
     * Method for displaying current song info.
     * @param title TextView for displaying song title.
     * @param artist TextView for displaying artist.
     */
    public void setSongInfo(TextView title, TextView artist) {
        mCurrentSong = songs.get(mSongIndex);
        mTitle = mCurrentSong.getSongName();
        mArtist = mCurrentSong.getArtist();

        title.setText(mTitle);
        artist.setText(mArtist);
    }


}
