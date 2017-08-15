package com.alexbernat.homework9;

import android.util.Log;

import com.alexbernat.domain.entity.Picture;
import com.alexbernat.domain.interaction.PictureArrayUseCase;

import java.util.ArrayList;

import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;

/**
 * Created by Александр on 14.08.2017.
 */
public class ItemViewModel {

        String link;
        ArrayList<Picture> picturesArray;
        private PictureArrayUseCase useCase = new PictureArrayUseCase();

        public ItemViewModel(){
                picturesArray = new ArrayList<>();
                useCase.execute(10, new DisposableObserver<ArrayList<Picture>>() {
                        @Override
                        public void onNext(@NonNull ArrayList<Picture> pictures) {
                                picturesArray = pictures;
                        }

                        @Override
                        public void onError(@NonNull Throwable e) {
                        }

                        @Override
                        public void onComplete() {
                                Log.e("ItemViewModel", "ArrayList is created");
                        }
                });
        }

        public String getLinkToPicture() {
                return link;
        }

        public void setLinkToPicture(String linkToPicture) {
                this.link = linkToPicture;
        }

        public ArrayList<Picture> getPicturesArray() {
                return picturesArray;
        }
}
