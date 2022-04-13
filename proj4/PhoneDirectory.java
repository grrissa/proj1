package proj4;
import java.util.*;

public class PhoneDirectory {

    
    List<DirectoryEntry> theDirectory;

    public PhoneDirectory() {
        this.theDirectory = new ArrayList<>();
    }
    

    // NEED TO MAKE CONSTRUCTOR AND ACCESSOR METHODS
    public String toString() {
        /* 
           Method that displays ...
       */
        String name = "";
        for (DirectoryEntry directory : theDirectory) {
            name += directory.name + ": " + directory.number +"\n";
        }   
        return name; //ADD SOMETHING
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
<<<<<<< HEAD
            if ((theDirectory.get(index).name == name) && (index < theDirectory.size()))  {
=======
            if ((this.theDirectory.get(index).name == name) && (index < this.theDirectory.length))  {
>>>>>>> 638aabf34b1e1d41c9088dd0532caa94f72d8e47
                is_there = true;
                old = this.theDirectory.get(index).number;
                DirectoryEntry new_entry = new DirectoryEntry(name, number);
                this.theDirectory.set(index, new_entry);
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
<<<<<<< HEAD
            if ((theDirectory.get(index).name == name) && (index < theDirectory.size())) {
                found = theDirectory.get(index);
=======
            if ((this.theDirectory.get(index).name == name) && (index < this.theDirectory.length)) {
                found = this.theDirectory.get(index);
>>>>>>> 638aabf34b1e1d41c9088dd0532caa94f72d8e47
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
<<<<<<< HEAD
        while ((is_there == false) && (index < theDirectory.size())) {
            if (theDirectory.get(index).name == name) {
=======
        while ((is_there == false) && (index < this.theDirectory.length)) {
            if (this.theDirectory.get(index).name == name) {
>>>>>>> 638aabf34b1e1d41c9088dd0532caa94f72d8e47
                found = theDirectory.get(index);
                this.theDirectory.remove(index);
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
        
        for (DirectoryEntry directory : this.theDirectory) {
            System.out.println(directory.name + ": " + directory.number);
        }    
    }

    
    
    

}


