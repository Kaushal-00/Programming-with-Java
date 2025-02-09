## **Runtime Stack in Java**

- The Runtime Stack (also called Call Stack) is a memory structure used by the Java Virtual Machine (JVM) to manage method execution. It stores method calls and local variables in a Last In, First Out (LIFO) manner.

---

### **How the Runtime Stack Works**
1. When a method is called, the JVM creates a **stack frame** for it.
2. This frame stores:
   - Method parameters
   - Local variables
   - Return address (where to return after the method completes)
3. When the method completes**, its stack frame is removed (popped) from the stack.
4. The process continues recursively for every function call.

---

### **Stack Memory vs Heap Memory**
| Feature  | Stack | Heap |
|----------|----------|----------|
| Purpose | Stores method calls and local variables | Stores objects and instance variables |
| Access | LIFO (Last In, First Out) | Objects accessed dynamically |
| Speed | Fast | Slower than stack |
| Lifetime | Exists until method execution completes | Exists as long as references exist |
| Size | Small and limited | Large and dynamically allocated |

---

### **Example: Understanding the Runtime Stack**
```java
public class StackExample {
    public static void main(String[] args) {
        System.out.println("Main starts");
        methodA();
        System.out.println("Main ends");
    }

    static void methodA() {
        System.out.println("Inside methodA");
        methodB();
        System.out.println("Exiting methodA");
    }

    static void methodB() {
        System.out.println("Inside methodB");
    }
}
```
**Output:**
```
Main starts
Inside methodA
Inside methodB
Exiting methodA
Main ends
```

#### **How Stack Works in This Example**
1. `main()` is called → Stack frame for `main()` is created.
2. `methodA()` is called → Stack frame for `methodA()` is created.
3. `methodB()` is called → Stack frame for `methodB()` is created.
4. `methodB()` completes → Stack frame for `methodB()` is removed.
5. `methodA()` completes → Stack frame for `methodA()` is removed.
6. `main()` completes → Stack frame for `main()` is removed.

---
### **StackOverflowError (Infinite Recursion Issue)**

- If a method keeps calling itself indefinitely, the stack keeps growing until it runs out of memory, causing a `StackOverflowError`.

**Example: Stack Overflow Due to Infinite Recursion**
```java
public class StackOverflowExample {
    static void recursiveMethod() {
        recursiveMethod();  // Infinite recursion
    }

    public static void main(String[] args) {
        recursiveMethod();
    }
}
```
**Output:**
```
Exception in thread "main" java.lang.StackOverflowError
```