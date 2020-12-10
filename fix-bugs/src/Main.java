import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    //ADDED: arr made global--no need to create it each time optionsSelected() is called
    final static String[] arr = {"1. I wish to review my expenditure",
            "2. I wish to add my expenditure",
            "3. I wish to delete my expenditure",
            "4. I wish to sort the expenditures",
            "5. I wish to search for a particular expenditure",
            "6. Close the application"
    };

    //ADDED: expenses made global to save results each time optionsSelected() is called
    static ArrayList<Integer> expenses;

    public static void main(String[] args) {
        //ADDED: moved initialization outside of optionsSelected() so changes to data are not overwritten
        expenses = new ArrayList<>();
        expenses.add(1000);
        expenses.add(2300);
        expenses.add(45000);
        expenses.add(32000);
        expenses.add(110);

        System.out.println("\n**************************************\n");
        System.out.println("\tWelcome to TheDesk \n");
        System.out.println("**************************************");
        optionsSelection();

    }

    private static void optionsSelection() {
        for (String s : arr) {
            System.out.println(s);
        }
        System.out.println("\nEnter your choice:\t");
        Scanner sc = new Scanner(System.in);
        int options = sc.nextInt();
        //REMOVED: unnecessary for loop
        switch (options) {
            case 1 -> {
                System.out.println("Your saved expenses are listed below: \n");
                System.out.println(expenses + "\n");
                optionsSelection();
            }
            case 2 -> {
                //ADDED: handling of invalid input
                System.out.println("Enter the value to add your Expense: \n");
                try {
                    int value = sc.nextInt();
                    expenses.add(value);
                    System.out.println("Your value is updated\n");
                    System.out.println(expenses + "\n");
                } catch (Exception e) {
                    System.out.println("Invalid input.");
                } finally {
                    optionsSelection();
                }
            }
            case 3 -> {
                //ADDED: handling of invalid input
                System.out.println("You are about the delete all your expenses! \nConfirm again by selecting the same option...\n");
                try {
                    int con_choice = sc.nextInt();
                    if (con_choice == options) {
                        expenses.clear();
                        System.out.println(expenses + "\n");
                        System.out.println("All your expenses are erased!\n");
                    } else {
                        System.out.println("Oops... try again!");
                    }
                } catch (Exception e) {
                    System.out.println("Oops... try again!");
                } finally {
                    optionsSelection();
                }
            }
            case 4 -> {
                sortExpenses(expenses);
                optionsSelection();
            }
            case 5 -> {
                searchExpenses(expenses);
                optionsSelection();
            }
            case 6 -> closeApp();
            default -> System.out.println("You have made an invalid choice!");
        }
    }

    private static void closeApp() {
        System.out.println("Closing your application... \nThank you!");
    }

    private static void searchExpenses(ArrayList<Integer> arrayList) {
        System.out.println("Enter the expense you need to search:\t");
        Scanner scanner = new Scanner(System.in);
        try{
            int input = scanner.nextInt();
            if (arrayList.contains(input)) {
                System.out.println(input + " is in the database");
            } else {
                System.out.println(input + " is not in the database");
            }
        } catch (Exception e){
            System.out.println("Invalid search token");
        }

    }

    private static void sortExpenses(ArrayList<Integer> arrayList) {
        System.out.println("Sorted.");
        Collections.sort(arrayList);
    }
}
