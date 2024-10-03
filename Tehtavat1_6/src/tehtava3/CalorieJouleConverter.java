package tehtava3;
import java.util.Scanner;

public class CalorieJouleConverter {
    public static final double CALORIES_TO_JOULES = 4.184;
    public static final double JOULES_TO_CALORIES = 0.2390;

    // Method to display the menu and prompt the user for a choice
    public static void displayMenu() {
        System.out.println("\nChoose a conversion:");
        System.out.println("1. Convert calories to joules");
        System.out.println("2. Convert joules to calories");
        System.out.println("3. Exit");
        System.out.print("Enter your choice (1/2/3): ");
    }

    public static void convertCaloriesToJoules() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of calories: ");
        double calories = scanner.nextDouble();
        double joules = calories * CALORIES_TO_JOULES;
        System.out.println(calories + " calories = " + joules + " joules");
    }

    public static void convertJoulesToCalories() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of joules: ");
        double joules = scanner.nextDouble();
        double calories = joules * JOULES_TO_CALORIES;
        System.out.println(joules + " joules = " + calories + " calories");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            displayMenu();
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    convertCaloriesToJoules();
                    break;
                case 2:
                    convertJoulesToCalories();
                    break;
                case 3:
                    System.out.println("Exiting the program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please select 1, 2, or 3.");
                    break;
            }
        } while (choice != 3);
    }
}
