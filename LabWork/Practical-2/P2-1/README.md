## Practical-2.1:

- Define a class Array with following member

    **Field:**
    - int data[];

    **Function:**
    - Array( )     //create array data of size 10
    - Array(int size)    // create array of size size
    - Array(int data[])    // initialize array with parameter array
    - void Reverse _an _array ()    //reverse element of an array
    - int Maximum _of _array ()    // find maximum element of array
    - int Average_of _array()    //find average of element of array
    - void Sorting ()    //sort element of array
    - void display()    //display element of array
    - int search(int no)    //search element and return index else return -1
    - int size();   //return size of an array
- Use all the function in main method. Create different objects with different constructors.



### Used Methods

1. **copyOf()**:
- The **`copyOf()`** method in Java is a utility method from the `java.util.Arrays` class that is used to create a **new array with a specified length** by copying elements from an existing array.
- Works for **primitive types** (like `int`, `double`, `char`) and **objects** (like `String`).

### **Syntax**
```java
Arrays.copyOf(originalArray, newLength);
```
- **`originalArray`** – The array to be copied.
- **`newLength`** – The length of the new array.

If `newLength` **is greater** than the original array length, the extra elements will be **initialized with default values** (e.g., `0` for `int` arrays).  
If `newLength` **is smaller**, the array will be **truncated**.

---

2. **toString():**

- The **`toString()`** method in Java is used to **convert an object into a String representation**. It is commonly used for debugging and displaying meaningful information about objects.
- The `toString()` method does **not work directly on arrays**. Instead, we use `Arrays.toString(array)` to **convert an array to a string**.

```java
import java.util.Arrays;

public class ToStringExample {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};

        // Printing array using Arrays.toString()
        System.out.println("Array: " + Arrays.toString(numbers));
    }
}
```
### **Output**
```
Array: [1, 2, 3, 4, 5]
```
🚀 **Without `Arrays.toString()`, the output would look like:**  
`[I@15db9742` (Memory reference, not useful).