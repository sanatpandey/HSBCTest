package com.test.hsbctest;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.test.hsbctest.presenter.ReadingFilePresenter;
import com.test.hsbctest.views.ReadingFileView;

import androidx.annotation.Nullable;

public class ReadingFile extends Activity implements ReadingFileView {

    private TextView tvInputFileData;
    private ReadingFilePresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.reading_file_activity);
        presenter = new ReadingFilePresenter(this, this);
        initView();
        setUpView();
    }

    private void setUpView() {
        presenter.readFile("input.txt");
    }

    private void initView(){
        tvInputFileData = findViewById(R.id.tvInputFileData);
    }

    @Override
    public void readFileSuccess(String fileFromAssets) {
        Toast.makeText(this, fileFromAssets, Toast.LENGTH_LONG).show();
        tvInputFileData.setText(fileFromAssets);
        presenter.reverseString(fileFromAssets);
    }

    @Override
    public void reverseStringSuccess(String reversedString) {
        Toast.makeText(this, "Reversed String: "+reversedString, Toast.LENGTH_LONG).show();
        presenter.writeToFile(reversedString, this);
    }

    @Override
    public void writeFileSuccess() {
        Toast.makeText(this, "The reversed text written to file config.txt in sandbox area of application", Toast.LENGTH_LONG).show();
    }

    @Override
    public void readFileFailed() {
        Toast.makeText(this, "Sorry!! Reading file from assests gets failed", Toast.LENGTH_LONG).show();
    }

    @Override
    public void writeFileFailed() {
        Toast.makeText(this, "Sorry!! Writing a file gets failed", Toast.LENGTH_LONG).show();
    }
}
