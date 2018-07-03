package com.example.ruben.filereader.di;

import com.example.ruben.filereader.model.usecase.FileReaderUseCase;
import com.example.ruben.filereader.model.usecase.Interactor;
import com.example.ruben.filereader.presenter.Presenter;
import com.example.ruben.filereader.presenter.PresenterImpl;
import com.example.ruben.filereader.view.FileReaderView;

import dagger.Module;
import dagger.Provides;

@Module
public class FileReaderModule {

    @Provides
    public Interactor provideFileReaderUseCase(FileReaderUseCase fileReaderUseCase) {
        return fileReaderUseCase;
    }

    @Provides
    public Presenter<FileReaderView> providePresenter(FileReaderUseCase fileReaderUseCase) {
        return new PresenterImpl(fileReaderUseCase);
    }

}
