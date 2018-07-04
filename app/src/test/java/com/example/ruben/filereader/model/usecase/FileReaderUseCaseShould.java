package com.example.ruben.filereader.model.usecase;

import com.example.ruben.filereader.model.repository.FileReaderRepository;

import org.junit.Test;

import java.io.File;

import io.reactivex.Flowable;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class FileReaderUseCaseShould {

    @Test(expected = IllegalArgumentException.class)
    public void throw_exception_with_invalid_parameters() {
        new FileReaderUseCase(null);
    }

    @Test public void call_repository_to_get_word() {
        FileReaderRepository mockRepository = mock(FileReaderRepository.class);
        when(mockRepository.readFIle(new File("foo"))).thenReturn(Flowable.empty());

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

        FileReaderUseCase useCase = new FileReaderUseCase(mockRepository);
        useCase.execute(new File("foo"), subscribeCallback);

        verify(mockRepository).readFIle(new File("foo"));
    }
}
