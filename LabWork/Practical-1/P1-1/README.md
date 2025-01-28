## Practical-1.1: Study of class path and java runtime environment.

### Steps:
1. **Classpath**: It tells Java where to look for `.class` files when running a program.
2. **Java Runtime Environment (JRE)**: The **JRE** is a software package that provides the runtime environment necessary to run Java programs. It includes:
   - **Java Virtual Machine (JVM)**: Executes your Java program.
   - **Core Libraries**: These are essential Java libraries (like `java.lang`, `java.util`, etc.) that your program uses.
   - **Other Components**: Such as class loaders to load the program's `.class` files.

The JRE does *not* include tools for development like `javac` (Java compiler). It is designed specifically for running already compiled Java programs.

---

### Explanation:
1. **`System.getProperty`**:
   - `"java.version"`: Shows the version of Java you are using.
   - `"java.runtime.name"`: Gives details about the runtime environment.
   - `"java.class.path"`: Displays the classpath where Java looks for `.class` files.

2. **Steps to Compile and Run:**
   - Open a terminal or command prompt.
   - Navigate to the folder where your `.java` file is saved.
   - Compile the program:
     ```bash
     javac Main.java
     ```
   - Run the program:
     ```bash
     java Main
     ```
     
---

3. **Output:**
```
Hello World
Java Version: 23.0.2
Java Runtime Environment: Java(TM) SE Runtime Environment
Java Classpath: .
```
