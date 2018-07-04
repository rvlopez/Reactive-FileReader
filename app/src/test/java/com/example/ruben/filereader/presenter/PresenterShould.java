package com.example.ruben.filereader.presenter;

import com.example.ruben.filereader.view.IView;

import org.junit.Test;
import org.mockito.Mockito;

import java.io.File;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;

public class PresenterShould {

    @Test(expected = IllegalArgumentException.class) public void throw_exception_on_null_view() {
        Presenter presenter = Mockito.mock(Presenter.class, Mockito.CALLS_REAL_METHODS);
        presenter.setView(null);

        presenter.start(new File("foo"));
    }

    @Test public void start_correctly_with_valid_mock_presenter() {
        IView view = Mockito.mock(IView.class);
        Presenter presenter = Mockito.mock(Presenter.class, Mockito.CALLS_REAL_METHODS);
        doNothing().when(presenter).initialize(new File("foo"));

        presenter.setView(view);
        presenter.start(new File("foo"));

        verify(presenter).initialize(new File("foo"));
    }

    @Test public void start_correctly_with_valid_presenter() {
        IView view = Mockito.mock(IView.class);
        Presenter presenter = new Presenter() {

            @Override
            protected void initialize(File filePath) {

            }
        };

        Presenter spy = Mockito.spy(presenter);

        spy.setView(view);
        spy.start(new File("foo"));

        verify(spy).initialize(new File("foo"));
    }
}
