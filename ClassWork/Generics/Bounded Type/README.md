## **Bounded Type in Generics:**

- Bounded Type means putting a limit (boundary) on the type that can be passed as a generic.

---

### Example:

```java
class Box<T extends Number> {
    T value;

    void setValue(T value) {
        this.value = value;
    }

    T getValue() {
        return value;
    }
}
```

- Here, `<T extends Number>` means:
    - You can only use `Number` or its subclasses like `Integer`, `Double`, `Float`, etc.
    - You cannot use `String`, `Character`, etc.

---

- We can use more than one boundary using `&`.

```java
class Data<T extends Number & Comparable<T>> {
    T value;
}
```

- This means:
    - `T` must be a **subclass of Number**
    - and also **implement Comparable interface**

---

### Summary

| Syntax                          | Meaning                                    |
|---------------------------------|--------------------------------------------|
| `<T extends Class>`            | Only classes that extend this class        |
| `<T extends Interface>`        | Only classes that implement this interface |
| `<T extends Class & Interface>`| Both class and interface bounds            |