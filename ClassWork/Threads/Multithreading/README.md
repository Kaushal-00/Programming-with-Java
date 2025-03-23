## **Multithreading**

- Multithreading is a Java feature that allows multiple parts of a program (called threads) to run simultaneously.


---

### **Why use Multithreading?**

- Better performance by using CPU efficiently
- Multiple tasks can run in parallel
- Useful in real-world tasks like:
  - Downloading a file while playing music
  - Handling multiple users in a chat app
  - Running animations in games

---

#### **Example:**

```java
class First extends Thread {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("First Thread: " + i);
        }
    }
}

class Second extends Thread {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Second Thread: " + i);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        First f = new First();
        Second s = new Second();
        f.start();
        s.start();
    }
}
```

#### **Output:**
- (Order may vary, showing threads run in parallel)

```
First Thread: 1
Second Thread: 1
First Thread: 2
Second Thread: 2
...
```

---