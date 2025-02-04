## **Anonymous Inner Class in Java**  

- An Anonymous Inner Class is an inner class without a name.
- It is used when you need a one-time implementation of a class or interface.
- Instead of creating a separate subclass, you define and instantiate the class at the same time.  

---

### **Example 1: Anonymous Inner Class Extending a Class**
```java
class Animal {
    void makeSound() {
        System.out.println("Animal makes a sound");
    }
}

public class Main {
    public static void main(String[] args) {
        // Anonymous Inner Class extending Animal
        Animal dog = new Animal() {
            void makeSound() {
                System.out.println("Dog barks!");
            }
        };
        
        dog.makeSound();  // Output: Dog barks!
    }
}
```
### **Explanation**
- We created an Anonymous Inner Class that **extends** `Animal`.
- It **overrides** the `makeSound()` method without creating a new named class.
- We **instantiated and defined the subclass at the same time**.

---

### **Example 2: Anonymous Inner Class Implementing an Interface**
```java
interface Vehicle {
    void drive();
}

public class Main {
    public static void main(String[] args) {
        // Anonymous Inner Class implementing Vehicle interface
        Vehicle car = new Vehicle() {
            public void drive() {
                System.out.println("Car is driving...");
            }
        };
        
        car.drive();  // Output: Car is driving...
    }
}
```
### **Explanation**
- Here, we created an **Anonymous Inner Class** that **implements** `Vehicle`.
- We **directly defined** the method `drive()` inside the object declaration.

---

### **Example 3: Anonymous Inner Class in a Method**
```java
abstract class Greeting {
    abstract void sayHello();
}

public class Main {
    void displayGreeting() {
        Greeting greeting = new Greeting() {
            void sayHello() {
                System.out.println("Hello, welcome to Java!");
            }
        };
        greeting.sayHello();
    }

    public static void main(String[] args) {
        Main obj = new Main();
        obj.displayGreeting();
    }
}
```
### **Explanation**
- The **Anonymous Inner Class** is created **inside the method**.
- It **extends** the `Greeting` class and **overrides** `sayHello()`.
- It is **instantiated within the method**, making it local.

---

### **Key Points About Anonymous Inner Classes**
1. **No Name:** You cannot create multiple instances because it has no name.
2. **Can Extend a Class or Implement an Interface:**  
   - If extending a class → Can override methods but **cannot add new ones**.  
   - If implementing an interface → Must implement **all abstract methods**.
3. **Used for Quick and One-Time Use:** Mostly for event handling and short-lived tasks.

---

### **Summary Table**
| Feature | Description |
|---------|-------------|
| **Definition** | Inner class without a name, declared and instantiated at the same time. |
| **Extends a Class?** | Yes, but can’t add new methods (only override). |
| **Implements an Interface?** | Yes, but must implement all abstract methods. |
| **Use Case** | When you need a one-time implementation. |
| **Scope** | Defined inside a method or as an object. |