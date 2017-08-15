package com.alexbernat.domain.interaction;

import com.alexbernat.domain.entity.Picture;
import com.alexbernat.domain.interaction.base.UseCase;

import java.util.ArrayList;

import io.reactivex.Observable;

/**
 * Created by Александр on 14.08.2017.
 */
public class PictureArrayUseCase extends UseCase<Integer, ArrayList<Picture>> {

        protected Observable<ArrayList<Picture>> buildUseCase() {

        ArrayList<Picture> picturesList = new ArrayList<>();
        Picture picture1 = new Picture();
        picture1.setLink("https://s-media-cache-ak0.pinimg.com/236x/ee/cf/37/eecf37527700cce34dc313737203ccc2--comedy-movies-hd-movies.jpg");
        picturesList.add(picture1);
        Picture picture2 = new Picture();
        picture2.setLink("https://s-media-cache-ak0.pinimg.com/236x/5b/bc/09/5bbc0921b795fb5a24a32404caf040a8--film-poster-movie-posters.jpg");
        picturesList.add(picture2);
        Picture picture3 = new Picture();
        picture3.setLink("https://s-media-cache-ak0.pinimg.com/236x/3e/2a/2b/3e2a2b4f7eadd7d1ec403373438c549e--hd-movies-movies-free.jpg");
        picturesList.add(picture3);
        Picture picture4 = new Picture();
        picture4.setLink("https://s-media-cache-ak0.pinimg.com/236x/27/09/2b/27092bbb5f20a43c7e04e46429de4964.jpg");
        picturesList.add(picture4);
        Picture picture5 = new Picture();
        picture5.setLink("https://www.movie2free.com/wp-content/uploads/2015/05/SmallSoldiers1.jpg");
        picturesList.add(picture5);
        Picture picture6 = new Picture();
        picture6.setLink("https://s-media-cache-ak0.pinimg.com/originals/57/c4/8b/57c48b8dfde29e078ed46ed8a3dddadb.jpg");
        picturesList.add(picture6);
        Picture picture7 = new Picture();
        picture7.setLink("https://s-media-cache-ak0.pinimg.com/236x/b5/11/6c/b5116cf85b309b39f201d780c1a235a7--ip-man-man-.jpg");
        picturesList.add(picture7);
        Picture picture8 = new Picture();
        picture8.setLink("https://s-media-cache-ak0.pinimg.com/236x/13/81/30/138130c7ff0ee9da2a26e88935f49476--watch-free-movies-movies-free.jpg");
        picturesList.add(picture8);
        Picture picture9 = new Picture();
        picture9.setLink("https://s-media-cache-ak0.pinimg.com/236x/13/81/30/138130c7ff0ee9da2a26e88935f49476--watch-free-movies-movies-free.jpg");
        picturesList.add(picture9);
        Picture picture10 = new Picture();
        picture10.setLink("https://i.pinimg.com/236x/28/94/1f/28941fd4d1e50ba307b12cfdbce192bc--kung-fu-movies--movie.jpg");
        picturesList.add(picture10);

        return Observable.just(picturesList);
    }
}
