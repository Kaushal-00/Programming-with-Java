import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 5000);

        DataInputStream dis = new DataInputStream(socket.getInputStream());
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        Scanner scanner = new Scanner(System.in);

        // Receive messages
        Thread readThread = new Thread(new Runnable() {
            public void run() {
                try {
                    while (true) {
                        String msg = dis.readUTF();
                        System.out.println(msg);
                    }
                } catch (IOException e) {
                    System.out.println("Disconnected from server.");
                }
            }
        });

        readThread.start();

        // Send messages
        while (true) {
            String message = scanner.nextLine();
            dos.writeUTF(message);

            if (message.equalsIgnoreCase("exit")) {
                break;
            }
        }

        dis.close();
        dos.close();
        socket.close();
        scanner.close();
    }
}
