import java.io.*;
import java.net.*;

public class webclient2019{

    public static void main(String[] args) {
        try{
            String host = "www.martinbroadhurst.com";   // url of the server
            int portnum = 80;    // port address of the web server
            Socket client = new Socket(host, portnum);  // connection between client socket and server socket established

            // Attach a PrintWriter output buffer to send http headers line by line rather than character by character
            PrintWriter outToSocket = new PrintWriter(client.getOutputStream(), true);

            // Attach a input buffer to read serial character from socket and buffer it

            BufferedReader InFromSocket = new BufferedReader(new InputStreamReader(client.getInputStream()));

            outToSocket.println("GET / HTTP/1.1");  // first http request header sent
            outToSocket.println("Host: www.martinbroadhurst.com");  // second http request header sent
            outToSocket.println();  // send blank header
            
            String inputLine;
            
            while( (inputLine = InFromSocket.readLine()) != null){
                System.out.println(inputLine);
            }
        }catch(Exception e){ System.out.println("Error"); }
        
        System.exit(1);
            
    }
}