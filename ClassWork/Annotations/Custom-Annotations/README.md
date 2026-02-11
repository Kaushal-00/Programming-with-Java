## **Custom Annotation:**

- A custom annotation is an annotation that you create yourself.
- A custom annotation is user-defined metadata used to provide extra information to classes, methods, fields, etc.
- We Create Custom Annotations Because sometimes built-in annotations are not enough.
- For example:
    * Marking admin-only methods
    * Validating fields
    * Defining roles
    * Creating custom testing framework
    * Building mini version of Spring-like behavior
- syntax:

```java
@interface MyAnnotation {
}
```

---

### **Simple Custom Annotation:**

- Create annotation

```java
@interface MyAnnotation {
}
```

- Use annotation

```java
@MyAnnotation
class Test {
}
```

- This is the most basic form.

---

### **Adding Meta-Annotations:**

- Usually we add:

    * `@Target`
    * `@Retention`

- Example:

```java
import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation {
}
```

- Now:

    * It can be used on classes
    * It is available at runtime

---

### **Annotation Elements:**

- Inside an annotation, we don’t write variables.
- We write **methods without body**.
- These methods are called **annotation elements**.
- They define what values the annotation can store.
- Syntax

```java
@interface AnnotationName {
    returnType elementName();
}
```
- Important:
    * No method body
    * No parameters
    * No throws
    * Ends with `;`

---

- Example

```java
@interface Author {
    String name();
}
```

- Here:
    * `name()` is an annotation element
    * It stores a `String` value

- Usage:

```java
@Author(name = "Kaushal")
class Test {
}
```

- `"Kaushal"` is the value of `name()`.

---

- Wrong way:
```java
@interface Test {
    String name(String s);   // ERROR
}
```

- Correct way:
```java
@interface Test {
    String name();
}
```

---

- Multiple Elements Example

```java
@interface StudentInfo {
    String name();
    int rollNo();
}
```

Usage:

```java
@StudentInfo(name = "Kaushal", rollNo = 101)
class Student {
}
```

- Each element acts like a key-value pair.

---

- Quick Summary:

| Feature       | Meaning                                           |
| ------------- | ------------------------------------------------- |
| Elements      | Methods inside annotation                         |
| No body       | Only declaration                                  |
| No parameters | Cannot take input                                 |
| Default value | Use `default` keyword                             |
| Special case  | If element name is `value`, shortcut allowed      |
| Allowed types | Primitive, String, Class, Enum, Annotation, Array |

---

### **Why Are Annotation Elements Written Like Methods:**

- Annotations are implemented as special interfaces.
- Each element becomes an abstract method.
- At runtime, JVM creates a proxy object that implements that interface and returns stored values when those methods are called.
- That’s why elements must look like methods.

---

- When we write:

```java
@interface Author {
    String name();
}
```

- It looks like a method,

- But why not like this

```java
@interface Author {
    String name;   // Why not variable?
}
```

- Because **annotations are internally special types of interfaces in Java.**
- When we write:

```java
@interface Author
```

- Java actually treats it like:

```java
interface Author extends java.lang.annotation.Annotation
```

- So annotation = special interface.

- And what do interfaces contain?
    - Methods
    - Variables (normal instance variables)

- That’s why annotation elements are written like methods.

---

- What Actually Happens Internally?

- When we write:

```java
@interface Author {
    String name();
}
```

- It means:
    - Any usage of this annotation must provide implementation (value) for `name()`.

- When we use:

```java
@Author(name = "Kaushal")
```

- Java automatically creates an object internally and stores:

```
name() → "Kaushal"
```

- So when we do:

```java
Author a = obj.getAnnotation(Author.class);
System.out.println(a.name());
```
- We are actually calling a method!
- That’s why elements are methods.

---

- Simple Analogy:
- Think of annotation like a **form template**.
- Interface defines:

```
String name();
int rollNo();
```

- When you fill the form:

```
name = Kaushal
rollNo = 101
```

- Later, when Java reads annotation:

```java
a.name();
```

- It retrieves stored value.
- So elements behave like **getter methods**.

---

- Quick Summary

| Question                 | Answer                                  |
| ------------------------ | --------------------------------------- |
| Why methods?             | Because annotation is special interface |
| What do elements become? | Abstract methods                        |
| How are values accessed? | By calling methods                      |
| Why not variables?       | To keep annotation immutable & simple   |

---

### **Why Annotation Elements Cannot Have Parameters:**

- Annotation elements cannot have parameters because annotations are designed to store fixed metadata values known at compile time.
- Allowing parameters would introduce dynamic behavior, which violates the static and immutable nature of annotations.
- Why No Parameters Allowed:
    - Annotations store static metadata
    - Values must be compile-time constants
    - Proxy mechanism needs fixed structure
    - Prevents dynamic logic inside annotation

