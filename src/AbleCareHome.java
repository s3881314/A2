// each action should be noted with day+time and id of staff member
// exception should be raised if staff is not authorized to do the action or is not rostered in for that day+time
// 2 wards and 6 rooms, each room has 1 to 4 beds
// write a text menu for this system.
// write file to store data

import java.text.ParseException;
import java.time.LocalDate;
import java.util.*;
import java.text.SimpleDateFormat;

public class AbleCareHome {
    void checkCompliance(){
        // Check shift
        // nurses are assigned to two shifts from 8am to 4 pm, and 2 pm to 10 pm. No more than 8 hours per day
        // doctors are assigned for 1 hour

    }
    public static void main(String[] args) throws ParseException {
        // show menu
        //Menu menu = new Menu();

        // Only Resident, Doctor, Nurse, Manager objects can be created.
        Manager m = new Manager("W","1", "000", "000");
        m.AddDoctor("D1","1","000", "000");
        m.AddDoctor("D2","2","000", "000");
        m.AddDoctor("D3","3","000", "000");
        m.AddDoctor("D4","4","000", "000");
        m.AddDoctor("D5","5","000", "000");
        m.AddNurse("N1", "1", "000", "000");

        LocalDate d = LocalDate.of(2021, 1, 2);
        m.AddResident("R1", "F", "1", d);
        m.AddNewResidentToBed("5", "Ward 1", 1);

        m.UpdateDoctorPassword("1", "111");
        m.UpdateDoctorPassword("4", "123");


        // add any member(Non medical/medical staff or resident)?



        // other functions


        // show graph of wards, rooms and beds

    }
}
