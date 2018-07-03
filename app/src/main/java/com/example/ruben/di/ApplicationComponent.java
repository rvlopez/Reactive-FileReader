package com.example.ruben.di;

import com.example.ruben.filereader.FileReaderApplication;
import com.example.ruben.filereader.di.FileReaderComponent;
import com.example.ruben.filereader.di.FileReaderModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    void inject(FileReaderApplication application);

    // Sub-components
    FileReaderComponent fileReaderComponent(FileReaderModule module);
}
