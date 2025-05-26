## **Volatile Keyword:**

- The `volatile` keyword in Java is used to indicate that a variable's value may be changed by multiple threads.
- It ensures visibility of changes to variables across threads.
- In multithreading, each thread may keep a copy of a variable in its own CPU cache(Pass by Value in loop), so changes made by one thread might not be visible to others.

---

### **Example:**

```java
class MyThread extends Thread {
    boolean running = true;

    public void run() {
        while (running) {
            // do something
        }
        System.out.println("Thread Stopped");
    }

    public void stopThread() {
        running = false;
    }
}
```

- Now, if the main thread calls `stopThread()`, the new value of `running = false` might not be visible to the `run()` method in the loop (due to caching).

---

### **Example:**

```java
class MyThread extends Thread {
    volatile boolean running = true;  // volatile added

    public void run() {
        while (running) {
            // do something
        }
        System.out.println("Thread Stopped");
    }

    public void stopThread() {
        running = false;
    }
}
```

- Ensures immediate visibility of changes made by one thread to all other threads.
- Every read/write of the variable happens directly in main memory (not CPU cache).
- `volatile` forces the thread to read the variable's value directly from main memory, and write changes directly back to main memory, bypassing the thread's local cache.

---

### **Important Points:**

| Feature                                | Explanation                                               |
| -------------------------------------- | --------------------------------------------------------- |
| Ensures Visibility                | Changes made by one thread are seen by others immediately |
| Does NOT Ensure Atomicity        | Doesn't protect from race conditions                      |
| Used with primitives or references | Mostly for flags or shared variables                      |
| Lighter than synchronized          | No locking involved                                       |

---

### **When NOT to use `volatile`:**

- When we need to increment a counter: use `synchronized` or `AtomicInteger` instead.
- `volatile` can't be used for compound actions (like `i++`), because it doesn't guarantee atomicity.

```java
class CounterVolatile {
    volatile int count = 0;

    void increment() {
        count++; // Not atomic (read-modify-write)
    }
}
```

- Even with `volatile`, this `count++` is not safe when used by multiple threads.
- It actually does three things:
    - Read the current value of `count`.
    - Increment it (add 1).
    - Write the new value back to `count`.
- This is called a read-modify-write operation, and it is not atomic (not indivisible).

- If Thread A reads `count` as 5, Thread B also reads `count` as 5, both increment to 6 and both write 6 back.
- Final value is 6 instead of expected 7. This is called a race condition.
- Even if `count` is marked as `volatile`, it only guarantees visibility, not atomicity.

---

```java
class CounterSync {
    int count = 0;

    synchronized void increment() {
        count++; // Atomic and thread-safe
    }
}
```

- `synchronized` ensures only one thread can execute `increment()` at a time.
- So `count++` becomes effectively atomic.

---

### **`volatile` vs `synchronized`:**

| Feature                             | `volatile`                      | `synchronized`                           |
| ----------------------------------- | ------------------------------- | ---------------------------------------- |
| Purpose                        | Guarantees visibility       | Guarantees visibility + atomicity    |
| Thread Safety                   | Only visibility, not atomic | Ensures full thread safety               |
| Locks                           | No locking                   | Uses lock (mutex)                      |
| Performance                     | Faster (no locking overhead)    | Slower due to locking                    |
| Use Case                        | Shared flags, status indicators | Critical sections, counters, file access |
| Partial Operations (e.g. `i++`) | Not safe                      | Safe                                   |
| Blocking                        | Non-blocking                    | May block if thread holds the lock       |

---

- If we want performance + thread safety, consider using `java.util.concurrent.atomic` classes like:
- `AtomicInteger`
- `AtomicBoolean`

```java
AtomicInteger count = new AtomicInteger(0);
count.incrementAndGet();  // thread-safe and faster than synchronized
```
---