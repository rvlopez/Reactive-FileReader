package com.example.ruben.filereader.model.datasource;

import java.io.BufferedReader;
import java.io.FileReader;

import io.reactivex.Flowable;

public class FileReaderDataSource {

    public Flowable<String> read(String filePath) {
        return Flowable.generate(
                () -> new BufferedReader(new FileReader(filePath)),
                (reader, emitter) -> {
                    final String line = reader.readLine();
                    while (line != null) {
                        String[] splitted = line.split("\\s+");
                        for (String word : splitted) {
                            emitter.onNext(word);
                        }
                    }
                    emitter.onComplete();
                },
                BufferedReader::close
        );
    }
}
