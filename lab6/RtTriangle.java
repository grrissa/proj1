package lab6;
import java.util.Scanner;
import java.lang.Math;

public class RtTriangle extends Shape {
    private double width = 0;
    private double height = 0;

    public Recrangle() {
        super("RtTriangle");
    }

    public RtTriangle(double w, double h) {
        super("RtTriangle");
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
        return (height * width) / 2;
    }

    public double computePerimeter() {
        return (height + width) + Math.sqrt((height**2 + width**2));
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