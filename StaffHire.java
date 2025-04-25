
/**
 * Write a description of class StaffHire here.
 *
 * @author (Emmanuel Megwara)
 * student numbers : 23035172
 * @version (a version number or a date)
 */

//
public class StaffHire
{
    // the attributes of the staffHire
    private int VacancyNumber;
    private String Designation;
    private String jobType;
    private String StaffName;
    private String joiningDate;
    private String Qualification;
    private String appointedBY;
    private boolean joined;
    
    // constructor
    public StaffHire(int VacancyNumber,String jobType,String StaffName,String Designation, String joiningDate
    , String Qualifications, String appointedBY,boolean joined)
    {
        this.VacancyNumber = VacancyNumber;
        this.jobType = jobType;
        this.StaffName = StaffName;
        this.Designation = Designation;
        this.joiningDate = joiningDate;
        this.Qualification = Qualifications;
        this.appointedBY = appointedBY;
        this.joined = joined;
    
    }
    
    // the method below is a list of getter and setter method
    public int getVacancyNumber()
    {
        return VacancyNumber;
    }
    
    public void setVacancyNumber(int VacancyNumber )
    {
        this.VacancyNumber = VacancyNumber;
    }
    
    public String getjobType()
    {
        return jobType;
    }
    
    public void setjobType(String jobType )
    {
        this.jobType = jobType;
    }
    
    public String getStaffName()
    {
        return StaffName;
    }
    
    public void setStaffName(String StaffName )
    {
        this.StaffName = StaffName;
    }
    
    public String getDesignation()
    {
        return Designation;
    }
    
    public void setDesignation(String Designation )
    {
        this.Designation = Designation;
    }
    
    public String getjoiningDate()
    {
        return joiningDate;
    }
    
    public void setjoiningDate(String joiningDate )
    {
        this.joiningDate = joiningDate;
    }
    
    public String getQualification()
    {
        return Qualification;
    }
    
    public void setQualification(String Qualification )
    {
        this.Qualification = Qualification;
    }
    
    public String getappointedBY()
    {
        return appointedBY;
    }
    
    public void setappointedBY(String appointedBY )
    {
        this.appointedBY = appointedBY;
    }
    
    public boolean getjoined()
    {
        return joined;
    }
    
    public void setjoined(boolean joined)
    {
        this.joined = joined;
    }

    public void amendjoined_staus(boolean joined)
    {
        this.joined = joined;
    }
    
    // the method below display informations 
    public void display()
    {
        System.out.println("Vacancy Number:"+" "+ VacancyNumber);
        System.out.println("jobtype:" +"  "+jobType);
        System.out.println("StaffName:" +"  "+ StaffName);
        System.out.println("Designations:"+" "+Designation);
        System.out.println("joiningDate:" +" "+joiningDate);
        System.out.println("Qualification:"+" "+Qualification);
        System.out.println("appointedBY:" +" "+appointedBY );
        
        // this is a conditon to tell the system to print out one this to the terminal 
        if (joined == true)
        {
            System.out.println("joined:  yes");
        }
        else
        {
            System.out.println("joined:  NO");
        }
    }
    
}
