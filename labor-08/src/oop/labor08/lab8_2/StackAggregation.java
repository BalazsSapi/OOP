package oop.labor08.lab8_2;

import java.util.ArrayList;

public class StackAggregation {
    private final int capacity;
    private final ArrayList<Object> items;

    public StackAggregation(int capacity) {
        this.capacity=capacity;
        items=new ArrayList<>(capacity);
    }

    public boolean isFull(){
        return items.size()==capacity;
    }

    public void push(Object object){
        if(isFull()){
            System.out.println("The stack is full!");
            return;
        }
        items.add(object);
    }

    public boolean isEmpty(){
        return items.isEmpty();
    }

    public Object top(){
        if(isEmpty()){
            System.out.println("The stack is empty!");
            return null;
        }
        return items.getLast();
    }

    public void pop(){
        if(isEmpty()){
            System.out.println("The stack is empty!");
            return;
        }
        items.removeLast();
    }
}
