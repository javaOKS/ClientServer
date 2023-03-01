package org.example;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
;

public class Server {
    public static void main(String[] args) {

        try (ServerSocket serverSocket = new ServerSocket(8080)) {
            System.out.println("Waiting for a client...");
            try (Socket socket = serverSocket.accept();


                 BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                 PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {
                String strClient;
                String dateTime = DateTimeFormatter.ofPattern("MMM dd yyyy, hh:mm:ss a")
                        .format(LocalDateTime.now());
                Pattern pattern = Pattern.compile("[эъы]");
                Matcher m;
                String parting = "BAY!";
                String strServer = "Привіт!";
                out.println(strServer);
                while (!(strServer.equals(parting))) {
                    strClient = in.readLine();
                    System.out.println("Client says: " + strClient);
                    if ((m = pattern.matcher(strClient)).find()) {
                        out.println("Що таке паляниця?");
                        strClient = in.readLine();
                        if (strClient.equals("хліб")) {
                            strServer = parting;
                            out.println(dateTime + " " + strServer);
                        } else {
                            strServer = parting;
                            out.println(strServer);
                        }
                    } else {
                        strServer = parting;
                        out.println(dateTime + "  " + strServer);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}