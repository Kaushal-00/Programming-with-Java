## **Deadlock:**

- A deadlock occurs when two or more threads are waiting on each other to release a resource, and none of them ever does, so they all get stuck forever.

---

### **Example:**

- Imagine this situation:

- Thread A has a Lock on Resource 1 and wants to get Resource 2.
- Thread B has a Lock on Resource 2 and wants to get Resource 1.

Now:

- A is waiting for B to release Resource 2
- B is waiting for A to release Resource 1

- Both keep waiting... forever. That’s a deadlock.

---

### **Example:**

```java
class DeadlockExample {
    static final Object lock1 = new Object();
    static final Object lock2 = new Object();

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            synchronized (lock1) {
                System.out.println("Thread 1: Holding lock 1...");

                try { Thread.sleep(100); } catch (Exception e) {}

                synchronized (lock2) {
                    System.out.println("Thread 1: Acquired lock 2");
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (lock2) {
                System.out.println("Thread 2: Holding lock 2...");

                try { Thread.sleep(100); } catch (Exception e) {}

                synchronized (lock1) {
                    System.out.println("Thread 2: Acquired lock 1");
                }
            }
        });

        t1.start();
        t2.start();
    }
}
```

- This program may enter a deadlock, depending on timing:
- Thread 1 locks `lock1` and waits for `lock2`
- Thread 2 locks `lock2` and waits for `lock1`
- Deadlock! Both are stuck forever.

---

### How to Avoid Deadlock?

1. Always acquire locks in the same order in all threads.
2. Try to lock all needed resources at once.
3. Use timeout-based locking like `tryLock()` from `ReentrantLock`.

---