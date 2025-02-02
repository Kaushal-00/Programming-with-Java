## Practical-2.5:

- Define a class Cipher with following member

    **Field:**
    - String plainText; 
    - int key;

    **Function:**
    - Cipher(String plaintext,int key) 
    - String Encryption( ) 
    - String Decryption( ) 
    
- Read string and key from command prompt and replace every character of string with character which is key place down from current character.
- Example plainText = “GCET” Key = 3 Encryption function written following String “ JFHW” Decryption function will convert encrypted string to original form “GCET”.

---

### **Expected Improvement:** 

1. **Character Overflow:** If the key is too large, the encrypted character may go beyond the valid character range.  
2. **Handling Special Characters:** Non-alphabetic characters (digits, spaces, punctuation) also get shifted, which may not be desirable.  
3. **Negative Key Handling:** If a negative key is provided, decryption might not work as expected.