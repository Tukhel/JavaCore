package ru.geekbrains.lesson4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WindowChat extends JFrame {

    JTextArea messagesArea;
    JTextField messageField;

    public WindowChat() {
        setTitle("Chat");
        setBounds(200,200, 500, 500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        messagesArea = new JTextArea();
        messagesArea.setLineWrap(true);
        messagesArea.setWrapStyleWord(true);
        messagesArea.setEditable(false);

        JScrollPane scroll = new JScrollPane(messagesArea,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        add(scroll, BorderLayout.CENTER);


        JPanel sendMessagePanel = new JPanel();
        sendMessagePanel.setLayout(new BorderLayout());
        JButton sendButton = new JButton("Отправить");
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addMessage();
            }
        });
        sendMessagePanel.add(sendButton, BorderLayout.EAST);
        messageField = new JTextField();
        messageField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addMessage();
            }
        });
        sendMessagePanel.add(messageField, BorderLayout.CENTER);


        add(sendMessagePanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    void addMessage(){
        messagesArea.append(messageField.getText() + "\n");
        messageField.setText("");
    }
}