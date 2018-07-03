package com.example.ruben.filereader;

import android.app.Application;

import com.example.ruben.di.ApplicationComponent;
import com.example.ruben.di.ApplicationModule;
import com.example.ruben.di.DaggerApplicationComponent;

public class FileReaderApplication extends Application {

    protected ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initializeInjector();
    }

    private void initializeInjector() {
        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this)).build();
        applicationComponent.inject(this);
    }

    public void setComponent(ApplicationComponent component) {
        this.applicationComponent = component;
    }

    public ApplicationComponent getComponent() {
        return applicationComponent;
    }
}
