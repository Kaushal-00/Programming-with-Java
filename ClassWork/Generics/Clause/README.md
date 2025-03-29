## **Generic Clause:**

- The Generic clause in Java is the part where you define type parameters (like `<T>`, `<E>`, `<K, V>`) in a class, interface, or method.
- It usually looks like this:

```java
class MyClass<T> { ... }
```

That `<T>` is called the **generic clause**.

---

### Where is it used?

- You can use the generic clause in:
1. **Generic Classes**
2. **Generic Interfaces**
3. **Generic Methods**
4. **Generic Constructors**

---

### Generic Class:

```java
class Box<T> {
    T value;

    void set(T value) {
        this.value = value;
    }

    T get() {
        return value;
    }
}
```
- `<T>` tells Java: This class will use a generic type `T` which we will specify later.

---

### Generic Method:

```java
class Printer {
    public <T> void print(T item) {
        System.out.println(item);
    }
}
```
- `<T>` before return type (`void`) tells java: This method can now accept any type: `String`, `Integer`, `Double`, etc.

---

### Generic Interface:

```java
interface DataHolder<T> {
    void setData(T data);
    T getData();
}
```

---

- We can define multiple type parameters like:

```java
class Pair<K, V> {
    K key;
    V value;
}
```
---