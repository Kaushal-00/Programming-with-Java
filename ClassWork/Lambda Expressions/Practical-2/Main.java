import java.util.*;

class Student {
    String name;
    int age;
    int grade;

    Student(String name, int age, int grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    void display() {
        System.out.println(name + " - Age: " + age + ", Grade: " + grade);
    }
}

// Functional Interface
@FunctionalInterface
interface StudentCondition {
    boolean test(Student s);
}

public class FilterStudent {

    static void filter(List<Student> list, StudentCondition condition) {
        for (Student s : list) {
            if (condition.test(s)) {
                s.display();
            }
        }
    }

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Kaushal", 19, 9));
        students.add(new Student("Henil", 17, 8));
        students.add(new Student("Karan", 20, 7));
        students.add(new Student("Rudra", 16, 6));

        System.out.println("Students age > 18:");
        filter(students, (s) -> s.age > 18);

        System.out.println("\nStudents grade >= 8:");
        filter(students, (s) -> s.grade >= 8);

        System.out.println("\nStudents name starts with K:");
        filter(students, new StudentCondition() {
            public boolean test(Student s) {
                return s.name.startsWith("K");
            }
        });
    }
}
