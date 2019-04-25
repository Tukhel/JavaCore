package ru.geekbrains.lesson6;

import java.io.IOException;
import java.net.Socket;

public class EchoClient {

    public static void main(String[] args) {

        try (Socket socket = new Socket("localhost", 7777)) {
            SocketHendler socketHendler = new SocketHendler(socket);
            socketHendler.start();
            socketHendler.join();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}