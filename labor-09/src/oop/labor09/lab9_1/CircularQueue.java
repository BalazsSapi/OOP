package oop.labor09.lab9_1;

import java.util.Queue;

public class CircularQueue implements IQueue {
    private final int capacity;
    private int front;
    private int rear;
    private Object[] items;

    public CircularQueue(int capacity) {
        this.capacity = capacity;
        items = new Object[capacity];
        front = -1;
        rear = -1;
    }

    @Override
    public boolean isEmpty() {
        return front == -1;
    }

    @Override
    public boolean isFull() {
        return rear  == (front+1)%capacity; //itt a hiba
    }

    @Override
    public void enQueue (Object item) {
        if (isFull()) {
            System.out.println("Queue is full");
            return;
        }
        if(isEmpty()){
            front = (front+1)%capacity;
        }
        items[(rear+1)%capacity] = item;
        rear = (rear+1)%capacity;
    }

    @Override
    public Object deQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return null;
        }
        Object o=items[front];
        if (front == rear) {
            front=-1;
        }
        else {
            front = (front + 1) % capacity;
        }
        return o;
    }

    @Override
    public void printQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        int copyFront=front;
        while (copyFront%capacity != rear) {
            System.out.print(items[(copyFront++)%capacity] + " ");
        }
    }
}
