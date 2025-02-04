## **Method-Local Inner Class**  

- A Method-Local Inner Class is an inner class defined inside a method of an outer class.
- It is local to that method and cannot be accessed outside of it.

---

### **Important Rules for Method-Local Inner Class**
1. **Defined inside a method** → It can only be used inside the method where it is declared.
2. **Cannot be accessed outside the method** → The object of the inner class must be created inside the method.
3. **Can access `final` or effectively final variables of the outer method** → Since Java 8, method-local inner classes can access variables that are effectively final (unchanged after initialization).

---

### **Example: Accessing Final Variables of Outer Method**
```java
class Outer {
    void display() {
        final int number = 100; // Must be final or effectively final

        class Inner {
            void show() {
                System.out.println("Number is: " + number);
            }
        }
        
        Inner inner = new Inner();
        inner.show();
    }
}

public class Main {
    public static void main(String[] args) {
        Outer outer = new Outer();
        outer.display();
    }
}
```

#### **Output:**
```
Number is: 100
```

---

### **Summary Table**
| Feature | Description |
|---------|-------------|
| **Scope** | Only inside the method where it is declared. |
| **Access Restrictions** | Cannot be accessed outside the method. |
| **Can Access Outer Class Members?** | Yes, if they are final or effectively final. |
| **Use Case** | Temporary or helper classes used within a method. |