public class Cipher {

    String plainText;
    int key;

    public Cipher(String plainText, int key) {
        this.plainText = plainText;
        this.key = key;
    }


    public String Encryption() {
        char encryptedText[] = new char[plainText.length()];
        char temp_plainText[] = plainText.toCharArray();

        for (int i = 0; i < temp_plainText.length; i++) {
            int updated_Ascii = (int) temp_plainText[i] + key;
            char updated_Char = (char) updated_Ascii;
            encryptedText[i] = updated_Char;
        }

        return new String(encryptedText);
    }


    public String Decryption() {
        char decryptedText[] = new char[plainText.length()];
        char temp_encryptedText[] = plainText.toCharArray();

        for (int i = 0; i < temp_encryptedText.length; i++) {
            int original_Ascii = (int) temp_encryptedText[i] - key;
            char original_Char = (char) original_Ascii;
            decryptedText[i] = original_Char;
        }

        return new String(decryptedText);
    }

}