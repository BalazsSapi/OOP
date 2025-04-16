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
        return (rear+1)%capacity  == front;
    }

    @Override
    public void enQueue (Object item) {
        if (isFull()) {
            System.out.println("Queue is full");
            return;
        }
        if (isEmpty()) {
            front = 0;
            rear = 0;
        }
        else {
            rear = (rear + 1) % capacity;
        }
        items[rear] = item;

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
            rear=-1;
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
        int i = front;
        while (true) {
            System.out.print(items[i] + " ");
            if (i == rear) break;
            i = (i + 1) % capacity;
        }
        System.out.println();
    }

    @Override
    public boolean equals (Object o) {
        if (!(o instanceof CircularQueue)) {
            return false;
        }
        CircularQueue q = (CircularQueue) o;
        int i = front;
        int j = q.front;
        if (isEmpty()!=q.isEmpty()) {
            return false;
        }

        while (true) {
            if() {

            }
        }
    }
}
