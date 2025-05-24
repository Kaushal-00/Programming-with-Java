## **Functional Interface:**

- A Functional Interface is an interface that has only one abstract method.
- It can have multiple default or static methods, but only ONE abstract method.
- It is called “Functional” because it can be used as the target for a lambda expression — meaning you can implement it with less code using lambdas.

---

### **Example of Functional Interface:**

```java
@FunctionalInterface
interface MyFunction {
    void greet();  // only one abstract method
}
```

- Note: The `@FunctionalInterface` annotation is optional, but recommended.
- If you try to add another abstract method, the compiler will give an error.

```java
public class Main {
    public static void main(String[] args) {
        MyFunction obj = new MyFunction() {
            public void greet() {
                System.out.println("Hello from functional interface!");
            }
        };

        obj.greet();
    }
}
```

- Using Functional Interface with Lambda.

```java
public class Main {
    public static void main(String[] args) {
        MyFunction obj = () -> System.out.println("Hello using Lambda!");
        obj.greet();
    }
}
```

---

- Java already has many functional interfaces in the `java.util.function` package:

| Interface       | Abstract Method | Purpose                      |
| --------------- | --------------- | ---------------------------- |
| `Runnable`      | `run()`         | Used in threads              |
| `Callable<T>`   | `call()`        | Returns value in threads     |
| `Consumer<T>`   | `accept(T t)`   | Takes input, returns nothing |
| `Supplier<T>`   | `get()`         | No input, returns output     |
| `Function<T,R>` | `apply(T t)`    | Takes input, returns output  |
| `Predicate<T>`  | `test(T t)`     | Returns true/false           |

---