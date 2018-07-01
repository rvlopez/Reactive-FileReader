package com.example.ruben.filereader.model.repository;

import io.reactivex.Flowable;

public interface FileReaderRepository {

    Flowable<String> readFIle(String path);
}
