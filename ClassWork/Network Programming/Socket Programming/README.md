## **Network Programming:**

- Network programming in Java is used to enable communication between two or more computers over a network (like LAN or the internet).
- It allows data exchange between programs running on different machines.
- Java provides built-in classes and interfaces in the `java.net` package to build network-enabled applications.

---

### **Types of Network Communication:**

- Java supports two main types of network communication:
    1. **TCP (Transmission Control Protocol)** – Reliable, connection-oriented (like a phone call).
    2. **UDP (User Datagram Protocol)** – Fast but connectionless and less reliable (like sending a letter).

---

## **Socket Programming (TCP Communication):**

- Used for two-way communication between server and client using TCP.

### **`Socket` class:**

- Used by the client to connect to the server.
- Communicates through input/output streams.

### **`ServerSocket` class:**

- Used by the server to listen for incoming client requests.
- Accepts the connection using `accept()` method which returns a `Socket`.

---

### **Basic Flow:**

#### Server Side:
1. Create a `ServerSocket`.
2. Wait for a client to connect (`accept()` method).
3. Read data from the client.
4. Send data back (if needed).

#### **Example:**
```java
import java.net.*;
import java.io.*;

public class MyServer {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(5000); // listen on port 5000
        System.out.println("Server is waiting...");
        Socket s = ss.accept(); // accept the client connection
        DataInputStream dis = new DataInputStream(s.getInputStream());
        String msg = dis.readUTF(); // read message from client
        System.out.println("Client says: " + msg);
        ss.close();
    }
}
```
---

#### Client Side:
1. Create a `Socket` with IP and port.
2. Send data to server.
3. Receive data from server.

#### **Example:**
```java
import java.net.*;
import java.io.*;

public class MyClient {
    public static void main(String[] args) throws IOException {
        Socket s = new Socket("localhost", 5000); // connect to server on port 5000
        DataOutputStream dout = new DataOutputStream(s.getOutputStream());
        dout.writeUTF("Hello Server!"); // send message
        dout.flush();
        dout.close();
        s.close();
    }
}
```

---

#### **How it works:**
1. Run the server first. It waits for connection.
2. Run the client. It connects to the server and sends `"Hello Server!"`.
3. Server receives and prints the message.

---

### **Methods:**

| Method | Description |
|--------|-------------|
| `ServerSocket(int port)` | Creates a server on given port |
| `accept()` | Waits for client |
| `Socket(String host, int port)` | Connects client to server |
| `getInputStream()` / `getOutputStream()` | For sending/receiving data |
| `readUTF()` / `writeUTF()` | For reading/writing strings |

---

### **Datagram Programming (UDP):**

- Used for fast and lightweight communication, but it doesn't guarantee delivery.
- `DatagramSocket` and `DatagramPacket` Classes are used for sending and receiving packets.

---