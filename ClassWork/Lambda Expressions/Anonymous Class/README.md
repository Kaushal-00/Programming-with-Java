## **Anonymous Class:**

- An anonymous class is a class without a name.
- It is used to create a one-time-use class that:
    - Implements an interface
    - Extends a class
    - And is declared and instantiated in one single step.
- Used to avoid creating a separate class file.
- Useful for small implementations, especially for event handling, threading, or when implementing Functional Interfaces.

---

### **Example 1: Anonymous Class using Interface**

```java
interface Greeting {
    void sayHello();
}
```

- Now, instead of creating a new class like:

```java
class Hello implements Greeting {
    public void sayHello() {
        System.out.println("Hello, Kaushal!");
    }
}
```

- We can use an Anonymous Class directly:

```java
public class Main {
    public static void main(String[] args) {
        Greeting g = new Greeting() {
            public void sayHello() {
                System.out.println("Hello, Kaushal!");
            }
        };

        g.sayHello();  // Output: Hello, Kaushal!
    }
}
```

#### **Notice:**

- We did not give a class name.
- We used `new Greeting() { ... }` to define and create an object at the same time.

---

### **Example 2: Anonymous Class using a Normal Class**

```java
class Animal {
    void makeSound() {
        System.out.println("Animal sound");
    }
}
```

- Use anonymous class to override method:

```java
public class Main {
    public static void main(String[] args) {
        Animal dog = new Animal() {
            void makeSound() {
                System.out.println("Bark!");
            }
        };

        dog.makeSound();  // Output: Bark!
    }
}
```

#### **Notice:**

- `dog` is a reference to interface `Animal`.
- But the object assigned is of anonymous subclass of `Animal`.

---

- We can only call methods defined in the interface (Animal) from `dog`, not any extra method you write inside the anonymous class.

### **Example 3:**

```java
interface Animal {
    void speak();
}

public class Test {
    public static void main(String[] args) {
        Animal cat = new Animal() {
            int age = 5;

            public void speak() {
                System.out.println("Meow!");
            }

            public void extraMethod() {
                System.out.println("I'm an extra method.");
            }
        };

        cat.speak(); // ✅ OK
        // cat.extraMethod(); ERROR: method not defined in Animal
        // System.out.println(cat.age); ERROR: 'age' not accessible
    }
}
```

---

### **Key Points:**

| Feature              | Explanation                           |
| -------------------- | ------------------------------------- |
| No class name        | Class is unnamed                      |
| One-time use         | Object created once, can’t be reused  |
| Used with            | Interface or abstract/concrete class  |
| Can override methods | Yes, in the `{ ... }` block           |
| Helpful in           | GUI apps, event handling, short tasks |

---