package cz.uhk.fim.todolist.app;

import cz.uhk.fim.todolist.gui.Frame;

import javax.swing.*;

public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

                new Frame().setVisible(true);

            }
        });
    }
}
