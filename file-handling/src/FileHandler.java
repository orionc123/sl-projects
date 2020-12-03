import java.io.*;

public class FileHandler {
    //prints contents of file to System.out
    public static void readFile(String fileName) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(fileName)))) {
            String buffer;
            while ((buffer = bufferedReader.readLine()) != null) {
                System.out.println(buffer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //writes a single line of text to a file (overwrite)
    public static void writeFile(String fileName, String text) {
        try (FileWriter fileWriter = new FileWriter(new File(fileName), false)) {
            fileWriter.write(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //appends one line of text to a file
    public static void appendFile(String fileName, String text) {
        try (FileWriter fileWriter = new FileWriter(new File(fileName), true)) {
            fileWriter.write(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //writes multiple lines to a file (overwrite)
    public static void writeLines(String fileName, String text, int numLines){
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File(fileName), false))){
            for(int i=0; i <numLines;i++) {
                bufferedWriter.write(text + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //appends multiple lines to a file
    public static void appendLines(String fileName, String text, int numLines){
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File(fileName), true))){
            for(int i=0; i <numLines;i++) {
                bufferedWriter.write(text + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String f = "test.txt";
        readFile(f);
        writeFile(f, "This has overwritten the previous data.\n");
        readFile(f);
        appendFile(f, "This is appended data.");
        readFile(f);
        writeLines(f, "writeLines", 5);
        readFile(f);
        appendLines(f, "appendLines", 5);
        readFile(f);
    }
}
