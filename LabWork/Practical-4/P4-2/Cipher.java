abstract class Cipher {
    String plainText;
    int key;

    Cipher(String plainText, int key) {
        this.plainText = plainText;
        this.key = key;
    }

    abstract String Encryption();
    abstract String Decryption();
}

class Substitution_Cipher extends Cipher {

    char[] plain = {'a','b','c','d','e','f','g','h','i','j','k','l','m',
                    'n','o','p','q','r','s','t','u','v','w','x','y','z'};

    char[] cipher = {'q','a','z','w','s','x','e','d','c','r','f','v','t',
                     'g','b','y','h','n','u','j','m','i','k','o','l','p'};

    Substitution_Cipher(String plainText, int key) {
        super(plainText, key);
    }

    String Encryption() {
        char[] encryptedText = new char[plainText.length()];

        for (int i = 0; i < plainText.length(); i++) {
            char ch = plainText.charAt(i);

            for (int j = 0; j < plain.length; j++) {
                if (ch == plain[j]) {
                    encryptedText[i] = cipher[j];
                    break;
                }
            }
        }

        return new String(encryptedText);
    }

    String Decryption() {
        char[] decryptedText = new char[plainText.length()];

        for (int i = 0; i < plainText.length(); i++) {
            char ch = plainText.charAt(i);

            for (int j = 0; j < cipher.length; j++) {
                if (ch == cipher[j]) {
                    decryptedText[i] = plain[j];
                    break;
                }
            }
        }

        return new String(decryptedText);
    }
}

class Caesar_Cipher extends Cipher {

    Caesar_Cipher(String plainText, int key) {
        super(plainText, key);
    }

    String Encryption() {
        char[] encryptedText = new char[plainText.length()];

        for (int i = 0; i < plainText.length(); i++) {
            char ch = plainText.charAt(i);
            char encryptedChar = (char) (ch + key);
            encryptedText[i] = encryptedChar;
        }

        return new String(encryptedText);
    }

    String Decryption() {
        char[] decryptedText = new char[plainText.length()];

        for (int i = 0; i < plainText.length(); i++) {
            char ch = plainText.charAt(i);
            char decryptedChar = (char) (ch - key);
            decryptedText[i] = decryptedChar;
        }

        return new String(decryptedText);
    }
}