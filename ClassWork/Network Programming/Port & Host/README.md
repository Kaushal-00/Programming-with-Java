## **Port:**

- When two computers talk over the internet or a network:
    - The **IP address** tells **which computer** to talk to.
    - The **Port number** tells **which application** on that computer to talk to.
- In Java, we usually use port numbers above 1024 (because lower ones are often reserved by system apps).

---

### Example:

- Let’s say your computer is like a big building with many rooms (ports).  
- Each room has a different service running inside it:

| Room (Port) | What it Does |
|-------------|---------------|
| 80          | Website (HTTP) |
| 443         | Secure Website (HTTPS) |
| 21          | File Transfer (FTP) |
| 25          | Email (SMTP) |
| 5000        | Your custom Java Server |

- When you create a server in Java like this:
```java
ServerSocket server = new ServerSocket(5000);
```
- It means room number 5000 is open to wait for visitors (clients).
- So when a client connects, it connects to:
```
IP address:port number
Example: 192.168.0.101:5000
```

- `192.168.0.101` → is the Server's IP address.
- `5000` → is the Port number where the server is listening.

- This is how the client knows where to send the request.

---

## **Host:**

- The host is the name or IP address of the server that the client wants to connect to.


### **Example:**

- When you create a Client in Java like this:

```java
Socket socket = new Socket("192.168.0.101", 5000);
```

- `192.168.0.101` is the host (IP address) of the server.
- `5000` is the port the client is trying to enter to talk to the server.

- You can also use a hostname instead of an IP address:

    - `"localhost"` is just another name for your own computer (IP = 127.0.0.1).
    - This is useful when both client and server run on the same machine.

---