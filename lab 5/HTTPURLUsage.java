import java.net.*;
import java.io.*;

public class HTTPURLUsage{

	public static void main(String[] args) throws Exception{
		
		URL URLObject = new URL("https://universe.bits-pilani.ac.in/Uploads/Campus/BITS_university_logo.gif");
		// make use of highevel java network api to hide complexities of programming at basic socket level
		HttpURLConnection newConnection = (HttpURLConnection)URLObject.openConnection();
		newConnection.connect();	// 1. now connection established	2. Http request headers sent 
									// 3. Http response headers and image started recieving
		String httpResponse = newConnection.getResponseMessage();
		System.out.println(httpResponse); 
		System.out.println("Method used (GET or POST) : " + newConnection.getRequestMethod());
	
		System.out.println("Content length : " + newConnection.getContentLength());
		// open an input stream to read image bytes
		File Destination = new File("/Users/parthpoply/Documents/Study Material 6th Semester/Computer Networks/Lab Stuff/lab 5/Download.gif");
		//open an output stream to file, write image bytes got by HTTPURLConnection
		OutputStream Tofile = new FileOutputStream(Destination);

		byte[] imagebuffer = new byte[2048]; 	// valid data filled in the imagebuffer
		int length;
		// open an input stream to newConnection obj (which represents a connection b/w client and server) 
		// to receive blocks of bytes corresponding to pixels of the image incrementally
		InputStream FromServer = newConnection.getInputStream();
		// read first block of data from server and store
		while((length = FromServer.read(imagebuffer)) != -1){
			Tofile.write(imagebuffer,0,length); 	// now write block of data from imagebuffer to file		
			System.out.println(" current transfer length : " + length);
		}

	}
}