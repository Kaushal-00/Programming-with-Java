## **ArrayList:**

| Feature | Array | ArrayList |
|--------|-------|------------|
| Fixed size | Yes | No (Resizable) |
| Add/remove elements easily | No | Yes |
| Stores only same type | Yes | Yes (Generic) |

---

### **Example:**

```java
import java.util.ArrayList;

public class Example {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();

        names.add("Kaushal");
        names.add("Henil");
        names.add("Karan");

        System.out.println(names.get(0));

        names.set(1, "Ravi");

        names.remove(2);

        System.out.println(names);

        System.out.println("Size: " + names.size());
    }
}
```

---

### **Methods of ArrayList:**

| Method | Description |
|--------|-------------|
| `.add(element)` | Adds an element to the end |
| `.get(index)` | Gets element at index |
| `.set(index, element)` | Replaces element at index |
| `.remove(index)` | Removes element at index |
| `.size()` | Returns number of elements |
| `.clear()` | Removes all elements |
| `.contains(value)` | Checks if element exists |

---

### **Generics:**

- We can define the type of data stored in the `ArrayList`:

```java
ArrayList<Integer> numbers = new ArrayList<>();
ArrayList<String> fruits = new ArrayList<>();
```

---