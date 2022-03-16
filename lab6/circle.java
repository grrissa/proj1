package lab6;
import java.util.Scanner;
import java.lang.Math;

public class circle extends Shape {
    private double radius = 0;

    public Cicle() {
        super("Rectangle");
    }

    public circle(double r) {
        super("Circle");
        radius = r;
    }

    public double getRadius() {
        return radius;
    }

    public double computeArea() {
        return Math.PI * (radius**2);
    }

    public double computePerimeter() {
        return 2*Math.PI*radius;
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
