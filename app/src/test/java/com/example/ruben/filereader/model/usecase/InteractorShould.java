package com.example.ruben.filereader.model.usecase;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.verify;
import org.reactivestreams.Subscriber;

import java.io.File;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.subscribers.TestSubscriber;

import static org.mockito.Mockito.spy;

public class InteractorShould {

    private Interactor interactor;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        interactor = new Interactor() {
            @Override
            protected Flowable<String> buildObservable(File file) {
                return Flowable.empty();
            }
        };
    }

    @Test public void create_subscription_correctly() {
        SubscribeCallback subscribeCallback = new SubscribeCallback() {
            @Override
            public void onNext(String word) {

            }

            @Override
            public void onError(Throwable error) {

            }

            @Override
            public void onComplete() {

            }
        };
        interactor.execute(new File("foo"), subscribeCallback);

    }
}
