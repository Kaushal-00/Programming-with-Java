## **Event-Delegation Model:**

- It is how Java handles user actions (events) like:

    - Button clicks
    - Mouse movement
    - Key press

- Instead of components handling events themselves, the job is delegated to Listener objects.

---

### **Components:**

| Component | Role |
|----------|------|
| Event Source | The GUI component (e.g., `JButton`) |
| Event Object | Contains info about the event (like `ActionEvent`) |
| Event Listener | Interface/class that responds to the event |

---

### **Example:**

```java
import javax.swing.*;
import java.awt.event.*;

public class EventExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Button Click Example");
        JButton button = new JButton("Click Me");

        button.setBounds(100, 100, 120, 40);
        frame.add(button);

        // Step 3: Registering Listener
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Button clicked!");
            }
        });

        frame.setSize(300, 250);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
```

---

### **Flow:**

1. By clicking the button `Event Source`
2. Java creates an ActionEvent `Event Object`
3. The `ActionListener` is called `Event Listener`
4. The listener method (`actionPerformed`) is executed

- In Java Swing, we can assign actions (or responses) to components like buttons using listener methods.  
- For example, we use `addActionListener()` to handle button clicks.  
- In this method, we pass an object of a class that implements the `ActionListener` interface.  
- The `ActionListener` interface contains one predefined method:
```java
public void actionPerformed(ActionEvent e)
```
- This method is automatically called when the button is clicked.  
- The `ActionEvent` object (`e`) contains information about the event.

---

### **Types of Listeners:**
- `javax.swing.*` gives us Swing components like:
    - `JFrame`
    - `JButton`
    - `JLabel`
    - `JTextField`, etc.

- These are GUI elements that let us build the interface.

- `java.awt.event` gives us event listeners like:

| Listener | Event It Handles |
|----------|------------------|
| `ActionListener` | Button clicks |
| `MouseListener` | Mouse pressed, released, entered, exited, clicked |
| `KeyListener` | Key press, release, type |
| `ItemListener` | Checkbox or selection changes |
| `WindowListener` | Opening, closing, minimizing window |

---

- We can attach different listener methods to handle user interactions like clicking, hovering, pressing, etc.

---

### **addActionListener():**

- Purpose: Handles button click events.
- Interface: `ActionListener`
- Method you override: `actionPerformed(ActionEvent e)`

#### Example:
```java
button.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        System.out.println("Button Clicked!");
    }
});
```

---

### **addMouseListener():**

- Purpose: Handles mouse events.
- Interface: `MouseListener`
- Methods you override:
  - `mouseClicked(MouseEvent e)`
  - `mousePressed(MouseEvent e)`
  - `mouseReleased(MouseEvent e)`
  - `mouseEntered(MouseEvent e)`
  - `mouseExited(MouseEvent e)`

#### Example:
```java
button.addMouseListener(new MouseAdapter() {
    public void mouseEntered(MouseEvent e) {
        System.out.println("Mouse entered the button");
    }

    public void mouseExited(MouseEvent e) {
        System.out.println("Mouse exited the button");
    }
});
```

---

### **addKeyListener():**

- Purpose: Handles key events.
- Interface: `KeyListener`
- Methods you override:
  - `keyPressed(KeyEvent e)`
  - `keyReleased(KeyEvent e)`
  - `keyTyped(KeyEvent e)`

#### Example:
```java
button.addKeyListener(new KeyAdapter() {
    public void keyPressed(KeyEvent e) {
        System.out.println("Key Pressed on Button: " + e.getKeyChar());
    }
});
```

---