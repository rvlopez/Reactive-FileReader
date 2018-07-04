package com.example.ruben.filereader.model.repository;

import com.example.ruben.filereader.model.datasource.FileReaderDataSource;

import java.io.File;

import javax.inject.Inject;

import io.reactivex.Flowable;

public class FileReaderRepositoryImpl implements FileReaderRepository {

    private FileReaderDataSource fileReaderDataSource;

    @Inject
    public FileReaderRepositoryImpl(FileReaderDataSource fileReaderDataSource) {
        if (fileReaderDataSource == null) {
            throw new IllegalArgumentException("FileReaderDataSource parameters can't be null");
        }
        this.fileReaderDataSource = fileReaderDataSource;
    }

    @Override
    public Flowable<String> readFIle(File file) {
        return fileReaderDataSource.read(file);
    }
}
