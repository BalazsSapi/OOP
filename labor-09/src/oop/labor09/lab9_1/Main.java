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

        /*IQueue q1 = new CircularQueue(5);
        IQueue q2 = new CircularQueue(10);
        for( int i=0; i<5; ++i){
            if(q1.isFull()){
                q1.deQueue();
            }
            if(q2.isFull()){
                q2.deQueue();
            }
            q1.enQueue(i);
            q2.enQueue(i);
        }
        q1.printQueue();
        q2.printQueue();

        System.out.println(q1.equals(q2));*/

        IQueue q3 = new CircularQueue(5);
        IQueue q4 = new CircularQueue(5);
        for( int i=1; i<6; ++i){
            q3.enQueue( i );
        }
        q4.enQueue(1 );
        q4.enQueue(1 );
        for( int i=1; i<4; ++i){
            q4.enQueue(i);
        }
        q4.deQueue();
        q4.deQueue();
        q4.enQueue( 4 );
        q4.enQueue( 5 );
        System.out.println( q3.equals( q4 ));
    }
}
