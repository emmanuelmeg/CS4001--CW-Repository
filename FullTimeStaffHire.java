
/**
 * Write a description of class fullTimeStaffHire here.
 *
 * @author (Emmanuel Megwara)
 * student numbers : 23035172
 * @version (a version number or a date)
 */
public class FullTimeStaffHire extends StaffHire
{
    // the attributes of this class
    private double Salary;
    private int WeeklyFractionalHours;
    
    
    
    // the constructor for fulltimestaffhire and also the constructor of the staffhire
    public FullTimeStaffHire(int VacancyNumber,String jobType,
                             String StaffName,String Designation,
                             String joiningDate, String Qualifications,
                             String appointedBY,boolean joined,
                             double Salary, int weekly_Hour)
    {                        
        
        // this to call the superclass constructor
        super(VacancyNumber ,jobType, StaffName, Designation, 
            joiningDate,Qualifications,appointedBY,joined);

        this.Salary = Salary;
        WeeklyFractionalHours = weekly_Hour;

    } 
     
    
    
    public double getSalary()
    {
        return Salary;
    }

    public void setSalary(double newSalary)
    {
        // this checking if staff has joined before allowing to set a new salary
        if (getjoined())
        {
            this.Salary = newSalary;
        }
        else
        {
            System.out.println("there is not staff avaliable for that salary ");
        }

    }

    public int getweekly_Hour()
    {
        return WeeklyFractionalHours;
    }

    public void setweekly_Hour(int weekly_Hour)
    {
        WeeklyFractionalHours = weekly_Hour;

    }
 
    // this Override display method 
    @Override
    public void display()
    {
        
        /* this is to call the method from the superclass to print along with 
         this method from this class */
        super.display();
        
        
        /* it checks whether is staff has joined before print the salary and 
        weeklFractionalHours  */
        if(getjoined())
        {
            System.out.println("Salary:  £" + Salary);
            System.out.println("Weekly Fractional Hours: " + 
                WeeklyFractionalHours);
        }
        else
        {
            System.out.println("there is not staff avaliable for that salary ");
        }
    }

}
