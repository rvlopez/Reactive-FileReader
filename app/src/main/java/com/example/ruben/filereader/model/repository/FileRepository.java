package com.example.ruben.filereader.model.repository;

import io.reactivex.Flowable;

public interface FileRepository {

    Flowable<String> readFIle(String path);
}
