package ex3a;
import java.io.*;
import java.net.*;
public class EchoClient {
public static void main(String[] args) throws IOException {
Socket socket = new Socket("localhost", 1234);
System.out.println("Connected to server.");
BufferedReader input = new BufferedReader(new
InputStreamReader(socket.getInputStream()));
PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
BufferedReader keyboard = new BufferedReader(new
InputStreamReader(System.in));
String clientMsg, serverMsg;
while (true) {
System.out.print("Client: ");
clientMsg = keyboard.readLine();
output.println(clientMsg);
if (clientMsg.equalsIgnoreCase("exit")) {
System.out.println("Disconnected from server.");
break;
}
serverMsg = input.readLine();
System.out.println("Server: " + serverMsg);
}
socket.close();
}
}