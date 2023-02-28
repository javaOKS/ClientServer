package org.example;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {

        try (ServerSocket serverSocket = new ServerSocket(8080)) {
            System.out.println("Waiting for a client...");
            try (Socket socket = serverSocket.accept();

                 BufferedReader serverInput = new BufferedReader(new InputStreamReader(System.in));
                 BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                 PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {
                String strClient;
                String strServer = "Привіт!";
                out.println(strServer);
                while (!(strClient = in.readLine()).equals("вихід")) {
                    System.out.println("Client says :" + strClient);
                    strServer = serverInput.readLine();
                    out.println("Server says: " + strServer);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}