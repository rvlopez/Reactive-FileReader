package com.example.ruben.filereader.presenter;

import com.example.ruben.filereader.model.usecase.FileReaderUseCase;
import com.example.ruben.filereader.model.usecase.SubscribeCallback;
import com.example.ruben.filereader.view.FileReaderView;

import java.io.File;
import java.util.Map;
import java.util.TreeMap;

public class PresenterImpl extends Presenter<FileReaderView> implements SubscribeCallback {

    private Map<String, Integer> wordsMap;
    private FileReaderUseCase fileReaderUseCase;

    public PresenterImpl(FileReaderUseCase fileReaderUseCase) {
        this.fileReaderUseCase = fileReaderUseCase;
    }

    @Override
    protected void initialize(File file) {
        initializeMap();
        fileReaderUseCase.execute(file, this);
    }

    private void initializeMap() {
         wordsMap = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
    }

    @Override
    public void onNext(String word) {
        updateMap(word);
        view.showData(wordsMap);
    }

    @Override
    public void onError(Throwable error) {
        view.showError(error);
    }

    @Override
    public void onComplete() {
        // File read is complete
    }

    private void updateMap(String word) {
        if (wordsMap.size() == 0) {
            wordsMap.put(word, 1);
        } else {
            if (wordsMap.containsKey(word)) {
                Integer integer = wordsMap.get(word);
                wordsMap.put(word, ++integer);
            } else {
                wordsMap.put(word, 1);
            }
        }
    }
}
