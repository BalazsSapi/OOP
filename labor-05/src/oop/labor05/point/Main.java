package oop.labor05.point;

import oop.labor05.ractangle.Ractangle;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Point> points = new ArrayList<Point>();
        System.out.println(points.size());
        for(int i = 0; i < 10; i++){
            points.add(new Point (i,i));
        }
        for(Point p : points){
            System.out.println(p);
        }
        for (Point p : points){
            System.out.printf("%.2f\n",p.distanceFromOrigin());
        }
    }
}
