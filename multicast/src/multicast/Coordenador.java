package multicast;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class Coordenador {

	public static void main(String [] args) throws IOException{
		MulticastSocket multiSocket = new MulticastSocket();
		byte[] send;
		byte[] receiveData = new byte[1024];
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
		String group = "224.0.0.1";
                int port;
                DatagramSocket socket = new DatagramSocket();
                port = socket.getPort();
                // falta enviar a porta 
		DatagramPacket pacote = new DatagramPacket(send, send.length,InetAddress.getByName(group) , port);
		multiSocket.send(pacote);
                
                while(true){
                    multiSocket.receive(pacote);
                    String resposta = new String(receivePacket.getData(), receivePacket.getOffset(),
				receivePacket.getLength());
                    System.out.println(resposta);
                }
                
                
				
	}
	
	
}