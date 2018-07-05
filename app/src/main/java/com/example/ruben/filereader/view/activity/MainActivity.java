package com.example.ruben.filereader.view.activity;

import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.ruben.filereader.FileReaderApplication;
import com.example.ruben.filereader.R;
import com.example.ruben.filereader.StreamUtils;
import com.example.ruben.filereader.di.FileReaderComponent;
import com.example.ruben.filereader.di.FileReaderModule;
import com.example.ruben.filereader.presenter.Presenter;
import com.example.ruben.filereader.view.adapter.FileReaderAdapter;
import com.example.ruben.filereader.view.FileReaderView;

import java.io.IOException;
import java.util.Map;

import javax.inject.Inject;

import butterknife.BindView;

public class MainActivity extends RootActivity implements FileReaderView {

    @Inject FileReaderAdapter adapter;
    @Inject Presenter<FileReaderView> presenter;

    @BindView(R.id.showNoResults) TextView showNoResults;
    @BindView(R.id.recyclerView) RecyclerView recyclerView;

    @Override
    public void showData(Map<String, Integer> wordsMap) {
        showNoResults.setVisibility(View.GONE);
        recyclerView.setVisibility(View.VISIBLE);
        adapter.setWordsMap(wordsMap);
    }

    @Override
    public void showError(Throwable error) {
        recyclerView.setVisibility(View.GONE);
        showNoResults.setVisibility(View.VISIBLE);
        showNoResults.setText(error.getMessage());
    }

    @Override
    public void dataLoadedComplete() {
        Snackbar.make(recyclerView, R.string.snackbar_message, Snackbar.LENGTH_LONG).show();
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initializeInjector() {
        FileReaderComponent fileReaderComponent = ((FileReaderApplication) getApplication())
                .getComponent().fileReaderComponent(new FileReaderModule());
        fileReaderComponent.inject(this);
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
        try {
            presenter.start(StreamUtils.streamToFile(
                    getResources().openRawResource(R.raw.light_file)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_activity_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.light_file:
                try {
                    presenter.start(StreamUtils.streamToFile(
                            getResources().openRawResource(R.raw.light_file)));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return true;
            case R.id.heavy_file:
                try {
                    presenter.start(StreamUtils.streamToFile(
                            getResources().openRawResource(R.raw.heavy_file)));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
