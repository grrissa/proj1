/********************************************************************************
Brief Summary:
Authors: Marissa Esteban and Alizea Hinz
Last Date Modified:
*********************************************************************************/

// HEYYYYYYY
import java.util.Scanner;
public class CaesarCipher {
    public static void main(String[]args) {
        char repeat_again = 'n';
        do {
            Scanner kv = new Scanner(System.in);
            System.out.println("Enter the individual key values (positive or negative integers, 
            one after another in the same line with a blank between two values):");
            String key_values = kv.nextLine().split(); // idk if this is the best way to do this but just for now ig
            // some how get values into an array?? best way to do this??

            // getting the line to encode
            Scanner te = new Scanner(System.in);
            System.out.println("\nEnter a string to be encoded:");
            String to_encode = te.nextLine();

            // propbably implement cipher here

            System.out.println("\nThe encoded message:");
            System.out.println("\nThe decoded message:");

            //asks the user whether they would like to run the program again with response validation
            Scanner again = new Scanner(System.in);
            System.out.println("\nDo you want to run the program again (y for yes and n for no)?");
            repeat_again = again.next().charAt(0);

            while ((repeat_again!='y')||(repeat_again!='Y')||(repeat_again!='n')||(repeat_again!='N')){
                System.out.println("\nInvalid response: /nDo you want to run the program again (y for yes and n for no)?");
                repeat_again = again.next().charAt(0);
            }
        } while (repeat_again=='y' || repeat_again=='Y');
    }
}