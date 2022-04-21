package proj4;
/*************************************************************************************
Brief Summary: Program that defines a DirectoryEntry object that contains two instance 
variables: name and number
Last Date Modified: 4/20/2022
*************************************************************************************/

public class DirectoryEntry {
    String name = null;
    String number = null;
    

    public DirectoryEntry(String n, String num){
    /*
    Constructor method that creates a new instance of the DirectoryEntry object 
    with two instance variables
    */
        name = n;
        number = num;
    }
}
