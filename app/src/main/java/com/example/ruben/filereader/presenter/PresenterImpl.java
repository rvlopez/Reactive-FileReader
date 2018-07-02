package com.example.ruben.filereader.presenter;

import com.example.ruben.filereader.model.usecase.FileReaderUseCase;
import com.example.ruben.filereader.view.FileReaderView;

import java.util.HashMap;
import java.util.Map;

public class PresenterImpl extends Presenter<FileReaderView> implements SubscribeCallback {

    private Map<String, Integer> wordsMap;
    private FileReaderUseCase fileReaderUseCase;

    public PresenterImpl(FileReaderUseCase fileReaderUseCase) {
        this.fileReaderUseCase = fileReaderUseCase;
    }

    @Override
    protected void initialize(String filePath) {
        initializeMap();
        fileReaderUseCase.execute(filePath, this);
    }

    private void initializeMap() {
         wordsMap = new HashMap<>();
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
        for (Map.Entry<String, Integer> entry : wordsMap.entrySet()) {
            if (entry.getKey().equalsIgnoreCase(word)) {
                entry.setValue(entry.getValue() + 1);
            } else {
                wordsMap.put(word, 1);
            }
        }
    }
}
