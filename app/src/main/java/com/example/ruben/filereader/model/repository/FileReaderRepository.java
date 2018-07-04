package com.example.ruben.filereader.model.repository;

import java.io.File;

import io.reactivex.Flowable;

public interface FileReaderRepository {

    Flowable<String> readFIle(File file);
}
