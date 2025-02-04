## Toggle-Case:

- **Toggle case** refers to a process of changing the case of each letter in a given string. Specifically, it involves converting lowercase letters to uppercase and vice versa. So, if a string contains the character 'a', it will be changed to 'A', and if it contains 'B', it will be changed to 'b'.

### Example:
- Input: `"Hello World"`
- Output: `"hELLO wORLD"`

---

- The **`Character`** class in Java is a part of the `java.lang` package and is used to work with characters (single Unicode characters). This class provides several methods for character manipulation, such as checking the type of character (like whether it's a letter, digit, or whitespace), converting case (uppercase to lowercase or vice versa), and performing other character-related operations.

### Key Points:
- The `Character` class is a **wrapper class** for the primitive data type `char`.
- It provides utility methods for working with single `char` values.
- You can think of it as providing **helper functions** for working with individual characters.

### Important Methods of the `Character` Class:

1. **`isLetter(char ch)`**:
   - Returns `true` if the character is a letter (a-z, A-Z).
   
   ```java
   Character.isLetter('a');  // true
   Character.isLetter('1');  // false
   ```

2. **`isDigit(char ch)`**:
   - Returns `true` if the character is a digit (0-9).
   
   ```java
   Character.isDigit('5');  // true
   Character.isDigit('a');  // false
   ```

3. **`isWhitespace(char ch)`**:
   - Returns `true` if the character is a whitespace (such as spaces, tabs, etc.).
   
   ```java
   Character.isWhitespace(' ');  // true
   Character.isWhitespace('a');  // false
   ```

4. **`isUpperCase(char ch)`**:
   - Returns `true` if the character is an uppercase letter (A-Z).
   
   ```java
   Character.isUpperCase('A');  // true
   Character.isUpperCase('a');  // false
   ```

5. **`isLowerCase(char ch)`**:
   - Returns `true` if the character is a lowercase letter (a-z).
   
   ```java
   Character.isLowerCase('a');  // true
   Character.isLowerCase('A');  // false
   ```

6. **`toUpperCase(char ch)`**:
   - Converts the character to uppercase. If it's already uppercase, it returns the same character.
   
   ```java
   Character.toUpperCase('a');  // 'A'
   Character.toUpperCase('A');  // 'A'
   ```

7. **`toLowerCase(char ch)`**:
   - Converts the character to lowercase. If it's already lowercase, it returns the same character.
   
   ```java
   Character.toLowerCase('A');  // 'a'
   Character.toLowerCase('a');  // 'a'
   ```

8. **`isLetterOrDigit(char ch)`**:
   - Returns `true` if the character is either a letter or a digit (a-z, A-Z, 0-9).
   
   ```java
   Character.isLetterOrDigit('a');  // true
   Character.isLetterOrDigit('1');  // true
   Character.isLetterOrDigit('@');  // false
   ```

9. **`isJavaIdentifierStart(char ch)`**:
   - Returns `true` if the character is a valid start of a Java identifier (first character).
   
   ```java
   Character.isJavaIdentifierStart('_');  // true
   Character.isJavaIdentifierStart('1');  // false
   ```

10. **`isJavaIdentifierPart(char ch)`**:
    - Returns `true` if the character is a valid part of a Java identifier (can be used after the first character).
    
    ```java
    Character.isJavaIdentifierPart('a');  // true
    Character.isJavaIdentifierPart('$');  // true
    Character.isJavaIdentifierPart('1');  // true
    ```
