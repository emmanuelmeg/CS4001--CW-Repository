/**
 * Write a description of class RecrutitmentSystem here.
 *
 * @author (Emmanuel Megwara)
 * student numbers : 23035172
 * @version (a version number or a date)
 * cs4001 coursework3
 */


// 
import java.util.ArrayList;
public class Database
{
    // this is an arraylist to store staff details 
    
    private ArrayList<StaffHire>staffinformations;
    
    // the constructor of the database class
    
    public Database()
    {
        // start of the arraylist when a databasr object is created
        
        staffinformations = new ArrayList<StaffHire>();
    }
    
    //  method to add fulltimestaff to the staffinformations list
    public void AddFullTimeStaff( StaffHire FullTimeStaffHire )
    {
        
        staffinformations.add(FullTimeStaffHire);
        
    }
    
    //  method to add parttimestaff to the staffinformations list
    public void AddPartTimeStaff(StaffHire PartTimeStaffHire)
    {
        staffinformations.add(PartTimeStaffHire);
    }
    
    // this method get the index number of the object from the arraylist
    public StaffHire getAtIndex(int index)
    {
        return staffinformations.get(index);
    }
    
    //this method get the size of the of the arraylist
    public int getSize()
    {
        return staffinformations.size();
    }
    
    // this method return the whole list store in the arraylist
    public ArrayList<StaffHire>getAllStaff()
    {
        return staffinformations;
    }
    
    // this is a method that remove an object from the list with the use of the index number
    public StaffHire remove(int index)
    {
        return staffinformations.remove(index);
    }



}