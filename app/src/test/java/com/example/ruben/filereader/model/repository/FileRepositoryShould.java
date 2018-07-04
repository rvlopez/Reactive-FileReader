package com.example.ruben.filereader.model.repository;

import com.example.ruben.filereader.model.datasource.FileReaderDataSource;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;

public class FileRepositoryShould {

    private FileReaderDataSource fileReaderDataSource;
    private FileReaderRepository fileReaderRepository;

    @Before
    public void setUp() {
        fileReaderDataSource = mock(FileReaderDataSource.class);
        fileReaderRepository = new FileReaderRepositoryImpl(fileReaderDataSource);
    }

    @Test(expected = IllegalArgumentException.class)
    public void throw_exception_with_invalid_arguments() {
        new FileReaderRepositoryImpl(null);
    }
}
