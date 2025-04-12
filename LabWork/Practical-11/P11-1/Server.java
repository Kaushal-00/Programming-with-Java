import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(5000);
        System.out.println("Server started. Waiting for client...");

        Socket socket = serverSocket.accept();
        System.out.println("Client connected.");

        DataInputStream dis = new DataInputStream(socket.getInputStream());
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

        String message = dis.readUTF();
        System.out.println("Received from client: " + message);

        // Echo back the message
        dos.writeUTF("Echo: " + message);

        dis.close();
        dos.close();
        socket.close();
        serverSocket.close();
    }
}
