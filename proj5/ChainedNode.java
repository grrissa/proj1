package proj5;

public class ChainedNode<Key,Value> {
    Key key;
    Value value;

    final int hashCode;
 

    ChainedNode<Key, Value> next;     // Reference to next node
 
    // Constructor
    public ChainedNode(Key key, Value value, int hashCode)
    {
        this.key = key;
        this.value = value;
        this.hashCode = hashCode;
    }

}
