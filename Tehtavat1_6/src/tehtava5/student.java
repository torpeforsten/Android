package tehtava5;
import java.util.List;

class Student {
    private String name;
    private int age;
    private String address;
    private List<String> completedCourses;

    public Student(String name, int age, String address, List<String> completedCourses) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.completedCourses = completedCourses;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public List<String> getCompletedCourses() { return completedCourses; }
    public void setCompletedCourses(List<String> completedCourses) { this.completedCourses = completedCourses; }

    @Override
    public String toString() {
        return "Student{name='" + name + "', age=" + age + ", address='" + address + "', completedCourses=" + completedCourses + '}';
    }
}
