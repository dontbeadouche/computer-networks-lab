import java.net.*;
import java.io.*;

public class WebClient{

	public static void main(String[] args) throws Exception{
	
	

	// create a client socket to connect to server socket of google

	Socket client = new Socket();
	String host = "www.google.com";
	PrintWriter s_out = null;	// sending HTTP request as a line from the program 
								// and get converting it into character by character for sending to the client
	
	BufferedReader s_in = null;

	/* public void connect(SocketAddress endpoint)
             throws IOException
    */
    		
    client.connect(new InetSocketAddress(host,80));		// connect to google server socket 
    													// using IP address and port number
    s_out = new PrintWriter(client.getOutputStream(),true);		// attach the printwriter to client socket

    System.out.println("Connected to server socket of google");

    String FirstHTTPRequest = "GET / HTTP/1.1\r\n";
    String SecondReq = "Host: www.google.com\r\n\r\n";

    s_out.println(FirstHTTPRequest);
    s_out.println(SecondReq);		// done with the request

    System.out.println("HTTP headers sent from client to server socket of google");

	}
}