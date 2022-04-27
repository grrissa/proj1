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
        if 
    }

    public v put(k key, v value){

    }

    public v remove(Object key){

    }

}
