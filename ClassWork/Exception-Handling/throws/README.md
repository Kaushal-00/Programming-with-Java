## **`throws`**  

- The **`throws`** keyword in Java is used to declare exceptions that a method **might throw** but does not handle itself.  

---

### **Syntax of `throws`**
```java
returnType methodName(parameters) throws ExceptionType {
    // Code that might cause an exception
}
```
- ExceptionType is the type of exception that the method may throw.  
- The calling method must handle the exception using a `try-catch` block or declare it using `throws`.

---

### **Example 1: Declaring an Exception**

```java
import java.io.*;  

public class ThrowsExample {
    static void readFile() throws IOException {
        FileReader file = new FileReader("nonexistent.txt"); // File not found
        BufferedReader br = new BufferedReader(file);
        System.out.println(br.readLine());
    }

    public static void main(String[] args) throws IOException { 
        readFile(); // This method may throw an IOException
    }
}
```
**Output:**
```
- Exception in thread "main" java.io.FileNotFoundException: nonexistent.txt (No such file or directory)
```
- `readFile()` declares that it might throw an `IOException`, but it does not handle it. 
- The `main` method also declares `throws IOException`, so the program terminates if an exception occurs.

---

### **Example 2: Handling Exception in `main()`**

```java
import java.io.*;  

public class ThrowsExample {
    static void readFile() throws IOException {
        FileReader file = new FileReader("nonexistent.txt"); // File not found
        BufferedReader br = new BufferedReader(file);
        System.out.println(br.readLine());
    }

    public static void main(String[] args) {
        try {
            readFile(); // Calls method that might throw an exception
        } catch (IOException e) {
            System.out.println("Exception handled: " + e);
        }
    }
}
```
**Output:**
```
Exception handled: java.io.FileNotFoundException: nonexistent.txt (No such file or directory)
```
- Instead of letting the program crash, **we handle the exception using `try-catch`**.

---

### **Example 3: Declaring Multiple Exceptions**

```java
public class MultipleThrowsExample {
    static void process() throws ArithmeticException, NullPointerException {
        int x = 10 / 0; // Will throw ArithmeticException
    }

    public static void main(String[] args) {
        try {
            process();
        } catch (ArithmeticException | NullPointerException e) {
            System.out.println("Exception handled: " + e);
        }
    }
}
```
**Output:**
```
Exception handled: java.lang.ArithmeticException: / by zero
```
- A method **can declare multiple exceptions** using `,` separated values.

---

### **Difference Between `throw` and `throws`**
| Feature      | `throw` | `throws` |
|-------------|--------|---------|
| Purpose | Used to throw an exception manually | Used to declare exceptions that a method might throw |
| Placement | Inside a method | In method signature |
| Number of Exceptions | Throws only one exception at a time | Can declare multiple exceptions |
| Example | `throw new ArithmeticException("Error");` | `void method() throws IOException, SQLException` |

---