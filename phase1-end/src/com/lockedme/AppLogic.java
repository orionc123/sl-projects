package com.lockedme;

import java.io.File;

public interface AppLogic {
    //-----------navigation & display-----------
    //display welcome screen
    void welcome();
    //display UI for add/delete/search
    void displayUI();
    //exit application
    void closeApp();
    //view all files in the root directed sorted in ascending order
    void viewFiles(File dir);

    //-----------file handling-----------
    //add file to directory
    void addFile();
    //delete file from directory
    void deleteFile();
    //search for file in directory
    void searchFile();
}
