import java.net.*;

class MulticastCliente {
    public static void main(String[] args) {
        String multicastAddress = "239.1.1.1"; 
        int port = 5000;

        try (MulticastSocket socket = new MulticastSocket(port)) {
            InetAddress group = InetAddress.getByName(multicastAddress);
            
            NetworkInterface netIf = NetworkInterface.getByName("wlp2s0"); 
            socket.joinGroup(new InetSocketAddress(group, port), netIf);
            System.out.println("Cliente unido al grupo multicast.");
            
            byte[] buffer = new byte[1024];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            
            socket.receive(packet);
            String receivedMessage = new String(packet.getData(), 0, packet.getLength());
            System.out.println("Mensaje recibido: " + receivedMessage);
            
            socket.leaveGroup(new InetSocketAddress(group, port), netIf);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}