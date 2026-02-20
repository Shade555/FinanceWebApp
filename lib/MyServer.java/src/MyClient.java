import java.io.*;
import java.net.*;

public class MyClient {
    public static void main(String[] args) {
        try {
            // Connect to server running on localhost at port 6666
            Socket s = new Socket("localhost", 6666);
            System.out.println("Connected to server.");

            // Create output stream to send data
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());

            // Send message to server
            dout.writeUTF("Hello Server");
            System.out.println("Message sent to server.");

            // Flush and close streams
            dout.flush();
            dout.close();
            s.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
