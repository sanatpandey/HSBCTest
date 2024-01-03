package com.test.hsbctest;

import android.content.Context;

import com.test.hsbctest.presenter.ReadingFilePresenter;
import com.test.hsbctest.views.ReadingFileView;

import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.OutputStreamWriter;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

public class ReadingFilePresenterTest {

    private ReadingFilePresenter presenter;

    private ReadingFileView view;

    private Context context;

    @Before
    public void setUp(){
        view = mock(ReadingFileView.class);
        context = mock(Context.class);
        presenter = spy(new ReadingFilePresenter(view, context));
    }

    @Test
    public void readFile(){

    }

    @Test
    public void reverseStringSuccess(){
        presenter.reverseString("TEST");
        verify(view).reverseStringSuccess(any());
    }

    @Test
    public void writeToFileSuccess() throws FileNotFoundException {
        OutputStreamWriter outputStreamWriter = mock(OutputStreamWriter.class);
        doReturn(outputStreamWriter).when(presenter).getOutputStreamWriter();
        presenter.writeToFile("TEST", context);
        verify(view).writeFileSuccess();
    }
}
