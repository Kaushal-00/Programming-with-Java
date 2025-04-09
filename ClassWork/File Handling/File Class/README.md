## **File Class:**

- The File class in Java represents a file or directory path in the file system (but it does not read/write content).
- It belongs to: java.io package
- it used for:
    - Check if a file or folder exists.
    - Create a new file or new directory.
    - Delete a file or folder
    - Get file name, path, size, etc.

---

### **Common Constructors:**
```java
File f = new File("filename.txt");               // file in current folder
File f = new File("C:\\Users\\Kaushal\\data.txt"); // absolute path
```

---

### **Common Methods:**

| Method                     | Description                              |
|---------------------------|------------------------------------------|
| `createNewFile()`         | Creates new file if it doesn't exist     |
| `mkdir()`                 | Creates new directory                    |
| `exists()`                | Checks if file/folder exists             |
| `delete()`                | Deletes file/folder                      |
| `getName()`               | Gets file/folder name                    |
| `getAbsolutePath()`       | Gets full path                           |
| `length()`                | Gets file size in bytes                  |
| `isDirectory()`           | Checks if it's a folder                  |
| `isFile()`                | Checks if it's a file                    |

---

### **Example:**

```java
import java.io.File;
import java.io.IOException;

public class FileExample {
    public static void main(String[] args) {
        try {
            File file = new File("example.txt");

            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File already exists.");
            }

            System.out.println("Path: " + file.getAbsolutePath());
            System.out.println("Is File: " + file.isFile());
            System.out.println("Is Directory: " + file.isDirectory());
            System.out.println("Length: " + file.length() + " bytes");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
```

#### **Output:**
```
File created: example.txt
Path: C:\Users\Kaushal\example.txt
Is File: true
Is Directory: false
Length: 0 bytes
```

---