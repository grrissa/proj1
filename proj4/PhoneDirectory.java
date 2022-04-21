/*************************************************************************************
Brief Summary: Program that defines a PhoneDirectory object that is an ArrayList made up of
DirectoryEntry objects.  User can call methods to add or change entries, remove entries, 
search for entries, or display entries.  

Last Date Modified: 4/20/2022
*************************************************************************************/
package proj4;
import java.util.*;


public class PhoneDirectory {

    
    List<DirectoryEntry> theDirectory;

    public PhoneDirectory() {
    /*
    Constructor that creates a the PhoneDirectory object array list
    */
        this.theDirectory = new ArrayList<>();
    }
    
    public String toString() {
        /* 
           Method that displays the contents of the PhoneDirectory in a readable format
       */
        String name = "";

        // will add the first entry of the Directory to the string
        DirectoryEntry first = this.theDirectory.get(0);
        name += first.name + ": " + first.number;
        boolean is_first = true;
        
        // will add every entry of the dictionary to the string and skip the first
        for (DirectoryEntry directory : theDirectory) {
            if (is_first)
                is_first = false;
            else                
                name += "\n" + directory.name + ": " + directory.number;
        }   
        return name; 
        }

    public String addOrChangeEntry(String name, String number){
    /*
    Will add an entry to the directory or change and existing entry;
    will return the old number or null if it is a new entry    
    */

        boolean is_there = false;
        int index = 0;
        String old = "";

        // will iterate through directory and check if name is in the dictionary 
        // and either add or change entry
        while ((is_there == false) && (index < this.theDirectory.size())) {
            if ( name.equals((this.theDirectory.get(index)).name))  {
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

    public DirectoryEntry searchEntry(String find_name){
    /*
    search the entry referenced by name; return the 
    entry searched or null if there is no entry for name
    */

        boolean is_there = false;
        int index = 0;
        DirectoryEntry found = null;

        // will iterate through directory and check if name is in the dictionary 
        while ((is_there == false) && (index < this.theDirectory.size())) {
            if ( find_name.equals((this.theDirectory.get(index)).name) ) {
                found = this.theDirectory.get(index);
                is_there = true;
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

        // will iterate through directory and check if name is in the dictionary 
        // and remove that entry
        while ((is_there == false) && (index < this.theDirectory.size())) {
            if (name.equals((this.theDirectory.get(index)).name)) {
                found = theDirectory.get(index);
                this.theDirectory.remove(index);
                is_there = true;
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


