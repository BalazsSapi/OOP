package oop.labor10.lab10_2;

public class MyDate implements Comparable<MyDate> {
    private int year;
    private int month;
    private int day;

    public MyDate(int year, int month, int day) {
        if(DateUtil.isValidDate(year, month, day)) {
            this.year = year;
            this.month = month;
            this.day = day;
        }
        else {
            //System.out.println("Invalid date!");
        }
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public String toString() {
        return year + "." + month + "." + day;
    }

    @Override
    public int compareTo(MyDate o) {
        if(this.year != o.year) {
            return this.year - o.year;
        }
        if(this.month != o.month) {
            return this.month - o.month;
        }
        return this.day - o.day;
    }
}
