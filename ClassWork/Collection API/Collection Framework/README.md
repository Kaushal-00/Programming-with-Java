## **Collection API:**

- The Collection API in Java is a set of classes and interfaces used to store, manipulate, and retrieve groups of objects (data)
efficiently.

- It is part of the `java.util` package, and helps programmers to handle data structures like:

- Lists
- Sets
- Queues
- Maps

---

## **Collection Framework:**

- The Collection Framework is the architecture that organizes the Collection API.
- It includes:

    - **Interfaces** – define what operations can be done  
    (e.g., `List`, `Set`, `Queue`, `Map`)

    - **Classes** – provide the actual implementation  
    (e.g., `ArrayList`, `HashSet`, `LinkedList`, `HashMap`)

    - **Algorithms** – like sorting, searching, etc. (available via `Collections` class)

---

## **Collection:**

- Java provides a **Collection Interface** (from java.util package) that is the root interface for all data structures like: 

```plaintext
           Collection (Interface)
           /       |       \
       List       Set     Queue
        |          |        |
  ArrayList   HashSet   PriorityQueue
  LinkedList  TreeSet   ArrayDeque
```
- Note: `Map` (like `HashMap`, `TreeMap`) is not part of the Collection interface, but still part of the Collection Framework.

---

### Key Interfaces and Their Uses

| Interface | Purpose                          | Example Classes        |
|-----------|----------------------------------|------------------------|
| `List`    | Ordered, allows duplicates       | `ArrayList`, `LinkedList` |
| `Set`     | No duplicates                    | `HashSet`, `TreeSet`       |
| `Queue`   | FIFO structure                   | `PriorityQueue`, `ArrayDeque` |
| `Map`     | Key-value pairs (not a subtype of Collection) | `HashMap`, `TreeMap` |

---