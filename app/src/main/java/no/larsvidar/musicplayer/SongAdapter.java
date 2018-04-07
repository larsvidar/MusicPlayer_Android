package no.larsvidar.musicplayer;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


class SongAdapter extends ArrayAdapter<Song> {
    public SongAdapter(Activity context, ArrayList<Song> songs) {
        super(context, 0, songs);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //Checking if view is inflated.
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.song_list, parent, false);
        }

        //Get the current song-
        Song currentSong = getItem(position);

        //Saving the thumbnail ImageView to a variable.
        ImageView thumbnail = listItemView.findViewById(R.id.playlist_thumbnail);
        //Setting the thumbnail on the ImageView.
        int thumbImage = getContext().getResources().getIdentifier(currentSong.getAlbumArt(), "drawable", "no.larsvidar.musicplayer");
        thumbnail.setImageResource(thumbImage);

        //Saving the TextView for artist to a variable.
        TextView artistTextView = (TextView) listItemView.findViewById(R.id.artist_view);
        //Setting text on the TextView
        artistTextView.setText(currentSong.getArtist());

        //Saving the TextView for SongTitle to a variable.
        TextView songTitleTextView = (TextView) listItemView.findViewById(R.id.song_title_view);
        //Setting text on the TextView.
        songTitleTextView.setText(currentSong.getSongName());

        //Return the list item.
        return listItemView;
    }
}
