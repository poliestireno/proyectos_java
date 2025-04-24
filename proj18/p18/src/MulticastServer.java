import java.net.*;

class MulticastServer {
    public static void main(String[] args) {
        String multicastAddress = "239.1.1.1"; 
        int port = 5000;

        try (MulticastSocket socket = new MulticastSocket()) {
            InetAddress group = InetAddress.getByName(multicastAddress);
            String message = "¡ALARMA ESTADO DE SITIO!";
            byte[] buffer = message.getBytes();
            
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length, group, port);
            System.out.println("Enviando mensaje multicast...");
            socket.send(packet);
            System.out.println("Mensaje enviado: " + message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}