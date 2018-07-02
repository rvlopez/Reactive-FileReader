package com.example.ruben.filereader.view.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.ruben.filereader.R;
import com.example.ruben.filereader.presenter.Presenter;
import com.example.ruben.filereader.view.adapter.FileReaderAdapter;
import com.example.ruben.filereader.view.FileReaderView;

import java.util.Map;

import javax.inject.Inject;

import butterknife.BindView;

public class MainActivity extends RootActivity implements FileReaderView {

    @Inject private FileReaderAdapter adapter;
    @Inject private Presenter<FileReaderView> presenter;

    @BindView(R.id.showNoResults) TextView showNoResults;
    @BindView(R.id.recyclerView) RecyclerView recyclerView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void showData(Map<String, Integer> wordsMap) {
        recyclerView.setVisibility(View.VISIBLE);
        adapter.setWordsMap(wordsMap);
    }

    @Override
    public void showError() {

    }

    @Override
    public void showNoResults() {

    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initializeInjector() {

    }

    @Override
    protected void initializeRecycler() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void initializePresenter() {
        presenter.setView(this);
        presenter.start();
    }
}
