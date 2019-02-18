import java.io.*;
import java.net.*;

public class TCPServer_MultiCommunication_2019{
	// this program allows multiple communication between a single client and server
	public static void main(String[] args) throws Exception{
		
		// open a ServerSocket which listens via port number 6969 
		ServerSocket serversocket = new ServerSocket(46969);// welcome socket
		System.out.println("server connection on");
		Socket Toclient = serversocket.accept();	// Blocking call to wait for incoming connection from client

		// open InputStream and OutputStream to Toclient obj to send/recieve info

		System.out.println("client got connected");
		BufferedReader FromClient = new BufferedReader(new InputStreamReader(Toclient.getInputStream()));

		PrintWriter SendClient = new PrintWriter(Toclient.getOutputStream());

		while(true){	// while loop for multiple time communication 
			String ReadData = FromClient.readLine();	// read a line of data from client

			// Display the read data in server console
			System.out.println(ReadData) ;
			String modified = ReadData.toUpperCase();
		
			SendClient.println(modified);
			SendClient.flush();
		}

	}
}