package oop.labor09.lab9_1;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        /*IQueue q1 = new ArrayListQueue(5);
        IQueue q2 = new ArrayListQueue(10);
        for( int i=0; i<5; ++i){
            q1.enQueue( i );
            q2.enQueue( i+1);
        }
        System.out.println( q1.equals( q2 ));*/

        IQueue q1 = new CircularQueue(5);
        IQueue q2 = new CircularQueue(10);
        for( int i=0; i<10; ++i){
            q1.enQueue( i );
            q2.enQueue( i+1);
            if(q1.isFull()){
                q1.deQueue();
            }
            if(q2.isFull()){
                q2.deQueue();
            }
        }
        q1.printQueue();
    }
}
