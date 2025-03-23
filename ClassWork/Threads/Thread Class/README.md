## **Thread Class**

- `Thread` is a **built-in class** in `java.lang` package.
- It allows you to create and manage **threads** (small units of a program that can run independently).
- You can either **extend** the `Thread` class or **pass a Runnable** object to it to create a new thread.

---

### Commonly Used **Constructors** of `Thread` Class:

| Constructor | Description |
|-------------|-------------|
| `Thread()` | Creates a thread object with no task. You must override `run()` method. |
| `Thread(Runnable r)` | Creates a thread that runs the task given by the `Runnable` object. |
| `Thread(String name)` | Creates a thread and sets its name. |
| `Thread(Runnable r, String name)` | Creates a thread to run a `Runnable` task and sets the thread's name. |

---

### Common **Methods** of `Thread` Class:

| Method | Description |
|--------|-------------|
| `start()` | Starts the thread, which internally calls `run()` |
| `run()` | Contains the code that runs in the new thread |
| `sleep(ms)` | Puts the thread to sleep for given milliseconds |
| `join()` | Waits for another thread to finish |
| `getName()` | Returns the name of the thread |
| `setName(String)` | Sets the name of the thread |
| `getPriority()` | Returns thread priority |
| `setPriority(int)` | Sets thread priority (1 to 10) |
| `isAlive()` | Returns `true` if thread is still running |
| `yield()` | Tells the current thread to pause and let others run |

---

### Example Using `Thread` Class:

```java
class MyThread extends Thread {
    public void run() {
        System.out.println("Thread is running...");
    }
}

public class Main {
    public static void main(String[] args) {
        MyThread t = new MyThread();   // Create thread object
        t.start();                     // Start the thread
    }
}
```

---

### Example Using `Thread(Runnable r)` Constructor:

```java
class MyRunnable implements Runnable {
    public void run() {
        System.out.println("Runnable thread is running...");
    }
}

public class Main {
    public static void main(String[] args) {
        Thread t = new Thread(new MyRunnable());
        t.start();
    }
}
```

---

### Thread Priority

| Constant | Value |
|----------|-------|
| `Thread.MIN_PRIORITY` | 1 |
| `Thread.NORM_PRIORITY` | 5 (default) |
| `Thread.MAX_PRIORITY` | 10 |

```java
Thread t1 = new Thread();
t1.setPriority(Thread.MAX_PRIORITY);
```

---