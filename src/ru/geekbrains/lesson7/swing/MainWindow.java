package ru.geekbrains.lesson7.swing;

import ru.geekbrains.lesson7.ClientHandler;
import ru.geekbrains.lesson7.MessageReciever;
import ru.geekbrains.lesson7.Network;
import ru.geekbrains.lesson7.TextMessage;
import ru.geekbrains.lesson7.auth.AuthService;
import ru.geekbrains.lesson7.auth.AuthServiceImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame implements MessageReciever {

    private final JList<TextMessage> messageList;

    private final DefaultListModel<TextMessage> messageListModel;

    private final TextMessageCellRenderer messageCellRenderer;

    private final JScrollPane scroll;

    private final JPanel sendMessagePanel, userPanel;

    private final JButton sendButton;

    private final JTextField messageField, userNameField;

    private final JTextArea userName;

    private final Network network;

    public MainWindow() {
        setTitle("Чат");
        setBounds(200,200, 500, 500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        messageList = new JList<>();
        messageListModel = new DefaultListModel<>();
        messageCellRenderer = new TextMessageCellRenderer();
        messageList.setModel(messageListModel);
        messageList.setCellRenderer(messageCellRenderer);

        scroll = new JScrollPane(messageList,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        add(scroll, BorderLayout.CENTER);

        sendMessagePanel = new JPanel();
        sendMessagePanel.setLayout(new BorderLayout());
        sendButton = new JButton("Отправить");
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userTo = userNameField.getText();
                String text = messageField.getText();
                if (text != null && !text.trim().isEmpty()) {
                    TextMessage msg = new TextMessage(network.getLogin(), userTo, text);
                    messageListModel.add(messageListModel.size(), msg);
                    messageField.setText(null);

                    // TODO реализовать проверку, что сообщение не пустое
                    network.sendTextMessage(msg);
                }
            }
        });
        sendMessagePanel.add(sendButton, BorderLayout.EAST);
        messageField = new JTextField();
        userNameField = new JTextField(30);
        userPanel = new JPanel();
        userName = new JTextArea("Отправить личное сообщение:");
        sendMessagePanel.add(userPanel, BorderLayout.NORTH);
        sendMessagePanel.add(messageField, BorderLayout.CENTER);
        userPanel.add(userName, BorderLayout.WEST);
        userPanel.add(userNameField, BorderLayout.CENTER);

        add(sendMessagePanel, BorderLayout.SOUTH);
        setVisible(true);

        this.network = new Network("localhost", 7777, this);

        LoginDialog loginDialog = new LoginDialog(this, network);
        loginDialog.setVisible(true);

        if (!loginDialog.isConnected()) {
            System.exit(0);
        }
    }

    @Override
    public void submitMessage(TextMessage message) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                messageListModel.add(messageListModel.size(), message);
                messageList.ensureIndexIsVisible(messageListModel.size() - 1);
            }
        });
    }
}