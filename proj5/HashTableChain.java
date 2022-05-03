package proj5;

import java.util.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class HashTableChain<k,v> implements KWHashMap<k,v>{

    public static class Entry<k,v> {
        private final k key; //final can't be changed
        private v value;

        public Entry(k key, v value) {
            this.key = key;
            this.value = value;
        }

        public k getKey() {
            return key;
        }

        public v getValue() {
            return value;
        }

        public v setValue(v val) {
            v oldVal = value;
            value = val;
            return oldVal;
        }

        public String toString() {
            return key.toString() + " = "+ value.toString();
        }
    }

    private LinkedList<Entry<k,v>>[] table; // array of linked lists
    private int numKeys;
    private static int CAPACITY; // i am making this a non final bc in rehash we have to change it again
    private static final double LOAD_THRESHOLD = 0.75; //tbd? i found num this on the internet
    private int num_rehash = 0;
    //may need more

    public HashTableChain() {// CONSTRUCTOR
        table = new LinkedList[CAPACITY];
        numKeys = 0;
    }

    public HashTableChain(int cap) {
        table = new LinkedList[cap];
        numKeys = 0;
    }

    public boolean isEmpty(){
        return numKeys==0;
    }

    public int size(){
        return numKeys;
    }

    public int number_rehash(){
        return num_rehash;
    }

    public v get(Object key){
        /*
        Uses the object key to search and return for the value that is associated with the key
        */
        int index = key.hashCode() % table.length;
        if (index < 0){
            index += table.length;
        }
        if (table[index] == null){
            return null; //means key is not in table
        }
        for(Entry<k,v> nextItem:table[index]){
            if (nextItem.getKey().equals(key)){
                return nextItem.getValue();
            }
        }
        return null;
    }

    public v put(k key, v value){
        /*
        (key, val) pair is inserted into the table and numKeys incremented. If key
        is already in table, value changed to value in param.
        */

        int index = key.hashCode() % table.length;
        if (index < 0){
            index += table.length;
        }
        if (table[index] == null){
           table[index] = new LinkedList<>();
        }
        for(Entry<k,v> nextItem:table[index]){
            if (nextItem.getKey().equals(key)){
                v oldVal = nextItem.getValue(); 
                nextItem.setValue(value); 
                return oldVal;
            }
        }

        table[index].addFirst(new Entry<>(key, value));
        numKeys++;
        if (numKeys > (LOAD_THRESHOLD * table.length)) 
            rehash();
        return null;
    }

    public v remove(Object key){
        /*
        Will remove (key, val) entry pair from the table
        */
        int index = key.hashCode() % table.length;
        if (index < 0){
            index += table.length;
        }
        if (table[index] == null){
           return null;
        }

        int counter = 0; // to specify what item in linked list to remove
        for(Entry<k,v> nextItem:table[index]){
            if (nextItem.getKey().equals(key)){
                table[index].remove(counter); 
                numKeys--; //decrement 

                if(table[index].isEmpty()){
                    table[index] = null;
                }
                return nextItem.getValue();
            }
            counter++;
        }

        return null; // if key is not in the table
    }

    public static boolean isPrime(int n){

        if (n <= 1) return false;
        if (n <= 3) return true;
         
        if (n % 2 == 0 || n % 3 == 0) return false;
         
        for (int i = 5; i * i <= n; i = i + 6)
            if (n % i == 0 || n % (i + 2) == 0)
            return false;
         
        return true;
    }
     
    public static int nextPrime(int N) {
    
        if (N <= 1)
            return 2;
     
        int prime = N;
        boolean found = false;

        while (!found){
            prime++;
     
            if (isPrime(prime))
                found = true;
        }
        System.out.print(prime);
        return prime;
    }
     
    public void rehash() {
        num_rehash++;
        int next_prime = nextPrime(CAPACITY*2);
        LinkedList<Entry<k,v>>[] new_table = new LinkedList[next_prime];

        //will go through every index in table and then every entry in linked list to add entry into new table
        for (int i = 0; i < table.length; i++){
            //for(Entry<k,v> nextItem:table[i]){
            for (int x = 0; x < table[i].size(); x++) {
                
                Entry<k,v> nextItem = table[i].get(x);
                int index = (nextItem.getKey().hashCode()) % new_table.length;
                if (index < 0){
                    index += new_table.length;
                }
                if (new_table[index] == null){
                    new_table[index] = new LinkedList<>();
                }
                new_table[index].addFirst(new Entry<>(nextItem.getKey(), nextItem.getValue()));
            }
        }

        table = new_table;
        new_table = null;
        CAPACITY = next_prime;


    }
        

}
