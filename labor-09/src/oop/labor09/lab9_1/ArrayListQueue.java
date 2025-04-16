package oop.labor09.lab9_1;

import java.util.ArrayList;
import java.util.Queue;

public class ArrayListQueue implements IQueue {
    private final int capacity;
    private ArrayList<Object> items;

    public ArrayListQueue(int capacity) {
        this.capacity = capacity;
        items = new ArrayList<>(capacity);
    }

    @Override
    public boolean isEmpty() {
        return items.isEmpty();
    }

    @Override
    public boolean isFull() {
        return items.size() == capacity;
    }

    @Override
    public void enQueue(Object item) {
        if (isFull()) {
            System.out.println("Queue is full");
            return;
        }
        items.add(item);
    }

    @Override
    public Object deQueue() {
        if(isEmpty()){
            System.out.println("Queue is empty");
            return null;
        }
        return items.removeFirst();
    }

    @Override
    public void printQueue() {
        if(isEmpty()){
            System.out.println("Queue is empty");
            return;
        }
        for (Object item : items) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    @Override
    public boolean equals(Object o) {
        if(!(o instanceof ArrayListQueue)) {
            return false;
        }
        ArrayListQueue q = (ArrayListQueue)o;
        if(q.items.size() != this.items.size()) {
            return false;
        }
        /*for(int i=0;i<this.items.size();i++) {
            if(!this.items.get(i).equals(q.items.get(i))) {
                return false;
            }
        }*/
        return q.items.equals(this.items);
    }
}
