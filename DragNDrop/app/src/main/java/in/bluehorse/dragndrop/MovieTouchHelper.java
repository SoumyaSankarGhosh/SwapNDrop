package in.bluehorse.dragndrop;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

/**
 * Created by kiit on 27-03-2017.
 */

public class MovieTouchHelper extends ItemTouchHelper.SimpleCallback {

    private PlayerAdapter mMovieAdapter;

    public MovieTouchHelper(PlayerAdapter movieAdapter){
        super(ItemTouchHelper.UP | ItemTouchHelper.DOWN, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT);
        this.mMovieAdapter = movieAdapter;
    }

    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        mMovieAdapter.swap(viewHolder.getAdapterPosition(), target.getAdapterPosition());
        return true;
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
        mMovieAdapter.remove(viewHolder.getAdapterPosition());
    }
}
