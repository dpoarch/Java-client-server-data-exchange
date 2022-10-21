package ServerUDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;

public class UDPService implements Runnable{
    private final UDPServer udpserver;
    private final int port;
    private final byte[] buf;
    private final InetAddress address;
    
    public UDPService(DatagramPacket packet, UDPServer udpserver) {
        address = packet.getAddress();
        port = packet.getPort();
        buf = packet.getData();
        this.udpserver = udpserver;
    }
    
    @Override
    public void run() {
    	// check if message from client is ping response should be pong
        if(new String(buf, 0, buf.length).trim().equals("ping")){ 
            byte[] response = "pong".getBytes();
           
			try {
				udpserver.sendPacket(new DatagramPacket(response,
					                                     response.length,
					                                     address,
					                                     port));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
			
        }
    }
}
