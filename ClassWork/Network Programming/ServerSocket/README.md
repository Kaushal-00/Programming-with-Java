## **`ServerSocket`:**

- The `ServerSocket` class is used on the server-side of a network connection.  
- Its job is to wait for clients to connect to it over a specific port number.

---

### **Used for:**

- To open a port on the server.
- To wait for incoming client connections.
- To accept those connections and create a `Socket` object to communicate.

---**

### **Constructors:**

| Constructor | Description |
|-------------|-------------|
| `ServerSocket(int port)` | Creates a server socket on the given port. |
| `ServerSocket(int port, int backlog)` | Also sets how many clients can wait in line. |
| `ServerSocket(int port, int backlog, InetAddress bindAddr)` | Binds the server to a specific IP address and port. |

---

### **Important Methods:**

| Method | Description |
|--------|-------------|
| `accept()` | Waits (blocks) until a client connects. Returns a `Socket` object. |
| `close()` | Closes the server socket. |
| `getInetAddress()` | Returns the server's IP address. |
| `getLocalPort()` | Returns the port number the server is listening on. |
| `isClosed()` | Checks if the server socket is closed. |

---

## **`accept()` Method:**

- The `accept()` method is part of the `ServerSocket` class.  
- It is used by the server to wait and listen for a client to connect.

### **Syntax:**
```java
Socket clientSocket = serverSocket.accept();
```

- It waits (blocks) until a client connects to the server.
- While the server is waiting at `accept()`:
    - It pauses execution.
    - It will not continue to the next line until a client connects.
- Once a client connects, it returns a new `Socket` object.
- That new `Socket` is assigned to `clientSocket`.
- This new `Socket` is used to communicate with the connected client.

---