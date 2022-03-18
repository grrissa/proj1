/*****************************************************************************************
Brief Summary: Program that computes the area and perimeter of a Rectangle object.
Authors: Marissa Esteban and Alizea Hinz
Last Date Modified: 2/23/2022
*****************************************************************************************/
package lab6;
import java.util.Scanner;

public class Rectangle extends Shape {
    private double width = 0;
    private double height = 0;

    public Rectangle() {
    /* 
        Default rectangle constructor
    */
        super("Rectangle");
    }

    public Rectangle(double w, double h) {
    /* 
        Constructor for triangle object that defines the width and height
    */
        super("Rectangle");
        width = w;
        height = h;
    }

    public double getWidth() {
    /* 
        Method that returns the rectangle width
    */
        return width;
    }

    public double getHeight() {
    /* 
        Method that returns the rectangle height
    */
        return height;
    }

    public double computeArea() {
    /* 
        Method that returns the rectangle area
    */
        return height * width;
    }

    public double computePerimeter() {
    /* 
        Method that returns the rectangle perimeter
    */
        return 2 * (height + width);
    }

    public void readShapeData() {
    /* 
        Method that prompts the user to enter rectangle data
    */
        Scanner inRect = new Scanner(System.in);
        System.out.println("Enter the width of the Rectangle");
        width = inRect.nextDouble();
        System.out.println("Enter the height of the Rectangle");
        height = inRect.nextDouble();       
    }

    public String toString() {
    /* 
       Method that returns the rectangle data as a string
    */
        return super.toString() + ": width is " + width + ", height is " + height;
    }
}
