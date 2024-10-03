package tehtava2;

import java.util.ArrayList;
import java.util.Scanner;

public class IntegerStats {
    private ArrayList<Integer> numbers;
    public IntegerStats(){
        numbers = new ArrayList<>();
    }
    public void InputValues(){
        Scanner scanner = new Scanner(System.in);
        String input;
        System.out.println("Enter integer values (type 'done' to finnish):");
        while (true){
            input = scanner.next();
            if (input.equalsIgnoreCase("done")){
                break;
            }
            try {
                int number = Integer.parseInt(input);
                numbers.add(number);
            } catch (NumberFormatException e){
                System.out.println("Please enter a valid integer or type 'done' to finish.");
            }
        }
    }
    public int calculateSum(){
        int sum = 0;
        for (int num : numbers){
            sum += num;
        }
        return sum;
    }
    public int findSmallest() {
        int smallest = Integer.MAX_VALUE;
        for (int num : numbers) {
            if (num < smallest) {
                smallest = num;
            }
        }
        return smallest;
    }
    public int findLargest() {
        int largest = Integer.MIN_VALUE;
        for (int num : numbers) {
            if (num > largest) {
                largest = num;
            }
        }
        return largest;
    }
    public double calculateAverage() {
        if (numbers.isEmpty()) {
            return 0;
        }
        return (double) calculateSum() / numbers.size();
    }
    public void printResults() {
        if (!numbers.isEmpty()) {
            System.out.println("Sum: " + calculateSum());
            System.out.println("Smallest: " + findSmallest());
            System.out.println("Largest: " + findLargest());
            System.out.println("Average: " + calculateAverage());
        } else {
            System.out.println("No numbers were entered.");
        }
    }
}