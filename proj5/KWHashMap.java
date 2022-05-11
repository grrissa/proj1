package proj5;
/*************************************************************************************
Brief Summary: program creates the KWHashMap interface
Last Date Modified: 5/11/2022
*************************************************************************************/

public interface KWHashMap<k,v> {
    public v get(Object key);
    public v put( k key, v value);
    public boolean isEmpty();
    public v remove(Object key);
    public int size();

}
