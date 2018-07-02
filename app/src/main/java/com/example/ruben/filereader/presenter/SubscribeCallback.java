package com.example.ruben.filereader.presenter;

public interface SubscribeCallback {

    void onNext(String word);

    void onError(Throwable error);

    void onComplete();

}
