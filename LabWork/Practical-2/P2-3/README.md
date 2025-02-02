## Practical-2.2:

- Write a program to demonstrate usage of different methods of
Wrapper class.


### **Wrapper Class in Java**  

In Java, **wrapper classes** are used to **convert primitive data types into objects**. This is helpful because 
sometimes we need an object instead of a primitive value, such as when working with collections like `ArrayList`.  

---

## **1. Why Do We Need Wrapper Classes?**
Java has **8 primitive data types**:  
`int`, `float`, `double`, `char`, `byte`, `short`, `long`, `boolean`  
However, Java does not allow primitive types to be stored in objects like `ArrayList`, `HashMap`, etc.  

---

## **2. List of Wrapper Classes in Java**
Each primitive type has a corresponding **wrapper class**:  

| Primitive Type | Wrapper Class |
|---------------|--------------|
| `int`        | `Integer` |
| `float`      | `Float` |
| `double`     | `Double` |
| `char`       | `Character` |
| `byte`       | `Byte` |
| `short`      | `Short` |
| `long`       | `Long` |
| `boolean`    | `Boolean` |

---

## **3. Example of Wrapper Class Usage**
```java
public class WrapperExample {
    public static void main(String[] args) {
        // Primitive to Wrapper (Autoboxing)
        int num = 10;
        Integer obj = num;  // Autoboxing: int → Integer
        System.out.println("Integer object: " + obj);

        // Wrapper to Primitive (Unboxing)
        Integer numObj = Integer.valueOf(20); // Creating Integer object
        int primitiveNum = numObj;  // Unboxing: Integer → int
        System.out.println("Primitive int: " + primitiveNum);

        // Using Wrapper Class Methods
        Integer a = Integer.valueOf(30);
        System.out.println("String to Integer: " + Integer.parseInt("100"));  // Convert String to int
        System.out.println("Max Value of Integer: " + Integer.MAX_VALUE);  // Get max value of int
    }
}
```

### **Output:**
```
Integer object: 10
Primitive int: 20
String to Integer: 100
Max Value of Integer: 2147483647
```

---

## **4. Important Features of Wrapper Classes**
### **(i) Autoboxing (Primitive → Wrapper)**
Java **automatically** converts primitive types to wrapper objects.  
🔹 Example:  
```java
int num = 10;
Integer obj = num;  // Autoboxing (int → Integer)
```

### **(ii) Unboxing (Wrapper → Primitive)**
Java **automatically** converts wrapper objects back to primitive types.  
🔹 Example:  
```java
Integer obj = Integer.valueOf(20);
int num = obj;  // Unboxing (Integer → int)
```

---

## **5. Common Wrapper Class Methods**
| Method | Description | Example |
|--------|------------|---------|
| `valueOf()` | Converts primitive to wrapper | `Integer obj = Integer.valueOf(10);` |
| `intValue()`, `doubleValue()` | Converts wrapper to primitive | `int num = obj.intValue();` |
| `parseInt()`, `parseDouble()` | Converts String to primitive | `int num = Integer.parseInt("100");` |
| `toString()` | Converts wrapper to String | `String str = obj.toString();` |
| `MAX_VALUE`, `MIN_VALUE` | Returns max & min value of primitive | `System.out.println(Integer.MAX_VALUE);` |

---

🌐 **For More Details, Visit:** [Javatpoint](https://www.javatpoint.com/wrapper-class-in-java)

