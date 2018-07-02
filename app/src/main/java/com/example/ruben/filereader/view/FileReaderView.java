package com.example.ruben.filereader.view;

import java.util.Map;

public interface FileReaderView extends IView {

    void showData(Map<String, Integer> wordsMap);

    void showError(Throwable error);
}
