package com.lockedme;

public interface AppLogic {
    //navigation & display
    void welcome();
    void displayUI();
    void closeApp();

    //file handling
    void addFile();
    void deleteFile();
    void searchFile();
}
