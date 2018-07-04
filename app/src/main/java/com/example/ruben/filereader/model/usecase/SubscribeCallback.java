package com.example.ruben.filereader.model.usecase;

public interface SubscribeCallback {

    void onNext(String word);

    void onError(Throwable error);

    void onComplete();

}
