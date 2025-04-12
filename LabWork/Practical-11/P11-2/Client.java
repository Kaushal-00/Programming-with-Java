import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket();
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter audio file name (with extension): ");
        String fileName = sc.nextLine();
        byte[] sendBuffer = fileName.getBytes();

        InetAddress serverAddress = InetAddress.getByName("localhost");
        DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, serverAddress, 5000);
        socket.send(sendPacket);

        // Receive file content
        byte[] receiveBuffer = new byte[1024];
        DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
        socket.receive(receivePacket);

        String response = new String(receivePacket.getData(), 0, receivePacket.getLength());
        System.out.println("\nContent from server:\n" + response);

        socket.close();
    }
}