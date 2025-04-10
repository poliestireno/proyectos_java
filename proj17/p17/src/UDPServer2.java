import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPServer2 {
    public static void main(String[] args) 
{
        try (DatagramSocket serverSocket = new DatagramSocket(5000)) {
            byte[] buffer = new byte[1024];
            byte[] bufferR = new byte[1024];

            System.out.println("Servidor UDP iniciado. Esperando mensajes...");
        
            while(true)
            {
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                System.out.println("Esperando mensaje UDP...");
                serverSocket.receive(packet);
                String message = new String(packet.getData(), 0, packet.getLength());
                System.out.println("Mensaje recibido: " + message);
                
                if(message.equalsIgnoreCase("exit"))
                {
                    System.out.println("El cliente ha terminado la conexión");
                    break;
                }
                
                String response = " Servidor recibió:"+message;
                bufferR = response.getBytes();
                DatagramPacket packetEnvio = new DatagramPacket(bufferR, bufferR.length,packet.getAddress(),packet.getPort());
                serverSocket.send(packetEnvio);
            }   
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
