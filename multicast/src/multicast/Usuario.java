package multicast;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.management.ManagementFactory;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class Usuario {	
	public static void main(String [] args) throws IOException, InterruptedException{
		int port;
                InetAddress ip;
		byte[] sendData = new byte[1024];
		byte[] receiveData = new byte[1024];
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                DatagramPacket sendPacket; new DatagramPacket(sendData,sendData.length);
		MulticastSocket mSocket = new MulticastSocket(3333);
		String group = "224.0.0.2";		
		mSocket.joinGroup(InetAddress.getByName(group));
		mSocket.receive(receivePacket);
                
                
                String resposta = new String(receivePacket.getData(), receivePacket.getOffset(),
				receivePacket.getLength());
                port = Integer.parseInt(resposta);
                
                String id = ManagementFactory.getRuntimeMXBean().getName();
                sendData = id.getBytes();
		DatagramPacket pacote = new DatagramPacket(sendData, sendData.length,receivePacket.getAddress() , port);
                mSocket.send(pacote);

                
	}	
	
}