package lab2_2;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Rectangle[] rectangles;
        rectangles = new Rectangle[10];
        Random rand = new Random();
        for (int i = 0; i < rectangles.length; i++) {
            double length = 1 + rand.nextInt(10);
            double width = 1 + rand.nextInt(10);
            rectangles[i] = new Rectangle(length, width);
        }
        for (int i = 0; i < rectangles.length; i++) {
            System.out.println(i + ". rectangle: " +
                    "\n\t\t" + "length: " + rectangles[i].getLength() +
                    "\n\t\twidth: " + rectangles[i].getWidth() +
                    "\n\t\tperimeter: " + rectangles[i].perimeter() +
                    "\n\t\tarea: " + rectangles[i].area() + "\n\n\n");
        }
        double sumArea=0;
        for (int i = 0; i < rectangles.length; i++) {
            sumArea += rectangles[i].area();
        }
        System.out.println("Sum area: " + sumArea);
    }
}
