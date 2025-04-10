## **Socket:**

- The `Socket` class is used on both client and server sides to create a connection.
- It represents a single connection between two machines: a client and a server.

---

### **Used for:**

- To connect to a remote server from a client.
- To communicate (send/receive data) once the connection is established.
- It handles the actual data transfer after `ServerSocket.accept()` returns a `Socket`.

---

### **Constructors (Client Side):**

| Constructor | Description |
|-------------|-------------|
| `Socket(String host, int port)` | Connects to the server at the given hostname/IP and port. |
| `Socket(InetAddress address, int port)` | Connects to the server using an `InetAddress` object. |

---

### **Important Methods:**

| Method | Description |
|--------|-------------|
| `getInputStream()` | Returns an `InputStream` to read data from the other side. |
| `getOutputStream()` | Returns an `OutputStream` to send data to the other side. |
| `getInetAddress()` | Returns the IP address of the connected remote host. |
| `getPort()` | Returns the port number of the remote host. |
| `getLocalPort()` | Returns the port number on your side of the connection. |
| `close()` | Closes the socket connection. |
| `isClosed()` | Returns `true` if the socket is closed. |

---