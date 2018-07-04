package com.example.ruben.filereader.model.datasource;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javax.inject.Inject;

import io.reactivex.Flowable;

public class FileReaderDataSource {

    @Inject
    public FileReaderDataSource() {
    }

    public Flowable<String> read(File file) {
        return Flowable.generate(
                () -> new BufferedReader(new FileReader(file)),
                (reader, emitter) -> {
                    final String line = reader.readLine();
                    if (line != null) {
                        String[] splitted = line.split("\\s+");
                        for (String word : splitted) {
                            emitter.onNext(word);
                        }
                    } else {
                        emitter.onComplete();
                    }
                },
                BufferedReader::close
        );
    }
}
