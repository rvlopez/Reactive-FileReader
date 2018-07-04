package com.example.ruben.filereader.presenter;

import com.example.ruben.filereader.view.IView;

import java.io.File;

public abstract class Presenter<V extends IView> {

    protected V view;

    public void start(File file) {
        if (view == null) {
            throw new IllegalArgumentException("Presenter's view can not be null.");
        }

        if (file != null) {
            initialize(file);
        }

    }

    protected abstract void initialize(File filePath);

    public void setView(V view) {
        this.view = view;
    }
}
