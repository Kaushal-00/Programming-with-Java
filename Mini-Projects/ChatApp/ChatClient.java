import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String host;
        int port = 5000;

        // Ask user where to connect
        System.out.println("Choose connection option:");
        System.out.println("1. Connect to localhost");
        System.out.println("2. Connect to custom IP");
        System.out.print("Enter choice (1 or 2): ");
        int choice = Integer.parseInt(scanner.nextLine());

        if (choice == 1) {
            host = "localhost";
        } else {
            System.out.print("Enter server IP address: ");
            host = scanner.nextLine();
        }

        // Connect to chosen host
        Socket socket = new Socket(host, port);
        DataInputStream dis = new DataInputStream(socket.getInputStream());
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

        // Receiving thread
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

        // Sending thread
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
