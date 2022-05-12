package proj5;
/*************************************************************************************
Brief Summary: Program creates the linked hash map that will be used for compress
Last Date Modified: 5/11/2022
*************************************************************************************/

import java.util.LinkedList;

public class HashTableChain<k,v> implements KWHashMap<k,v>{

    public static class Entry<k,v> {

        //initializes instance variables
        private final k key;
        private v value;

        public Entry(k key, v value) {
        /*
        A constructor that sets the key and value instance variables to the set paramters
        */
            this.key = key;
            this.value = value;
        }

        public k getKey() {
        /*
        accesor method that returns the key
        */
            return key;
        }

        public v getValue() {
        /*
        accesor method that returns the value
        */
            return value;
        }

        public v setValue(v val) {
        /*
        modifier method that changes the value
        */
            v oldVal = value;
            value = val;
            return oldVal;
        }

        public String toString() {
        /*
        Displays a string representation of the entry object
        */
            return key.toString() + " = "+ value.toString();
        }
    }

    
    private LinkedList<Entry<k,v>>[] table; // array of linked lists
    private int numKeys;
    private static final int CAPACITY = 149;
    private static int capacity_used;
    private static final double LOAD_THRESHOLD = 0.75; 
    private int num_rehash = 0;


    public HashTableChain() {
    /*
        default constructor method that creates a new hash table to default size
    */
        table = new LinkedList[CAPACITY];
        capacity_used = CAPACITY;
        numKeys = 0;
    }

    public HashTableChain(int cap) {
    /*
        constructor method that creates a new hash table to a set size
    */
        table = new LinkedList[cap];
        capacity_used = cap;
        numKeys = 0;
    }

    public boolean isEmpty(){
    /*
        method that returns whether the hash table is empty or not
    */
        return numKeys==0;
    }

    public int size(){
    /*
        method that returns the amount of items in the hash table
    */
        return numKeys;
    }

    public int number_rehash(){
    /*
        method that returns the amount of times that the hash table has rehashed
    */
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
    /*
        method that returns whether the number is a prime number or not
    */

        if (n <= 1) return false;
        if (n <= 3) return true;
         
        if (n % 2 == 0 || n % 3 == 0) return false;
         
        for (int i = 5; i * i <= n; i = i + 6)
            if (n % i == 0 || n % (i + 2) == 0)
            return false;
         
        return true;
    }
     
    public static int nextPrime(int N) {
    /*
        method that returns the next prime integer
    */
    
        if (N <= 1)
            return 2;
     
        int prime = N;
        boolean found = false;

        while (!found){
            prime++;
     
            if (isPrime(prime))
                found = true;
        }
        return prime;
    }
     
    public void rehash() {
    /*
        method that creates a new array of linked lists that is double the size of the old one.  
        Will create a new hashcode for each entry in the old array and place it into the new one.
    */
        num_rehash++;
        int next_prime = nextPrime(capacity_used*2);
        LinkedList<Entry<k,v>>[] new_table = new LinkedList[next_prime];

        //will go through every index in table and then every entry in linked list to add entry into new table
        for (int i = 0; i < table.length; i++){
            //for(Entry<k,v> nextItem:table[i]){
            
            if (table[i] != null) {  
                for (int x = 0; x < table[i].size(); x++) {
                    
                    Entry<k,v> nextItem = table[i].get(x);
                    int index = (nextItem.getKey().hashCode()) % new_table.length;
                    if (index < 0){
                        index += new_table.length;
                    }
                    if (new_table[index] == null){
                        new_table[index] = new LinkedList<>();
                    }
                    new_table[index].addLast(new Entry<>(nextItem.getKey(), nextItem.getValue()));
                }
            }
        }

        table = new_table;
        capacity_used = next_prime;


    }
        

}
