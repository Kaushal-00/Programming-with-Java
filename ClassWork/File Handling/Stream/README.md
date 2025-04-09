## **Stream:**

- In Java, a Stream is like a pipeline used to transfer data (like characters, bytes, objects, etc.) from a source to a destination.
- It is a flow of data.
- Java provides two main types of I/O (Input/Output) Streams:

---

### 1. **Byte Streams:** 

- For Binary Data.
- Deals with raw binary data like images, videos, PDFs, etc.
- Uses `InputStream` and `OutputStream` classes.
- `FileInputStream` → Reads bytes from a file
- `FileOutputStream` → Writes bytes to a file

### **Example**:
```java
import java.io.*;

public class ByteStreamExample {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("file.jpg");
        FileOutputStream fos = new FileOutputStream("copy.jpg");

        int b;
        while ((b = fis.read()) != -1) {
            fos.write(b);
        }

        fis.close();
        fos.close();
        System.out.println("File copied!");
    }
}
```

---

### 2. **Character Streams:** 

- For Text Data.
- Deals with **text data** (characters).
- Uses `Reader` and `Writer` classes.
- `FileReader` → Reads characters from a file
- `FileWriter` → Writes characters to a file

### **Example**:

```java
import java.io.*;

public class CharStreamExample {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("data.txt");
        FileWriter fw = new FileWriter("copy.txt");

        int ch;
        while ((ch = fr.read()) != -1) {
            fw.write(ch);
        }

        fr.close();
        fw.close();
        System.out.println("Text file copied!");
    }
}
```

---

### **Summary Table:**

| Type           | Class Examples             | Used For         |
|----------------|----------------------------|------------------|
| Byte Stream    | `InputStream`, `OutputStream`, `FileInputStream`, `FileOutputStream` | Binary files (images, etc.) |
| Character Stream | `Reader`, `Writer`, `FileReader`, `FileWriter`     | Text files        |

---


### **`read()` Method:**

- Used to read data from a file character by character (or byte by byte).

#### Used with:
- `FileInputStream` (for bytes)
- `FileReader` (for characters)

---

#### Syntax:
```java
int data = reader.read();
```

- It reads one character/byte at a time.
- Returns:
  - an `int` value of the character/byte read
  - `-1` when end of file is reached

---


### **`write()` Method:**

- Used to write data to a file character by character (or byte by byte).

#### Used with:
- `FileOutputStream` (for bytes)
- `FileWriter` (for characters)

---

#### Syntax:
```java
writer.write(data);
```

- Writes a character or byte to the file.
- You can also write strings or arrays of characters.

---