package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

public class ParseFormGUI extends JFrame {
    private JPanel rootPanel;
    private JButton reButton;
    private JButton parseButton;
    private JTextArea textArea;

    public ParseFormGUI() {
        setContentPane(rootPanel);
        setLocation(200,200);
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        parseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ArrayList<Post> posts = ConnectAndParse.connectAndParse();
                    textArea.setColumns(1);
                    for (Post post : posts){
                        textArea.append(
                                post.getAuthor() + " " +
                                post.getTitle() + " " +
                                post.getDateOfCreated() + "\n" +
                                "--" + post.getDetailsLink() + "\n" +
                                "---" + post.getAuthorDetailsLink() + "\n\n");

                    }

                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        reButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
