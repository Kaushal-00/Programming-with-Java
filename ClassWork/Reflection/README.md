## **Reflection:**

- Reflection is a feature in Java that allows a program to inspect and modify itself at runtime.
- In simple words:
    - Reflection allows Java to see details of a class (methods, fields, constructors) while the program is running.
    - Reflection is a feature in Java that allows a program to inspect and modify classes, methods, fields, and constructors at runtime.
- Normally Java code is fixed after compilation.
- But Reflection allows Java to look inside a class while the program is running.

- Normally in Java:
    * We know class name
    * We know methods
    * We know variables

- But using Reflection, we can:
    * Find class name
    * Find methods
    * Find variables
    * Create objects dynamically
    * Call methods dynamically
    * Access private variables
    * Find methods without knowing them at compile time

---

### **Need:**

- Normally:

```java
Student s = new Student();
s.display();
```

- Here:

    * We already know class name → `Student`
    * We already know method → `display()`

- But what if:

    * Class name is stored in database?
    * Method name comes from user input?
    * We don't know class at compile time?
    * Framework needs to create objects automatically?

- That is where Reflection is used.

---

### **Working of Reflection:**

- Reflection mainly uses:

```
java.lang.reflect package
```

- Important classes:

    * `Class`
    * `Method`
    * `Field`
    * `Constructor`

---

### **Getting Class Object**

- First, we need the `Class` object.
- There are 3 ways:

---

1. Using `.class`

```java
Class c = Student.class;
```

---

2. Using object

```java
Student s = new Student();
Class c = s.getClass();
```

---

3. Using Class.forName()

```java
Class c = Class.forName("Student");
```

- This loads class dynamically.

---

### **Example 1: Getting Class Information:**

- Student.java

```java
class Student {
    int roll;
    String name;

    public void display() {
        System.out.println("Hello Student");
    }
}
```

- Main Program

```java
import java.lang.reflect.*;

class Test {
    public static void main(String[] args) throws Exception {

        Class c = Class.forName("Student");

        System.out.println("Class Name: " + c.getName());

        Method[] methods = c.getDeclaredMethods();
        for(Method m : methods) {
            System.out.println("Method: " + m.getName());
        }

        Field[] fields = c.getDeclaredFields();
        for(Field f : fields) {
            System.out.println("Field: " + f.getName());
        }
    }
}
```

- Output:

```
Class Name: Student
Method: display
Field: roll
Field: name
```

- Reflection inspected class structure at runtime.

---

### **Example 2: Creating Object Using Reflection:**

```java
Class c = Class.forName("Student");

Object obj = c.getDeclaredConstructor().newInstance();

System.out.println(obj.getClass().getName());
```

- Object created without using `new Student()`.

---

### **Example 3: Calling Method Using Reflection:**

```java
Class c = Class.forName("Student");

Object obj = c.getDeclaredConstructor().newInstance();

Method m = c.getMethod("display");

m.invoke(obj);
```

- Output:

```
Hello Student
```

- Method called dynamically.

---

### **Example 4: Accessing Private Variable:**

- Student Class

```java
class Student {
    private int roll = 10;
}
```

- Using Reflection

```java
Class c = Class.forName("Student");

Object obj = c.getDeclaredConstructor().newInstance();

Field f = c.getDeclaredField("roll");

f.setAccessible(true);   // VERY IMPORTANT

System.out.println(f.get(obj));
```

- Output:

```
10
```

- Reflection can break encapsulation (access private members).

---

### **Why Reflection is Dangerous?**

- Because:
    * It can access private data
    * Break encapsulation
    * Slower than normal code
    * Can cause security problems

- That’s why it should be used carefully.

---

### **Important Reflection Methods:**

| Method                    | Purpose                    |
| ------------------------- | -------------------------- |
| getName()                 | Get class name             |
| getDeclaredMethods()      | Get all methods            |
| getDeclaredFields()       | Get all variables          |
| getDeclaredConstructors() | Get constructors           |
| getMethod()               | Get specific public method |
| getDeclaredField()        | Get specific field         |
| invoke()                  | Call method                |
| setAccessible(true)       | Access private members     |

---

### **The `Class` Class:**

- `Class` is a predefined class in `java.lang` package that represents metadata (information) about a class.
- Simple meaning:
    - When your Java program runs, every class has a corresponding `Class` object in memory.
