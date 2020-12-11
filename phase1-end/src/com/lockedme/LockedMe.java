package com.lockedme;

public class LockedMe implements AppLogic {
    @Override
    public void welcome() {
        System.out.println("Welcome to the LockedMe Application - Company Lockers Pvt. Ltd.");
        System.out.println("Developed by Orion Carroll\n-----------------------------");
        System.out.println("Please select an option:");
        System.out.println("1 - View all files in the directory");
        System.out.println("2 - Add/Delete/Search files");
        System.out.println("3 - Close the application");
        System.out.println("-----------------------------");
    }

    @Override
    public void displayUI() {
        System.out.println("Please select an option:");
        System.out.println("1 - Add File");
        System.out.println("2 - Delete File");
        System.out.println("3 - Search for File");
        System.out.println("-----------------------------");
    }

    @Override
    public void closeApp() {
        System.out.println("Closing Application - Thank you for using LockedMe.");
        System.out.println("-----------------------------");
    }

    @Override
    public void addFile() {

    }

    @Override
    public void deleteFile() {

    }

    @Override
    public void searchFile() {

    }
}
