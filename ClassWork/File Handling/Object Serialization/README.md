## **Object Serialization:**

- Serialization means converting a Java object into a byte stream, so that:

    - It can be saved to a file.
    - Sent over a network.
    - Or stored in memory.

- The byte stream created is platform independent. 
- So, the object serialized on one platform can be deserialized(converted back into the same Java object) on a different platform.

---

- The class must implement `java.io.Serializable` interface (marker interface, has no methods).
    - Only the objects of those classes can be serialized which are implementing `java.io.Serializable` interface. 
    - Serializable is a marker interface (has no data member and method). 
    - It is used to “mark” java classes so that objects of these classes may get certain capability.
- The `ObjectOutputStream` class contains `writeObject()` method for serializing an Object. 
- The `ObjectInputStream` class contains `readObject()` method for deserializing an object.

---

### **Need:**

- To save an object’s state.
- To transfer objects over a network (e.g., in sockets, RMI).
- To store data in files or databases.

---


### **Example:** 

#### **Step 1 - Create a class:**

```java
import java.io.Serializable;

class Student implements Serializable {
    int id;
    String name;

    Student(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
```

---

#### **Step 2 - Serialize (write object to file):**

```java
import java.io.*;

public class SerializeExample {
    public static void main(String[] args) {
        try {
            Student s1 = new Student(101, "Kaushal");

            FileOutputStream fileOut = new FileOutputStream("student.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);

            out.writeObject(s1); // Serialization
            out.close();
            fileOut.close();

            System.out.println("Object serialized successfully!");
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }
}
```

---

#### **Step 3 - Deserialize (read object from file):**

```java
import java.io.*;

public class DeserializeExample {
    public static void main(String[] args) {
        try {
            FileInputStream fileIn = new FileInputStream("student.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);

            Student s = (Student) in.readObject(); // Deserialization
            in.close();
            fileIn.close();

            System.out.println("ID: " + s.id);
            System.out.println("Name: " + s.name);
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}
```

---