package com.example.ruben.filereader.presenter;

import com.example.ruben.filereader.view.IView;

public abstract class Presenter<V extends IView> {

    protected V view;

    public void start(String filePath) {
        if (view == null) {
            throw new IllegalArgumentException("Presenter's view can not be null.");
        }

        if (filePath != null) {
            initialize(filePath);
        }

    }

    protected abstract void initialize(String filePath);

    public void setView(V view) {
        this.view = view;
    }
}
