## **Static Keyword:**

- `static` means belonging to the class, not to any object.
- When something is marked as `static`, it is shared among all objects of the class.
- You can access it without creating any object.

---

| Keyword | Meaning |
| --- | --- |
| `static variable` | Shared by all objects of the class |
| `static method` | Can be called without an object |
| `static block` | Runs once when the class is loaded |
| `static class` | Nested class that doesn't need outer class object |

---

### **Example:**

```java
class MyClass {
    static int count = 0; // static variable

    static void display() { // static method
        System.out.println("Static method called. Count = " + count);
    }
}

public class Main {
    public static void main(String[] args) {
        // Accessing static variable and method directly with class name / Without Object.
        MyClass.count = 5;
        MyClass.display();
    }
}

```

---

### **Notes**

- A static method cannot use `this` keyword.
- A static method cannot access non-static members directly.
- Static members belong to the class where they are defined,
- So they must be accessed using the class name: `ClassName.member`, not using other class objects.
    - If class A have static members and there is class B, then 
    - We can do -> `A.value`     // Access static variable using Class A
    - But we can not do -> `B.value`    //Can't access static method using Class B
- What if class B is inherited from Class B, We can do -> `B.value`


---

### **Static class:**

- A static class is always a nested class inside another class | Not possible at top level.
- It does NOT need an object of the outer class to create its object.
- It behaves like a normal top-level class but is scoped inside an outer class.
- Can only access static members of the outer class directly.

---

### **Example:**

```java
class Outer {
    static int x = 10;

    static class Inner {
        void show() {
            System.out.println("Inside Static Nested Class");
            System.out.println("Outer class static data: " + x);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Outer.Inner obj = new Outer.Inner();
        obj.show();
    }
}

```
---