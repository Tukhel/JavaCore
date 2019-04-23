package ru.geekbrains.lesson6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class EchoClient {

    public static void main(String[] args) throws InterruptedException {

        try (Scanner scanner = new Scanner(System.in);
             Socket socket = new Socket("localhost", 7777)) {

            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            DataInputStream in = new DataInputStream(socket.getInputStream());

            Thread thr = new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("Введите сообщение: ");
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
            //thr.join();

            while (true) {
                try {
                    System.out.println("Сервер: " + in.readUTF());
                } catch (IOException ex) {
                    ex.printStackTrace();
                    break;
                }
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}