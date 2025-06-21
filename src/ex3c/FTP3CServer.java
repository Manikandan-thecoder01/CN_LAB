package ex3c;
import java.io.*;
import java.net.*;
public class FTP3CServer {
 public static void main(String[] args) {
 try {
 ServerSocket ss = new ServerSocket(1024);
 System.out.println("Server is running and waiting for client connection...");
 Socket s = ss.accept();
 System.out.println("Client connected.");
 BufferedReader consoleInput = new BufferedReader(new
InputStreamReader(System.in));
 PrintWriter out = new PrintWriter(s.getOutputStream(), true);
 System.out.print("Enter a file name to send: ");
 String fname = consoleInput.readLine();
 File file = new File(fname);
 if (file.exists()) {
 BufferedReader fileReader = new BufferedReader(new
FileReader(file));
 String line;
 while ((line = fileReader.readLine()) != null) {
 out.println(line);
 }
 fileReader.close();
 System.out.println("File sent successfully.");
 } else {
 out.println("ERROR: File not found.");
 System.out.println("File does not exist.");
 }
 out.close();
 s.close();
 ss.close();
 } catch (Exception e) {
 System.out.println("Server Error: " + e.getMessage());
 }
 }
}