# Java `java.util` Package

The `java.util` package is one of the core packages in Java, providing a wide range of utility classes for handling common programming tasks like managing data structures, working with dates, generating random numbers, and more. This README file serves as an overview of the key components and functionalities offered by the `java.util` package.

## Key Classes and Interfaces in `java.util`

### 1. **Collections Framework**
The **Collections Framework** in `java.util` provides a set of interfaces and classes to manage and manipulate groups of data efficiently.

- **List**: An ordered collection that allows duplicates.  
  Example: `ArrayList`, `LinkedList`
- **Set**: A collection that does not allow duplicates.  
  Example: `HashSet`, `TreeSet`
- **Map**: A collection that stores key-value pairs.  
  Example: `HashMap`, `TreeMap`
- **Queue**: A collection designed for holding elements before processing.  
  Example: `LinkedList` (also implements `Queue`)

#### Example: Using `ArrayList`

```java
import java.util.ArrayList;

public class ListExample {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Java");
        list.add("Python");
        list.add("C++");

        // Printing the list
        System.out.println(list);
    }
}
