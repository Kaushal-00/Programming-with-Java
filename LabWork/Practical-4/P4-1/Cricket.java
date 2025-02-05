public class Cricket {
    String name;
    int age;

    void setData(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void display() {
        System.out.println("Player's name: " + name);
        System.out.println("Player's age: " + age);
    }
}

class Match extends Cricket {
    int no_of_odi;
    int no_of_test;

    void setData(String name, int age, int no_of_odi, int no_of_test) {
        super.setData(name, age);
        this.no_of_odi = no_of_odi;
        this.no_of_test = no_of_test;
    }

    void display() {
        super.display();
        System.out.println("Number of ODIs: " + no_of_odi);
        System.out.println("Number of Test Matches: " + no_of_test);
        System.out.println("--------------------------");
    }
}