package com.example.ruben.filereader.di;

import com.example.ruben.filereader.view.activity.MainActivity;

import dagger.Subcomponent;

@Subcomponent(modules = FileReaderModule.class)
public interface FileReaderComponent {
    void inject(MainActivity mainActivity);
}
