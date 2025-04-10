## **InetAddress:**

- `InetAddress` is a class in Java's `java.net` package.
- It represents an IP address (either IPv4 or IPv6).
- It is used to identify computers on a network, like the Internet or Local Area Network (LAN).

---

### **Used For:**

- Helps find the IP address of a host name.
- Helps find the host name of a given IP address.
- Useful in network programming when you want to connect to or identify devices.

---

### **Example:**

```java
import java.net.*;

public class InetAddressExample {
    public static void main(String[] args) {
        try {
            InetAddress address = InetAddress.getByName("www.google.com");
            System.out.println("Host Name: " + address.getHostName());
            System.out.println("IP Address: " + address.getHostAddress());
        } catch (UnknownHostException e) {
            System.out.println("Host not found!");
        }
    }
}
```

#### Output:
```
Host Name: www.google.com
IP Address: 142.250.182.132
```

---

### **Methods:**

| Method | Description |
|--------|-------------|
| `getByName(String host)` | Returns the `InetAddress` of the given host name (e.g., `"google.com"`). |
| `getLocalHost()` | Returns the IP address of your own machine. |
| `getHostName()` | Returns the host name (e.g., `"google.com"`). |
| `getHostAddress()` | Returns the IP address in string form (e.g., `"142.250.182.132"`). |
| `isReachable(int timeout)` | Checks if the IP address is reachable (like a ping). |

---