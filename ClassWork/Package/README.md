## **Package:**

- A package is a group of related classes and interfaces. It helps in:
    - Organizing code
    - Avoiding name conflicts
    - Making code modular and easier to manage

### Types:
- Built-in packages: `java.util`, `java.io`, `java.lang`, etc.
- User-defined packages: Created by the programmer.

### How to create a package:
```java
package mypackage;

public class MyClass {
    public void display() {
        System.out.println("Hello from MyClass!");
    }
}
```

---

## **CLASSPATH:**

- CLASSPATH tells Java where to look for class files (.class).
- It's like a path or address Java uses to find packages or classes.
- You can set it temporarily using:

  ```bash
  set CLASSPATH=.;C:\myJavaPrograms
  ```
- `.` means current directory.

---

## **Import Statement:**

- To use a class from another package.

### Syntax:
```java
import packageName.ClassName;
```

### Examples:
```java
import java.util.Scanner;     // Import single class
import java.util.*;           // Import all classes from java.util
```

---

## **Access Control in Java:**

### Access Modifiers:

| Modifier     | Same Class | Same Package | Subclass | Other Package |
|--------------|------------|--------------|----------|----------------|
| **private**  | ✅         | ❌           | ❌       | ❌             |
| **default**  | ✅         | ✅           | ❌       | ❌             |
| **protected**| ✅         | ✅           | ✅       | ❌             |
| **public**   | ✅         | ✅           | ✅       | ✅             |

### Use:
- Helps control access to class members (fields, methods).
- Used for **data hiding** and **security**.

---

## Example:

```java
// File: in/ac/adit/mypack/Book.java
package in.ac.adit.mypack;

public class Book {
    public void show() {
        System.out.println("Book class from package.");
    }
}
```

```java
// File: Test.java (in another file)
import in.ac.adit.mypack.Book;

public class Test {
    public static void main(String[] args) {
        Book b = new Book();
        b.show();
    }
}
```