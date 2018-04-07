package no.larsvidar.musicplayer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //Making songs ArrayList public and static so it can be accessed by other classes.
    public static ArrayList<Song> songs = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Filling up the songs array with songs.
        songs.add(new Song("A Kind Of Magic", "Queen", "#", "thumb"));
        songs.add(new Song("Dynamite", "Scorpions", "#", "thumb"));
        songs.add(new Song("Got My Mind Set On You", "George Harrison", "#", "thumb"));
        songs.add(new Song("Bohemian Rhapsody", "Queen", "#", "thumb"));
        songs.add(new Song("Mastermind", "Mike Oldfield", "#", "thumb"));
        songs.add(new Song("Heart Of Glass", "Blondie", "#", "thumb"));
        songs.add(new Song("End Game", "Taylor Swift", "#", "thumb"));
        songs.add(new Song("Ma Baker", "Boney M", "#", "thumb"));
        songs.add(new Song("Cocaine", "Eric Clapton", "#", "thumb"));
        songs.add(new Song("All That She Wants", "Ace Of Base", "#", "thumb"));

        //Initializing adapter for ListView.
        SongAdapter adapter = new SongAdapter(this, songs);

        //Attaching ListView to list-TextView in activity_main.xml.
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(adapter);

        //Attaching an onClickListener to each item in the ListView.
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parentView, View view, int position, long row) {

                // Create a new intent to open the play screen
                Intent playIntent = new Intent(MainActivity.this, PlayScreen.class);

                // Sending the index of the item that is pressed in the ListView.
                playIntent.putExtra("songIndex", position);

                // Start the new activity
                startActivity(playIntent);
            }
        });
    }
}
