## **Static Nested Class in Java**  

- A Static Nested Class is a nested class declared as `static` inside an outer class.
- Unlike other inner classes, it does not require an instance of the outer class to be instantiated.  

---

### **Example: Static Nested Class**
```java
class Outer {
    static class Nested {
        void display() {
            System.out.println("Inside Static Nested Class");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // Creating an instance of the Static Nested Class
        Outer.Nested obj = new Outer.Nested();
        obj.display();  // Output: Inside Static Nested Class
    }
}
```

#### **Explanation**
- `Nested` is a **static nested class** inside `Outer`.
- Since it is `static`, it **does not depend on an Outer class instance**.
- We access it using **`Outer.Nested`** and create an object directly.

---

### **Example: Static Nested Class Accessing Static Members of Outer Class**
```java
class Outer {
    static String message = "Hello from Outer Class";

    static class Nested {
        void display() {
            System.out.println(message); // Accessing static variable from Outer class
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Outer.Nested obj = new Outer.Nested();
        obj.display();  // Output: Hello from Outer Class
    }
}
```

#### **Explanation**
- `Nested` class **accesses static members** (`message`) of `Outer` class.
- Since `message` is `static`, it can be directly accessed.

---

### **Example: Static Nested Class Cannot Access Non-Static Members**
```java
class Outer {
    private String instanceVar = "Instance Variable"; // Non-static variable
    
    static class Nested {
        void display() {
            // System.out.println(instanceVar); // ❌ ERROR: Cannot access non-static members
            System.out.println("Inside Static Nested Class");
        }
    }
}
```
#### **Why Does This Fail?**
- A `static` nested class **cannot access non-static variables** or methods of the outer class **directly**.
- `instanceVar` is **non-static**, so the nested class **cannot access it**.

✔️ **Solution:** Pass an `Outer` instance to the nested class if needed.

---

### ** Key Points About Static Nested Classes**
| Feature | Description |
|---------|-------------|
| **Defined using?** | `static class Nested { }` inside another class. |
| **Requires Outer class instance?** | ❌ No, it can be instantiated directly. |
| **Can access static members of Outer class?** | ✅ Yes. |
| **Can access non-static members of Outer class?** | ❌ No, unless an instance of Outer class is passed. |
| **Common Use Case** | Grouping utility/helper classes inside a main class. |