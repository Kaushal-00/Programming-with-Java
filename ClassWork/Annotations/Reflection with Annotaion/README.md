## **Reading Custom Annotation Using Reflection:**

- Annotations store metadata.
- But metadata is useful only if we can read it.
- To read annotation at runtime → we use Reflection.

---

### **Important Condition:**

- If we want to read annotation using reflection, it MUST have:

```java
@Retention(RetentionPolicy.RUNTIME)
```

- Otherwise JVM will remove it before runtime.

---

- Step 1: Create Custom Annotation

```java
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface Author {
    String name();
    int version();
}
```

---

- Step 2: Use Annotation

```java
@Author(name = "Kaushal", version = 1)
class Demo {
}
```

---

- Step 3: Read Annotation Using Reflection

```java
import java.lang.reflect.*;

public class Main {
    public static void main(String[] args) {

        Class<Demo> obj = Demo.class;

        // Get annotation object
        Author author = obj.getAnnotation(Author.class);

        // Read values
        System.out.println("Name: " + author.name());
        System.out.println("Version: " + author.version());
    }
}
```

- Output:

```
Name: Kaushal
Version: 1
```

---

- What Is Happening Internally:
    - JVM reads annotation metadata from class file
    - JVM creates proxy object
    - `getAnnotation()` returns that proxy
    - Calling `author.name()` returns stored value
- So we are actually calling a method on a runtime-generated object.

---

### **Different Ways to Read Annotation:**

1. Check If Annotation Exists

```java
if(obj.isAnnotationPresent(Author.class)) {
    System.out.println("Annotation is present");
}
```
---

2. Get All Annotations

```java
Annotation[] annotations = obj.getAnnotations();

for(Annotation a : annotations) {
    System.out.println(a);
}
```

---

3. Reading Annotation from Method

```java
class Test {

    @Author(name = "Kaushal", version = 2)
    public void display() {}
}
```

Read it:

```java
Method m = Test.class.getMethod("display");

Author a = m.getAnnotation(Author.class);

System.out.println(a.name());
```

---

4. Reading Annotation from Field

```java
class Student {

    @Author(name = "Kaushal", version = 3)
    String name;
}
```

Read:

```java
Field f = Student.class.getDeclaredField("name");

Author a = f.getAnnotation(Author.class);

System.out.println(a.version());
```

---

- Where Reflection Can Read From
- We can read annotations from:

| Location    | Reflection Class |
| ----------- | ---------------- |
| Class       | Class            |
| Method      | Method           |
| Field       | Field            |
| Constructor | Constructor      |
| Parameter   | Parameter        |

---