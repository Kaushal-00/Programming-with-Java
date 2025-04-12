import java.util.*;

class Student {
    int id;
    String name;

    Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String toString() {
        return "ID: " + id + ", Name: " + name;
    }
}

public class CollectionAPI {

    public static void main(String[] args) {

        ArrayList<Student> studentList = new ArrayList<>();

        studentList.add(new Student(101, "Kaushal"));
        studentList.add(new Student(102, "Henil"));
        studentList.add(new Student(103, "Karan"));

        System.out.println("All Students (ArrayList):");
        for (Student s : studentList) {
            System.out.println(s);
        }

        for (Student s : studentList) {
            if (s.id == 102) {
                s.name = "Updated Henil";
            }
        }

        System.out.println("\n After Update (ID: 102):");
        for (Student s : studentList) {
            System.out.println(s);
        }

        studentList.removeIf(s -> s.id == 101);

        System.out.println("\nAfter Delete (ID: 101):");
        for (Student s : studentList) {
            System.out.println(s);
        }

        LinkedList<String> subjects = new LinkedList<>();
        subjects.add("Math");
        subjects.add("Science");
        subjects.add("English");

        System.out.println("\nSubjects (LinkedList):");
        for (String sub : subjects) {
            System.out.println(sub);
        }

        HashSet<String> cities = new HashSet<>();
        cities.add("Anand");
        cities.add("Vadodara");
        cities.add("Anand"); // duplicate, won't be added

        System.out.println("\nCities (HashSet - Unique Only):");
        for (String city : cities) {
            System.out.println(city);
        }

        LinkedHashMap<Integer, Integer> marks = new LinkedHashMap<>();
        marks.put(101, 85);
        marks.put(102, 90);
        marks.put(103, 78);

        System.out.println("\n Marks (LinkedHashMap - Insertion Order):");
        for (Map.Entry<Integer, Integer> entry : marks.entrySet()) {
            System.out.println("Roll: " + entry.getKey() + ", Marks: " + entry.getValue());
        }

        TreeMap<Integer, String> studentMap = new TreeMap<>();
        studentMap.put(103, "Karan");
        studentMap.put(101, "Kaushal");
        studentMap.put(102, "Henil");

        System.out.println("\nStudents (TreeMap - Sorted by Key):");
        for (Map.Entry<Integer, String> entry : studentMap.entrySet()) {
            System.out.println("Roll: " + entry.getKey() + ", Name: " + entry.getValue());
        }
    }
}
