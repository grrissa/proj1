package lab6;

public abstract class Shape {
    private String shapeName = "";

    public Shape(String name) {
        shapeName = name;
    }
    public String getShapeName() {
        return shapeName;
    }
    public String toString() {
        return "Shape is a " + shapeName;
    }

    //abstract methods
    public abstract double computeArea();
    public abstract double computePerimeter();
    public abstract void readShapeData();
}
