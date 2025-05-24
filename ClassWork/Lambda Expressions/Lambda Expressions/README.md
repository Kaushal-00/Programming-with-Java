## **Lambda Expressions:**

- Lambda Expressions were introduced in Java 8 and are used to write shorter, cleaner code — especially for functional interfaces (interfaces with only one method).
- A Lambda Expression is a way to write Anonymous Methods (i.e., methods without names) — mainly used when we need to pass behavior (not just data) to a method.

---

### **Need:**

- Java is not a "pure" functional language like Python or JavaScript.
- Everything has to be in a class or interface.
- If we wanted to pass a small piece of logic (like a function) to a method, we had no direct way to do that.

#### **Problems:**

- Java allows us to define interfaces with abstract methods.
- But to use them, we had to create a separate class*.

```java
interface MyTask {
    void doSomething();
}

class MyTaskImpl implements MyTask {
    public void doSomething() {
        System.out.println("Doing task...");
    }
}
```

- To reduce effort, Java allows Anonymous Classes.
- No need to create a separate file or named class.

```java
MyTask task = new MyTask() {
    public void doSomething() {
        System.out.println("Doing task using anonymous class...");
    }
};
```

- Java 8 introduced Functional Interfaces — interfaces with only one abstract method.
- This opened the door to pass functions directly!

```java
@FunctionalInterface
interface MyTask {
    void doSomething();
}
```

#### **Solution:**

- Before Java 8, to define a function or behavior, we had to write an anonymous class.
- But now, using Lambda, we can skip the boilerplate and just write the essential logic.
- Functional Interface uses with Lambda.

```java
MyTask task = () -> System.out.println("Doing task with Lambda!");
```

---

```plaintext
Interface 
    ↓
Functional Interface (only 1 abstract method)
    ↓
Can be used in:
    ↳ Anonymous Class (Old way)
    ↳ Lambda Expression (Java 8+)
```

---

### **Syntax:**

```java
(parameter) -> { body of method }
```

### **Example-1:**

```java
(int a, int b) -> { return a + b; }
```

- If it's a single statement, you can skip the curly braces and return keyword:

```java
(a, b) -> a + b
```

---

### **Example-2:**

#### Without Lambda Expressions(With Anonymous Class):

```java
interface MyInterface {
    void show();
}

public class Demo {
    public static void main(String[] args) {
        MyInterface obj = new MyInterface() {
            public void show() {
                System.out.println("Hello Java!");
            }
        };
        obj.show();
    }
}
```

#### With Lambda Expressions:

```java
interface MyInterface {
    void show();
}

public class Demo {
    public static void main(String[] args) {
        MyInterface obj = () -> System.out.println("Hello Java!");
        obj.show();
    }
}
```

---

### **Exmaple-3:**

```java
interface Add {
    int sum(int a, int b);
}

public class Main {
    public static void main(String[] args) {
        Add obj = (a, b) -> a + b;
        System.out.println(obj.sum(10, 20));  // Output: 30
    }
}
```

---

### **Example-4:**

#### Lambda with Collections:

```java
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Kaushal", "Henil", "Karan");

        list.forEach(name -> System.out.println(name));
    }
}
```

---