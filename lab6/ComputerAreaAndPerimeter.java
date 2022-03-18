package lab6;
import java.util.Scanner;

class ComputerAreaAndPerimeter {
    public static void main(String[] args) {
        String repeat_again;
        do {
            Shape myShape;
            double perimeter;
            double area;
            myShape = getShape(); // Ask for figure type 
            myShape.readShapeData(); // Read the shape data
            perimeter = myShape.computePerimeter(); // Compute perimeter 
            area = myShape.computeArea(); // Compute the area 
            displayResult(myShape, area, perimeter); // Display the result
            
            Scanner again = new Scanner(System.in);
            System.out.println("\nDo you want to run the program again (y for yes and n for no)?");
            
            repeat_again = again.next();
            repeat_again.toLowerCase(); 
            
            //ensures user inputs a valid character
            while ((repeat_again!="y") && (repeat_again!="n") ) {
                System.out.println("\nInvalid response: \nDo you want to run the program again (y for yes and n for no)?");
                repeat_again = again.next();
                repeat_again.toLowerCase();
                }
            
        } while (repeat_again!="n");
    
        System.exit(0); 
    }
    public static Shape getShape() {
        Scanner in = new Scanner(System.in);
        String type;
        //boolean valid = false;
        
        //do {
        System.out.println("Enter C for circle");
        System.out.println("Enter R for rectangle");
        System.out.println("Enter T for triangle");
        type = in.next();
        type.toLowerCase();
         //   if ((type == "c")||(type == "r")||(type == "t")) {
         //       valid = true;
        //    }
       // } while (valid == false);
        //in.close();
        if (type.equalsIgnoreCase("c")) {
            return new Circle();
        }
        else if (type.equalsIgnoreCase("r")) {
            return new Rectangle();
        }
        else if (type.equalsIgnoreCase("t")) {
            return new RtTriangle();
        }
        else {
            return null;
        }
        
    }
    private static void displayResult(Shape myShape, double area, double perim){
        System.out.println(myShape);
        System.out.printf("The area is %.2f%nThe perimeter is %.2f%n",
        area, perim);
    }
    public static void repeat_validation() {
        //asks the user whether they would like to run the program again

    }
}
