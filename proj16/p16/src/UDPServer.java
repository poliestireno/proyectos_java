import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPServer {
    public static void main(String[] args) 
{
        try (DatagramSocket serverSocket = new DatagramSocket(5000)) {
            byte[] buffer = new byte[1024];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            System.out.println("Esperando mensaje UDP...");
            serverSocket.receive(packet);
            String message = new String(packet.getData(), 0, packet.getLength());
            System.out.println("Mensaje recibido: " + message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
