## **Executor Framework:**

- It is a built-in Java API introduced in Java 5 (java.util.concurrent package) to manage and control multiple threads efficiently.
- It provides a pool of threads and handles task execution for you.

---

### **Need:**

| Without Executor                 | With Executor Framework         |
|----------------------------------|----------------------------------|
| `new Thread().start()` every time | Reuses threads (thread pool)     |
| Manually manage start/stop       | Automatically handles everything |
| Hard to scale                    | Easy and scalable                |

---

### **Core Components:**

####  **1. Executor Interface:**
- The main/basic interface that executes a task.

```java
Executor executor = new MyExecutor();
executor.execute(task);
```
- But it’s very basic. So we usually use its child:

#### **2. ExecutorService:**
- A sub-interface of Executor with more powerful features like shutdown, submit tasks, etc.
- Has more advanced features like:
- `submit()` – Submits tasks
- `shutdown()` – Stops the executor gracefully
- `invokeAll()`, `invokeAny()` – Handle multiple tasks

```java
ExecutorService executor = Executors.newFixedThreadPool(3);
```

### **3. Executors (Factory class):**
- Contains static methods to create thread pools.
- Used to create different types of thread pools:

| Method                         | Description                                  |
|--------------------------------|----------------------------------------------|
| `newFixedThreadPool(n)`        | Reuses n threads                          |
| `newSingleThreadExecutor()`    | Only 1 thread, serial execution               |
| `newCachedThreadPool()`        | Creates thread when needed                   |
| `newScheduledThreadPool(n)`    | For repeated/scheduled tasks                 |

---

### **Example:**

```java
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        // Create a thread pool with 3 threads
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // Submit tasks to be executed
        for (int i = 1; i <= 5; i++) {
            int taskNumber = i;
            executor.execute(() -> {
                System.out.println("Task " + taskNumber + " is running in thread " + Thread.currentThread().getName());
            });
        }

        // Shutdown the executor when done
        executor.shutdown();
    }
}
```

### **Output:**
```
Task 1 is running in thread pool-1-thread-1
Task 2 is running in thread pool-1-thread-2
Task 3 is running in thread pool-1-thread-3
...
```

---