package ua.nure.fedorenko.player.adapter;

import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import ua.nure.fedorenko.player.R;
import ua.nure.fedorenko.player.entity.Song;


public class SongAdapter extends RecyclerView.Adapter<SongAdapter.ViewHolder> {

    private List<Song> songs;
    @Nullable
    private SongListener songListener;

    public SongAdapter(List<Song> songs) {
        this.songs = songs;
    }

    public void setSongListener(@Nullable SongListener songListener) {
        this.songListener = songListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.song, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Song song = songs.get(position);
        holder.titleTextView.setText(song.getTitle());
        holder.artistTextView.setText(song.getArtist());
    }

    @Override
    public int getItemCount() {
        return songs.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView titleTextView;
        TextView artistTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.song_title);
            artistTextView = itemView.findViewById(R.id.song_artist);
        }

        @Override
        public void onClick(View view) {
            if (songListener != null) {
                songListener.onSongSelected(getAdapterPosition());
            }
        }
    }

    public interface SongListener {
        void onSongSelected(long id);
    }
}
