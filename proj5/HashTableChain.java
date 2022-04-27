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
    private static final int CAPACITY; //tbd
    private static final double LOAD_THRESHOLD; //tbd
    //may need more

    public HashTableChain() {// CONSTRUCTOR
        table = new LinkedList[CAPACITY];
        numKeys = 0;
    }

    public HashTableChain(int cap) {
        table = new LinkedList[cap];
        numKeys = 0;
    }

    public v get(Object key){
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

        if (numKeys > (LOAD_THRESHOLD * table.length)) rehash();
        return null;
    }

    public v remove(Object key){
        int index = key.hashCode() % table.length;
        if (index < 0){
            index += table.length;
        }
        if (table[index] == null){
           return null;
        }
        for(Entry<k,v> nextItem:table[index]){
            if (nextItem.getKey().equals(key)){
                table[index].remove(); //FIXME
                numKeys--; //decrement 
                if(table[index].isEmpty()){
                    table[index] = null;
                }
                return nextItem.getValue();
            }
        }

        return null; // if key is not in the table
    }

    public void rehash() {

    }
        

}
