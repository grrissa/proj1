/********************************************************************************
Brief Summary:
Authors: Marissa Esteban and Alizea Hinz
Last Date Modified:
*********************************************************************************/

import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class CaesarCipher {
    public static void main(String[]args) {
        char repeat_again = 'n';
        do {

            Scanner kv = new Scanner(System.in);
            System.out.println("Enter the individual key values (positive or negative integers, one after another in the same line with a blank between two values):");
            String key_values = kv.nextLine(); 

            StringTokenizer key = new StringTokenizer(key_values);
            int[] key_array = new int[key.countTokens()];
            int count = 0;
            while(key.hasMoreTokens() && (count<key.countTokens())){
                key_array[count] = Integer.parseInt(key.nextToken());
                count += 1;
            }
            System.out.println(key_array);
            // getting the line to encode
            Scanner te = new Scanner(System.in);
            System.out.println("\nEnter a string to be encoded:");
            String to_encode = te.nextLine();

            char[] to_encode_chars = to_encode.toCharArray();
            //ArrayList<Character> chars = new ArrayList<>();
            //for (char c : to_encode.toCharArray()) {
            //    chars.add(c);
            //}
            
            String encoded = "";
            for (int i=0; i< to_encode_chars.length; i++){
                char c = to_encode_chars[i];
                int n = (int)c + (int)(key_array[i%key_array.length]);
                encoded += (char)n;
            }

            System.out.println("\nThe encoded message:");
            System.out.println(encoded);

            System.out.println("\nThe decoded message:");

            //asks the user whether they would like to run the program again with response validation
            Scanner again = new Scanner(System.in);
            System.out.println("\nDo you want to run the program again (y for yes and n for no)?");
            repeat_again = again.next().charAt(0);

            
            while ((repeat_again!='y')&&(repeat_again!='Y')&&(repeat_again!='n')&&(repeat_again!='N')) {
                System.out.println("\nInvalid response: /nDo you want to run the program again (y for yes and n for no)?");
                repeat_again = again.next().charAt(0);
            }
            
        } while (repeat_again=='y' || repeat_again=='Y');
    }
}