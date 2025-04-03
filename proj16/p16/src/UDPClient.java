
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {
    public static void main(String[] args) throws Exception 
    {       
        try (DatagramSocket clienSocket = new DatagramSocket()) 
        {
            InetAddress serverAddress = InetAddress.getByName("localhost");
            int serverPort = 5000;
            String message = "Hello, Server UDP!";
            byte[] buffer = message.getBytes();
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length, serverAddress, serverPort);
            clienSocket.send(packet);
            System.out.println("Mensaje enviado: " + message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
