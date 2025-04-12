import java.net.*;
import java.io.*;

public class Server {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket(5000);
        byte[] receiveBuffer = new byte[1024];
        byte[] sendBuffer;

        System.out.println("Server is running...");

        while (true) {
            // Receive file name
            DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
            socket.receive(receivePacket);
            String fileName = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println("Client requested file: " + fileName);

            String fileContent = "";

            try {
                BufferedReader reader = new BufferedReader(new FileReader(fileName));
                StringBuilder sb = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    sb.append(line).append("\n");
                }
                reader.close();
                fileContent = sb.toString();
            } catch (IOException e) {
                fileContent = "File not found!";
            }

            // Send content back to client
            sendBuffer = fileContent.getBytes();
            InetAddress clientAddress = receivePacket.getAddress();
            int clientPort = receivePacket.getPort();
            DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, clientAddress, clientPort);
            socket.send(sendPacket);
        }
    }
}
