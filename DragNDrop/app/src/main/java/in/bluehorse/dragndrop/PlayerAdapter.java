package in.bluehorse.dragndrop;

import android.content.Context;
import android.graphics.Movie;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by kiit on 27-03-2017.
 */

public class PlayerAdapter extends RecyclerView.Adapter<PlayerAdapter.ViewHolder> {

    private Context mContext;
    private ArrayList<Player> mMovies;

    public PlayerAdapter(Context context, ArrayList<Player> movies){
        this.mContext = context;
        this.mMovies = movies;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.list_item_movie, parent, false));
    }

    @Override
    public void onBindViewHolder(PlayerAdapter.ViewHolder holder, int position) {
       // holder.bindMovie(mMovies.get(position));
        holder.movieNameTextView.setText(mMovies.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return mMovies.size();
    }

    public void remove(int position) {
        mMovies.remove(position);
        notifyItemRemoved(position);
    }

    public void swap(int firstPosition, int secondPosition){
        Collections.swap(mMovies, firstPosition, secondPosition);
        notifyItemMoved(firstPosition, secondPosition);
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public  TextView movieNameTextView;

        public ViewHolder(View view){
            super(view);
            movieNameTextView = (TextView) view.findViewById(R.id.movie_name);
        }


    }
}
