import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 5000);

        DataInputStream dis = new DataInputStream(socket.getInputStream());
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

        // Send message to server
        dos.writeUTF("Hi Server!");

        // Receive response from server
        String response = dis.readUTF();
        System.out.println("Received from server: " + response);

        dis.close();
        dos.close();
        socket.close();
    }
}
