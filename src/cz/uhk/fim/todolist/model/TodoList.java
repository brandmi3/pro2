package cz.uhk.fim.todolist.model;

import java.util.ArrayList;
import java.util.List;

public class TodoList {

    private List<TodoItem> itemList = new ArrayList<>();

    public void addItem(TodoItem todo) {
        itemList.add(todo);
    }

    public TodoItem getItem(int index) {
        return itemList.get(index);
    }

    public void setStateToCompleted(int index) {
        TodoItem item = itemList.get(index);
        item.setCompleted(!item.isCompleted());
    }

    public int getItemCount() {
        return itemList.size();
    }
}
