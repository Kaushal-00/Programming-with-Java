## **Custom Exception in Java**  

- A **custom exception** (also called a **user-defined exception**) in Java is a class that **extends `Exception` or `RuntimeException`** to handle specific error cases in a meaningful way.

---

### **Why Use Custom Exceptions?**  
- More meaningful error messages for better debugging.  
- Improves code readability and clarity.  
- Encapsulates application-specific logic in a structured way.  

---

### **Creating a Custom Exception**  

#### **Checked Custom Exception (Extends `Exception`)**

- Must be handled using `try-catch` or declared using `throws`.

```java
// Custom Checked Exception (Extends Exception)
class InvalidAgeException extends Exception {
    // Constructor to set custom error message
    public InvalidAgeException(String message) {
        super(message);
    }
}

public class CustomExceptionExample {
    // Method that throws custom exception
    static void validateAge(int age) throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException("Age must be 18 or above to vote.");
        }
        System.out.println("Valid Age! You can vote.");
    }

    public static void main(String[] args) {
        try {
            validateAge(16); // Throws exception
        } catch (InvalidAgeException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
```
**Output:**  
```
Exception: Age must be 18 or above to vote.
```
- **`InvalidAgeException`** extends `Exception`, making it a **checked exception**.  
- **`validateAge(16)`** throws `InvalidAgeException`, which must be handled using `try-catch`.

---

#### **Unchecked Custom Exception (Extends `RuntimeException`)**

- Does not require explicit handling (`try-catch` or `throws`).  
- Used for programming errors like invalid input, division by zero, etc.

```java
// Custom Unchecked Exception (Extends RuntimeException)
class NegativeNumberException extends RuntimeException {
    public NegativeNumberException(String message) {
        super(message);
    }
}

public class UncheckedCustomException {
    static void squareRoot(int num) {
        if (num < 0) {
            throw new NegativeNumberException("Cannot calculate square root of a negative number!");
        }
        System.out.println("Square root: " + Math.sqrt(num));
    }

    public static void main(String[] args) {
        squareRoot(-9); // Throws exception
    }
}
```
**Output:**  
```
Exception in thread "main" NegativeNumberException: Cannot calculate square root of a negative number!
```
- `NegativeNumberException` extends `RuntimeException`, making it an unchecked exception.  
- The exception crashes the program if not handled.

---

### **Difference Between Checked & Unchecked Custom Exceptions**
| Feature         | Checked Exception (`Exception`) | Unchecked Exception (`RuntimeException`) |
|----------------|--------------------------------|----------------------------------|
| Must Handle?   | Yes, must use `try-catch` or `throws`. | No, handling is optional. |
| When to Use?   | External problems (e.g., invalid age, file not found). | Internal programming issues (e.g., null pointer, invalid math). |
| Extends        | `Exception` | `RuntimeException` |