package com.lockedme;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class LockedMe implements AppLogic {
    private final Scanner scanner;
    //root directory
    private final File root;
    //stores filenames of all files currently in directory
    List<String> allFileNames;
    //stores all directories
    List<File> directories;
    //flag used during search
    private static boolean foundFile;
    //stores file to be deleted so deleteFile() can utilize searchHelper()
    private File deleteCache;


    public LockedMe() {
        scanner = new Scanner(System.in);
        String rootPath = "C:\\Users\\orion.carroll\\my-applications\\sl-projects\\phase1-end\\root";
        System.out.println("Default root directory: " + rootPath);
        System.out.println("Would you like to change the root directory? [Y/n]");
        String yn = scanner.next().toLowerCase();
        switch (yn) {
            case "y" -> {
                System.out.println("Enter the absolute path of the desired root directory:");
                rootPath = scanner.next();
                root = new File(rootPath);
            }
            case "n" -> root = new File(rootPath);
            default -> {
                System.out.println("Invalid input. Using default directory.");
                root = new File(rootPath);
            }
        }
        welcome();
    }

    @Override
    public void welcome() {
        System.out.println("Welcome to the LockedMe Application - Company Lockers Pvt. Ltd.");
        System.out.println("Developed by Orion Carroll\n-----------------------------");
        System.out.println("Please select an option:");
        System.out.println("1 - View all files in the directory");
        System.out.println("2 - Add/Delete/Search files");
        System.out.println("3 - Close the application");
        System.out.println("-----------------------------");
        try {
            int input = Integer.parseInt(scanner.next());
            switch (input) {
                case 1 -> viewFiles(root);
                case 2 -> displayUI();
                case 3 -> closeApp();
                default -> {
                    System.out.println("Error: invalid input. Please select an option by entering a valid number.");
                    welcome();
                }
            }
        } catch (Exception e) {
            System.out.println("Error: invalid input. Please select an option by entering a valid number.");
            welcome();
        }

    }

    @Override
    public void displayUI() {
        System.out.println("Please select an option:");
        System.out.println("1 - Add File");
        System.out.println("2 - Delete File");
        System.out.println("3 - Search for File");
        System.out.println("4 - Return to Welcome Screen");
        System.out.println("-----------------------------");
        try {
            int input = scanner.nextInt();
            switch (input) {
                case 1 -> addFile();
                case 2 -> deleteFile();
                case 3 -> searchFile();
                case 4 -> welcome();
                default -> {
                    System.out.println("Error: invalid input. Please select an option by entering a valid number.");
                    displayUI();
                }
            }
        } catch (Exception e) {
            System.out.println("Error: invalid input. Please select an option by entering a valid number.");
            displayUI();
        }
    }

    @Override
    public void closeApp() {
        System.out.println("Closing Application - Thank you for using LockedMe.");
        System.out.println("-----------------------------");
        scanner.close();
    }

    @Override
    public void viewFiles(File dir) {
        allFileNames = new ArrayList<>();
        viewFilesHelper(dir);
        Collections.sort(allFileNames);
        System.out.println(allFileNames);
        welcome();
    }

    @Override
    public void addFile() {
        System.out.println("Enter the name of the file you'd like to add:");
        String fileName = scanner.next();
        System.out.println("Choose the directory you'd like to add the file to:");

        //displays directories
        directories = new ArrayList<>();
        getDirectories(root);
        for (int i = 0; i < directories.size(); i++) {
            System.out.println(i + " - " + directories.get(i));
        }

        //handle user's choice of directory
        int dirChoice;
        try {
            dirChoice = scanner.nextInt();
            if (dirChoice < 0 || dirChoice >= directories.size()) throw new Exception();
        } catch (Exception e) {
            System.out.println("Invalid choice. Adding to root directory");
            dirChoice = 0;
        }

        //add file
        File toAdd = new File(directories.get(dirChoice), fileName);
        boolean added = false;
        try {
            added = toAdd.createNewFile();
        } catch (IOException e) {
            System.out.println("Error: IOException. Returning to welcome screen.");
        }
        if (added) {
            System.out.println("File added successfully.");
        } else {
            System.out.println("Add file failed. File already exists.");
        }
        welcome();
    }


    @Override
    public void deleteFile() {
        System.out.println("Enter the name of the file you'd like to delete:");
        String toDelete = scanner.next();

        //check if file is in directory
        foundFile = false;
        searchHelper(root, toDelete);

        if (foundFile) {
            boolean deleteSuccess = deleteCache.delete();
            if (deleteSuccess) {
                System.out.println(toDelete + " has been deleted.");
            } else {
                System.out.println("Delete failed. " + toDelete + " has not been deleted.");
            }
        } else {
            System.out.println("File not found.");
        }
        welcome();
    }

    @Override
    public void searchFile() {
        System.out.println("Enter the name of the file you'd like to search:");
        String fileName = scanner.next();
        foundFile = false;

        //call helper function and set foundFile flag to true if file has been found
        searchHelper(root, fileName);
        if (foundFile) {
            System.out.println(fileName + " is in the directory.");
        } else {
            System.out.println(fileName + " is not in the directory.");
        }
        welcome();
    }

    //recursive method to view all subdirectories
    public void viewFilesHelper(File dir) {
        File[] files = dir.listFiles();
        if (files != null) {
            for (File f : files) {
                if (f.isDirectory()) {
                    viewFilesHelper(f);
                } else {
                    allFileNames.add(f.getName());
                }
            }
        } else {
            System.out.println("Not a valid directory.");
        }
    }

    //stores the names of all directories in global "directories"
    public void getDirectories(File dir) {
        directories.add(dir);
        File[] files = dir.listFiles();
        if (files != null) {
            for (File f : files) {
                if (f.isDirectory()) {
                    getDirectories(f);
                }
            }
        }
    }

    //recursive method to search all subdirectories
    public void searchHelper(File dir, String fileName) {
        if (foundFile) {
            return;
        }
        File[] files = dir.listFiles();
        if (files != null) {
            for (File f : files) {
                if (f.getName().equals(fileName)) {
                    foundFile = true;
                    //cache file if calling this method from deleteFile()
                    deleteCache = f;
                    break;
                } else if (f.isDirectory()) {
                    searchHelper(f, fileName);
                }
            }
        }
    }
}
