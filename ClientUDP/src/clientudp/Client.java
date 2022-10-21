package ClientUDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Client {
	static final String expectedResponse = "pong";
	static final int listening_port = 3000;
	static final int buffer_size = 1024;
	static boolean hearbeatmessage = true;

	
    public static void main(String[] args) throws IOException {
        runSessionHeartbeat(1000); // 1 second request/response interval
    }
    
    static String UDPClientSend() throws IOException{
    	DatagramSocket client = new DatagramSocket(); // Client start
        InetAddress address = InetAddress.getByName("127.0.0.1"); // current Machine Address 127.0.0.1 or localhost
        
        String ping = "ping";
        byte[] buffer = new byte[buffer_size]; // Max data to be transfered
        byte[] sendMessage = ping.getBytes();
        System.arraycopy(sendMessage, 0, buffer, 0, sendMessage.length);
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length,address, listening_port); // implement sendRequest to port 3000 and localhost server via UDP
        client.send(packet); // Send ping message request to server
        System.out.println("\nPing has been sent to server");
        
        client.receive(packet); // receive server response
        String res = new String(packet.getData(),0,packet.getLength());
        System.out.println("\nServer response " + res);
        client.close();
      
        return res;
    }
    

    static void runSessionHeartbeat(int interval) throws IOException {
    	
		    while(hearbeatmessage) {
		    	try {
				Thread.sleep(interval);
		    	} catch (InterruptedException e) {
					e.printStackTrace();
				}
		    	String res = UDPClientSend(); // Initialize Client/Send request and fetch response
		    	
		    	if(!res.equals(expectedResponse)) {
		    		break;
		    	}
		    } 
    }

}
