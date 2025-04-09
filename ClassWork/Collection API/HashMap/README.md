## **HashMap:**

- A `HashMap` is a data structure in Java that stores key-value pairs.  
- It belongs to the Java Collection Framework and is part of the `java.util` package.


---

### **Syntax:**

```java
HashMap<KeyType, ValueType> map = new HashMap<>();
```

For example:
```java
HashMap<Integer, String> students = new HashMap<>();
```

This means:
- Keys are `Integer` (like roll numbers),
- Values are `String` (like student names).

---

### **Basic Operations:**

| Operation           | Code Example                             |
|---------------------|-------------------------------------------|
| Add data            | `map.put(key, value);`                   |
| Get value           | `map.get(key);`                          |
| Remove entry        | `map.remove(key);`                       |
| Check if key exists | `map.containsKey(key);`                  |
| Check size          | `map.size();`                            |
| Iterate             | `for (Map.Entry<...> entry : map.entrySet())` |

---

### **Example:**

```java
import java.util.*;

public class HashMapExample {
    public static void main(String[] args) {
        HashMap<Integer, String> students = new HashMap<>();

        students.put(1, "Kaushal");
        students.put(2, "Henil");
        students.put(3, "Karan");

        System.out.println("Student with roll 2: " + students.get(2));

        // Display all students
        for (Map.Entry<Integer, String> entry : students.entrySet()) {
            System.out.println("Roll: " + entry.getKey() + ", Name: " + entry.getValue());
        }
    }
}
```

---

### **Notes:**

- Keys must be **unique**.
- Values can be **duplicate**.
- HashMap is **not ordered** – the entries are not stored in insertion order.

---