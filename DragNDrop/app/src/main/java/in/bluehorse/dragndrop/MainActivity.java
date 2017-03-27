package in.bluehorse.dragndrop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Setup RecyclerView
        RecyclerView movieRecyclerView = (RecyclerView) findViewById(R.id.movie_recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        movieRecyclerView.setLayoutManager(linearLayoutManager);

        // Setup Adapter
        PlayerAdapter movieAdapter = new PlayerAdapter(this, getMovies());
        movieRecyclerView.setAdapter(movieAdapter);

        // Setup ItemTouchHelper
        ItemTouchHelper.Callback callback = new MovieTouchHelper(movieAdapter);
        ItemTouchHelper helper = new ItemTouchHelper(callback);
        helper.attachToRecyclerView(movieRecyclerView);
    }

    private ArrayList<Player> getMovies(){
        ArrayList<Player> movieList = new ArrayList<>();
       movieList.add(new Player("Messi"));
        movieList.add(new Player("Ronaldo"));
        movieList.add(new Player("Sancez"));
        movieList.add(new Player("Ibrahmovic"));
        movieList.add(new Player("Rooney"));
        movieList.add(new Player("Neymar"));
        movieList.add(new Player("Lewandoski"));
        movieList.add(new Player("Torres"));
        movieList.add(new Player("Ozil"));
        return movieList;
    }
}