- That `Class` object stores information like:
    * Class name
    * Package name
    * Methods
    * Fields (variables)
    * Constructors
    * Interfaces
    * Superclass
    * Annotations
    * Modifiers (public, private, etc.)

---

- When we write:

```java
Student s = new Student();
```

- JVM does TWO things:
    1. Loads `Student` class into memory
    2. Creates a `Class` object for `Student`

- So internally:

```
Student.class  →  Class object
```

- That object contains all metadata of Student class.

---

It is inside:

```
java.lang.Class
```

- We don’t need to import it because `java.lang` is automatically imported.
- There are 3 important ways to get Class Object.

---





#### 1. `ClassName.class`

```java
Class c = Student.class;
```

- Gets the `Class` object at compile-time.
- Advantages:
    * No exception
    * Fast
    * Compile-time safe

```java
class Student { }

class Test {
    public static void main(String[] args) {
        Class c = Student.class;
        System.out.println(c.getName());
    }
}
```

- Used when:
    - We already know the class name
    - Normal reflection usage
    - No dynamic loading needed
    - We want safest & fastest way

---

#### 2. `object.getClass()`

```java
Student s = new Student();
Class c = s.getClass();
```

- Gets Class object from an **existing object**.

```java
class Student { }

class Test {
    public static void main(String[] args) {
        Student s = new Student();
        Class c = s.getClass();
        System.out.println(c.getName());
    }
}
```

- Used when:
    - We already have an object
    - We want to know its runtime type 
    - Used in polymorphism cases

---

#### **Example:**

```java
Object obj = new Student();
System.out.println(obj.getClass().getName());
```

- Even if reference type is `Object`,
- it tells actual runtime class → `Student`.

---

#### 3. `Class.forName()`

```java
Class c = Class.forName("Student");
```
- Loads class dynamically at runtime using class name as String.

```java
class Test {
    public static void main(String[] args) throws Exception {
        Class c = Class.forName("Student");
        System.out.println(c.getName());
    }
}
```

- Important:
    * Throws `ClassNotFoundException`
    * Class name must be fully qualified (with package)

- Used when:
    * Class name comes from:
        * Database
        * User input
        * Config file
    * We don’t know class at compile-time
    * Framework development
    * JDBC driver loading

- Example:

```java
Class.forName("com.example.Student");
```

---

#### **Note:**

- There is only ONE `Class` object per class.
- Even if we create many objects:

```java
Student s1 = new Student();
Student s2 = new Student();
```

- Both share the same:

```
Student.class
```

---

- All three methods return the **same Class object**.
- Example:

```java
Class c1 = Student.class;
Student s = new Student();
Class c2 = s.getClass();
Class c3 = Class.forName("Student");

System.out.println(c1 == c2); // true
System.out.println(c2 == c3); // true
```

- Output will be `true`
- Because JVM creates only ONE Class object per class.

---

#### **Important Methods of `Class` Class:**

1. `getName()`

- Returns full class name.

```java
Class c = Student.class;
System.out.println(c.getName());
```

- Output:

```
Student
```

---

2. `getSimpleName()`

- Returns class name without package.

```java
System.out.println(c.getSimpleName());
```

---

3. `getDeclaredMethods()`

- Returns all methods (including private).

```java
Method[] methods = c.getDeclaredMethods();
```

---

4. `getDeclaredFields()`

- Returns all variables.

```java
Field[] fields = c.getDeclaredFields();
```

---

5. `getDeclaredConstructors()`

- Returns all constructors.

```java
Constructor[] cons = c.getDeclaredConstructors();
```

---

6. `newInstance()` (Old Way)

- Deprecated now.
- Better way:

```java
Object obj = c.getDeclaredConstructor().newInstance();
```

- Creates object using Reflection.

---

7. `getSuperclass()`

- Returns parent class.

```java
System.out.println(c.getSuperclass());
```

---

8. `isInterface()`

- Checks if class is interface.

```java
System.out.println(c.isInterface());
```

---

9. `isAnnotationPresent()`

- Used to check annotation.

```java
c.isAnnotationPresent(MyAnnotation.class);
```

---

#### **Example:**

- Student.java

```java
class Student {
    int roll;
    private String name;

    public void display() {
        System.out.println("Hello");
    }
}
```

---

- Main Class

