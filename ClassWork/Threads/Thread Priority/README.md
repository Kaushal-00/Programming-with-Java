## Thread Priority**

- Every thread in Java has a **priority**, which helps the CPU decide which thread to run first (when multiple threads are waiting to execute).  

---

### **Priority Range:**

- Java thread priority values range from **1 to 10**:

| Constant             | Value | Meaning               |
|----------------------|--------|------------------------|
| `Thread.MIN_PRIORITY` | 1     | Lowest priority        |
| `Thread.NORM_PRIORITY`| 5     | Default/normal priority|
| `Thread.MAX_PRIORITY` | 10    | Highest priority       |

---

### **How to Set and Get Priority:**

- You can set and get priority using:

```java
thread.setPriority(value);  // Set priority (1 to 10)
thread.getPriority();       // Get current priority
```

---

#### **Example**

```java
class MyThread extends Thread {
    public void run() {
        System.out.println(Thread.currentThread().getName() + 
                           " Priority: " + Thread.currentThread().getPriority());
    }
}

public class Main {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        MyThread t3 = new MyThread();

        t1.setPriority(Thread.MIN_PRIORITY);   // 1
        t2.setPriority(Thread.NORM_PRIORITY);  // 5 (default)
        t3.setPriority(Thread.MAX_PRIORITY);   // 10

        t1.start();
        t2.start();
        t3.start();
    }
}
```

#### **Output**
```
Thread-0 Priority: 1
Thread-1 Priority: 5
Thread-2 Priority: 10
```

---

### Important Notes:

- Priority doesn’t guarantee execution order. It’s up to the OS and JVM.

---