package no.larsvidar.musicplayer;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;


class SongAdapter extends ArrayAdapter<Song> {
    public SongAdapter(Activity context, ArrayList<Song> songs) {

        super(context, 0, songs);
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.song_list, parent, false);
        }

        // Get the {@link AndroidFlavor} object located at this position in the list
        Song currentSong = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView songTitleTextView = (TextView) listItemView.findViewById(R.id.song_title_view);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        songTitleTextView.setText(currentSong.getSongName());

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView artistTextView = (TextView) listItemView.findViewById(R.id.artist_view);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        artistTextView.setText(currentSong.getArtist());

        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }
}