```java
import java.lang.reflect.*;

class Test {
    public static void main(String[] args) throws Exception {

        Class c = Class.forName("Student");

        System.out.println("Class Name: " + c.getName());

        Field[] fields = c.getDeclaredFields();
        for(Field f : fields) {
            System.out.println("Field: " + f.getName());
        }

        Method[] methods = c.getDeclaredMethods();
        for(Method m : methods) {
            System.out.println("Method: " + m.getName());
        }
    }
}
```

---

### **Getting Class Information:**

- Let’s create one class to test everything.

```java
package mypackage;

interface Printable { }

public abstract class Student extends Person implements Printable {
}
```

- Assume:

```java
class Person { }
```

---

#### **1. Getting Class Object**

```java
Class c = Student.class;
```

- Now we will extract information from `c`.

---

#### **2. Getting Class Name**

- Method:

```java
getName()
```

- Example:

```java
System.out.println("Full Name: " + c.getName());
System.out.println("Simple Name: " + c.getSimpleName());
```

- Output:

```
Full Name: mypackage.Student
Simple Name: Student
```

- Difference:

| Method          | Returns                |
| --------------- | ---------------------- |
| getName()       | Full name with package |
| getSimpleName() | Only class name        |

---

#### **3. Getting Package Name**

- Method:

```java
getPackage()
```

- Example:

```java
Package p = c.getPackage();
System.out.println("Package: " + p.getName());
```

- Output:

```
Package: mypackage
```

---

#### **4. Getting Modifiers (public, abstract, final)**

- Modifiers are stored as numbers internally.

- Method:

```java
getModifiers()
```

- But this returns integer.
- To convert it into readable form, use:

```java
Modifier.toString()
```

- Example:

```java
import java.lang.reflect.Modifier;

int mod = c.getModifiers();
System.out.println("Modifiers: " + Modifier.toString(mod));
```

- Output:

```
Modifiers: public abstract
```

- Possible Modifiers:
    * public
    * private
    * protected
    * abstract
    * final
    * static

---

#### **5. Getting Superclass**

- Method:

```java
getSuperclass()
```

- Example:

```java
Class superClass = c.getSuperclass();
System.out.println("Superclass: " + superClass.getName());
```

- Output:

```
Superclass: Person
```

- Important:
- If class does not extend anything explicitly:

```java
class A { }
```

- Then:

```java
System.out.println(A.class.getSuperclass());
```

- Output:

```
class java.lang.Object
```

- Because every class extends `Object`.

---

#### **6. Getting Implemented Interfaces**

- Method:

```java
getInterfaces()
```

- It returns array of `Class`.
Example:

```java
Class[] interfaces = c.getInterfaces();

for(Class i : interfaces) {
    System.out.println("Interface: " + i.getName());
}
```

- Output:

```
Interface: Printable
```

---

#### **Example:**

```java
import java.lang.reflect.*;

interface Printable { }

class Person { }

public abstract class Student extends Person implements Printable {

    public static void main(String[] args) {

        Class c = Student.class;

        // 1. Class Name
        System.out.println("Full Name: " + c.getName());
        System.out.println("Simple Name: " + c.getSimpleName());

        // 2. Package
        Package p = c.getPackage();
        System.out.println("Package: " + p);

        // 3. Modifiers
        int mod = c.getModifiers();
        System.out.println("Modifiers: " + Modifier.toString(mod));

        // 4. Superclass
        System.out.println("Superclass: " + c.getSuperclass());

        // 5. Interfaces
        Class[] interfaces = c.getInterfaces();
        for(Class i : interfaces) {
            System.out.println("Interface: " + i.getName());
        }
    }
}
```

---

#### **Summary Table:**

| Information  | Method Used                |
| ------------ | -------------------------- |
| Class Name   | getName(), getSimpleName() |
| Package Name | getPackage()               |
| Modifiers    | getModifiers()             |
| Superclass   | getSuperclass()            |
| Interfaces   | getInterfaces()            |

---

### **Working with Constructors:**

- First let’s create one class to test everything.

```java
class Student {

    public Student() {
        System.out.println("Public Constructor");
    }

    public Student(int roll) {
        System.out.println("Roll: " + roll);
    }

    private Student(String name) {
        System.out.println("Name: " + name);
    }
}
```

- Now we will use Reflection on this class.

---

#### **1. Getting Class Object**

```java
Class c = Student.class;
```

- Now we work with constructors.

---

#### **2. `getConstructors()`**

- Returns **only public constructors** of the class.
- Syntax:

```java
Constructor[] cons = c.getConstructors();
```

- Example:

