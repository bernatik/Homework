package com.alexbernat.homework9;

import com.alexbernat.base.BaseViewModel;
import com.alexbernat.domain.entity.Picture;
import com.alexbernat.domain.interaction.PictureArrayUseCase;

import java.util.ArrayList;

import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;

/**
 * Created by Александр on 14.08.2017.
 */
public class ItemViewModel implements BaseViewModel{

        String link;
        ArrayList<ItemViewModel> picturesArray;
        private PictureArrayUseCase useCase = new PictureArrayUseCase();

        public ItemViewModel(){
        }

        public String getLink() {
                return link;
        }

        public void setLink(String link) {
                this.link = link;
        }

        public ArrayList<ItemViewModel> getPicturesArray() {
                return picturesArray;
        }

        @Override
        public void init() {
                picturesArray = new ArrayList<>();
                useCase.execute(10, new DisposableObserver<Picture>() {
                        @Override
                        public void onNext(@NonNull Picture picture) {
                                ItemViewModel item = new ItemViewModel();
                                item.setLink(picture.getLink());
                                picturesArray.add(item);
                        }

                        @Override
                        public void onError(@NonNull Throwable e) {

                        }

                        @Override
                        public void onComplete() {

                        }
                });
        }

        @Override
        public void release() {
                useCase.dispose();
        }

        @Override
        public void resume() {

        }

        @Override
        public void pause() {

        }
}
