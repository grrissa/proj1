/*****************************************************************************************
Brief Summary: Program that prompts user for shape and computes the area and perimeter.
Authors: Marissa Esteban and Alizea Hinz
Last Date Modified: 3/17/2022
*****************************************************************************************/
package lab6;
import java.util.Scanner;

class ComputeAreaAndPerimeter {
    public static void main(String[] args) {
        char repeat_again = 'n';
        do {
            Shape myShape;
            double perimeter;
            double area;
            myShape = getShape(); // Ask for figure type 
            myShape.readShapeData(); // Read the shape data
            perimeter = myShape.computePerimeter(); // Compute perimeter 
            area = myShape.computeArea(); // Compute the area 
            displayResult(myShape, area, perimeter); // Display the result
            
            //asks the user whether they would like to run the program again
            Scanner again = new Scanner(System.in);
            System.out.println("\nDo you want to run the program again (y for yes and n for no)?");
            repeat_again = again.next().charAt(0);

            //ensures user inputs a valid character
            while ((repeat_again!='y') && (repeat_again!='n') && (repeat_again!='Y') && (repeat_again!='N') ) {
                System.out.println("\nInvalid response: \nDo you want to run the program again (y for yes and n for no)?");
                repeat_again = again.next().charAt(0);
            }
            
        } while ((repeat_again!='n') && (repeat_again!='N'));
    
        System.exit(0); 
    }
    public static Shape getShape() {
        /* 
        Method that prompts the user for type and returns a new shape object
        */
        Scanner in = new Scanner(System.in);
        String type;
       
        System.out.println("Enter C for circle");
        System.out.println("Enter R for rectangle");
        System.out.println("Enter T for triangle");
        type = in.next();
        type.toLowerCase();
         
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
         /* 
        Method that displays the shape type and the area and perimeter of shape
        */
        System.out.println(myShape);
        System.out.printf("The area is %.2f%nThe perimeter is %.2f%n",
        area, perim);
    }
}