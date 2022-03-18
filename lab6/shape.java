/*****************************************************************************************
Brief Summary: Program that defines a shape object and creates abstract methods to
compute the shape object's area and perimeter.
Authors: Marissa Esteban and Alizea Hinz
Last Date Modified: 3/17/2022
*****************************************************************************************/
package lab6;

public abstract class Shape {
    private String shapeName = "";

    public Shape(String name) {
    /* 
        Constructs a shape obejct
    */
        shapeName = name;
    }
    public String getShapeName() {
    /* 
        Method that returns the shape name
    */
        return shapeName;
    }
    public String toString() {
    /* 
        Method that returns a string of the shape name
    */
        return "Shape is a " + shapeName;
    }

    //abstract methods
    public abstract double computeArea();
    public abstract double computePerimeter();
    public abstract void readShapeData();
}
