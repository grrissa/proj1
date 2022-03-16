package lab6;
import java.util.Scanner;
import java.lang.Math;

public class Circle extends Shape {
    private double radius = 0;

    public Circle() {
        super("Circle");
    }

    public Circle(double r) {
        super("Circle");
        radius = r;
    }

    public double getRadius() {
        return radius;
    }

    public double computeArea() {
        return Math.PI * (radius*radius);
    }

    public double computePerimeter() {
        return 2*Math.PI*radius;
    }

    public void readShapeData() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the radius of the Circle");
        radius = in.nextDouble();     
    }

    public String toString() {
        return super.toString() + ": radius is" + radius;
    }
}
