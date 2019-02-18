import java.io.*;
import java.net.*;

public class TCPServer2019{

	public static void main(String[] args) throws Exception{
		
		// open a ServerSocket which listens via port number 6969 
		ServerSocket serversocket = new ServerSocket(6969);// welcome socket
		System.out.println("server connection on");
		Socket Toclient = serversocket.accept();	// Blocking call to wait for incoming connection from client

		// open InputStream and OutputStream to Toclient obj to send/recieve info

		System.out.println("client got connected");
		BufferedReader FromClient = new BufferedReader(new InputStreamReader(Toclient.getInputStream()));

		PrintWriter SendClient = new PrintWriter(Toclient.getOutputStream());
		String ReadData = FromClient.readLine();	// read a line of data from client

		// Display the read data in server console
		System.out.println(ReadData) ;
		String modified = ReadData.toUpperCase();
		
		SendClient.println(modified);
		SendClient.flush();


	}
}