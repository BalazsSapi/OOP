package oop.labor07_parcialis;

public class MyDate {
    private final int year;
    private final int month;
    private final int day;

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
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

    @Override
    public String toString() {
        return "MyDate{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }

    public boolean equals(MyDate other){
    if(day!=other.day || month!=other.month || year!=other.year){
        return false;
    }
    return true;
    }

    public boolean isAfter(MyDate other){
        if(year>other.year){
            return true;
        }
        else{
            if(year< other.year){
                return false;
            }
            else{
                if(month>other.month){
                    return true;
                }
                else {
                    if(month<other.month){
                        return false;
                    }
                    else{
                        if(day> other.day){
                            return true;
                        }
                        else {
                            return false;
                        }
                    }
                }
            }
        }
    }
}
