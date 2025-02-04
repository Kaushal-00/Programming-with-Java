## **Normal Inner Class (Regular Inner Class)**  
  
A **Normal Inner Class** (also called **Regular Inner Class**) is a **non-static** class defined **inside another class**.  
- It can **access all members** (both `private` and `public`) of the outer class.  
- It **requires an instance** of the outer class to be created.  
- Cannot have `static` members unless they are **constant variables (`final static`)**.  

---

### **Key Features of Normal Inner Class**
1. Must be associated with an instance of the outer class.  
2. Can access both static and non-static members of the outer class.  
3. Cannot have static members (except constants).  
4. Used when an inner class is strongly related to the outer class.  

---

### **Normal Inner Class with a Constructor**
You can define a constructor inside the inner class.

```java
class Outer {
    class Inner {
        Inner() {
            System.out.println("Inner Class Constructor Called");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Outer outer = new Outer();
        Outer.Inner inner = outer.new Inner(); // Calls Inner class constructor
    }
}
```
**Output:**
```
Inner Class Constructor Called
```

---

### **Accessing Private Members of Outer Class**
A normal inner class can **access private members** of the outer class.

```java
class Outer {
    private int number = 10;

    class Inner {
        void showNumber() {
            System.out.println("Number: " + number); // Accessing private variable
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Outer outer = new Outer();
        Outer.Inner inner = outer.new Inner();
        inner.showNumber();
    }
}
```
**Output:**
```
Number: 10
```

---

### **Summary Table**
| **Feature** | **Normal Inner Class** |
|------------|-------------------|
| **Requires Outer Class Instance?** | ✅ Yes |
| **Can Access Outer Class Members?** | ✅ Yes (including private members) |
| **Can Have Static Members?** | ❌ No (except `final static` constants) |
| **Can Be Instantiated Without Outer Class?** | ❌ No |
| **Use Case** | When an inner class is strongly related to the outer class |