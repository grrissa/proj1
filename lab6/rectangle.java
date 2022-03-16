package lab6;
import java.util.Scanner;
import java.lang.Math;

public class Rectangle extends Shape {
    private double width = 0;
    private double height = 0;

    public Rectangle() {
        super("Rectangle");
    }

    public Rectangle(double w, double h) {
        super("Rectangle");
        width = w;
        height = h;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public double computeArea() {
        return height * width;
    }

    public double computePerimeter() {
        return 2 * (height + width);
    }

    public void readShapeData() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the width of the Rectangle");
        width = in.nextDouble();
        System.out.println("Enter the height of the Rectangle");
        height = in.nextDouble();        
    }

    public String toString() {
        return super.toString() + ": width is" + width + ", height is " + height;
    }
}