```java
import java.lang.reflect.*;

Class c = Student.class;

Constructor[] cons = c.getConstructors();

for(Constructor con : cons) {
    System.out.println(con);
}
```

- Output:

```
public Student()
public Student(int)
```

- Notice:
    - Private constructor is NOT shown.

---

#### **3. `getDeclaredConstructors()`**

- Returns ALL constructors (public + private + protected + default)
- Syntax:

```java
Constructor[] cons = c.getDeclaredConstructors();
```

- Example:

```java
Constructor[] cons = c.getDeclaredConstructors();

for(Constructor con : cons) {
    System.out.println(con);
}
```

- Output:

```
public Student()
public Student(int)
private Student(java.lang.String)
```

- Now private constructor is visible.

- Difference Between Both

| Method                    | Returns                  |
| ------------------------- | ------------------------ |
| getConstructors()         | Only public constructors |
| getDeclaredConstructors() | All constructors         |

---

#### **4. Accessing Private Constructor**

- Normally we cannot do:

```java
new Student("Kaushal");   // Error (private)
```

- But using Reflection we can access it.
- Steps:
    1. Get constructor using `getDeclaredConstructor()`
    2. Use `setAccessible(true)`
    3. Create object

- Example:

```java
import java.lang.reflect.*;

class Test {
    public static void main(String[] args) throws Exception {

        Class c = Student.class;

        Constructor con = c.getDeclaredConstructor(String.class);

        con.setAccessible(true);   // VERY IMPORTANT

        Object obj = con.newInstance("Kaushal");
    }
}
```

- Output:

```
Name: Kaushal
```

- Reflection breaks encapsulation.

---

#### **5. Creating Object Using Reflection**

- Instead of:

```java
Student s = new Student();
```

- We can do:

- Using Default Constructor

```java
Class c = Student.class;

Object obj = c.getDeclaredConstructor().newInstance();
```

- Calls public no-argument constructor.

---

- Using Parameterized Constructor

```java
Constructor con = c.getDeclaredConstructor(int.class);

Object obj = con.newInstance(101);
```

- Calls constructor with parameter.

---

#### **Important Methods Used:**

| Method                    | Purpose                    |
| ------------------------- | -------------------------- |
| getConstructors()         | Get public constructors    |
| getDeclaredConstructors() | Get all constructors       |
| getDeclaredConstructor()  | Get specific constructor   |
| setAccessible(true)       | Access private constructor |
| newInstance()             | Create object              |

---

#### **Example:**

```java
import java.lang.reflect.*;

class Student {

    public Student() {
        System.out.println("Public Constructor");
    }

    private Student(String name) {
        System.out.println("Private Constructor: " + name);
    }
}

class Test {
    public static void main(String[] args) throws Exception {

        Class c = Student.class;

        // 1. Public constructor
        Object obj1 = c.getDeclaredConstructor().newInstance();

        // 2. Private constructor
        Constructor con = c.getDeclaredConstructor(String.class);
        con.setAccessible(true);
        Object obj2 = con.newInstance("Kaushal");
    }
}
```

---

#### **Important Points:**

- Reflection is slower than normal object creation.
- Can break security.
- Used mostly in frameworks (Spring, Hibernate).
- Private constructor access should be avoided unless necessary.

---

### **Working with Methods**

- Let’s create one class:

```java
class Student {

    public void display() {
        System.out.println("Hello Student");
    }

    public void showRoll(int roll) {
        System.out.println("Roll: " + roll);
    }

    private void secretMethod() {
        System.out.println("This is private method");
    }
}
```

- Now we will use Reflection on this class.

---

#### **1. Get Class Object**

```java
Class c = Student.class;
```

---

#### **2. `getMethods()`**

- Returns all public methods of:
    * Current class
    * Parent class (like Object class)

- Syntax:

```java
Method[] methods = c.getMethods();
```

- Example:

```java
import java.lang.reflect.*;

Method[] methods = c.getMethods();

for(Method m : methods) {
    System.out.println(m.getName());
}
```

- Output (Example):

```
display
showRoll
wait
equals
toString
hashCode
...
```

- Notice:

    * It includes `wait()`, `equals()` etc.
    * Because they come from `Object` class.

---

#### **3. `getDeclaredMethods()`**

- Returns **all methods declared in that class only** (public + private + protected + default)
- But does NOT include parent class methods.

- Syntax:

```java
Method[] methods = c.getDeclaredMethods();
```

