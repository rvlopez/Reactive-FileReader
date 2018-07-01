package com.example.ruben.filereader.presenter;

import com.example.ruben.filereader.model.usecase.FileReaderUseCase;
import com.example.ruben.filereader.view.FileReaderView;

public class PresenterImpl extends Presenter<FileReaderView> implements SubscribeCallback {

    private FileReaderUseCase fileReaderUseCase;

    public PresenterImpl(FileReaderUseCase fileReaderUseCase) {
        this.fileReaderUseCase = fileReaderUseCase;
    }

    @Override
    protected void initialize(String filePath) {
        fileReaderUseCase.execute(filePath, this);
    }

    @Override
    public void onNext() {

    }

    @Override
    public void onError() {

    }

    @Override
    public void onComplete() {

    }
}
