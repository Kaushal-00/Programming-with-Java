## **Annotations:**

- An annotation is a label or note that you put on code to give extra information about that code.
- Think of it like a sticky note on your Java code
- It does NOT change logic directly, but tools, compiler, or framework read it and act accordingly.

- **Real-life example:**

```text
"Fragile – Handle with care"
```

- This note doesn’t change the box, but it tells people how to handle it.
- Same idea with annotations in Java.

- Annotations always start with `@`

```java
@Override
```

---

### **Why Annotations Were Introduced?**

- Annotations were introduced in **Java 5** to solve many problems of older Java programming.

#### **Poblems before Annotations:**

#### 1. Too many `public static final` constants

```java
public static final int RED = 1;
public static final int GREEN = 2;
public static final int BLUE = 3;
```

- Problems:
    * No type safety
    * Invalid values allowed
    * Hard to manage

---

#### 2. Heavy use of XML (Very messy)

- Before annotations, frameworks used large XML files:

```xml
<bean id="userService" class="com.app.UserService"/>
```

- Problems:
    * Too much configuration
    * Hard to read
    * Errors only at runtime
    * Code and config separated

---

#### 3. No standard way to give extra info to code

- Developers used:
    * Comments (not readable by compiler)
    * Naming conventions (not reliable)

---

### **Why Annotations are Better (Advantages):**

#### 1. Less Code, More Clarity

```java
@Component
class UserService {
}
```

- Instead of long XML files ✔

---

#### 2. Compile-time Checking

```java
@Override
void show() { }
```

* Compiler checks correctness
* Avoids hidden bugs

---

#### 3. Better Readability

- Annotations make code **self-explanatory**

```java
@Deprecated
void oldMethod() { }
```

- Immediately understand: “Don’t use this method”

---

#### 4.Powerful Framework Support

- Annotations made frameworks like:

    * **Spring**
    * **Hibernate**
    * **JUnit**
    * much easier to use

---

#### **Example:**

```java
@Entity
class Student {
    @Id
    int id;
}
```

- Hibernate reads annotations and automatically:

    * Creates table
    * Maps columns
    * Handles database operations

- No extra XML required

---

### Example 1: Built-in Annotation – `@Override`

```java
class Parent {
    void show() {
        System.out.println("Parent show");
    }
}

class Child extends Parent {
    @Override
    void show() {
        System.out.println("Child show");
    }
}
```

- What `@Override` does?
    * Tells compiler:
        - “This method is overriding a parent method”
    * If method name is wrong → **compile-time error**

- Without `@Override` → mistake may go unnoticed

---

### Example 2: `@Deprecated`

- Used when a method or class should **not be used anymore**

```java
class Test {

    @Deprecated
    void oldMethod() {
        System.out.println("Old method");
    }
}
```

- Compiler will show a **warning** if someone uses `oldMethod()`.

---

### Example 3: `@SuppressWarnings`

- Used to **hide compiler warnings**

```java
@SuppressWarnings("unused")
class Demo {
    int x;
}
```

- Tells compiler:
    - “Don’t show warning for unused variable”

---

### Types of Annotations in Java

####    1. Built-in Annotations

- Provided by Java

    * `@Override`
    * `@Deprecated`
    * `@SuppressWarnings`
    * `@FunctionalInterface`

---

#### 2. Custom Annotations (User-defined)

- You can create your own annotation

```java
@interface MyAnnotation {
    String value();
}
```

Usage:

```java
@MyAnnotation(value = "Hello")
class Demo {
}
```

---

#### 3. Meta-Annotations

- Annotations **used on annotations**

| Annotation    | Purpose                          |
| ------------- | -------------------------------- |
| `@Target`     | Where annotation can be used     |
| `@Retention`  | How long annotation is available |
| `@Documented` | Show in JavaDoc                  |
| `@Inherited`  | Inherited by child classes       |

Example:

```java
import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnno {
}
```

---

#### Where Annotations Are Used a LOT?

- Real-world usage:

    * **Spring** → `@Component`, `@Autowired`, `@RestController`
    * **Hibernate/JPA** → `@Entity`, `@Table`, `@Id`
    * **JUnit** → `@Test`, `@Before`, `@After`

Example:

```java
@Test
void testLogin() {
}
```

---

#### Important Points to Remember

- Annotations are **metadata**, not logic
- They improve **readability & maintainability**
- Used by **compiler, frameworks, tools**
- Heavy use in **enterprise applications**
- Annotations in Java are metadata that provide additional information about code and are used by the compiler, tools, and frameworks.

---
---

### Annotation vs Comments in Java

- At first glance, both look like **notes**, but they are **very different** in purpose and power.

