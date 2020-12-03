import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ValidationMain {
    private static ArrayList<String> employeeEmails;
    public static final String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
    public static final Pattern pattern = Pattern.compile(regex);

    public static void insert(String email) {
        employeeEmails.add(email);
    }

    public static boolean isValid(String email) {
        return pattern.matcher(email).matches();
    }

    public static void main(String[] args) {
        employeeEmails = new ArrayList<>();
        insert("test1@gmail.com");
        insert("test2@gmail.com");
        insert("test3@gmail.com");
        insert("test4@gmail.com");
        insert("test5@gmail.com");
        Scanner scan = new Scanner(System.in);
        do{
            System.out.println("Enter your email address:");
            System.out.println("Please enter 'exit' when finished.");
            String input = scan.next();
            if(input.equalsIgnoreCase("exit")) break;
            if (employeeEmails.contains(input)) {
                System.out.println("Email is already in the database.");
            } else if (isValid(input)){
                System.out.println("Email has been added to the database.");
                insert(input);
            } else {
                System.out.println("Email is invalid.");
            }
        }while(true);
        scan.close();
    }
}