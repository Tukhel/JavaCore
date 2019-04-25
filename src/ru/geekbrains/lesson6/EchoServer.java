package ru.geekbrains.lesson6;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(7777)) {
            while (true) {
                System.out.println("Сервер ожидает подключения!");
                Socket socket = serverSocket.accept();

                System.out.println("Подключился новый клиент!");
                SocketHendler socketHendler = new SocketHendler(socket);
                socketHendler.start();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}