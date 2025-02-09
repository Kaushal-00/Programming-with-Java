## **Try-Catch Block in Java**

- The try-catch block is used for exception handling in Java. It helps prevent program crashes by catching and handling runtime errors (exceptions).

---

### **Syntax of Try-Catch Block**
```java
try {
    // Code that might throw an exception
} catch (ExceptionType e) {
    // Code to handle the exception
}
```

---

### **How It Works**
1. **try block**: Contains the code that may cause an exception.
2. **catch block**: Catches and handles the exception if it occurs.
3. **If no exception occurs**, the catch block is **skipped**.
4. **If an exception occurs**, the catch block **executes** to handle the error.

---

### **Example: Handling ArithmeticException**
```java
public class TryCatchExample {
    public static void main(String[] args) {
        try {
            int result = 10 / 0; // This causes ArithmeticException
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Error: Cannot divide by zero!");
        }
        System.out.println("Program continues...");
    }
}
```
**Output:**
```
Error: Cannot divide by zero!
Program continues...
```

- Without try-catch, the program would crash.  
- With try-catch, the error is handled, and execution continues.

- **Scenario 1:** If `ArithmeticException` occurs (as in your code) 
- The `catch (ArithmeticException e)` block executes, and the program continues normally.

- **Scenario 2:** If another type of exception occurs (e.g., `NullPointerException`, `ArrayIndexOutOfBoundsException`) 
- Since there is no matching catch block, the program terminates abnormally, and an uncaught exception error occurs.


---

### **Multiple Catch Blocks**

```java
try {
    int arr[] = new int[3];
    arr[5] = 10;
} catch (ArithmeticException e) {
    System.out.println("Arithmetic Exception Occurred");
} catch (ArrayIndexOutOfBoundsException e) {
    System.out.println("Array Index Out of Bounds!");
} catch (Exception e) {
    System.out.println("Some other exception occurred");
}
```
**Output:**
```
Array Index Out of Bounds!
```
- Each catch block handles a specific exception.

---

### **Finally Block (Always Executes)**

- A `finally` block **always executes**, whether an exception occurs or not. It is useful for **clean-up operations** like closing files or database connections.

```java
try {
    int num = 5 / 0;
} catch (ArithmeticException e) {
    System.out.println("Exception handled.");
} finally {
    System.out.println("This will always execute.");
}
```
**Output:**
```
Exception handled.
This will always execute.
```

---

### **Nested Try-Catch (Try-Catch Inside Try Block)**

- You can nest try-catch blocks to handle different types of exceptions at different levels.

```java
try {
    try {
        int result = 10 / 0;
    } catch (ArithmeticException e) {
        System.out.println("Inner Catch: Cannot divide by zero!");
    }
    int arr[] = new int[3];
    arr[5] = 10;
} catch (ArrayIndexOutOfBoundsException e) {
    System.out.println("Outer Catch: Array index out of bounds!");
}
```
**Output:**
```
Inner Catch: Cannot divide by zero!
Outer Catch: Array index out of bounds!
```
- Inner catch handles division by zero. 
- Outer catch handles array index errors.