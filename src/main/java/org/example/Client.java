package org.example;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 8080);
             BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            String str = "";

            while (!(str.equals("вихід"))) {
                System.out.println(in.readLine());
                str = userInput.readLine();
                out.println(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
