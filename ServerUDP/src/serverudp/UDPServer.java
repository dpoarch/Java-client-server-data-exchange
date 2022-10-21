package ServerUDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UDPServer {
    private static final int THREAD_POOL = 4;
    private DatagramSocket socket;

    public UDPServer() throws SocketException {
        socket = new DatagramSocket(3000);
    }
    
    public void start() throws IOException{
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL);
        
        byte[] buf = new byte[1024];
        
        DatagramPacket packet = new DatagramPacket(buf, 1024);
        
        while (true) {
            socket.receive(packet);
            executor.execute(new UDPService(packet, this));
        }
    }
    
    public void sendPacket(DatagramPacket packet) throws IOException{
        try {
            socket.send(packet);
        } catch (IOException ex) {}
    }
    
    public static void main(String[] args) throws Exception {
        new UDPServer().start();
    }
}
