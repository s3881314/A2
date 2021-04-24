// each action should be noted with day+time and id of staff member
// exception should be raised if staff is not authorized to do the action or is not rostered in for that day+time
// 2 wards and 6 rooms, each room has 1 to 4 beds
// write a text menu for this system.
// write file to store data

public class AbleCareHome {
    public static void main(String[] args) {

        // show menu
        Menu menu = new Menu();

        // Only Resident, Doctor, Nurse, Manager objects can be created.
        Doctor d;
        Nurse n;
        Manager m = new Manager("0", "0");
        Resident r;
        Bed b;
        Ward w1 = new Ward("W1",0);
        Ward w2 = new Ward("W2",0);


        // add any member(Non medical/medical staff or resident)?
        m.AddDoctor("1", "1");
        m.AddDoctor("2", "2");
        m.AddDoctor("3", "3");
        m.AddNurse("4", "4");
        m.AddNurse("5", "5");
        m.AddNurse("6", "6");



        // other functions

        // show graph of wards, rooms and beds

    }
}
