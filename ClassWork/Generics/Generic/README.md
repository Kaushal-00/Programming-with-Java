## **Generics:**

- Generics allow you to write flexible, reusable, and type-safe code.
- Generics means writing code that works with any data type in a type-safe way.
- In simple terms: 
    - Generics let you create **classes, interfaces, and methods** where the **type (like `String`, `Integer`) is specified later**, when the object is created or the method is called.

---

### Why Use Generics?

1. **Type Safety** – Prevents runtime `ClassCastException`.
2. **Code Reusability** – Write one version of the code and use it for multiple types.
3. **Cleaner Code** – No need to typecast objects.

---

### Example Without Generics:
```java
import java.util.ArrayList;

public class Example {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();  // no type specified

        list.add("Hello");
        list.add(123);  // This is allowed

        String str = (String) list.get(0);  // Typecasting needed
        System.out.println(str);
    }
}
```
- Problem: You can accidentally add any type of data, which may cause errors at runtime.

---

### Same Example Using Generics:
```java
import java.util.ArrayList;

public class Example {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();  // only Strings allowed

        list.add("Hello");
        // list.add(123); // compile-time error

        String str = list.get(0);  // No typecasting needed
        System.out.println(str);
    }
}
```
- Now only Strings can be added. Errors are caught at compile-time.

---

### Generic Class Example:
```java
// A simple generic class
class Box<T> {
    T value;

    void set(T value) {
        this.value = value;
    }

    T get() {
        return value;
    }
}

public class Main {
    public static void main(String[] args) {
        Box<String> strBox = new Box<>();
        strBox.set("Hello Generics!");
        System.out.println(strBox.get());

        Box<Integer> intBox = new Box<>();
        intBox.set(123);
        System.out.println(intBox.get());
    }
}
```
- Here, `T` is a placeholder for type, and it’s replaced by actual types like `String` or `Integer`. (we can use single alphabet as a placeholder only)

---

### Generic Method Example:
```java
class Demo {
    public <T> void print(T item) {
        System.out.println(item);
    }
}

public class Main {
    public static void main(String[] args) {
        Demo d = new Demo();
        d.print("Hello");
        d.print(100);
        d.print(3.14);
    }
}
```
- The method `print` works for **any type**!

---

### Real-Life Use:
Collections in Java like `ArrayList`, `HashMap`, etc., use generics.

```java
ArrayList<Integer> list = new ArrayList<>();
HashMap<String, Integer> map = new HashMap<>();
```

---