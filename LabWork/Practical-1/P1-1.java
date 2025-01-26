// Study of Class Path and Java Runtime Environment

public class ClassPathExample {
    public static void main(String[] args) {
        // Displaying the Java class path
        System.out.println("Java Class Path: " + System.getProperty("java.class.path"));
        // Displaying Java runtime environment details
        System.out.println("Java Runtime Environment: " + System.getProperty("java.runtime.name"));
        System.out.println("Java Version: " + System.getProperty("java.version"));
    }
}
