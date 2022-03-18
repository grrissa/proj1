/*****************************************************************************************
Brief Summary: Program that computes the area and perimeter of a Circle object.
Authors: Marissa Esteban and Alizea Hinz
Last Date Modified: 2/23/2022
*****************************************************************************************/
package lab6;
import java.util.Scanner;
import java.lang.Math;

public class Circle extends Shape {
    private double radius = 0;

    public Circle() {
    /* 
        Default constructor for circle object
    */
        super("Circle");
    }

    public Circle(double r) {
    /* 
        Constructor for circle object that defines the radius
    */
        super("Circle");
        radius = r;
    }

    public double getRadius() {
    /* 
        returns radius of the circle object
    */
        return radius;
    }

    public double computeArea() {
     /* 
        returns the area of the circle
    */
        return Math.PI * (radius*radius);
    }

    public double computePerimeter() {
     /* 
        returns the circumference of the circle
    */
        return 2*Math.PI*radius;
    }

    public void readShapeData() {
     /* 
        Method that prompts the user to enter circle data
    */
        Scanner inCir = new Scanner(System.in);
        System.out.println("Enter the radius of the Circle");
        
        radius = inCir.nextDouble();   

        inCir.close();
    }

    public String toString() {
     /* 
        Method that displays the shape type and the area and perimeter of circle
    */
        return super.toString() + ": radius is " + radius;
    }
}
