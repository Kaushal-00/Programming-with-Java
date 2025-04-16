import java.io.*;
import java.net.Socket;

public class ClientHandler extends Thread {
    private Socket socket;
    private DataInputStream dis;
    private DataOutputStream dos;
    private String name;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            dis = new DataInputStream(socket.getInputStream());
            dos = new DataOutputStream(socket.getOutputStream());

            dos.writeUTF("Enter your name:");
            name = dis.readUTF();
            System.out.println(name + " joined the chat.");
            ChatServer.broadcast(name + " joined the chat!", this);

            sendChatHistory(); // Send previous messages

            String message;
            while (true) {
                message = dis.readUTF();
                if (message.equalsIgnoreCase("exit")) break;
                String formatted = name + ": " + message;
                System.out.println(formatted);
                ChatServer.broadcast(formatted, this);
            }

        } catch (IOException e) {
            System.out.println(name + " disconnected.");
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            ChatServer.clients.remove(this);
            ChatServer.broadcast(name + " left the chat.", this);
        }
    }

    public void sendMessage(String message) {
        try {
            dos.writeUTF(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sendChatHistory() {
        for (String line : ChatLogger.readHistory()) {
            sendMessage(line);
        }
    }
}
