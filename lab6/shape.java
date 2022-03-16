package lab6;

public abstract class shape {
    private String shapeName = "";

    public shape(String name) {
        shapeName = name;
    }
    public String getShapeName() {
        return shapeName;}
    public String toString() {
        return "Shape is a " +shapeName;
    }
}
