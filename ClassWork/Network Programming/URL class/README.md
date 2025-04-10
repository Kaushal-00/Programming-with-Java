## **URL class:**

- The `URL` class in Java is part of the `java.net` package.
- It represents a Uniform Resource Locator, which is basically a web address like:

  ```
  https://www.example.com/index.html
  ```

- This class allows you to connect to web resources, read data from websites, and analyze parts of a URL (like protocol, host, port, file, etc).

---

### **Package:**
```java
import java.net.URL;
```

---

### **Example:**

```java
import java.net.*;

public class URLExample {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.example.com/index.html?name=kaushal");

            System.out.println("Protocol: " + url.getProtocol());
            System.out.println("Host: " + url.getHost());
            System.out.println("Port: " + url.getPort()); // -1 means default port
            System.out.println("File: " + url.getFile());
            System.out.println("Query: " + url.getQuery());

        } catch (MalformedURLException e) {
            System.out.println("Invalid URL");
        }
    }
}
```

#### Output:
```
Protocol: https
Host: www.example.com
Port: -1
File: /index.html?name=kaushal
Query: name=kaushal
```

---

### **Methods:**

| Method | Description |
|--------|-------------|
| `getProtocol()` | Returns the protocol (e.g., `http`, `https`, `ftp`) |
| `getHost()` | Returns the hostname (e.g., `www.google.com`) |
| `getPort()` | Returns the port number (e.g., `80`, `443`) |
| `getFile()` | Returns file name and query (e.g., `/index.html?x=1`) |
| `getPath()` | Returns only the path (e.g., `/index.html`) |
| `getQuery()` | Returns query string (e.g., `x=1&y=2`) |
| `openStream()` | Opens a stream to read from the URL like a file |

---

### **Example to Read Data from a Website:**

```java
import java.net.*;
import java.io.*;

public class ReadWebsite {
    public static void main(String[] args) throws Exception {
        URL url = new URL("https://www.example.com");
        BufferedReader reader = new BufferedReader(
            new InputStreamReader(url.openStream())
        );

        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line); // prints HTML content of the page
        }
        reader.close();
    }
}
```

---