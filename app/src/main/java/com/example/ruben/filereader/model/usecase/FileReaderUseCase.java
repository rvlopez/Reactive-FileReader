package com.example.ruben.filereader.model.usecase;

import com.example.ruben.filereader.model.repository.FileReaderRepository;
import com.example.ruben.filereader.presenter.SubscribeCallback;

import io.reactivex.Flowable;

public class FileReaderUseCase extends Interactor {

    private final FileReaderRepository fileReaderRepository;

    public FileReaderUseCase(FileReaderRepository fileReaderRepository) {
        if (fileReaderRepository == null) {
            throw new IllegalArgumentException("FileReaderRepository must have valid parameters");
        }
        this.fileReaderRepository = fileReaderRepository;
    }

    public void execute(String filePath, SubscribeCallback subscribeCallback) {
        super.execute(filePath, subscribeCallback);
    }


    @Override
    protected Flowable<String> buildObservable(String filePath) {
        return fileReaderRepository.readFIle(filePath);
    }
}
