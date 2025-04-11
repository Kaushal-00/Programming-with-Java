## **GUI:**

- GUI stands for Graphical User Interface.
- Instead of interacting with a program through the command line, It allows users to interact with a program using windows, buttons, menus, text boxes, etc.

---

### **GUI Toolkits:**

- Java provides two main toolkits to build GUI:

| Toolkit | Description |
|--------|-------------|
| AWT (Abstract Window Toolkit) | Basic, platform-dependent |
| Swing (Part of `javax.swing`) | More advanced, platform-independent (Recommended for GUI apps) |


---

### **Swing:**

- `javax.swing` is a Java GUI toolkit to create windows-based applications.
- It’s built on AWT but offers more components and better look & feel.

---

### **Package:**

```java
import javax.swing.*;
```

---

### **Basic GUI Components:**

| Component | Purpose |
|----------|---------|
| `JFrame` | Main window |
| `JButton` | Button users can click |
| `JLabel` | Display text |
| `JTextField` | One-line input field |
| `JTextArea` | Multi-line input |
| `JCheckBox` | A checkbox |
| `JRadioButton` | A radio button |
| `JList` | List of items |
| `JComboBox` | Drop-down list |

---

## **Example:**

```java
import javax.swing.*;

public class MyGUI {
    public static void main(String[] args) {
        JFrame frame = new JFrame("My First GUI");
        JButton button = new JButton("Click Me");

        button.setBounds(100, 100, 100, 40); // x, y, width, height
        frame.add(button); // Add button to frame

        frame.setSize(300, 300); // width x height
        frame.setLayout(null);   // no layout manager
        frame.setVisible(true);  // make frame visible
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exit on close
    }
}
```

---

### **Basic Steps:**

1. **Create a JFrame** – The window.
2. **Add components** – Like buttons, text fields.
3. **Add Event Listeners** – To handle clicks, typing, etc.
4. **Set Layout** – Control how components are arranged.
5. **Display the GUI** – Set frame visible.

---

### **JFrame class:**

- `JFrame` is a class in Java Swing used to create a main window of your GUI application.

---

#### **Methods of JFrame:**

| Method                        | Description |
|------------------------------|-------------|
| `setTitle("Title")`          | Sets the title of the window |
| `setSize(width, height)`     | Sets the size of the window |
| `setVisible(true/false)`     | Shows or hides the window |
| `setLayout(...)`             | Sets the layout manager |
| `add(component)`             | Adds a button, label, etc. |
| `setDefaultCloseOperation(...)` | Defines what happens when window is closed |

---