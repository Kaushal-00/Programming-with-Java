## **Runnable Interface**

- `Runnable` is a **functional interface** in Java, present in the `java.lang` package.
- It is used to define the **task (work)** that a **thread should execute**.
- Instead of extending the `Thread` class, you can implement `Runnable`.

| Thread Class                              | Runnable Interface                        |
|--------------------------------------------|---------------------------------------------|
| It's a class in `java.lang` package.        | It's an interface in `java.lang` package.   |

---

### **Steps to use Runnable:**

1. Create a class that implements the `Runnable` interface.
2. Override the `run()` method (this is the code that will run in the thread).
3. Pass the object of your class to a `Thread` object.
4. Call the `start()` method on the `Thread` object.

---

#### Example:

```java
class MyTask implements Runnable {
    public void run() {
        System.out.println("Thread is running...");
    }
}

public class Main {
    public static void main(String[] args) {
        MyTask task = new MyTask();            // Step 1: Create task
        Thread t = new Thread(task);           // Step 2: Pass task to Thread
        t.start();                              // Step 3: Start the thread
    }
}
```

---

#### Output:
```
Thread is running...
```

---

### **Why use Runnable?**

- java doesn't support multiple inheritance with classes.  
- So if your class already extends another class, you can’t extend `Thread`.  
- But you can implement `Runnable` because Java allows multiple interfaces.

```java
class Animal {
    void eat() {
        System.out.println("Eating...");
    }
}

// This will give error
class MyThread extends Animal, Thread {
    public void run() {
        System.out.println("Thread is running");
    }
}
```
- You can’t extend both `Animal` and `Thread` here. This is where `Runnable` helps!
- Since Java allows implementing multiple interfaces, we can do this:

```java
class Animal {
    void eat() {
        System.out.println("Eating...");
    }
}

// This works!
class MyTask extends Animal implements Runnable {
    public void run() {
        System.out.println("Thread is running");
    }
}
```
- Now your class can inherit from another class (like `Animal`) AND
- Still define a thread task using `Runnable`.

---

### **Difference: `Thread` vs `Runnable`**

| Feature             | Extending Thread        | Implementing Runnable      |
|---------------------|-------------------------|-----------------------------|
| Inheritance         | You cannot extend another class | You can still extend another class |
| Structure           | `class MyThread extends Thread` | `class MyTask implements Runnable` |
| Reusability         | Less reusable (tightly coupled) | More reusable (separate task and thread logic) |
| Flexibility         | Less flexible | More flexible |

---