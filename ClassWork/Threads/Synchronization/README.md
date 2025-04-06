## **Thread Synchronization:**

- When two or more threads access shared resources (like variables, files, objects) at the same time, it can cause data inconsistency or errors.
- Thread Synchronization is a technique that ensures only one thread at a time can access a shared resource or critical section.
- synchronized is used to **lock** an object so only one thread can access a block of code at a time.

---

### **Need:**

- Imagine we have a shared bank account, and two threads are trying to withdraw money at the same time:

```java
balance = 1000;

Thread 1: withdraw(800);
Thread 2: withdraw(800);
```

- If both access `balance` without synchronization, they might both see `1000` and allow withdrawal, causing overdraft or wrong results.

---

### **How to Use Synchronization:**

#### **`synchronized` Keyword:**

1. **Synchronized Method** – Only one thread can execute it at a time.
```java
public synchronized void deposit(int amount) {
    balance += amount;
}
```

2. **Synchronized Block** – You can synchronize only the part of code that needs protection.
```java
public void deposit(int amount) {
    synchronized(this) {
        balance += amount;
    }
}
```
- This ensures mutual exclusion – only one thread can enter the synchronized section at a time.

---

### **Example:**

```java
class BankAccount {
    int balance = 1000;

    // synchronized method
    synchronized void withdraw(int amount) {
        if (balance >= amount) {
            System.out.println(Thread.currentThread().getName() + " is withdrawing " + amount);
            balance -= amount;
            System.out.println("Remaining Balance: " + balance);
        } else {
            System.out.println("Not enough balance for " + Thread.currentThread().getName());
        }
    }
}

public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();

        // Thread 1
        Thread t1 = new Thread(() -> {
            account.withdraw(700);
        }, "Thread-1");

        // Thread 2
        Thread t2 = new Thread(() -> {
            account.withdraw(500);
        }, "Thread-2");

        t1.start();
        t2.start();
    }
}
```
- Without synchronization, both threads may access `balance` at the same time, causing incorrect results.

---