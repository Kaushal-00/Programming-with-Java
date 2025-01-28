## Scanner

The `Scanner` class in Java is part of the `java.util` package and is commonly used to read input from various sources like the console, files, and strings. It simplifies the process of taking user input in console-based applications.

### Key Features of the `Scanner` Class:
1. **Reading Input**: It allows you to read different types of input like `int`, `double`, `String`, etc.
2. **Flexible Input Handling**: It can read input from different sources, such as the console (keyboard), files, or strings.
3. **Parsing Input**: It can parse primitive types (like `int`, `double`, `boolean`, etc.) from the input, making it easier to handle and use in your programs.

### Common Methods of the `Scanner` Class:
Here are some of the commonly used methods in `Scanner`:

1. **`nextInt()`**: Reads the next integer.
   ```java
   int num = scanner.nextInt();
   ```

2. **`nextDouble()`**: Reads the next double value.
   ```java
   double num = scanner.nextDouble();
   ```

3. **`nextLine()`**: Reads the next entire line of input as a `String`.
   ```java
   String text = scanner.nextLine();
   ```

4. **`next()`**: Reads the next token (word) from the input as a `String`.
   ```java
   String word = scanner.next();
   ```

5. **`hasNext()`**: Checks if there is another token in the input.
   ```java
   if (scanner.hasNext()) {
       // Process next input
   }
   ```

6. **`close()`**: Closes the `Scanner` object to release resources after usage.
   ```java
   scanner.close();
   ```

### Key Points to Remember:
1. **`nextLine()` and `next()`**: Be aware that if you use `nextInt()` or `nextDouble()`, the `Scanner` might leave a newline character (`\n`) in the input buffer. This can cause issues when you want to use `nextLine()` afterward. To handle this, you can add an extra `nextLine()` call to clear the buffer.
   
2. **Closing the Scanner**: Always close the `Scanner` object when you're done using it. This is especially important when you're reading from files or other resources, as failing to close it might cause resource leaks.

3. **Using `next()` vs `nextLine()`**:
   - `next()` reads the next token (word or number) separated by space.
   - `nextLine()` reads the entire line until the newline character.

### Why `Scanner` is Useful:
- It provides an easy and flexible way to read input from the user.
- It automatically handles different data types, like integers and strings, making it easier to process user input.