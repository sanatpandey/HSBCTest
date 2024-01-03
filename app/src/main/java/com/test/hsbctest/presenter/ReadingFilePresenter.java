package com.test.hsbctest.presenter;

import android.content.Context;

import com.test.hsbctest.views.ReadingFileView;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;

public class ReadingFilePresenter {
    private ReadingFileView view;
    private Context context;
    public ReadingFilePresenter(ReadingFileView view, Context context){
        this.view = view;
        this.context = context;
    }

    public void readFile(String inputFile){
        String tContents = "";

        try {
            InputStream stream = context.getAssets().open(inputFile);

            int size = stream.available();
            byte[] buffer = new byte[size];
            stream.read(buffer);
            stream.close();
            tContents = new String(buffer);
            view.readFileSuccess(tContents);
        } catch (IOException e) {
            view.readFileFailed();
        }
    }

    public void reverseString(String inputString){
        //String reversed = new StringBuilder(s).reverse().toString();
        char[] s = inputString.toCharArray();
        int n = s.length;
        int halfLength = n / 2;
        for (int i=0; i<halfLength; i++)
        {
            char temp = s[i];
            s[i] = s[n-1-i];
            s[n-1-i] = temp;
        }
        view.reverseStringSuccess(new String(s));
    }

    public void writeToFile(String data, Context context) {
        try {
            OutputStreamWriter outputStreamWriter = getOutputStreamWriter();
            outputStreamWriter.write(data);
            outputStreamWriter.close();
            view.writeFileSuccess();
        }
        catch (IOException e) {
            view.writeFileFailed();
        }
    }

    public OutputStreamWriter getOutputStreamWriter() throws FileNotFoundException {
        return new OutputStreamWriter(context.openFileOutput("config.txt", Context.MODE_PRIVATE));
    }
}
