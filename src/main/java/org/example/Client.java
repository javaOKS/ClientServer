package org.example;

import java.io.*;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Client {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 8080);
             BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            String str = "";
            String strServer = "";
            while (!str.equals("BAY.")) {
                strServer = in.readLine();
                System.out.println(strServer);
                if (Pattern.matches(".*BAY.*", strServer)) {
                    str = "BAY!";
                    break;
                }
                str = userInput.readLine();
                out.println(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
