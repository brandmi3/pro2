package cz.uhk.fim.todolist.gui;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {
    public Frame() {
        intit();
    }

    private void intit() {
        setTitle("Todo List App");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(640, 480);
        setLocationRelativeTo(null);
        initControlPanel();
    }

    private void initControlPanel() {
        JPanel controlPanel = new JPanel(new BorderLayout());

        JPanel formPanel = new JPanel(new BorderLayout());
        JLabel lblAddTodo = new JLabel("Zadejte Todo:");
        JTextField txtAddTodo = new JTextField();
        JButton btnAdd = new JButton("Přidat");

        formPanel.add(lblAddTodo, BorderLayout.WEST);
        formPanel.add(txtAddTodo, BorderLayout.CENTER);
        formPanel.add(btnAdd, BorderLayout.EAST);

        controlPanel.add(formPanel, BorderLayout.NORTH);
        add(controlPanel);


    }

    private void intiContentPanel() {

    }
}
