##**Interface Inside an Interface in Java**

### **Syntax of Interface Inside Interface**
```java
interface OuterInterface {
    // Interface inside an interface
    interface InnerInterface {
        void display();
    }
}
```
- `InnerInterface` is a nested interface inside the `OuterInterface`.
- Just like any other interface, an inner interface can have abstract methods that need to be implemented by the classes.

---

### **Example 1: Interface Inside an Interface**
```java
interface Animal {
    // Nested interface
    interface Sound {
        void makeSound();
    }
}

class Dog implements Animal.Sound {
    @Override
    public void makeSound() {
        System.out.println("Bark!");
    }
}

public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.makeSound();  // Output: Bark!
    }
}
```
#### **Explanation**
- In this example, the `Sound` interface is defined inside the `Animal` interface.
- The class `Dog` implements `Animal.Sound` and provides an implementation of the `makeSound()` method.
- The nested interface is used to represent some related functionality that the `Animal` class might have, in this case, making a sound.

---

### **Example 2: Nested Interface with Multiple Implementations**
```java
interface Shape {
    // Nested interface
    interface Draw {
        void draw();
    }
}

class Circle implements Shape.Draw {
    @Override
    public void draw() {
        System.out.println("Drawing Circle");
    }
}

class Square implements Shape.Draw {
    @Override
    public void draw() {
        System.out.println("Drawing Square");
    }
}

public class Main {
    public static void main(String[] args) {
        Shape.Draw circle = new Circle();
        circle.draw();  // Output: Drawing Circle

        Shape.Draw square = new Square();
        square.draw();  // Output: Drawing Square
    }
}
```
#### **Explanation**
- Here, the `Draw` interface is nested inside the `Shape` interface.
- Both `Circle` and `Square` implement `Shape.Draw`, providing their own versions of the `draw()` method.
- This demonstrates the use of nested interfaces for grouping related methods in a specific context.

---

### **Characteristics of Interface Inside Interface**
- **Implicitly `public`**: An interface inside another interface is implicitly `public` (just like nested classes), so you don’t need to specify the `public` modifier explicitly.
  
- **Access**: A nested interface can be accessed by using the **outer interface name**, e.g., `OuterInterface.InnerInterface`.

- **Instantiation**: You **cannot instantiate** an interface, whether it's nested or not. You need a class to implement the interface and provide a concrete implementation.

- **Nested Interface Types**:
  - **Static**: All interfaces inside an interface are implicitly `static`. So you can access and implement them without creating an instance of the outer interface.
  
- **Used for Specific Grouping**: Nested interfaces are typically used for grouping related functionality or defining behaviors that belong to the context of the outer interface.

---

### **Example 3: Nested Interface with Default Method in Outer Interface**
```java
interface Vehicle {
    // Nested interface inside Vehicle interface
    interface Engine {
        void start();
    }

    // Default method in outer interface
    default void stop() {
        System.out.println("Vehicle stopped");
    }
}

class Car implements Vehicle.Engine {
    @Override
    public void start() {
        System.out.println("Car engine started");
    }
}

public class Main {
    public static void main(String[] args) {
        Vehicle.Engine engine = new Car();
        engine.start();  // Output: Car engine started
    }
}
```
#### **Explanation**
- The `Engine` interface is nested inside the `Vehicle` interface.
- The `Car` class implements the `Vehicle.Engine` interface and provides an implementation for the `start()` method.
- The outer interface `Vehicle` contains a default method `stop()`, which is inherited by the `Car` class.

---

### **Summary of Interface Inside Interface**

| **Feature**             | **Interface Inside Interface**                  |
|-------------------------|-------------------------------------------------|
| **Access Modifier**     | Implicitly `public` and `static`                |
| **Instantiation**        | Cannot be instantiated directly                |
| **Usage**                | Used to group related functionality or behaviors |
| **Example Usage**        | Encapsulating behaviors like `Shape.Draw`, `Animal.Sound` |
| **Default Methods**      | Outer interface can have default methods which are inherited by the class implementing the nested interface |