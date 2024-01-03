package com.test.hsbctest.views;

public interface ReadingFileView {
    public void readFileSuccess(String fileFromAssets);
    public void reverseStringSuccess(String reversedString);
    public void writeFileSuccess();
    public void readFileFailed();
    public void writeFileFailed();
}
