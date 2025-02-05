## **Class Inside Interface in Java**

### **Syntax of Class Inside an Interface**
```java
interface MyInterface {
    class MyClass {
        void show() {
            System.out.println("Class inside an interface.");
        }
    }
}
```

---

### **Example 1: Class Inside Interface**
```java
interface Animal {
    class Dog {  // Class inside an interface
        void sound() {
            System.out.println("Bark!");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // Creating an object of the nested class Dog inside the interface Animal
        Animal.Dog dog = new Animal.Dog();
        dog.sound();  // Output: Bark!
    }
}
```
### **Explanation**
- The `Dog` class is **nested inside** the `Animal` interface.
- We can create an object of `Animal.Dog` because the class `Dog` is **public by default** (static classes in interfaces are implicitly public).
- The `Dog` class is instantiated and used inside the `Main` class.

---

### **Example 2: Static Nested Class Inside Interface**
```java
interface Vehicle {
    static class Car {  // Static class inside an interface
        void display() {
            System.out.println("Car is running!");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // Instantiating the static nested class Car inside the interface Vehicle
        Vehicle.Car car = new Vehicle.Car();
        car.display();  // Output: Car is running!
    }
}
```
### **Explanation**
- The `Car` class is **static** inside the `Vehicle` interface.
- Being **static**, we can instantiate it without an instance of `Vehicle`, making it easier to use.
- The class `Car` is **accessible** via `Vehicle.Car`.

---

### **Characteristics of a Class Inside an Interface**
- **Static**: All classes defined inside an interface are **implicitly static**. This means they can be instantiated without an instance of the interface itself.
  
- **Accessibility**: The class can be accessed using the interface name (e.g., `InterfaceName.ClassName`).

- **Modifiers**: The class inside the interface **does not require** the `public` modifier, as all inner classes inside an interface are implicitly **public** and **static**.

- **Usage**: A class inside an interface can be used to logically group related implementations that should be associated with the interface.

---

### **Summary**

| **Feature**        | **Class Inside Interface**        |
|-------------------|-----------------------------------|
| **Static**         | Implicitly static                 |
| **Access**         | Can be accessed using `InterfaceName.ClassName` |
| **Instantiation**  | Can be instantiated without creating an instance of the interface |
| **Modifiers**      | Implicitly `public` and `static` |
| **Usage**          | Useful for logically grouping related classes to the interface |

---

### **Conclusion**
Classes inside interfaces are useful for logically grouping related functionality and ensuring modular design. These classes are **implicitly static** and can be used in various design patterns such as **Factory** or **Singleton** patterns.