package com.example.ruben.filereader.model.repository;

import com.example.ruben.filereader.model.datasource.FileReaderDataSource;

import io.reactivex.Flowable;

public class FileRepositoryImpl implements FileRepository {

    private FileReaderDataSource fileReaderDataSource;

    public FileRepositoryImpl(FileReaderDataSource fileReaderDataSource) {
        if (fileReaderDataSource == null) {
            throw new IllegalArgumentException("FileReaderDataSource parameters can't be null");
        }
        this.fileReaderDataSource = fileReaderDataSource;
    }

    @Override
    public Flowable<String> readFIle(String path) {
        return fileReaderDataSource.read(path);
    }
}
