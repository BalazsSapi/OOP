package oop.labor08.lab8_2;

import java.util.ArrayList;

public class StackInheritance extends ArrayList<Object> {
    private final int capacity;
    public StackInheritance(int capacity) {
        super(capacity);
        this.capacity = capacity;
    }

    public boolean isFull() {
        return size() == capacity;
    }

    public boolean isEmpty() {
        return super.isEmpty();
    }

    public void push(Object item) {
        if(isFull()) {
            System.out.println("The stack is full!");
            return;
        }
        add(item);
    }

    public void pop() {
        if(isEmpty()) {
            System.out.println("The stack is empty!");
            return;
        }
        removeLast();
    }

    public Object top() {
        if(isEmpty()) {
            System.out.println("The stack is empty!");
            return null;
        }
        return getLast();
    }
}
