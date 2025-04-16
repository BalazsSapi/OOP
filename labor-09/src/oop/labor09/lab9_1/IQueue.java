package oop.labor09.lab9_1;

public interface IQueue {
    public void enQueue(Object o);
    public Object deQueue();
    public void printQueue();
    public boolean isEmpty();
    public boolean isFull();
}
