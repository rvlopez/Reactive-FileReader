package com.example.ruben.filereader.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.ruben.filereader.R;
import com.example.ruben.filereader.presenter.Presenter;

public class MainActivity extends AppCompatActivity {

    private Presenter<FileReaderView> presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter.start();
    }
}
