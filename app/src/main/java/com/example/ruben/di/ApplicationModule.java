package com.example.ruben.di;

import android.content.Context;

import com.example.ruben.filereader.FileReaderApplication;
import com.example.ruben.filereader.model.datasource.FileReaderDataSource;
import com.example.ruben.filereader.model.repository.FileReaderRepository;
import com.example.ruben.filereader.model.repository.FileReaderRepositoryImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    private final Context applicationContext;

    public ApplicationModule(FileReaderApplication applicationContext) {
        this.applicationContext = applicationContext.getApplicationContext();
    }

    @Provides
    @Singleton
    public FileReaderRepository provideFileReaderRepository(FileReaderDataSource fileReaderDataSource) {
        return new FileReaderRepositoryImpl(fileReaderDataSource);
    }

    @Provides @Singleton
    public Context provideApplicationContext() {
        return applicationContext;
    }
}