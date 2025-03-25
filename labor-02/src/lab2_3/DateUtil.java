package lab2_3;

public class DateUtil {
    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0 || year % 400 == 0);
    }

    public static boolean isValidDate(int year, int month, int day) {
        return (year > 0 && (
                ((month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) && day <= 31 && day > 0) ||
                ((month == 4 || month == 6 || month == 9 || month == 11) && day <= 30 && day > 0) ||
                (month == 2 && isLeapYear(year) && day <= 29 && day > 0) ||
                (month == 2 && !isLeapYear(year) && day <= 28 && day > 0)
                ));
    }
}
