package cz.uhk.fim.todolist.gui;

import cz.uhk.fim.todolist.model.TodoList;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.*;

public class Frame extends JFrame {

    private JTable table;
    private TodoList todoList;
    private TodoTableModel model;

    public Frame() {
        intit();
    }

    private void intit() {
        setTitle("Todo List App");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(640, 480);
        setLocationRelativeTo(null);

        todoList = new TodoList();
        model = new TodoTableModel();
        model.setTodoList(todoList);

        initControlPanel();
        intiContentPanel();
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
        JPanel contentPanel = new JPanel(new BorderLayout());
        table = new JTable();
        table.setModel(model);
        contentPanel.add(new JScrollPane(table));
        add(contentPanel,BorderLayout.CENTER);

    }
}
