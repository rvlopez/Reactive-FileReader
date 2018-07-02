package com.example.ruben.filereader.model.usecase;

import com.example.ruben.filereader.presenter.SubscribeCallback;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.schedulers.Schedulers;

public abstract class Interactor {

    protected Disposable disposable = Disposables.empty();

    public void execute(String filePath, SubscribeCallback subscribeCallback) {
        disposable = buildObservable(filePath)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(
                        subscribeCallback::onNext,  //  nextEvent -> {subscribeCallback.onNext(nextEvent);}
                        subscribeCallback::onError, //error -> {subscribeCallback.onError(error);}
                        subscribeCallback::onComplete);
    }

    protected abstract Flowable<String> buildObservable(String filePath);

}
