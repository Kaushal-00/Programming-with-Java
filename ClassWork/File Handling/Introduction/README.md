## **File Handling:**

- File handling in Java allows you to:
    - Create a file
    - Write data to a file
    - Read data from a file
    - Delete a file

- Java provides classes in the `java.io` and `java.nio.file` packages for file handling.

---

### **Common Classes:**

| Class | Purpose |
|-------|---------|
| `File` | To create, delete, check existence of a file or folder |
| `FileWriter` | To write data to a file |
| `FileReader` | To read data from a file |
| `BufferedReader` | To read large chunks of text efficiently (Read file line-by-line) |
| `Scanner` | To read file line by line or word by word (Read file like user input) |
| `PrintWriter` | To write formatted text |
| `Files` (Java 7+) | To perform file operations in a simple way |

---

### **Note:**
- Always close `FileWriter`, `BufferedReader` etc., using `.close()` method.
- Use `try-catch` to handle `IOException` safely.
- File is stored in your project directory by default unless you give a path like `"C:\\Users\\Kaushal\\Desktop\\file.txt"`

---


### 1. **File Class:**
- This class is used to create, check, and delete files or directories.

```java
import java.io.*;

public class FileExample {
    public static void main(String[] args) {
        File f = new File("myfile.txt");

        try {
            if (f.createNewFile()) {
                System.out.println("File created!");
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("Error occurred.");
        }
    }
}
```

---

### 2. **FileWriter:** 
– Writing to a file.

```java
import java.io.*;

public class WriteExample {
    public static void main(String[] args) {
        try {
            FileWriter fw = new FileWriter("myfile.txt");
            fw.write("Hello, Kaushal!");
            fw.close();
            System.out.println("Data written.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

---

### 3. **FileReader:** 
– Reading from a file.

```java
import java.io.*;

public class ReadExample {
    public static void main(String[] args) {
        try {
            FileReader fr = new FileReader("myfile.txt");
            int ch;
            while ((ch = fr.read()) != -1) {
                System.out.print((char) ch);
            }
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

---

### 4. **BufferedReader:** 
– Reading a full line

```java
import java.io.*;

public class BufferedReaderExample {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("myfile.txt"));
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
        br.close();
    }
}
```

---

### 5. **Scanner:**

```java
import java.io.*;
import java.util.*;

public class ScannerReadFile {
    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("myfile.txt");
        Scanner sc = new Scanner(f);

        while (sc.hasNextLine()) {
            String data = sc.nextLine();
            System.out.println(data);
        }
        sc.close();
    }
}
```

---