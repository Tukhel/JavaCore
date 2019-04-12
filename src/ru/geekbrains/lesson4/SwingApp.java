package ru.geekbrains.lesson4;

import javax.swing.*;

public class SwingApp {

    private static WindowChat windowChat;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                windowChat = new WindowChat();
            }
        });
    }
}
