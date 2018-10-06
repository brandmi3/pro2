package cz.uhk.fim.todolist.gui;

import cz.uhk.fim.todolist.model.TodoItem;
import cz.uhk.fim.todolist.model.TodoList;

import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TodoTableModel extends AbstractTableModel {

    private TodoList todoList;

    public void setTodoList(TodoList todoList) {
        this.todoList = todoList;
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return todoList.getItemCount();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        TodoItem item = todoList.getItem(rowIndex);
        switch (columnIndex) {
            case 0:
                return item.getTitle();
            case 1:
                return item.isCompleted();
            case 2:
                return item.getDate();
            default:
                return "Bad index";

        }

    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        TodoItem item = todoList.getItem(rowIndex);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        switch (columnIndex) {
            case 0:
                item.setTitle((String) aValue);
                break;
            case 1:
                item.setCompleted((Boolean) aValue);
                if ((Boolean) aValue) {
                    item.setDate(dateFormat.format(new Date()));
                } else {
                    item.setDate("");
                }
                setTodoList(todoList);
                break;
            default:
                break;
        }
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return "Název";
            case 1:
                return "Dokončeno";
            case 2:
                return "Datum dokončení";
            default:
                return "?";
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return String.class;
            case 1:
                return Boolean.class;
            case 2:
                return String.class;
            default:
                return Object.class;
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return !(columnIndex == 3);
    }
}
