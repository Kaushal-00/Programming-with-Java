## **Meta-Annotations:**

- Meta-Annotations are annotations that are used on other annotations.
- Simple line:
    - **Meta-annotations define how an annotation behaves.**

- Think like this:
    * **Annotation** → used on classes, methods, fields
    * **Meta-Annotation** → used on annotations themselves

- Why Meta-Annotations are Needed?
    - When you create your own annotation, Java needs to know:
        * Where can it be used?
        * How long should it exist?
        * Should it appear in JavaDoc?
        * Should child classes inherit it?
    - Meta-annotations answer these questions.

---

### Main Meta-Annotations in Java

- Java provides 4 main meta-annotations:
    1. `@Target`
    2. `@Retention`
    3. `@Documented`
    4. `@Inherited`
    5. `@Repeatable`

---

### **`@Target` Meta-Annotation:**

- `@Target` is used to specify WHERE an annotation can be applied.
- In simple words:
    - **`@Target` restricts the places where an annotation is allowed to be used.**

- Without `@Target`:
    * Annotation can be used **anywhere**
    * Misuse is possible
    * No compile-time restriction

- With `@Target`:
    * Proper usage enforced
    * Compile-time checking
    * Cleaner and safer code

- Syntax of `@Target`

```java
@Target(ElementType.METHOD)
@interface MyAnnotation {
}
```
- Now `@MyAnnotation` can be used **only on methods**

---

### `ElementType`:

- `ElementType` is an enum that defines WHERE an annotation can be used.
- It is used inside `@Target` meta-annotation.
- Simple line:
    - **`ElementType` tells Java which program element an annotation is allowed to annotate.**

---

#### `ElementType.TYPE`:

- Used on:
    * Class
    * Interface
    * Enum

```java
@Target(ElementType.TYPE)
@interface Entity {
}

@Entity
class Student {
}
```

---

#### `ElementType.METHOD`:

- Used on methods

```java
@Target(ElementType.METHOD)
@interface Log {
}

class Test {
    @Log
    void show() {
    }
}
```

---

#### `ElementType.FIELD`:

- Used on variables (fields)

```java
@Target(ElementType.FIELD)
@interface Inject {
}

class Demo {
    @Inject
    int x;
}
```

---

#### `ElementType.PARAMETER`:

- Used on method parameters

```java
@Target(ElementType.PARAMETER)
@interface NotNull {
}

void print(@NotNull String name) {
}
```

---

#### `ElementType.CONSTRUCTOR`:

- Used on constructors

```java
@Target(ElementType.CONSTRUCTOR)
@interface Init {
}

class Test {

    @Init
    Test() {
    }
}
```

---

#### `ElementType.LOCAL_VARIABLE`:

- Used on local variables

```java
@Target(ElementType.LOCAL_VARIABLE)
@interface Temp {
}

void method() {
    @Temp
    int x = 10;
}
```

---

#### `ElementType.PACKAGE`:

- Used on package (inside `package-info.java`)

```java
@Target(ElementType.PACKAGE)
@interface PkgInfo {
}
```
- Used inside:

```java
package com.example;

@PkgInfo
package com.example;
```
---

#### `ElementType.ANNOTATION_TYPE`

- Used on another annotation

```java
@Target(ElementType.ANNOTATION_TYPE)
@interface Meta {
}
```

---

#### **Using Multiple ElementTypes:**

```java
@Target({ElementType.METHOD, ElementType.FIELD})
@interface MyAnno {
}
```
- Can be used on both method & field

---

#### **Real Built-in Annotation Examples:**

| Annotation             | ElementType Used      |
| ---------------------- | --------------------- |
| `@Override`            | `METHOD`              |
| `@FunctionalInterface` | `TYPE`                |
| `@Deprecated`          | `TYPE, METHOD, FIELD` |

---

#### **Common Mistakes:**

- Wrong ElementType

```java
@Target(ElementType.FIELD)
@interface MyAnno { }

@MyAnno
void show() { }   // compile-time error
```
---

- Forgetting `@Target`

```java
@interface MyAnno { }
```
- Can be used anywhere (unsafe)

---

### `@Retention`:

- `@Retention` tells Java how long an annotation should be kept.
- In simple words:
    - **`@Retention` defines the lifetime of an annotation.**

- Java needs to know:
    * Should the annotation exist only in source code?
    * Should it be saved in the `.class` file?
    * Should it be available while the program is running?

- `@Retention` answers this.

- Syntax

```java
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation {
}
```

---

### **RetentionPolicy:**

- `RetentionPolicy` is an enum that defines how long an annotation is kept.
- It is used **inside the `@Retention` meta-annotation**.
- Java provides 3 retention policies:

---

#### 1. `RetentionPolicy.SOURCE`

- Annotation exists **only in source code**
- Removed by compiler
- Not stored in `.class` file

```java
@Retention(RetentionPolicy.SOURCE)
@interface Todo {
}
```

- Usage:
```java
@Todo
void pendingTask() {
}
```

- Used by compiler / IDE  
- Not available at runtime
- Real example:
```java
@Override
```

- `@Override` is only needed by the compiler to check method overriding, so it is removed after compilation and does not need to exist at runtime (Only the compiler needs it).
- `@Override` tells the compiler:
    - “This method MUST override a method from the parent class or interface.”
- Compiler checks:
    - Method name
    - Parameters
    - Return type
- If anything is wrong → compile-time error
---

#### 2. `RetentionPolicy.CLASS` (Default)

- Stored in `.class` file
- Not available at runtime

```java
@Retention(RetentionPolicy.CLASS)
@interface Version {
}
```

- If `@Retention` is not specified, this is used automatically.
- Useful for bytecode tools  
- Reflection cannot access it

---

#### 3. `RetentionPolicy.RUNTIME`:

- Stored in `.class` file
- Available during program execution also.
- Can be read using Reflection

```java
@Retention(RetentionPolicy.RUNTIME)
@interface Role {
    String value();
}
```

- Usage:
```java
@Role("ADMIN")
class UserService {
}
```

- Used by frameworks  
- Most powerful retention
- Used by:
    - Spring (`@Component`)
    - Hibernate (`@Entity`)
    - JUnit (`@Test`)

---

#### **Common Mistakes:**

- Forgetting RUNTIME for framework annotations
```java
@interface MyAnno {
}
```
- Default = CLASS  
- Framework won’t detect it

---

- Expecting SOURCE annotation via reflection
```java
@Retention(RetentionPolicy.SOURCE)
```
- Reflection won’t work

---