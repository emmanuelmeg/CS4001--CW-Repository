
/**
 * Write a description of class PartTimeStaffHire here.
 *
 * @author (Emmanuel Megwara)
 * student numbers : 23035172
 * @version (a version number or a date)
 */
public class PartTimeStaffHire extends StaffHire
{
    // the attributes of this class
    
    private int WorkingHour;
    private double WagesPerHour;
    private String Shifts;
    private boolean Terminated; 
    
    
     // the constructor for parttimestaffhire and also the constructor of the staffhire
    public PartTimeStaffHire(int VacancyNumber, String jobType,
                             String StaffName, String Designation,
                             String joiningDate, String Qualifications,
                             String appointedBY,boolean joined,
                             int WorkingHour, double WagesPerHour,
                             String Shifts,boolean terminated)
    {
     
        // this to call the superclass constructor
        super(VacancyNumber ,jobType, StaffName, Designation, joiningDate,
               Qualifications,appointedBY,joined);
        
        this.WorkingHour = WorkingHour;
        this.WagesPerHour = WagesPerHour;
        this.Shifts = Shifts;
        this.Terminated = Terminated;
    }
        
    
    // this to call the superclass constructor
    public int getWorkingHour()
        {
            return WorkingHour;
        }
        
    public void setWorkingHour(int WorkingHour)
    {
        this.WorkingHour = WorkingHour; 
    }
    
    public double getWagesPerHour()
    {
       return WagesPerHour;
    }
    
    public void setWagesPerHour(double WagesPerHour)
    {
        this.WagesPerHour = WagesPerHour;
    }
    
    public String getShifts()
    {
        return Shifts;
    }
    
    public void setShifts(String Shifts)
    {
        
        //to check if staff has joined 
        if (getjoined())
        {
            this.Shifts = Shifts;
        }
        else
        {
            System.out.println("the staff has been terminated");
        }
    }
    
    public boolean getTerminated()
    {
        return Terminated;
    }
    
    public void setterminated(boolean Terminated)
    {
        
        // this checks what the value in Terminated  
        if (Terminated)
        {
            System.out.println("the staff has been terminated");
        }
        else
        {
            // this condition clears all the staff details
            
            setStaffName("");
            setjoiningDate("");
            setQualification("");
            setappointedBY("");
            setjoined(false);
            Terminated = true;
            System.out.println("your information has now  been terminated");
        }
    }
    
    
    //this is a display method that show the staff detial and his current status
    public void display()
    {
        
        /* this is to call the method from the superclass to print along with 
         this method from this class */
         
        super.display();
        
        System.out.println("wages Per Hour : £"+ WagesPerHour);
        System.out.println("WorkingHour : "+""+WorkingHour);
        System.out.println("your shifts for the day is "+" "+ Shifts);
        
        /* it checks whether is staff has been Terminated */
        if (Terminated == true)
        {
            System.out.println("terminated: yes");
        }
        else
        {
            System.out.println("terminated: no");
        }
        
        // this is calculate the income for everys day works
        double incomePerday= WagesPerHour * WorkingHour;
        System.out.println("this is income per day £ "+":" + incomePerday);
        
        
    }
    
}
    
                                 
                             


