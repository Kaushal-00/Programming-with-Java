## Practical-4.2:

- Define a class Cripher with following data.

    **Field:**
    - String plainText
    - int key

    **Functions:**
    - Cipher(String plaintext,int key)
    - abstract String Encryption( )
    - abstract String Decryption( )
    
- Derived two classes Substitution_Cipher and Caesar_Cipher override Encyption() and Decyption() Method. 
- In substitute cipher every character of string is replace with another character. 
- **For example:** In this method you will replace the letters using the following scheme.
    - Plain Text: a b c d e f g h i j k l m n o p q r s t u v w x y z
    - Cipher Text: q a z w s x e d c r f v t g b y h n u j m i k o l p
- So if string consist of letter “gcet” then encrypted string will be ”ezsj” and decrypt it to get original string.
- In ceaser cipher encrypt the string same as program 5 of LAB 5.