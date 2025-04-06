## **Inter-Thread Communication:**

- inter-thread communication allows multiple threads to cooperate with each other by **waiting and notifying**.
- It is used when:
    - One thread **waits** for a condition (like a queue being non-empty),
    - And another thread **notifies** when that condition becomes true (like after adding an item to the queue).

---

### **Need:**

- Imagine a Producer-Consumer problem:

    - Producer puts items in a queue.
    - Consumer takes items from the queue.

- If the queue is empty, the consumer should wait.
- When the producer adds an item, it should notify the waiting consumer.
- Without communication, the consumer might keep checking needlessly (called *busy waiting*).

---

- Java provides 3 key methods from `Object` class:

| Method | Description |
|--------|-------------|
| `wait()` | Causes current thread to wait until notified |
| `notify()` | Wakes up a single thread waiting on the object |
| `notifyAll()` | Wakes up all threads waiting on the object |

- ⚠️ These methods must be called inside a synchronized block/method.

---

## **Example:**

```java
class SharedQueue {
    int item;
    boolean available = false;

    synchronized void produce(int value) {
        while (available) {
            try {
                wait(); // Wait if item is already produced
            } catch (Exception e) {}
        }
        item = value;
        available = true;
        System.out.println("Produced: " + item);
        notify(); // Notify consumer
    }

    synchronized void consume() {
        while (!available) {
            try {
                wait(); // Wait until item is available
            } catch (Exception e) {}
        }
        System.out.println("Consumed: " + item);
        available = false;
        notify(); // Notify producer
    }
}

public class Main {
    public static void main(String[] args) {
        SharedQueue queue = new SharedQueue();

        // Producer thread
        Thread producer = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                queue.produce(i);
            }
        });

        // Consumer thread
        Thread consumer = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                queue.consume();
            }
        });

        producer.start();
        consumer.start();
    }
}
```

---

- synchronized is used to lock an object so only one thread can access a block of code at a time.
- wait() tells the thread to wait and release the lock on that object.
- notify() wakes up one thread that is waiting on the object’s lock.

| Concept | Description |
|--------|-------------|
| `wait()` | Pauses the thread and releases the lock |
| `notify()` | Wakes one waiting thread |
| `notifyAll()` | Wakes all waiting threads |
| Use Case | Producer-Consumer, Reader-Writer problems |

---