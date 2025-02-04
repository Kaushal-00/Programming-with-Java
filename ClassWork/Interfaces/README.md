### **Interfaces in Java**

An **interface** in Java is a blueprint for a class that defines a set of abstract methods (methods without a body) that any implementing class must provide. It is similar to an abstract class but has **some key differences**.

---

## **1. Key Features of Interfaces**
- **Contains only abstract methods (before Java 8)**  
  → All methods in an interface are **implicitly public and abstract**.  
- **Supports multiple inheritance**  
  → A class can implement multiple interfaces, unlike class inheritance where only **single inheritance** is allowed.  
- **Cannot have instance variables**  
  → Only **constants** (`public static final`) are allowed.  
- **Used for full abstraction**  
  → Since interfaces do not have method implementations, they enforce that classes provide their own functionality.  

---

## **4. Interfaces vs Abstract Classes**
| Feature          | Interface  | Abstract Class |
|-----------------|-----------|---------------|
| Methods        | Only abstract (before Java 8) | Can have both abstract & concrete methods |
| Variables      | Only **public, static, final** constants | Can have instance variables |
| Access Modifiers | All methods are `public` by default | Can have `private`, `protected`, `public` methods |
| Inheritance   | Supports **multiple inheritance** | Supports **single inheritance** |
| Constructor   | No constructor | Can have a constructor |
