
/**
 * Write a description of class RecrutitmentSystem here.
 *
 * @author (Emmanuel Megwara)
 * @version (a version number or a date)
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.GridLayout;
import java.awt.FlowLayout;

public class RecruitmentSystem implements ActionListener
{
    
    // this for the frame to hold the components of the gui
    private JFrame frame;
    
    // this is the text fields for input
    private JTextField VacancyNumberTextField;
    private JTextField DesignationTextField;
    private JTextField jobTypeTextField;
    private JTextField StaffNameTextField;
    private JTextField joiningDateTextField;
    private JTextField QualificationTextField;
    private JTextField appointedBYTextField; 
    private JTextField SalaryTextField;
    private JTextField WeeklyFractionalHoursTextField;
    private JTextField WorkingHourTextField;
    private JTextField WagesPerHourTextField;
    private JTextField shiftsTextField;
    private JTextField TerminatedNumberTextField;
    private JTextField displayNumberTextField;
    
    // this a checkbox for both the joined Terminated
    private JCheckBox joined;
    private JCheckBox Terminate;
    
    // handler an object to manage connections and operation with the database
    private Database database;
    
    // this the button for the following actions
    private JButton AddFullTimeStaffButton;
    private JButton AddPartTimestaffButton;
    private JButton SetSalaryButton;
    private JButton SetworkingShiftButton;
    private JButton TerminatePartTimeStaffButton;
    private JButton DisplayNumberButton;
    private JButton ClearButton;
    
    
    // constructor for the recruitmentSystem
    public RecruitmentSystem()
    {
        makeFrame(); 
        // this build the main gui window and its components
        
        database = new Database();
        //this create an instance in the database class
    }

    //action event handler for buttons
    public void actionPerformed(ActionEvent event)
    {
        // this get command from event
        String command = event.getActionCommand();
        
        // this set of condition to control different button commands 
        if(command.equals("open")) 
        {
            open();
        }
        if ( command.equals("Quit")) 
        {
            Quit();
        }
        if ( command.equals("Clear"))
        {
            Clear();
        }
        if( command.equals("Add fullTimeStaff"))
        {
            AddFullTimeStaffButton();
        }
        if( command.equals("Add partTimeStaff"))
        {
            AddPartTimeStaffButton();
        }
        if (command.equals("Set Salary"))
        {
            setsalary();
        }
        if (command.equals("DisplayNumber"))
        {
            DisplayNumber();
        }

        if (command.equals("Set working Shift"))
        {
            setworkingshift();
        }

        if (command.equals("Terminate PartTimeSatff"))
        {
            TerminatePartTimeStaff();
        }

    }

    public void open()
    {
        System.out.println("unable to open a file.");
    }

    public void Quit()
    {
        System.out.println("thanks for use our system ");
        System.exit(0);
    }

    // this a method to clear all input fields
    public void Clear()
    {
        // this resets all input fields and checkbox
        
        VacancyNumberTextField.setText(" ");
        DesignationTextField.setText("  ");
        jobTypeTextField.setText(" ");
        StaffNameTextField.setText(" ");
        QualificationTextField.setText(" ");
        appointedBYTextField.setText(" ");
        SalaryTextField.setText(" ");
        WeeklyFractionalHoursTextField.setText(" ");
        WorkingHourTextField.setText(" ");
        WagesPerHourTextField.setText(" ");
        shiftsTextField.setText(" ");
        displayNumberTextField.setText(" ");
        joiningDateTextField.setText(" ");
        joined.setSelected(false);
        Terminate.setSelected(false);

    }

    
    // method of add a FullTimeStaffhire to the database
    public void AddFullTimeStaffButton()
    {
        try
        {
            
            // this to collect data from thier  textfields and checkbox
            int VacancyNumber = Integer.parseInt(VacancyNumberTextField.getText());
            String Designation = DesignationTextField.getText();
            String jobType = jobTypeTextField.getText();
            String StaffName = StaffNameTextField.getText();
            String joiningDate = joiningDateTextField.getText();
            String Qualification = QualificationTextField.getText();
            String appointedBY = appointedBYTextField.getText();
            double salary = Double.parseDouble(SalaryTextField.getText());
            int WeeklyFractionalHours = Integer.parseInt(WeeklyFractionalHoursTextField.getText());
            boolean isjoined = joined.isSelected();
            
            
            // this used the data from the textfields to create a new fulltimestaffhire
            FullTimeStaffHire FullTimeStaff = new FullTimeStaffHire(
                    VacancyNumber,jobType,StaffName,Designation, 
                    joiningDate, Qualification, appointedBY,isjoined,
                    salary, WeeklyFractionalHours);
                    
             // add a new full time staff to the database
            database.AddFullTimeStaff(FullTimeStaff);  
            
            // this show a comfirmation message to the user
            JOptionPane.showMessageDialog(frame,
                "ADD FULLTIMESTaff\n"+" was Successfully addedd",
                "fullTimeStaffHire",                            
                JOptionPane.INFORMATION_MESSAGE);
        }catch(NumberFormatException exception)
        {
            
            // this a pop up message to tell the user there is an error in the input fields
            JOptionPane.showMessageDialog(frame,
                "please check your details for any error \n "+
                "try to use the the part Time Staff button ",
                "fullTimeStaffHire",                            
                JOptionPane.INFORMATION_MESSAGE);
        }

    }

    
    // method of add a PartTimeStaffhire to the database
    public void AddPartTimeStaffButton()
    {
        try
        {

            // this to collect data from thier  textfields and checkbox
            int VacancyNumber = Integer.parseInt(VacancyNumberTextField.getText());
            String Designation = DesignationTextField.getText();
            String jobType = jobTypeTextField.getText();
            String StaffName = StaffNameTextField.getText();
            String joiningDate = joiningDateTextField.getText();
            String Qualification = QualificationTextField.getText();
            String appointedBY = appointedBYTextField.getText();
            boolean isjoined = joined.isSelected();
            int WorkingHours = Integer.parseInt(WorkingHourTextField.getText());
            double WagesPerHour = Double.parseDouble(WagesPerHourTextField.getText());
            String Shifts = shiftsTextField.getText();
            boolean isTerminate = Terminate.isSelected();

            // this used the data from the textfields to create a new parttimestaffhire
            PartTimeStaffHire PartTimeStaff = new PartTimeStaffHire(
                    VacancyNumber,jobType,StaffName, Designation,
                    Qualification,appointedBY,joiningDate,isjoined,
                    WorkingHours,WagesPerHour,Shifts,isTerminate);
            
                    
            //add a new part time staff to the database
            database.AddPartTimeStaff(PartTimeStaff); 
             

            // this show a comfirmation message to the user
            JOptionPane.showMessageDialog(frame,
                "ADD PART TIME STAFF  \n"+" was Successfully addedd",
                "PartTimeStaffHire",                            
                JOptionPane.INFORMATION_MESSAGE);

        }catch(NumberFormatException exception)
        {
            // this a pop up message to tell the user there is an error in the input fields
            JOptionPane.showMessageDialog(frame,
                "please check your details for any error \n "+
                "try to use the the full Time Staff button ",
                "PARTTIMESTAFFHIRE",                            
                JOptionPane.INFORMATION_MESSAGE);

        }
    }

    
    // method to set the salary 
    public void setsalary()
    {
        try{
            
            // get data from the following text field
            int VacancyNumber = Integer.parseInt(VacancyNumberTextField.getText());
            double salary = Double.parseDouble(SalaryTextField.getText());
            String StaffName = StaffNameTextField.getText();
            
            // iterate through all staff data from the database class
            for (StaffHire staff: database.getAllStaff()) 
            {
                
                /* this check if staff is a fulltimestaffhire 
                   and if both the vacancy number and staff name match the one
                   from the database*/
                if (staff instanceof FullTimeStaffHire && 
                staff.getVacancyNumber() == VacancyNumber && 
                staff.getStaffName().equals(StaffName))
                {
                    
                    // get the value in salary textfield and update the salary
                    ((FullTimeStaffHire)staff).setSalary(Double.parseDouble(SalaryTextField.getText()));

                    
                    // show success message
                    JOptionPane.showMessageDialog(frame,
                        "full-time staff Salary Updated successfully ",
                        "fullTimeStaffHire",                            
                        JOptionPane.INFORMATION_MESSAGE);

                }
                else
                {
                    
                    // if no match is found, show an error message
                    JOptionPane.showMessageDialog(frame,
                        "staff is does not exit" + " Salary Updated was not successfully ",
                        "vacancyNumber does not exits",                            
                        JOptionPane.INFORMATION_MESSAGE);

                }

            }
        }catch(NumberFormatException exception)
        {
            // this is a message to handle input format errors
            JOptionPane.showMessageDialog(frame,
                "Please enter a valid amount  for the Salary .",
                "Invalid Input",
                JOptionPane.ERROR_MESSAGE);
        }
    }

    public void setworkingshift()
    {
        try{
            
            // get data from the following text field
            int VacancyNumber= Integer.parseInt(VacancyNumberTextField.getText());
            String StaffName = StaffNameTextField.getText();
            String Shifts = shiftsTextField.getText();
            
            // iterate through all staff data from the database class
            for(StaffHire staff: database.getAllStaff())
            {
                
                /* this check if staff is a PartTimestaffhire 
                   and if both the vacancy number and staff name match the one
                   from the database*/
                if (staff instanceof PartTimeStaffHire &&
                staff.getVacancyNumber() == VacancyNumber  && 
                staff.getStaffName().equals(StaffName))
                {

                    // to check if the part time staff has joined 
                    if (((PartTimeStaffHire)staff).getjoined())
                    {
                        
                        // get the value in salary textfield and update the shift 
                        ((PartTimeStaffHire)staff).setShifts(shiftsTextField.getText());
                        
                        
                        // show success message
                        JOptionPane.showMessageDialog(frame, "Shift updated to: "
                            + Shifts, "Success",
                            JOptionPane.INFORMATION_MESSAGE);

                    }
                    else
                    {
                        
                        // if no match is found, show an error message
                        JOptionPane.showMessageDialog(frame,
                            "staff has not yet joined" + " set of new shift was not successfully ",
                            "vacancyNumber does not exits",                            
                            JOptionPane.WARNING_MESSAGE);

                    }

                }
            }
        }catch(NumberFormatException exception)
        {
            
            // this is a message to handle input format errors
            
            
            JOptionPane.showMessageDialog(frame,
                "Please enter a  string value for the shift .",
                "Invalid Input",
                JOptionPane.ERROR_MESSAGE);
        }
    }

    
    // a method to Terminate A part time staff
    public void TerminatePartTimeStaff()
    {
        
        //the index based on what the user put in this text field
        int index = getDisplayNumber();
        try
        {
            
            // get data from this  text field
            int VacancyNumber = Integer.parseInt(VacancyNumberTextField.getText());

            // to get staff object of a particular index
            StaffHire staff = database.getAtIndex(index);

            /*this is to check if the staff is a partTimestaffHire and 
             * the vacacny number matches the one from the index */
            if (staff instanceof PartTimeStaffHire&&
            staff.getVacancyNumber() == VacancyNumber)
            {
                // this is to tell the system to remove that index from the database  
                PartTimeStaffHire PartTimeStaff = (PartTimeStaffHire)staff;
                database.remove(index);
                

                /* this is to inform the user that the termination 
                 * of the part was successful */
                JOptionPane.showMessageDialog(frame,
                    "the part time staff has been Terminated",
                    "all iformation about the staff has been removed ",
                    JOptionPane.INFORMATION_MESSAGE);
            }
            else
            { 
                
                // inform user that staff has already remove from the system
                JOptionPane.showMessageDialog(frame,
                    "the part Time staff has already been terinated",
                    "all information about the staff has  been deleted",
                    JOptionPane.ERROR_MESSAGE);

            }
        }catch(NumberFormatException exception)
        {
            
            // this is to handel any invalid input from vacancy number text field
            JOptionPane.showMessageDialog(frame,
                    "the part Time staff may have not yet joined yet",
                    "please check that you enter the rigth VacancyNumber",
                    JOptionPane.INFORMATION_MESSAGE);

        }
    }

    // the method for display staff information
    public void DisplayNumber()
    {
        
        // //the index based on what the user put in this text field
        int index = getDisplayNumber();
        if(index != -1)
        {
            
            // to get staff object of a particular index
            StaffHire staff = database.getAtIndex(index);

            // to check if staff belong to the fullTimeStaffHire 
            if(staff instanceof FullTimeStaffHire)   {
            
                // to display the full time staff informations
                FullTimeStaffHire FullTimeStaff = (FullTimeStaffHire) staff;
                FullTimeStaff.display();

            }
            // to check if staff belong to the parttimestaff
            else if(staff instanceof PartTimeStaffHire )
            {
                // to display the part time staff informations
                PartTimeStaffHire PartTimeStaff = (PartTimeStaffHire) staff;
                PartTimeStaff.display();

            }
        }
    }

    
    // A method get DispalyNumber 
    public int getDisplayNumber()
    {
        // set the default to invalid index
        int displayNumber = -1;

        try {
            // get data from this  text field
            displayNumber = Integer.parseInt(displayNumberTextField.getText());

            // this is to check if index is within the range of the database list
            if (displayNumber < 0 || displayNumber >=database.getSize()) {
                JOptionPane.showMessageDialog(frame,
                    "Display number out of range. Please enter a number between 0 and " + (database.getSize() -1) + ".",
                    "Invalid Display Number",
                    JOptionPane.ERROR_MESSAGE);
                
                // return to invaild if out of range    
                displayNumber = -1;
            }

            
        } catch (NumberFormatException exception)
        {
            
            // this is to handel input that is not a number
            JOptionPane.showMessageDialog(frame,
                "Please enter a valid integer for the display number.",
                "Invalid Input",
                JOptionPane.ERROR_MESSAGE);
        }

        return displayNumber;
    }

    
    // the method of build of the frame and all it contain
    private void makeFrame()
    {
        
        //this the frame title
        frame = new JFrame("RecrutitmentSystem");
        
        // this a content pane of the frame
        Container contentPane = frame.getContentPane();
        makeMenuBar(frame);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // the size of the frame
        frame.setSize(900,400);

        // this where each label and input text field
        JLabel VacancyNumberText= new JLabel("Vacancy Number:");
        VacancyNumberTextField = new JTextField();

        JLabel jobTypeText = new JLabel("jobType:");
        jobTypeTextField = new JTextField();

        JLabel StaffNameText = new JLabel("StaffName:");
        StaffNameTextField = new JTextField();

        JLabel DesignationText = new JLabel("Designation:");
        DesignationTextField = new JTextField();

        JLabel joiningDateText = new JLabel("Joining Date:");
        joiningDateTextField = new JTextField();

        JLabel QualificationText = new JLabel("Qualifications:");
        QualificationTextField = new JTextField();

        JLabel appointedBYText= new JLabel("appointedBY:");
        appointedBYTextField = new JTextField();

        JLabel SalaryText= new JLabel("Salary:");
        SalaryTextField = new JTextField(15);

        JLabel WeeklyFractionalHoursText = new JLabel("WeeklyFractionalHours:");
        WeeklyFractionalHoursTextField = new JTextField(15);

        JLabel WorkingHourText= new JLabel("Working Hours:");
        WorkingHourTextField = new JTextField(15);

        JLabel WagesPerHourText= new JLabel("WagesPerHour:");
        WagesPerHourTextField = new JTextField(15);

        JLabel shiftsText= new JLabel("shifts:");
        shiftsTextField = new JTextField(15);

        JLabel displayNumberText= new JLabel("displayNumber:");
        displayNumberTextField = new JTextField(15);

        // the layout of the frame 
        contentPane.setLayout(new GridLayout(0,4));

        // this where each label and text field were place on the frame
        contentPane.add(VacancyNumberText);
        contentPane.add(VacancyNumberTextField);

        contentPane.add(jobTypeText);
        contentPane.add(jobTypeTextField);

        contentPane.add(StaffNameText);
        contentPane.add(StaffNameTextField);

        contentPane.add(DesignationText);
        contentPane.add(DesignationTextField);

        contentPane.add(joiningDateText);
        contentPane.add(joiningDateTextField);

        contentPane.add(QualificationText);
        contentPane.add(QualificationTextField);

        contentPane.add(appointedBYText);
        contentPane.add(appointedBYTextField);

        contentPane.add(SalaryText);
        contentPane.add(SalaryTextField);

        contentPane.add(WeeklyFractionalHoursText);
        contentPane.add(WeeklyFractionalHoursTextField);

        contentPane.add(WorkingHourText);
        contentPane.add(WorkingHourTextField);

        contentPane.add(WagesPerHourText);
        contentPane.add(WagesPerHourTextField);

        contentPane.add(shiftsText);
        contentPane.add(shiftsTextField);

        contentPane.add(displayNumberText);
        contentPane.add(displayNumberTextField);

        // the creation of  a new jpanel with a layout and was added to the main frame
        JPanel flowPanel = new JPanel();
        flowPanel.setLayout(new FlowLayout());
        frame.add(flowPanel);
        
        // this a checkbox for joined and Terminate
        joined = new JCheckBox("joined");
        flowPanel.add(joined);

        Terminate = new JCheckBox("terminated");
        frame.add(Terminate);

        /* the creations of the button ,add the button to the frame 
         * and  action listener */  

        AddFullTimeStaffButton = new JButton("Add fullTimeStaff");
        frame.add(AddFullTimeStaffButton);
        AddFullTimeStaffButton.addActionListener(this);

        AddPartTimestaffButton = new JButton("Add partTimeStaff");
        frame.add(AddPartTimestaffButton);
        AddPartTimestaffButton.addActionListener(this);

        SetSalaryButton = new JButton("Set Salary");
        frame.add(SetSalaryButton);
        SetSalaryButton.addActionListener(this);

        SetworkingShiftButton = new JButton("Set working Shift");
        frame.add(SetworkingShiftButton);
        SetworkingShiftButton.addActionListener(this);

        TerminatePartTimeStaffButton = new JButton("Terminate PartTimeSatff");
        frame.add(TerminatePartTimeStaffButton);
        TerminatePartTimeStaffButton.addActionListener(this);

        DisplayNumberButton = new JButton("DisplayNumber");
        frame.add(DisplayNumberButton);
        DisplayNumberButton.addActionListener(this);

        ClearButton = new JButton("Clear");
        frame.add(ClearButton);
        ClearButton.addActionListener(this);

              
        frame.pack();
        frame.setVisible(true); // make the frame visible
    }

    // a method to create a menu in the frame
    private void makeMenuBar(JFrame frame)
    {
        JMenuBar menubar = new JMenuBar();
        frame.setJMenuBar(menubar);

        // create the File menu
        JMenu fileMenu = new JMenu("File");
        menubar.add(fileMenu);

        JMenuItem openItem = new JMenuItem("Open");
        openItem.addActionListener(this);
        fileMenu.add(openItem);

        JMenuItem quitItem = new JMenuItem("Quit");
        quitItem.addActionListener(this);
        fileMenu.add(quitItem);
    }

    // a method to launch the gui outside BlueJ
    public static void main(String[] args) 
    {
        new RecruitmentSystem();
    }

}