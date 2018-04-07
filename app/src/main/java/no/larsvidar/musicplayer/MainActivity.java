package no.larsvidar.musicplayer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //Making songs ArrayList public and static so it can be accessed by other classes.
    public static ArrayList<Song> songs = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Filling up the songs array with songs.
        songs.add(new Song("A Kind Of Magic", "Queen", "http://hcmaslov.d-real.sci-nnov.ru/public/mp3/Queen/Queen%20'A%20Kind%20Of%20Magic'.mp3"));
        songs.add(new Song("Dynamite", "Scorpions", "http://hcmaslov.d-real.sci-nnov.ru/public/mp3/Scorpions/Scorpions%20'Dynamite'.mp3"));
        songs.add(new Song("Got My Mind Set On You", "George Harrison", "http://dora-robo.com/muzyka/70's-80's-90's%20/George%20Harrison%20-%20Got%20My%20Mind%20Set%20On%20You%20%5bJanuary%201988%5d.mp3"));
        songs.add(new Song("Bohemian Rhapsody", "Queen", "http://hcmaslov.d-real.sci-nnov.ru/public/mp3/Queen/Queen%20'Bohemian%20Rhapsody'.mp3"));
        songs.add(new Song("Mastermind", "Mike Oldfield", "http://www.replicaradio.ro/audio/oldfield/millenium/07.Mike%20Oldfield-Mastermind.mp3"));
        songs.add(new Song("Heart Of Glass", "Blondie", "http://dora-robo.com/muzyka/70's-80's-90's%20/Blondie%20-%20Heart%20of%20Glass.mp3"));
        songs.add(new Song("End Game", "Taylor Swift", "http://s1.mmdl.xyz/1396/08/18/Taylor%20Swift%20-%20Reputation/2%20End%20Game.mp3"));
        songs.add(new Song("Ma Baker", "Boney M", "http://dora-robo.com/muzyka/70's-80's-90's%20/Boney%20M.%20-%20Ma%20Baker.mp3"));
        songs.add(new Song("Cocaine", "Eric Clapton", "http://195.122.253.112/public/mp3/Eric%20Clapton/Eric%20Clapton%20'Cocaine'.mp3"));
        songs.add(new Song("All That She Wants", "Ace Of Base", "http://dora-robo.com/muzyka/70's-80's-90's%20/All%20That%20She%20Wants.mp3"));

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
