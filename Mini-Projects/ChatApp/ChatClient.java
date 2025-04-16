import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JOptionPane;

public class ChatClient {
    public static String name;
    public static String host;
    public static int port = 5000;
    public static DataInputStream dis;
    public static DataOutputStream dos;

    public static void main(String[] args) {
        NameInputWindow.show();
    }

    public static void connectToServer() {
        try {
            Socket socket = new Socket(host, port);
            dis = new DataInputStream(socket.getInputStream());
            dos = new DataOutputStream(socket.getOutputStream());

            dis.readUTF();
            dos.writeUTF(name);

            ChatWindow.show();

            new Thread(() -> {
                try {
                    while (true) {
                        String msg = dis.readUTF();
                        ChatWindow.addMessage(msg, false);
                    }
                } catch (IOException e) {
                    ChatWindow.addMessage("Disconnected from server.", false);
                }
            }).start();

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Connection failed: " + e.getMessage());
        }
    }
}
