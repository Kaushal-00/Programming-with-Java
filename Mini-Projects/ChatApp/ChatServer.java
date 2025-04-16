import java.io.*;
import java.net.*;
import java.util.*;

public class ChatServer {
    private static Set<ClientHandler> clientHandlers = new HashSet<>();
    private static final String HISTORY_FILE = "chat_history.txt";

    public static void main(String[] args) {
        int port = 12345;

        // Optional: Clear the history file on server start
        clearHistoryOnStart();

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Chat Server started on port " + port + "...");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected: " + socket.getInetAddress());

                ClientHandler clientHandler = new ClientHandler(socket);
                clientHandlers.add(clientHandler);
                clientHandler.start();
            }

        } catch (IOException e) {
            System.err.println("Server error: " + e.getMessage());
        }
    }

    // Optional: Clear history when server restarts
    private static void clearHistoryOnStart() {
        try (PrintWriter writer = new PrintWriter(HISTORY_FILE)) {
            writer.print(""); // Clear contents
        } catch (IOException e) {
            System.err.println("Could not clear history file.");
        }
    }

    // Broadcast message to all clients and save to file
    public static synchronized void broadcast(String message, ClientHandler sender) {
        // Write to file
        try (FileWriter writer = new FileWriter(HISTORY_FILE, true)) {
            writer.write(message + "\n");
        } catch (IOException e) {
            System.err.println("Error writing to history file: " + e.getMessage());
        }

        // Send to all other clients
        for (ClientHandler client : clientHandlers) {
            if (client != sender) {
                client.sendMessage(message);
            }
        }
    }

    // Inner class to handle each client
    static class ClientHandler extends Thread {
        private Socket socket;
        private PrintWriter out;
        private BufferedReader in;
        private String userName;

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);

                // Send chat history to the new client
                sendHistory();

                // Read username
                userName = in.readLine();
                System.out.println(userName + " joined the chat.");
                broadcast(userName + " joined the chat.", this);

                // Read and broadcast messages
                String message;
                while ((message = in.readLine()) != null) {
                    String fullMessage = userName + ": " + message;
                    System.out.println(fullMessage);
                    broadcast(fullMessage, this);
                }

            } catch (IOException e) {
                System.out.println(userName + " disconnected.");
            } finally {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                clientHandlers.remove(this);
                broadcast(userName + " left the chat.", this);
            }
        }

        void sendMessage(String message) {
            out.println(message);
        }

        // Send stored history to newly connected client
        private void sendHistory() {
            try (BufferedReader historyReader = new BufferedReader(new FileReader(HISTORY_FILE))) {
                String line;
                while ((line = historyReader.readLine()) != null) {
                    sendMessage(line);
                }
            } catch (IOException e) {
                System.err.println("Error reading chat history: " + e.getMessage());
            }
        }
    }
}
