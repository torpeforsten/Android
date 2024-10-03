package tehtava4;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class IntegerArrayWithBufferedReader {

    public static void main(String[] args) {
        int[] values = new int[10];
        int index = 0;

        System.out.println("Please enter 10 integer values between 1 and 30:");

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            while (index < 10) {
                try {
                    System.out.print("Enter value " + (index + 1) + ": ");
                    String inputLine = br.readLine();
                    int input = Integer.parseInt(inputLine);

                    if (input >= 1 && input <= 30) {
                        values[index] = input;
                        index++;
                    } else {
                        System.out.println("Invalid input, please enter a number between 1 and 30.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a valid integer.");
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading input.");
        }

        System.out.println("\nYou entered the following values:");
        for (int i = 0; i < values.length; i++) {
            System.out.println("Value " + (i + 1) + ": " + values[i]);
        }
    }
}
