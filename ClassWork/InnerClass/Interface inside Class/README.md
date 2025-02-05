## **Interface Inside a Class in Java**  

### **Syntax**
```java
class Outer {
    interface NestedInterface {  // Interface inside a class
        void show();
    }
}
```
- `NestedInterface` is defined **inside** the class `Outer`.
- This interface can be implemented **by any class**, inside or outside `Outer`.

---

### **Example 1: Implementing the Interface Inside the Outer Class**
```java
class Outer {
    interface NestedInterface {  // Nested interface
        void show();
    }

    // Implementing the interface inside the outer class
    static class Inner implements NestedInterface {
        public void show() {
            System.out.println("Implemented Nested Interface inside Outer class.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Outer.Inner inner = new Outer.Inner();  // Creating an instance of Inner
        inner.show();  
        // Output: Implemented Nested Interface inside Outer class.
    }
}
```
### **Explanation**
- `NestedInterface` is **inside** `Outer`.
- The `Inner` class **implements** `NestedInterface`.
- `Inner` is **static**, so we don't need an instance of `Outer` to use it.

---

### **Example 2: Implementing the Interface in Another Class**
```java
class Outer {
    interface NestedInterface {  // Nested interface
        void display();
    }
}

// Implementing the nested interface in a separate class
class Implementor implements Outer.NestedInterface {
    public void display() {
        System.out.println("Nested Interface Implemented in a Separate Class.");
    }
}

public class Main {
    public static void main(String[] args) {
        Implementor obj = new Implementor();
        obj.display();  
        // ✅ Output: Nested Interface Implemented in a Separate Class.
    }
}
```
### **Explanation**
- `NestedInterface` is **inside** `Outer`.
- `Implementor` (outside class) implements `Outer.NestedInterface`.
- The implementation **is not dependent** on `Outer`, making it more flexible.

---

### **Why Use an Interface Inside a Class?**
| Feature | Benefit |
|---------|---------|
| **Encapsulation** | Keeps the interface logically grouped with its related class. |
| **Modularity** | Useful when the interface is meant to be used only within the outer class. |
| **Security** | Prevents external classes from directly implementing it unless explicitly allowed. |

---

### **Summary**
| Feature | Nested Interface |
|---------|------------------|
| **Defined inside a class?** | ✅ Yes |
| **Can be implemented inside the outer class?** | ✅ Yes |
| **Can be implemented outside the outer class?** | ✅ Yes |
| **Does it need an instance of Outer to access?** | ❌ No (if static) |