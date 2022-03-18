/*****************************************************************************************
Brief Summary: Program that computes the area and perimeter of a RtTriangle object.
Authors: Marissa Esteban and Alizea Hinz
Last Date Modified: 3/17/2022
*****************************************************************************************/
package lab6;
import java.util.Scanner;
import java.lang.Math;

public class RtTriangle extends Shape {
    private double width = 0;
    private double height = 0;

    public RtTriangle() {
    /* 
        Default constructor for triangle object
    */
        super("RtTriangle");
    }

    public RtTriangle(double w, double h) {
    /* 
        Constructor for triangle object that defines the width and height
    */
        super("RtTriangle");
        width = w;
        height = h;
    }

    public double getWidth() {
    /* 
        Method that returns the width
    */
        return width;
    }

    public double getHeight() {
    /* 
        Method that returns the height
    */
        return height;
    }

    public double computeArea() {
    /* 
        Method that returns the area
    */
        return (height * width) / 2;
    }

    public double computePerimeter() {
    /* 
        Method that returns the perimeter
    */
        return (height + width) + Math.sqrt((height*height + width*width));
    }

    public void readShapeData() {
    /* 
       Method that prompts the user to enter triangle data
    */
        Scanner inTri = new Scanner(System.in);
        System.out.println("Enter the width of the Triangle");
        width = inTri.nextDouble();
        System.out.println("Enter the height of the Triangle");
        height = inTri.nextDouble();      
    }

    public String toString() {
    /* 
       Method that returns the triangle data as a string
    */
        return super.toString() + ": width is " + width + ", height is " + height;
    }
}