- Example:

```java
Method[] methods = c.getDeclaredMethods();

for(Method m : methods) {
    System.out.println(m.getName());
}
```

- Output:

```
display
showRoll
secretMethod
```

- Now private method is also visible.

---

##### **Difference Between Both**

| Method               | Returns                                 |
| -------------------- | --------------------------------------- |
| getMethods()         | Public methods (including parent class) |
| getDeclaredMethods() | All methods of current class only       |

---

#### **4. Invoking Methods Using `invoke()`**

- Reflection allows us to call methods dynamically.
- Syntax:

```java
method.invoke(object, parameters);
```

- Example 1: Call method without parameters

```java
Student s = new Student();

Method m = c.getMethod("display");

m.invoke(s);
```

- Output:

```
Hello Student
```

---

- Example 2: Call method with parameters

```java
Method m = c.getMethod("showRoll", int.class);

Student s = new Student();

m.invoke(s, 101);
```

- Output:

```
Roll: 101
```

- Important:

| Part       | Meaning        |
| ---------- | -------------- |
| "showRoll" | Method name    |
| int.class  | Parameter type |
| s          | Object         |
| 101        | Argument       |

---

#### **Accessing Private Methods:**

- Normally:

```java
s.secretMethod();   // Error
```

- But Reflection can access it.
- Steps:
    1. Use `getDeclaredMethod()`
    2. Use `setAccessible(true)`
    3. Use `invoke()`

- Example:

```java
Method m = c.getDeclaredMethod("secretMethod");

m.setAccessible(true);   // VERY IMPORTANT

Student s = new Student();

m.invoke(s);
```

- Output:

```
This is private method
```

- Reflection breaks encapsulation.

---

#### **Example:**

```java
import java.lang.reflect.*;

class Student {

    public void display() {
        System.out.println("Hello Student");
    }

    private void secretMethod() {
        System.out.println("Private Method Called");
    }
}

class Test {
    public static void main(String[] args) throws Exception {

        Class c = Student.class;

        Student s = new Student();

        // Public method
        Method m1 = c.getMethod("display");
        m1.invoke(s);

        // Private method
        Method m2 = c.getDeclaredMethod("secretMethod");
        m2.setAccessible(true);
        m2.invoke(s);
    }
}
```

---

#### **Important Points:**
    * `invoke()` can throw exceptions.
    * Reflection is slower than normal method call.
    * It breaks encapsulation.
    * Used in frameworks (Spring, JUnit, Hibernate).

---

### **Working with Fields:**

```java
class Student {

    public int roll = 101;
    private String name = "Kaushal";
    protected double marks = 85.5;
}
```

- Now we will use Reflection on this class.

---

#### **1. Get Class Object:**

```java
Class c = Student.class;
```

---

#### **2. `getFields()`**

- Returns only public fields (including inherited public fields)
- Syntax:

```java
Field[] fields = c.getFields();
```
- Example:

```java
import java.lang.reflect.*;

Field[] fields = c.getFields();

for(Field f : fields) {
    System.out.println(f.getName());
}
```

- Output:

```
roll
```

- Only `roll` is shown because it is public.

---

#### **3. `getDeclaredFields()`**

- Returns all fields declared in that class
    * public
    * private
    * protected
    * default

- But does NOT include parent class fields.

- Syntax:

```java
Field[] fields = c.getDeclaredFields();
```

- Example:

```java
Field[] fields = c.getDeclaredFields();

for(Field f : fields) {
    System.out.println(f.getName());
}
```

- Output:

```
roll
name
marks
```

- Now all fields are visible.

- Difference Between Both

| Method              | Returns                               |
| ------------------- | ------------------------------------- |
| getFields()         | Only public fields (including parent) |
| getDeclaredFields() | All fields of current class           |

---

#### **4. Reading Field Values:**

- To read value:
- Syntax:

```java
field.get(object);
```

- Example (Reading public field)

```java
Student s = new Student();

Field f = c.getField("roll");

System.out.println(f.get(s));
```

- Output:

```
101
```

---

#### **5. Modifying Field Values:**

- We can change field value using:

```java
field.set(object, value);
```

- Example:

```java
Student s = new Student();

Field f = c.getField("roll");

f.set(s, 200);

System.out.println(s.roll);
```

- Output:

```
200
```

- Value successfully changed.

---

#### **6. Accessing Private Fields:**

Normally:

