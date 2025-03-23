## **1. `sleep()` Method**

### **Purpose:**
- Pause the current thread for a specific amount of time (in milliseconds), without terminating it.

#### Syntax:
```java
Thread.sleep(milliseconds);
```

#### Example:
```java
public class SleepExample {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Start");
        Thread.sleep(2000);  // Pauses for 2 seconds
        System.out.println("After 2 seconds");
    }
}
```

#### Output:
```
Start
(2 sec pause)
After 2 seconds
```

---

## **2. `join()` Method**

### **Purpose:**
- Tells one thread to wait until another thread finishes before it continues.

#### Syntax:
```java
thread.join();
```

#### Example:
```java
class MyThread extends Thread {
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println("Child Thread: " + i);
        }
    }
}

public class JoinExample {
    public static void main(String[] args) throws InterruptedException {
        MyThread t = new MyThread();
        t.start();
        t.join();  // Waits for t to finish
        System.out.println("Main Thread resumes after child thread.");
    }
}
```

#### Output:
```
Child Thread: 1
Child Thread: 2
Child Thread: 3
Main Thread resumes after child thread.
```

---

## **3. `yield()` Method**

### **Purpose:**
- Tells the current thread to pause and let other threads of equal priority run.

#### Syntax:
```java
Thread.yield();
```

#### Example:
```java
public class YieldExample {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            for (int i = 1; i <= 3; i++) {
                System.out.println("Thread-1: " + i);
                Thread.yield();  // Hints to switch
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 1; i <= 3; i++) {
                System.out.println("Thread-2: " + i);
            }
        });

        t1.start();
        t2.start();
    }
}
```

#### Output:
```
Thread-1: 1
Thread-2: 1
Thread-1: 2
Thread-2: 2
...
```
---
