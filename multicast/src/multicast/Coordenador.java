package multicast;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class Coordenador {

	public static void main(String [] args) throws IOException, InterruptedException{
		MulticastSocket multiSocket = new MulticastSocket();
		byte[] send = new byte[1024];
		byte[] receiveData = new byte[1024];
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
		String group = "224.0.0.2";
                int port;
                DatagramSocket socket = new DatagramSocket(44444);
                socket.setSoTimeout(10);
                port = 44444;
                send = Integer.toString(port).getBytes();
                System.out.println(port);
                // falta enviar a porta 
		DatagramPacket pacote = new DatagramPacket(send, send.length,InetAddress.getByName(group) , 3333);
		multiSocket.send(pacote);
                int count =0;
                while(true){
                    try{
                        Thread.sleep(5000);
                        socket.receive(receivePacket);
                        String resposta = new String(receivePacket.getData(), receivePacket.getOffset(),
                                    receivePacket.getLength());
                        System.out.println(resposta);
                        count++;
                    }catch(Exception ex){
                        System.out.println("Socket não recebeu mais respostas,total de clientes conectados: "+count);
                        break;
                    }
                    
                }
                
                
				
	}
	
	
}