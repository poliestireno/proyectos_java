
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UDPClient2 {
    public static void main(String[] args) {
        try (DatagramSocket clientSocket = new DatagramSocket();Scanner scanner = new Scanner(System.in))
        {
            InetAddress serverAddress = InetAddress.getByName("localhost");
            byte[] sendBuffer;
            byte[] receiveBuffer = new byte[1024];

            System.out.println("Escribe algo o exit para terminar");

            while (true) 
            { 
                String mensaje = scanner.nextLine();
                sendBuffer= mensaje.getBytes();
                DatagramPacket sentPacket = new DatagramPacket(sendBuffer, sendBuffer.length, serverAddress,5000);
                clientSocket.send(sentPacket);
                
                if (mensaje.equalsIgnoreCase("exit"))
                {
                    System.out.println("Cerrando cliente......");
                    break;
                }

                DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
                clientSocket.receive(receivePacket);
                String respuestaServidor = new String(receivePacket.getData(),0,receivePacket.getLength());
                System.out.println("Servidor dice: "+respuestaServidor);

            }


            
        } catch (Exception e) 
        {

        }
    }
    
}
