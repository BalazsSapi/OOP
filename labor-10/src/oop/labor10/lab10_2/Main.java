package oop.labor10.lab10_2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        List<MyDate> dates = new ArrayList<>();
        Random rand = new Random();
        int i=0;
        while(dates.size() !=10) {
            int year = 2025;
            int month = rand.nextInt(1, 13);
            int day = rand.nextInt(1, 32);
            if (DateUtil.isValidDate(year, month, day)) {
                dates.add(new MyDate(year, month, day));
            }
            i++;
        }
        System.out.println("Original order:");
        for(MyDate date : dates) {
            System.out.println(date);
        }
        System.out.println();

        System.out.println("Sorted order:");
        Collections.sort(dates);
        for(MyDate date : dates) {
            System.out.println(date);
        }
        System.out.println();

        System.out.println("Reverse order:");
        Collections.sort(dates,((o1, o2) -> {
            return o2.compareTo(o1);
        }));
        for(MyDate date : dates) {
            System.out.println(date);
        }
    }
}
