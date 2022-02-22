/********************************************************************************
Brief Summary:
Authors: Marissa Esteban and Alizea Hinz
Last Date Modified:
*********************************************************************************/

import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.ArrayList;

class CaesarCipher {
    public static void main(String[]args) {
        char repeat_again = 'n';

        do {
            Scanner kv = new Scanner(System.in);
            System.out.println("\nEnter the individual key values (positive or negative integers, one");
            System.out.println("after another in the same line with a blank between two values):");
            String key_values = kv.nextLine(); 

            int[] keys = create_key(key_values);

            // getting the line to encode
            Scanner te = new Scanner(System.in);
            System.out.println("\nEnter a string to be encoded:");
            String to_encode = te.nextLine();

            String encoded_string = encode(to_encode, keys);
            System.out.println("\nThe encoded message:");
            System.out.println(encoded_string);

            String decoded_string = decode(encoded_string, keys);
            System.out.println("\nThe decoded message:");
            System.out.println(decoded_string);

            //asks the user whether they would like to run the program again with response validation
            Scanner again = new Scanner(System.in);
            System.out.println("\nDo you want to run the program again (y for yes and n for no)?");
            repeat_again = again.next().charAt(0);

            
            while ((repeat_again!='y') && (repeat_again!='n') && (repeat_again!='Y') && (repeat_again!='N') ) {
                System.out.println("\nInvalid response: /nDo you want to run the program again (y for yes and n for no)?");
                repeat_again = again.next().charAt(0);
            }
            
        } while ((repeat_again!='y') && (repeat_again!='Y'));
    }

    public static int[] create_key(String key_values) {
        String[] string_key_array = key_values.split("\\s");
        int[] key_array = new int[string_key_array.length];
        for (int i=0; i<string_key_array.length; i++){
            key_array[i] = Integer.parseInt(string_key_array[i]);
        }
    
        for (int i = 0; i<key_array.length; i++) {
    
            System.out.println(key_array[i]);
        }
        return key_array;
    }


    public static String encode(String to_encode, int[] key_array) {
        char[] to_encode_chars = to_encode.toCharArray();
        
        String encoded = "";
        for (int i=0; i<= to_encode_chars.length - 1; i++){
            char c = to_encode_chars[i];
            int key = (int)(key_array[i%key_array.length]);
            int n = (int)c + key;
            int dif = 0;
            if (n > 126) {
                dif = n - 126;
                n = 31 + dif;
            }
            else if (n < 32) {
                dif = 32-n;
                n = 127-dif;
            }
            encoded += (char)n;
        }
        return encoded;
        
    }

    public static String decode(String encoded_string, int[] key_array) {
        char[] to_decode_chars = encoded_string.toCharArray();

        String decoded = "";
        for (int i=0; i<= to_decode_chars.length - 1; i++){
            char c = to_decode_chars[i];
            int n = (int)c - (int)(key_array[i%key_array.length]);
            int dif = 0;
            if (n > 126) {
                dif = n - 126;
                n = 31 + dif;
            }
            else if (n < 32) {
                dif = 32-n;
                n = 127-dif;
            }
            decoded += (char)n;
        }
        return decoded;
    }
}