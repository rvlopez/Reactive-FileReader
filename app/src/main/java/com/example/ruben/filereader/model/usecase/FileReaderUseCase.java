package com.example.ruben.filereader.model.usecase;

import com.example.ruben.filereader.model.repository.FileReaderRepository;

import java.io.File;

import javax.inject.Inject;

import io.reactivex.Flowable;

public class FileReaderUseCase extends Interactor {

    private final FileReaderRepository fileReaderRepository;

    @Inject
    public FileReaderUseCase(FileReaderRepository fileReaderRepository) {
        if (fileReaderRepository == null) {
            throw new IllegalArgumentException("FileReaderRepository must have valid parameters");
        }
        this.fileReaderRepository = fileReaderRepository;
    }

    public void execute(File file, SubscribeCallback subscribeCallback) {
        super.execute(file, subscribeCallback);
    }

    @Override
    protected Flowable<String> buildObservable(File file) {
        return fileReaderRepository.readFIle(file);
    }
}