```java
System.out.println(s.name);   // Error
```

- But Reflection can access it.
- Steps:

    1. Use `getDeclaredField()`
    2. Use `setAccessible(true)`
    3. Use `get()` or `set()`

- Example:

```java
Student s = new Student();

Field f = c.getDeclaredField("name");

f.setAccessible(true);   // VERY IMPORTANT

System.out.println(f.get(s));
```

- Output:

```
Kaushal
```

---

#### **7. Modifying Private Field:**

```java
f.set(s, "Rahul");

System.out.println(f.get(s));
```

- Output:

```
Rahul
```

- Reflection breaks encapsulation.

---

#### **Example:**

```java
import java.lang.reflect.*;

class Student {

    public int roll = 101;
    private String name = "Kaushal";
}

class Test {
    public static void main(String[] args) throws Exception {

        Class c = Student.class;

        Student s = new Student();

        // Public field
        Field f1 = c.getField("roll");
        System.out.println("Roll: " + f1.get(s));

        f1.set(s, 500);
        System.out.println("Updated Roll: " + s.roll);

        // Private field
        Field f2 = c.getDeclaredField("name");
        f2.setAccessible(true);

        System.out.println("Name: " + f2.get(s));

        f2.set(s, "Amit");
        System.out.println("Updated Name: " + f2.get(s));
    }
}
```

---

#### **Important Points:**

* Reflection is slower than normal field access.
* It breaks encapsulation.
* Can create security problems.
* Used mainly in frameworks (Hibernate, Spring).

---

### **Access Modifiers:**

- In Java, access modifiers control visibility:

| Modifier  | Accessible From         |
| --------- | ----------------------- |
| public    | Everywhere              |
| protected | Same package + subclass |
| default   | Same package only       |
| private   | Only inside same class  |

- Example:

```java
class Student {
    private int roll = 101;
}
```

- Normally:

```java
Student s = new Student();
System.out.println(s.roll);  // Compile-time error
```

- Because `roll` is private.

---

### **`setAccessible(true)`**

- It is a method of:
    * `Field`
    * `Method`
    * `Constructor`

- It tells JVM:
    - Ignore Java access rules and allow access.

---

#### **Example: Breaking Encapsulation:**

```java
import java.lang.reflect.*;

class Student {
    private int roll = 101;
}

class Test {
    public static void main(String[] args) throws Exception {

        Student s = new Student();

        Field f = Student.class.getDeclaredField("roll");

        f.setAccessible(true);  // Breaking encapsulation

        System.out.println(f.get(s));
    }
}
```

- Output:

```
101
```

- Even though `roll` is private.

---

- Encapsulation means:

    * Hiding internal data
    * Protecting data using private keyword

- Example:

```java
private int balance;
```

- Only controlled access via getter/setter.

---

- Reflection + `setAccessible(true)`:
    - Access private variables
    - Call private methods
    - Use private constructors

- It bypasses normal Java access control.

- That means:
    - Data protection is broken
    - Object safety is broken

---

#### **Example: Breaking Singleton:**

```java
class Singleton {

    private static Singleton obj = new Singleton();

    private Singleton() { }

    public static Singleton getInstance() {
        return obj;
    }
}
```

- Singleton ensures: Only one object.
- But Reflection can break it:

```java
Constructor con = Singleton.class.getDeclaredConstructor();
con.setAccessible(true);

Singleton s1 = (Singleton) con.newInstance();
Singleton s2 = (Singleton) con.newInstance();

System.out.println(s1 == s2);   // false
```

- Now multiple objects created.
- Singleton broken.

---

#### **Security Implications:**

- Because Reflection can:
    * Access private fields
    * Modify final fields
    * Access sensitive data
    * Break design patterns

- It creates security risks.

---

#### **Example:**

- Suppose banking app:

```java
private double balance;
```

- Reflection can modify it:

```java
field.setAccessible(true);
field.set(account, 1000000);
```

- Now balance changed illegally.

---

#### **Why is it Allowed?**

- Because Reflection is needed for:
    * Frameworks
    * Serialization
    * ORM tools

- But in secure environments:
    * Security Manager (old Java)
    * Module system (Java 9+)

- Restricts reflective access.

---

#### **Spring Framework:**

- Spring:
    * Creates objects
    * Injects dependencies
    * Calls private constructors

- Example:

```java
@Autowired
private Service service;
```

- Spring uses reflection to inject it.

---