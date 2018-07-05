package com.example.ruben.filereader.model.datasource;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javax.inject.Inject;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;

public class FileReaderDataSource {

    @Inject
    public FileReaderDataSource() {
    }

    public Flowable<String> read(File file) {
        return Flowable.create(emitter -> {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            final String line = bufferedReader.readLine();
            if (line != null) {
                String[] splitted = line.split("[\\p{Punct}\\s]+");
                for (String word : splitted) {
                    Thread.sleep(1000);
                    emitter.onNext(word);
                }
                emitter.onComplete();
            } else {
                emitter.onComplete();
            }
        }, BackpressureStrategy.BUFFER);
    }
}
