package no.larsvidar.musicplayer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.view.View.OnClickListener;
import android.widget.TextView;

// Importing the songs ArrayList from MainActivity
import static no.larsvidar.musicplayer.MainActivity.songs;

public class PlayScreen extends AppCompatActivity {
    private String mTitle;
    private String mArtist;
    private int mAlbumArt;
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
        final ImageView playAlbumArt = findViewById(R.id.play_albumart);

        //Displaying song info.
        setSongInfo(playTitle, playArtist, playAlbumArt);


        /*** ONCLICKLISTENERS ***/

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
                    setSongInfo(playTitle, playArtist, playAlbumArt);
                } else {
                    mSongIndex++;
                    setSongInfo(playTitle, playArtist, playAlbumArt);
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
                    setSongInfo(playTitle, playArtist, playAlbumArt);
                } else {
                    mSongIndex--;
                    setSongInfo(playTitle, playArtist, playAlbumArt);
                }
            }
        });

        final Button navigateBackButton = findViewById(R.id.navigate_back_button);
        navigateBackButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create a new intent to open the main screen with the playlist.
                Intent playListIntent = new Intent(PlayScreen.this, MainActivity.class);

                // Start the new activity
                startActivity(playListIntent);
            }
        });
    }

    /**
     * Method for displaying current song info.
     * @param title TextView for displaying song title.
     * @param artist TextView for displaying artist.
     */
    private void setSongInfo(TextView title, TextView artist, ImageView albumArt) {
        mCurrentSong = songs.get(mSongIndex);
        mTitle = mCurrentSong.getSongName();
        mArtist = mCurrentSong.getArtist();
        mAlbumArt = getResources().getIdentifier(mCurrentSong.getAlbumArt(), "drawable", "no.larsvidar.musicplayer");


        title.setText(mTitle);
        artist.setText(mArtist);
        albumArt.setImageResource(mAlbumArt);
    }


}
