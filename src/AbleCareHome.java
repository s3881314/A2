// each action should be noted with day+time and id of staff member
// exception should be raised if staff is not authorized to do the action or is not rostered in for that day+time
// 2 wards and 6 rooms, each room has 1 to 4 beds
// write a text menu for this system.
// write file to store data

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.*;
import java.text.SimpleDateFormat;

public class AbleCareHome {
    static void AddManager(String n, String id, String p, String pw){
        Manager m = new Manager("W","1", "000", "000");
    }
    static void AddDoctor(String n, String id, String p, String pw){
        Doctor ne = new Doctor(n, id, p, pw);
    }
    static void AddNurse(String n, String id, String p, String pw){
        Nurse ne = new Nurse(n, id, p, pw);
    }
    static void AddResident(String n, String g, String id, LocalDate dob){
        Resident ne = new Resident(n, g, id, dob);
    }
    static void AddNewResidentToBed(String rid, String WName, int rn){  // Resident ID, Ward name, Room number
        Bed bed = new Bed(rid, WName, rn);
    }
    static void UpdatePassword(String p, String id, String np){  // Staff ID, new Password
        String n = "";
        if(p.equals("Doctor")) {
            try {
                File myObj = new File("./Archive/DoctorList.txt");
                Scanner myReader = new Scanner(myObj);
                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    // search for the specific doctor id
                    // modify the password
                    String a[] = data.split(",");
                    n = n + a[0] + "," + a[1] + "," + a[2] + ",";
                    if (a[0].equals(id)) {
                        n = n + np + "\n";
                    } else {
                        n = n + a[3] + "\n";
                    }

                }
                try {
                    FileWriter fw = new FileWriter("./Archive/DoctorList.txt");
                    fw.write(n); // 將字串寫到檔案裡
                    fw.close();
                } catch (IOException e) {
                    System.out.println("Updating Doctor password error.");
                    e.printStackTrace();
                }
                myReader.close();
            } catch (FileNotFoundException e) {
                System.out.println("An error occurred while updating password to DoctorList.txt.");
                e.printStackTrace();
            }
        }
        else if(p.equals("Nurse")){
            try {
                File myObj = new File("./Archive/NurseList.txt");
                Scanner myReader = new Scanner(myObj);
                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    // search for the specific doctor id
                    // modify the password
                    String a[] = data.split(",");
                    n = n + a[0] + "," + a[1] + "," + a[2] + ",";
                    if(a[0].equals(id)){
                        n = n + np + "\n";
                    }
                    else{
                        n = n + a[3] + "\n";
                    }

                }
                try {
                    FileWriter fw = new FileWriter("./Archive/NurseList.txt");
                    fw.write(n); // 將字串寫到檔案裡
                    fw.close();
                }
                catch (IOException e) {
                    System.out.println("Updating Doctor password error.");
                    e.printStackTrace();
                }
                myReader.close();
            } catch (FileNotFoundException e) {
                System.out.println("An error occurred while updating password to NurseList.txt.");
                e.printStackTrace();
            }
        }
    }

    static void AssignShift(String p, String id, int dow, int st, int et){  // Position, id
        Shift ne = new Shift(p, id, dow, st, et);
    }

    static void UpdateShift(String p, String id, int dow, int st, int et) {
        String n = "";
        if (p.equals("Doctor")) {
            try {
                File myObj = new File("./Archive/DoctorShift.txt");
                Scanner myReader = new Scanner(myObj);
                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    String a[] = data.split(",");
                    n = n + a[0] + ",";
                    if (a[0].equals(id)) {
                        n = n + dow + "," + st + "," + et + "\n";
                    }
                    else{
                        n = n + a[1] + "," + a[2] + "," + a[3] +"\n";
                    }
                }
                try {
                    FileWriter fw = new FileWriter("./Archive/DoctorShift.txt");
                    fw.write(n); // 將字串寫到檔案裡
                    fw.close();
                }
                catch (IOException e) {
                    System.out.println("Updating Doctor password error.");
                    e.printStackTrace();
                }
                myReader.close();
            } catch (FileNotFoundException e) {
                System.out.println("An error occurred while updating shift to DoctorList.txt.");
                e.printStackTrace();
            }
        }
        else if(p.equals("Nurse")){
            try {
                File myObj = new File("./Archive/NurseShift.txt");
                Scanner myReader = new Scanner(myObj);
                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    String a[] = data.split(",");
                    n = n + a[0] + "," ;
                    if (a[0].equals(id)) {
                        n = n + dow + "," + st + "," + et + "\n";
                    }
                    else{
                        n = n + a[1] + "," + a[2] + "," + a[3] +"\n";
                    }
                }
                try {
                    FileWriter fw = new FileWriter("./Archive/NurseShift.txt");
                    fw.write(n); // 將字串寫到檔案裡
                    fw.close();
                }
                catch (IOException e) {
                    System.out.println("Updating Doctor password error.");
                    e.printStackTrace();
                }
                myReader.close();
            } catch (FileNotFoundException e) {
                System.out.println("An error occurred while updating shift to DoctorList.txt.");
                e.printStackTrace();
            }
        }
    }

    void checkCompliance(){
        // Check shift
        // nurses are assigned to two shifts from 8am to 4 pm, and 2 pm to 10 pm. No more than 8 hours per day
        // doctors are assigned for 1 hour

    }

    public static void main(String[] args) throws ParseException {
        // MENU
        //Menu menu = new Menu();

        // FUNCTIONS
        AddManager("W","1", "000", "000");
        AddDoctor("D1","1","000", "000");
        AddDoctor("D2","2","000", "000");
        AddDoctor("D3","3","000", "000");
        AddDoctor("D4","4","000", "000");
        AddDoctor("D5","5","000", "000");
        AddNurse("N1", "1", "000", "000");

        LocalDate d = LocalDate.of(2021, 1, 2);
        AddResident("R1", "F", "1", d);
        AddNewResidentToBed("5", "Ward 1", 1);

        UpdatePassword("Doctor", "1", "111");
        UpdatePassword("Nurse", "4", "123");

        AssignShift("Doctor","1",3,7,15);
        AssignShift("Nurse","1",3,7,15);

        UpdateShift("Doctor", "1",1,1,2);
        UpdateShift("Nurse", "1",2,3,4);

        // GUI

    }
}
