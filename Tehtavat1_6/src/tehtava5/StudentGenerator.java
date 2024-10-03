package tehtava5;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class StudentGenerator {

    private static final String[] NAMES = {"Alice", "Bob", "Charlie", "David", "Eve", "Frank", "Grace", "Hannah", "Ian", "Judy"};
    private static final String[] ADDRESSES = {"123 Main St", "456 Oak St", "789 Pine St", "101 Maple Ave", "202 Birch Rd"};

    private static final List<String> COURSES = Arrays.asList("Math", "Science", "History", "English", "Art");

    public static void main(String[] args) {
        List<Student> students = generateStudents(10);
        String filename = "students.json";

        // Save students to a JSON file
        saveToJsonFile(students, filename);

        // Read students from the JSON file
        List<Student> readStudents = readFromJsonFile(filename);
        readStudents.forEach(System.out::println);
    }

    private static List<Student> generateStudents(int count) {
        List<Student> students = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < count; i++) {
            String name = NAMES[random.nextInt(NAMES.length)];
            int age = 18 + random.nextInt(10);
            String address = ADDRESSES[random.nextInt(ADDRESSES.length)];
            List<String> completedCourses = getRandomCourses(random);

            students.add(new Student(name, age, address, completedCourses));
        }

        return students;
    }

    private static List<String> getRandomCourses(Random random) {
        int numCourses = random.nextInt(COURSES.size() + 1);
        List<String> selectedCourses = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            selectedCourses.add(COURSES.get(random.nextInt(COURSES.size())));
        }
        return selectedCourses;
    }

    private static void saveToJsonFile(List<Student> students, String filename) {
        Gson gson = new Gson();
        try (FileWriter writer = new FileWriter(filename)) {
            gson.toJson(students, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<Student> readFromJsonFile(String filename) {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader(filename)) {
            Type studentListType = new TypeToken<List<Student>>() {}.getType();
            return gson.fromJson(reader, studentListType);
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}

