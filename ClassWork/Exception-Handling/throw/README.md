## **`throw:`**

- The throw keyword in Java is used to explicitly throw an exception in the program.

---

### **Syntax of `throw`**
```java
throw new ExceptionType("Error Message");
```
- Here, `ExceptionType` is the type of exception to be thrown.  
- `"Error Message"` is an optional message describing the error.  

---

### **Example: Throwing an Exception**

```java
public class ThrowExample {
    public static void main(String[] args) {
        int age = 15;
        if (age < 18) {
            throw new ArithmeticException("You must be 18 or older to vote.");
        }
        System.out.println("You can vote!");
    }
}
```
**Output:**
```
Exception in thread "main" java.lang.ArithmeticException: You must be 18 or older to vote.
```
- Since age is less than 18, the exception is thrown, and the program stops.

---

### **Using `throw` Inside a Method**

```java
public class ThrowExample {
    static void checkAge(int age) {
        if (age < 18) {
            throw new IllegalArgumentException("Age must be 18 or above.");
        } else {
            System.out.println("Access granted!");
        }
    }

    public static void main(String[] args) {
        checkAge(15);
}
```
**Output:**
```
Exception in thread "main" java.lang.IllegalArgumentException: Age must be 18 or above.
```
- **`throw` stops execution immediately when an exception is thrown.**

---

### **Difference Between `throw` and `throws`**
| Feature      | `throw` | `throws` |
|-------------|--------|---------|
| Purpose | Used to **throw** an exception manually | Used to **declare** exceptions that a method might throw |
| Placement | Inside a method | In method signature |
| Number of Exceptions | Throws **only one** exception at a time | Can declare **multiple** exceptions |
| Example | `throw new ArithmeticException("Error");` | `void method() throws IOException, SQLException` |