---

### **Default Values in Annotations:**

- Default values allow you to make an annotation element **optional**.
- If the user does not provide a value, Java will automatically use the default.
- Syntax:

```java
@interface AnnotationName {
    returnType elementName() default value;
}
```
- We use the `default` keyword.

- Example:

```java
@interface Info {
    String message() default "No Message";
}
```

- Now you can use it in two ways:
- Without providing value

```java
@Info
class Test {}
```
- Here:

```
message() → "No Message"
```

- Providing value

```java
@Info(message = "Hello Kaushal")
class Test {}
```
- Now:

```
message() → "Hello Kaushal"
```

- So default value is used only when value is not given.

---

#### **Example:**

```java
@interface Student {
    String name();
    int rollNo() default 0;
}
```

- Usage:

```java
@Student(name = "Kaushal")
class Test {}
```

- Here:
    * `name` → required
    * `rollNo` → optional (default = 0)

---

#### **Rules for Default Values:**

- Default values must be:
    - Compile-time constant
    - Same type as element return type

- Allowed:

```java
int number() default 10;
String name() default "Java";
boolean flag() default true;
```

- Not Allowed:

```java
String name() default new String("Java");   // ERROR
int number() default Math.random();         // ERROR
```

- Because these are not compile-time constants.

---

- It can be Array also:

```java
@interface Tags {
    String[] value() default {"Java", "Spring"};
}
```

---

#### **Special Case: `value()` Element:**

- If an annotation has **only one element**, and its name is `value`,
- then Java allows you to skip writing `value =`.
- Normal Annotation Example:

```java
@interface Author {
    String name();
}
```

- Usage:

```java
@Author(name = "Kaushal")
```

- We MUST write `name =`.
- But, 
- Special Case Example:

```java
@interface Message {
    String value();
}
```

- Now we can use it like this:

```java
@Message("Hello")
class Test {}
```

- Instead of:

```java
@Message(value = "Hello")
```

- Java automatically understands that `"Hello"` is for `value()`.

---

- Important Rule
- This shortcut works ONLY IF:
    - The annotation has only one element
    - That element is named `value`

- If There Are Multiple Elements
- Example:

```java
@interface Student {
    String value();
    int rollNo();
}
```
- Now we cannot do this:

```java
@Student("Kaushal")   // ERROR
```

- We must write:

```java
@Student(value = "Kaushal", rollNo = 101)
```

Because there are multiple elements.

---

- If `value()` Has Default
- Example:

```java
@interface Message {
    String value() default "Hi";
}
```

- Now we can use:

```java
@Message
```

OR

```java
@Message("Hello")
```

- Both are valid.

---

### **Annotation Data Types:** 

- When we define an annotation element like:

```java
@interface Info {
    String name();
}
```
- The `String` here is the data type of that annotation element.
- But Java allows only specific types.
- Annotation elements can return ONLY:

---

#### **1. Primitive Types**

```java
int
double
float
boolean
char
byte
short
long
```

- Example:

```java
@interface Test {
    int number();
    boolean flag();
}
```

---

#### **2. String**

```java
@interface Author {
    String name();
}
```

---

#### **3. Class Type**

```java
@interface Demo {
    Class clazz();
}
```

- Usage:

```java
@Demo(clazz = String.class)
```

---

#### **4. Enum Type**

```java
enum Level {
    LOW, MEDIUM, HIGH
}

@interface Log {
    Level level();
}
```

- Usage:

```java
@Log(level = Level.HIGH)
```

---

#### **5. Annotation Type**

- Annotation inside annotation

```java
@interface Author {
    String name();
}

@interface Book {
    Author author();
}
```

- Usage:

```java
@Book(author = @Author(name = "Kaushal"))
```

---

#### **6. Array of Above Types**

- We can use arrays of allowed types.
- Example:

```java
@interface Tags {
    String[] value();
}
```

- Usage:

```java
@Tags({"Java", "Spring", "Backend"})
```

---

#### **Not Allowed Data Types:**

- Objects like:

```java
ArrayList
HashMap
Scanner
```

- Custom classes (normal class)

```java
MyClass obj();   // NOT allowed
```

- Generics

```java
List<String>   // NOT allowed
```

- Wrapper Classes

```java
Integer   // NOT allowed
Double    // NOT allowed
```

- Only primitive `int`, not `Integer`.

---

#### **Why Only These Types Are Allowed?**

- Because:
1. Annotation values must be Compile-Time Constants

Example:

```java
@Info(name = "Kaushal")
```

- This value is stored directly in `.class` file.
- Java needs fixed, constant, simple types.

2. JVM Stores Annotation Metadata in Class File
- The class file format supports only:
    * Primitive constants
    * String constants
    * Class references
    * Enum constants
    * Annotation structures
    * Arrays of these

- So Java restricts types.

---