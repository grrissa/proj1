package proj5;

import java.util.*;

public class HashMapChained<k,v> {

    LinkedList<ChainedNode<k,v>>[] table;
    int num_keys;
    int total_buckets; // capacity of table

    public HashMapChained() {
        table = new LinkedList[total_buckets];
    }

}
