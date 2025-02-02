import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the plaintext: ");
        String plainText = sc.nextLine();

        System.out.print("Enter the key: ");
        int key = sc.nextInt();

        Cipher cipher = new Cipher(plainText, key);

        String encryptedText = cipher.Encryption();
        System.out.println("Encrypted text: " + encryptedText);

        Cipher decryptCipher = new Cipher(encryptedText, key);
        String decryptedText = decryptCipher.Decryption();
        System.out.println("Decrypted text: " + decryptedText);

        sc.close();
    }
}
