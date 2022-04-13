package proj4;
import java.util.*;

public class PhoneDirectory {

    
    List<DirectoryEntry> theDirectory = new ArrayList<>();
    

    // NEED TO MAKE CONSTRUCTOR AND ACCESSOR METHODS
    public String toString() {
        /* 
           Method that displays ...
       */
           return "something"; //ADD SOMETHING
       }

    public String addOrChangeEntry(String name, String number){
    /*
    Will add an entry to the directory or change and existing entry;
    will return the old number or null if it is a new entry    
    */

        boolean is_there = false;
        int index = 0;
        String old = "";
        while (is_there == false) {
            if ((theDirectory.get(index).name == name) && (index < theDirectory.length))  {
                is_there = true;
                old = theDirectory.get(index).number;
                DirectoryEntry new_entry = new DirectoryEntry(name, number);
                theDirectory.set(index, new_entry);
            }
            index +=1;
        }

        if (is_there == false) {
            DirectoryEntry new_entry = new DirectoryEntry(name, number);
            theDirectory.add(new_entry);
            return null;
        }

        return old; 
    }

    public DirectoryEntry searchEntry(String name){
    /*
    search the entry referenced by name; return the 
    entry searched or null if there is no entry for name
    */
        boolean is_there = false;
        int index = 0;
        DirectoryEntry found = null;
        while (is_there == false) {
            if ((theDirectory.get(index).name == name) && (index < theDirectory.length)) {
                found = theDirectory.get(index);
            }
            index +=1;
        }

        if (is_there == false){
            return null;
        }

        return found;
    }

    public DirectoryEntry removeEntry(String name) {
    /*
    Will remove the entry referenced by name and return the entry
    removed of null if there is no entry for that name
    */
        boolean is_there = false;
        int index = 0;
        DirectoryEntry found = null;
        while ((is_there == false) && (index < theDirectory.length)) {
            if (theDirectory.get(index).name == name) {
                found = theDirectory.get(index);
                theDirectory.remove(index);
            }
            index +=1;
        }

        if (is_there == false){
            return null;
        }

        return found;

    }

    public void displayAllEntries() {
    /*
    Will display all entries in a nice and readable format
    */
        
        for (DirectoryEntry directory : theDirectory) {
            System.out.println(directory.name + ": " + directory.number);
        }    
    }

    
    
    

}


