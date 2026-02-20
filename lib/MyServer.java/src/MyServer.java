import java.io.*;
import java.net.*;

public class MyServer {
    public static void main(String[] args) {
        try {
            // Create a server socket listening on port 6666
            ServerSocket ss = new ServerSocket(6666);

            System.out.println("Server is waiting for a client...");

            // Accept the client connection
            Socket s;
            s = ss.accept();
            System.out.println("Client connected.");

            // Create input stream to receive data
            DataInputStream dis = new DataInputStream(s.getInputStream());

            // Read message from client
            String str = dis.readUTF();
            System.out.println("Message = " + str);

            // Close connections
            dis.close();
            s.close();
            ss.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}