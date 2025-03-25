package lab2_2;

public class Rectangle {
    private double width, length;
    public Rectangle(double plenght, double pwidth) {
        if (pwidth <= 0 || plenght <= 0) {
            System.out.println("Invalid dimensions");
        }
        else{
            width = pwidth;
            length = plenght;
        }
    }
    public double getWidth() {
        return width;
    }
    public double getLength() {
        return length;
    }
    public double area() {
        return width * length;
    }
    public double perimeter() {
        return 2 * width + 2 * length;
    }
}
