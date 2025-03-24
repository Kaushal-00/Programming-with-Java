import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter plaintext (lowercase letters only): ");
        String text = sc.nextLine();

        System.out.print("Enter key for Caesar Cipher: ");
        int key = sc.nextInt();

        Substitution_Cipher s_cipher = new Substitution_Cipher(text, 0);
        System.out.println("Substitution Encrypted: " + s_cipher.Encryption());
        System.out.println("Substitution Decrypted: " + s_cipher.Decryption());

        Caesar_Cipher c_cipher = new Caesar_Cipher(text, key);
        System.out.println("Caesar Encrypted: " + c_cipher.Encryption());
        System.out.println("Caesar Decrypted: " + c_cipher.Decryption());

        sc.close();
    }
}
