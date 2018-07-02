package com.example.ruben.filereader.presenter;

public interface SubscribeCallback {

    void onNext();

    void onError();

    void onComplete();

}
