## Practical-2.4:

- Write a program to demonstrate usage of String and StringBuffer class

### **String in Java**

The `String` class in Java represents a sequence of characters. It is one of the most commonly used classes in Java, and it’s a part of the `java.lang` package, which is automatically imported. The `String` class in Java is **immutable**, meaning that once a `String` object is created, its value cannot be changed.

#### **Key Characteristics of String:**
1. **Immutability**:
   - When you modify a string, a new string object is created rather than modifying the original string. This is because strings in Java are immutable.
   - Example: If you try to modify a string, like adding something to it, a new string is created, and the original one remains unchanged.

2. **Memory Efficiency**:
   - Since strings are immutable, they can be cached by the JVM (Java Virtual Machine). If you create the same string multiple times, the JVM may reuse the string from the string pool, thus saving memory.

3. **Methods in the String Class**:
   - **`length()`**: Returns the number of characters in the string.
   - **`charAt(int index)`**: Returns the character at the specified index.
   - **`substring(int beginIndex, int endIndex)`**: Extracts a part of the string.
   - **`concat(String str)`**: Concatenates the specified string to the end.
   - **`equals(String str)`**: Compares two strings for equality.
   - **`toLowerCase()`**: Converts the string to lowercase.
   - **`toUpperCase()`**: Converts the string to uppercase.
   - **`contains(CharSequence sequence)`**: Checks if a string contains a particular sequence of characters.

#### **Example of Using String:**
```java
public class StringExample {
    public static void main(String[] args) {
        String str = "Hello";
        System.out.println("Original String: " + str);
        
        // Concatenating using "+" operator
        str = str + " World!";
        System.out.println("After concatenation: " + str);
        
        // String is immutable: A new object is created when we modify it
        String str2 = "Hello";
        System.out.println("Are both strings equal? " + str.equals(str2));
    }
}
```

**Output**:
```
Original String: Hello
After concatenation: Hello World!
Are both strings equal? false
```


### **StringBuffer in Java**

`StringBuffer` is another class in Java used for manipulating strings. Unlike `String`, `StringBuffer` is **mutable**, meaning that its content can be changed after it is created without creating new objects.

#### **Key Characteristics of StringBuffer:**

1. **Mutability**:
   - Unlike `String`, the contents of a `StringBuffer` object can be changed without creating new objects.
   - This makes `StringBuffer` more efficient when performing repeated string modifications (such as concatenations or insertions).

2. **Performance**:
   - StringBuffer is designed to be used in situations where you need to modify the string frequently (e.g., inside loops), as it doesn't create new objects for every modification like `String` does.

3. **Thread Safety**:
   - `StringBuffer` is **synchronized**, which means it is thread-safe. Multiple threads can access the same `StringBuffer` object without causing data corruption. However, because of synchronization, `StringBuffer` can be slower compared to `StringBuilder` (which is not synchronized but faster in single-threaded environments).

4. **Methods in the StringBuffer Class**:
   - **`append(String str)`**: Adds the specified string to the end.
   - **`insert(int index, String str)`**: Inserts the specified string at the specified position.
   - **`delete(int start, int end)`**: Removes characters from the specified start to end positions.
   - **`reverse()`**: Reverses the sequence of characters in the buffer.
   - **`toString()`**: Converts the `StringBuffer` to a `String`.

#### **Example of Using StringBuffer:**
```java
public class StringBufferExample {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("Hello");
        System.out.println("Original StringBuffer: " + sb);
        
        // Appending text to StringBuffer
        sb.append(" World!");
        System.out.println("After append: " + sb);
        
        // Inserting text at a specific position
        sb.insert(5, " Java");
        System.out.println("After insert: " + sb);
        
        // Reversing the string
        sb.reverse();
        System.out.println("After reverse: " + sb);
        
        // Converting StringBuffer to String
        String str = sb.toString();
        System.out.println("String from StringBuffer: " + str);
    }
}
```

**Output**:
```
Original StringBuffer: Hello
After append: Hello World!
After insert: Hello Java World!
After reverse: !dlroW avaJ olleH
String from StringBuffer: !dlroW avaJ olleH
```

### **Key Differences Between String and StringBuffer**

| Feature               | String                           | StringBuffer                    |
|-----------------------|----------------------------------|----------------------------------|
| **Mutability**         | Immutable (cannot be changed)    | Mutable (can be changed)         |
| **Performance**        | Slower for frequent modifications | Faster for frequent modifications|
| **Thread Safety**      | Thread-safe                      | Thread-safe (but slower)         |
| **Memory Usage**       | Less memory efficient for large number of changes | More memory efficient for frequent changes |

