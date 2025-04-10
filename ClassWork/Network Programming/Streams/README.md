## **Streams in Network Programming:**

- In Network Programming, we use `Socket` objects to connect two programs (typically a server and a client). 
- Once the connection is established, we use streams to send and receive data.

---

### **InputStream & OutputStream:**

- These are the base classes used for reading and writing raw bytes between two connected sockets.
    - InputStream → Used to read data.
    - OutputStream → Used to send/write data.

- On the server or client side, once the connection is accepted, we use:

```java
InputStream in = socket.getInputStream();     // To read data from the other side
OutputStream out = socket.getOutputStream();  // To send data to the other side
```

- These allow byte-level communication, so they are basic and not very convenient for structured data like `int`, `String`, etc.

---

### **DataInputStream & DataOutputStream:**

- These are wrapper classes that sit on top of `InputStream` and `OutputStream` and allow you to easily read and write primitive data types (int, float, boolean, etc.) and Strings.


```java
DataInputStream dis = new DataInputStream(socket.getInputStream() or in);
DataOutputStream dos = new DataOutputStream(socket.getOutputStream() or out);
```

- Then we can do:

```java
dos.writeInt(42);
dos.writeUTF("Hello Client");

int number = dis.readInt();
String msg = dis.readUTF();
```

---

### **Example:**

#### **Server:**
```java
import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(5000);
        System.out.println("Server is waiting...");

        Socket socket = serverSocket.accept();
        System.out.println("Client connected.");

        DataInputStream dis = new DataInputStream(socket.getInputStream());
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

        String received = dis.readUTF();
        System.out.println("Received from client: " + received);

        dos.writeUTF("Hello from Server!");

        dis.close();
        dos.close();
        socket.close();
        serverSocket.close();
    }
}
```

---

#### **Client:**
```java
import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 5000);

        DataInputStream dis = new DataInputStream(socket.getInputStream());
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

        dos.writeUTF("Hi Server!");

        String response = dis.readUTF();
        System.out.println("Received from server: " + response);

        dis.close();
        dos.close();
        socket.close();
    }
}
```

---

### Summary:

| Class             | Purpose                             | Used For                            |
|------------------|-------------------------------------|-------------------------------------|
| `InputStream`     | Read raw bytes                      | Base class for reading              |
| `OutputStream`    | Write raw bytes                     | Base class for writing              |
| `DataInputStream` | Read primitives and Strings easily  | Reads `int`, `float`, `String`, etc.|
| `DataOutputStream`| Write primitives and Strings easily | Writes `int`, `float`, `String`, etc.|

---

### Methods:

- `DataInputStream`
    - `readInt()`
    - `readUTF()`
    - `readBoolean()`
    - `readDouble()`

- `DataOutputStream`
    - `writeInt(int)`
    - `writeUTF(String)`
    - `writeBoolean(boolean)`
    - `writeDouble(double)`

---