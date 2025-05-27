## **PriorityQueue:**

- A PriorityQueue in Java is a special kind of queue where elements are ordered based on their priority.
- Unlike a normal queue (FIFO), where the first-in-first-out rule applies, a PriorityQueue always gives priority to the smallest or highest priority element (depending on how it's defined).

---

### **Syntax:**

```java
import java.util.PriorityQueue;

PriorityQueue<Integer> pq = new PriorityQueue<>();
```

- By default, it gives priority to the smallest number (min-heap).

---

### **Example:**

```java
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.add(30);
        pq.add(10);
        pq.add(20);

        System.out.println("Top priority: " + pq.peek());  // Output: 10

        while (!pq.isEmpty()) {
            System.out.println(pq.poll());  // Output: 10, 20, 30
        }
    }
}
```

- `peek()` shows the highest priority item (smallest by default).
- `poll()` removes the highest priority item.

---

### **Custom Priority (Max-Heap):**

- We can also create a max-heap (higher number = higher priority):

```java
PriorityQueue<Integer> maxPQ = new PriorityQueue<>((a, b) -> b - a);
```


```java
PriorityQueue<Integer> maxPQ = new PriorityQueue<>((a, b) -> {
    return b.compareTo(a);
});
```
---

- `(a, b) -> b - a` is a lambda expression that compares two integers, `a` and `b`.
- It returns the result of `b - a`.
- When comparing two numbers in Java for sorting or ordering: (For `b - a`)
    - If the result is negative, it means `a` should come before `b`.
    - If the result is positive, it means `a` should come after `b`.
    - If the result is 0, they are equal in ordering.

- So, `b - a` means:
    - If `b` is bigger than `a`, result > 0 → `a` comes after `b` (meaning bigger values come first).
    - If `b` is smaller than `a`, result < 0 → `a` comes before `b`.

- This makes the order descending, so bigger numbers come first → Max-Heap.

---

- `(a, b) -> { return b.compareTo(a); }` is another way to write a comparator using Objects, for example, Strings or Integer objects.
- `compareTo()` is a method that compares two objects.
    - It compares `b` with `a`.
    - If `b` is greater than `a`, it returns positive → meaning `a` should come after `b`.
    - If `b` is smaller than `a`, it returns negative → meaning `a` should come before `b`.

---

### **Example:**

```java
class Node {
    char ch;
    int frequency;

    Node(char ch, int frequency) {
        this.ch = ch;
        this.frequency = frequency;
    }
}
```

- By default, Java’s `PriorityQueue` is a min-heap, but since we are dealing with objects, you must tell the queue how to compare two `Node`s.
- We can do this by using a lambda comparator comparing the `frequency`:

```java
PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> n1.frequency - n2.frequency);
```

- Here, the lambda `(n1, n2) -> n1.frequency - n2.frequency` means:
    - If `n1.frequency < n2.frequency`, result is negative → `n1` comes before `n2`
    - If `n1.frequency > n2.frequency`, result is positive → `n2` comes before `n1`
    - So smallest frequency first (min-heap behavior).

```java
public class Main {
    public static void main(String[] args) {
        PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> n1.frequency - n2.frequency);

        pq.add(new Node('a', 5));
        pq.add(new Node('b', 2));
        pq.add(new Node('c', 8));
        pq.add(new Node('d', 3));

        while (!pq.isEmpty()) {
            Node n = pq.poll();
            System.out.println("Char: " + n.ch + ", Frequency: " + n.frequency);
        }
    }
}
```

---

### Output:

```
Char: b, Frequency: 2
Char: d, Frequency: 3
Char: a, Frequency: 5
Char: c, Frequency: 8
```

---