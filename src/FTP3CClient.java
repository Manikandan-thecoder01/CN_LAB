import java.io.*;
import java.net.*;
public class FTP3CClient {
 public static void main(String[] args) {
 try {
 InetAddress serverIP = InetAddress.getLocalHost();
 Socket socket = new Socket(serverIP, 1024);
 BufferedReader inputFromServer = new BufferedReader(new
InputStreamReader(socket.getInputStream()));
 BufferedReader consoleInput = new BufferedReader(new
InputStreamReader(System.in));
 System.out.print("Enter a new file name to save received content: ");
 String fname = consoleInput.readLine();
 PrintWriter fileWriter = new PrintWriter(new FileWriter(fname));
 String line;
 while ((line = inputFromServer.readLine()) != null) {
 fileWriter.println(line);
 }
 fileWriter.close();
 inputFromServer.close();
 socket.close();
 System.out.println("File received and saved successfully.");
 } catch (Exception e) {
 System.out.println("Client Error: " + e.getMessage());
 }
 }
}