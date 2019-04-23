package ru.geekbrains.lesson6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class EchoServer {

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(7777)) {
            while (true) {
                System.out.println("Сервер ожидает подключения!");
                Socket socket = serverSocket.accept();

                System.out.println("Кто-то подключился: " + socket.getInetAddress());

                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                Scanner scanner = new Scanner(System.in);

                Thread thr = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while (scanner.hasNextLine()) {
                            String line = scanner.nextLine();
                            try {
                                out.writeUTF(line);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                });
                thr.start();

                while (true) {
                    try {
                        System.out.println("Клиент: " + in.readUTF());
                    } catch (IOException ex) {
                        ex.printStackTrace();
                        break;
                    }
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}