- Comments are for humans only

    * Used to explain code
    * Ignored by compiler and JVM
    * No effect on program execution

- Example
```java
// This method prints hello
void show() {
    System.out.println("Hello");
}
```
- Helps developers understand code
- Compiler doesn’t care

--- 

- Annotations are for compiler, tools, and frameworks
    * Provide metadata about code
    * Read by compiler or frameworks
    * Can affect behavior indirectly

- Example

```java
@Override
void show() {
    System.out.println("Hello");
}
```

- Compiler checks correctness
- Frameworks can process it
- Can change how code is treated

---


| Feature                  | Comments               | Annotations                     |
| ------------------------ | ---------------------- | ------------------------------- |
| Purpose                  | Explain code to humans | Give metadata to compiler/tools |
| Read by compiler         | ❌ No                   | ✅ Yes                           |
| Affects program behavior | ❌ Never                | ✅ Indirectly                    |
| Checked at compile-time  | ❌ No                   | ✅ Yes                           |
| Used by frameworks       | ❌ No                   | ✅ Yes                           |
| Syntax                   | `//`, `/* */`          | `@AnnotationName`               |
| Can cause errors         | ❌ No                   | ✅ Yes (if wrong usage)          |

---

### Examples:

- Using Comment (No checking)

```java
// overriding parent method
void sho() {
}
```

- Method name is wrong (`sho` instead of `show`)
- Compiler will NOT warn you

- Using Annotation (Compile-time safety)

```java
@Override
void sho() {
}
```

- Compiler ERROR: method does not override
- Bug caught early

---

- Using Comments:
```java
// This method should not be used
void oldMethod() { }
```

- No warning
- Anyone can still use it unknowingly

- Using Annotation:
```java
@Deprecated
void oldMethod() { }
```

- Compiler warning shown
- IDE highlights it
- Safer and clearer

---
---

### Built-in Java Annotations:

- Built-in annotations are annotations provided by Java itself
- They help the **compiler** and **developers** understand how code should behave.
- Most common built-in annotations are in:

```java
java.lang
```

---

#### 1. `@Override`

- Tells the compiler:
    - “This method is overriding a method from the parent class”

- Example

```java
class Parent {
    void show() {
        System.out.println("Parent");
    }
}

class Child extends Parent {
    @Override
    void show() {
        System.out.println("Child");
    }
}
```

- Benefits
    - Compile-time checking
    - Avoids spelling mistakes
    - Improves readability

- Without `@Override`, errors may go unnoticed

---

#### 2. `@Deprecated`

- Marks a class, method, or field as old / not recommended

- Example

```java
class Test {

    @Deprecated
    void oldMethod() {
        System.out.println("Old method");
    }
}
```

```java
Test t = new Test();
t.oldMethod(); // compiler warning
```

- Benefits
    - Warns developers
    - IDE shows warning
    - Safer code evolution

---

#### 3. `@SuppressWarnings`

- Tells the compiler:
    - “Ignore specific warnings”
- Example

```java
@SuppressWarnings("unused")
class Demo {
    int x;
}
```
- Common warning types
    * `"unused"`
    * `"unchecked"`
    * `"deprecation"`
    * `"rawtypes"`

- Use carefully (don’t hide real problems)

---

#### 4.`@FunctionalInterface`

- Ensures an interface has only one abstract method

### Example

```java
@FunctionalInterface
interface MyInterface {
    void show();
}
```

- If you add another abstract method:

```java
void display(); // compiler error
```

- Used in
    * Lambda expressions
    * Streams
    * Functional programming

---

#### Built-in Meta-Annotations (Used on Annotations)

- These annotations are used to **define behavior of other annotations**.

---

#### 5. `@Target`

- Specifies **where** an annotation can be used

- Example

```java
import java.lang.annotation.*;

@Target(ElementType.METHOD)
@interface MyAnnotation {
}
```

- Common targets
    * `METHOD`
    * `CLASS`
    * `FIELD`
    * `PARAMETER`
    * `CONSTRUCTOR`

---

#### 6. `@Retention`

- Defines **how long annotation is available**
- Types:

| Policy    | Meaning              |
| --------- | -------------------- |
| `SOURCE`  | Only in source code  |
| `CLASS`   | In bytecode          |
| `RUNTIME` | Available at runtime |

- Example

```java
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnno {
}
```

---

#### 7. `@Documented`

- Includes annotation in **JavaDoc**

```java
@Documented
@interface MyAnno {
}
```

---

#### 8. `@Inherited`

- Allows child classes to inherit annotations

```java
@Inherited
@interface MyAnno {
}
```

---
