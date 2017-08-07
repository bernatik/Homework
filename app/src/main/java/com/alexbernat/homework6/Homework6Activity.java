package com.alexbernat.homework6;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.alexbernat.homework.R;

import java.util.ArrayList;

public class Homework6Activity extends Activity {

    RecyclerView rvGallery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homework6);

        rvGallery = (RecyclerView)findViewById(R.id.rv_homework6);

        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        rvGallery.setLayoutManager(layoutManager);

        ArrayList<String> pictureUrls = new ArrayList<>();
        pictureUrls.add("https://s-media-cache-ak0.pinimg.com/236x/ee/cf/37/eecf37527700cce34dc313737203ccc2--comedy-movies-hd-movies.jpg");
        pictureUrls.add("https://s-media-cache-ak0.pinimg.com/originals/b0/75/68/b07568db6c706ac6f0bb63c5dee21d5d.jpg");
        pictureUrls.add("https://s-media-cache-ak0.pinimg.com/236x/5b/bc/09/5bbc0921b795fb5a24a32404caf040a8--film-poster-movie-posters.jpg");
        pictureUrls.add("https://s-media-cache-ak0.pinimg.com/236x/3e/2a/2b/3e2a2b4f7eadd7d1ec403373438c549e--hd-movies-movies-free.jpg");
        pictureUrls.add("https://s-media-cache-ak0.pinimg.com/236x/27/09/2b/27092bbb5f20a43c7e04e46429de4964.jpg");
        pictureUrls.add("https://www.movie2free.com/wp-content/uploads/2015/05/SmallSoldiers1.jpg");
        pictureUrls.add("https://s-media-cache-ak0.pinimg.com/originals/57/c4/8b/57c48b8dfde29e078ed46ed8a3dddadb.jpg");
        pictureUrls.add("https://s-media-cache-ak0.pinimg.com/236x/b5/11/6c/b5116cf85b309b39f201d780c1a235a7--ip-man-man-.jpg");
        pictureUrls.add("https://s-media-cache-ak0.pinimg.com/236x/13/81/30/138130c7ff0ee9da2a26e88935f49476--watch-free-movies-movies-free.jpg");
        pictureUrls.add("https://i.pinimg.com/236x/28/94/1f/28941fd4d1e50ba307b12cfdbce192bc--kung-fu-movies--movie.jpg");

        Homework6Adapter adapter = new Homework6Adapter(pictureUrls, this);

        adapter.setClickListener(new Homework6Adapter.OnItemClickListener() {
            @Override
            public void onItemClick(String item) {
                Toast.makeText(Homework6Activity.this, "onItemClick " + item, Toast.LENGTH_SHORT).show();
            }
        });
        rvGallery.setAdapter(adapter);

    }
}
