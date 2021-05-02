// each action should be noted with day+time and id of staff member
// exception should be raised if staff is not authorized to do the action or is not rostered in for that day+time
// 2 wards and 6 rooms, each room has 1 to 4 beds
// write a text menu for this system.
// write file to store data

import java.io.*;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.text.SimpleDateFormat;

public class AbleCareHome {
    // Manager only
    static void AddManager(String sid, String p2, String n, String id, String p, String pw){
        Manager m = new Manager(sid,p2, n,id, p, pw);
    }
    // Manager only
    static void AddDoctor(String sid, String p2, String n, String id, String p, String pw){
        Doctor ne = new Doctor(sid, p2, n, id, p, pw);
    }
    // Manager only
    static void AddNurse(String sid, String p2, String n, String id, String p, String pw){
        Nurse ne = new Nurse(sid, p2, n, id, p, pw);
    }

    static void AddResident(String sid, String p2, String n, String g, String id, LocalDate dob){
        Resident ne = new Resident(sid, p2, n, g, id, dob);
    }

    static void AddNewResidentToBed(String sid, String p2, String rid, String WName, int rn){  // Resident ID, Ward name, Room number
        Bed bed = new Bed(sid, p2, rid, WName, rn);
    }
    // Manager only
    static void UpdatePassword(String sid, String p2, String p, String id, String np){  // Staff ID, new Password
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

                    // Record in Action.txt
                    try {
                        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
                        LocalDateTime now = LocalDateTime.now();

                        File file = new File("./Archive/Action.txt");
                        FileWriter fr = new FileWriter(file, true);
                        BufferedWriter br = new BufferedWriter(fr);
                        PrintWriter pr = new PrintWriter(br);
                        pr.println(dtf.format(now) + "," + p2 + "," + sid + ", Update doctor password");
                        pr.close();
                        br.close();
                        fr.close();
                    } catch (IOException e) {
                        System.out.println("An error occurred while writing Action.txt.");
                        e.printStackTrace();
                    }
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

                    // Record in Action.txt
                    try {
                        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
                        LocalDateTime now = LocalDateTime.now();

                        File file = new File("./Archive/Action.txt");
                        FileWriter fr = new FileWriter(file, true);
                        BufferedWriter br = new BufferedWriter(fr);
                        PrintWriter pr = new PrintWriter(br);
                        pr.println(dtf.format(now) + "," + p2 + "," + sid + ", Update nurse password");
                        pr.close();
                        br.close();
                        fr.close();
                    } catch (IOException e) {
                        System.out.println("An error occurred while writing Action.txt.");
                        e.printStackTrace();
                    }
                }
                catch (IOException e) {
                    System.out.println("Updating Nurse password error.");
                    e.printStackTrace();
                }
                myReader.close();
            } catch (FileNotFoundException e) {
                System.out.println("An error occurred while updating password to NurseList.txt.");
                e.printStackTrace();
            }
        }
    }

    static void AssignShift(String sid, String p2, String p, String id, int dow, int st, int et){  // Position, id
        Shift ne = new Shift(sid, p2, p, id, dow, st, et);
    }

    static void UpdateShift(String sid, String p2, String p, String id, int dow, int st, int et) {
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
                    // Record in Action.txt
                    try {
                        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
                        LocalDateTime now = LocalDateTime.now();

                        File file = new File("./Archive/Action.txt");
                        FileWriter fr = new FileWriter(file, true);
                        BufferedWriter br = new BufferedWriter(fr);
                        PrintWriter pr = new PrintWriter(br);
                        pr.println(dtf.format(now) + "," + p2 + "," + sid + ", Update doctor shift");
                        pr.close();
                        br.close();
                        fr.close();
                    } catch (IOException e) {
                        System.out.println("An error occurred while writing Action.txt.");
                        e.printStackTrace();
                    }
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
                    // Record in Action.txt
                    try {
                        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
                        LocalDateTime now = LocalDateTime.now();

                        File file = new File("./Archive/Action.txt");
                        FileWriter fr = new FileWriter(file, true);
                        BufferedWriter br = new BufferedWriter(fr);
                        PrintWriter pr = new PrintWriter(br);
                        pr.println(dtf.format(now) + "," + p2 + "," + sid + ", Update nurse shift");
                        pr.close();
                        br.close();
                        fr.close();
                    } catch (IOException e) {
                        System.out.println("An error occurred while writing Action.txt.");
                        e.printStackTrace();
                    }
                }
                catch (IOException e) {
                    System.out.println("Updating Doctor password error.");
                    e.printStackTrace();
                }
                myReader.close();
            } catch (FileNotFoundException e) {
                System.out.println("An error occurred while updating shift to NurseList.txt.");
                e.printStackTrace();
            }
        }
    }

    static void MoveResident(String sid, String p2, String rid, String w, String r, String b){
        // Staff position, Staff ID, Resident ID, Ward Name, Room, Bed
        // Check the status of bed to be empty
        boolean flag = false;
        try {
            File myObj = new File("./Archive/Bed.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String a[] = data.split(",");
                if (a[0].equals(w) && a[1].equals(String.valueOf(r)) && a[2].equals(b)) {
                    flag = true;
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        if(flag == false){
            // Delete old data
            try{
                FileWriter myWriter = new FileWriter("./Archive/Bed.txt");

                String NewFile = "";
                File myObj = new File("./Archive/Bed.txt");
                Scanner myReader = new Scanner(myObj);
                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    String a[] = data.split(",");
                    if (!a[3].equals(rid)) {  // Use Resident ID to skip the original bed data
                        NewFile = NewFile + data + "\n";
                    }
                }
                myReader.close();
                myWriter.write(NewFile);
                myWriter.close();
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }

            // Move resident
            try {
                File file = new File("./Archive/Bed.txt");
                FileWriter fr = new FileWriter(file, true);
                BufferedWriter br = new BufferedWriter(fr);
                PrintWriter pr = new PrintWriter(br);
                pr.println(w + "," + r + "," + b + "," + rid);
                pr.close();
                br.close();
                fr.close();
            } catch (IOException e) {
                System.out.println("An error occurred while writing Bed.txt.");
                e.printStackTrace();
            }

            // Record action
            try {
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
                LocalDateTime now = LocalDateTime.now();

                File file = new File("./Archive/Action.txt");
                FileWriter fr = new FileWriter(file, true);
                BufferedWriter br = new BufferedWriter(fr);
                PrintWriter pr = new PrintWriter(br);
                pr.println(dtf.format(now) + "," + p2 + "," + sid + ", Move resident to other bed.");
                pr.close();
                br.close();
                fr.close();
            } catch (IOException e) {
                System.out.println("An error occurred while writing Action.txt.");
                e.printStackTrace();
            }
        }
        else{ System.out.println("Resident didn't move.");}
    }

    static void DischargeResident(String sid, String p2, String rid){
        int flag = 0;
        String buff = "";
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        // check if the id exist
        try {
            File myObj = new File("./Archive/ResidentList.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String a[] = data.split(",");
                buff = buff + data;
                if(a[0].equals(rid)){ // if ID is the same with ID flag = 1
                    flag = 1;
                    buff = buff + "," + dtf.format(now)+  "\n";
                }
                else{
                    buff = buff + "\n";
                }
            }
            // if ID exist, write action in ActionList.txt
            if(flag == 1){
                // Replace old data
                try {
                    FileWriter myWriter = new FileWriter("./Archive/ResidentList.txt");
                    myWriter.write(buff);
                    myWriter.close();
                } catch (IOException e) {
                    System.out.println("An error occurred while writing ResidentList.txt.");
                    e.printStackTrace();
                }

                // Record action
                try {
                    File file = new File("./Archive/Action.txt");
                    FileWriter fr = new FileWriter(file, true);
                    BufferedWriter br = new BufferedWriter(fr);
                    PrintWriter pr = new PrintWriter(br);
                    pr.println(dtf.format(now) + "," + p2 + "," + sid + ", Discharge resident.");
                    pr.close();
                    br.close();
                    fr.close();
                } catch (IOException e) {
                    System.out.println("An error occurred while writing Action.txt in DischargeResident.");
                    e.printStackTrace();
                }
            }
            else{
                System.out.println("Resident ID not exist.");
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred while reading ResidentList.txt.");
            e.printStackTrace();
        }
    }

    static String CheckResidentDetails(String sid, String p2, String rid){
        String buff = "";
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        // check if the id exist
        try {
            File myObj = new File("./Archive/ResidentList.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                buff = buff + data + "\n";
            }
            myReader.close();
            System.out.println(buff);

            // Record action
            try {
                File file = new File("./Archive/Action.txt");
                FileWriter fr = new FileWriter(file, true);
                BufferedWriter br = new BufferedWriter(fr);
                PrintWriter pr = new PrintWriter(br);
                pr.println(dtf.format(now) + "," + p2 + "," + sid + ", Check resident details.");
                pr.close();
                br.close();
                fr.close();
            } catch (IOException e) {
                System.out.println("An error occurred while writing Action.txt in DischargeResident.");
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred while reading ResidentList.txt.");
            e.printStackTrace();
        }
        return buff;
    }

    // Doctor only
    static void AttachNewPrescription(String sid, String p2, String rid, String p){
        Prescription pre = new Prescription(sid, p2, rid, p);
    }
    // Doctor only
    static void UpdatePrescription(String sid, String p2, String rid, String p) {
        String n = "";
        try {
            File myObj = new File("./Archive/Prescription.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                // search for the specific Resident id
                // modify the prescription
                String a[] = data.split(",");
                n = n + a[0] + ",";
                if (a[0].equals(rid)) {
                    n = n + p + "\n";
                } else {
                    n = n + a[1] + "\n";
                }
            }
            myReader.close();
            try {
                FileWriter fw = new FileWriter("./Archive/Prescription.txt");
                fw.write(n); // 將字串寫到檔案裡
                fw.close();

                // Record in Action.txt
                try {
                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
                    LocalDateTime now = LocalDateTime.now();

                    File file = new File("./Archive/Action.txt");
                    FileWriter fr = new FileWriter(file, true);
                    BufferedWriter br = new BufferedWriter(fr);
                    PrintWriter pr = new PrintWriter(br);
                    pr.println(dtf.format(now) + "," + p2 + "," + sid + ", Update resident's prescription");
                    pr.close();
                    br.close();
                    fr.close();
                } catch (IOException e) {
                    System.out.println("An error occurred while writing Action.txt.");
                    e.printStackTrace();
                }
            } catch (IOException e) {
                System.out.println("Updating resident's prescription error.");
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred while updating prescription to Prescription.txt.");
            e.printStackTrace();
        }
    }
    // Medical staff only
    static String CheckPrescription(String sid, String p2, String rid){
        String buff = "";
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();

        try {
            File myObj = new File("./Archive/Prescription.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String a[] = data.split(",");
                if(a[0].equals(rid)) {
                    buff = buff + data + "\n";
                }
            }
            myReader.close();
            System.out.println(buff);

            // Record action
            try {
                File file = new File("./Archive/Action.txt");
                FileWriter fr = new FileWriter(file, true);
                BufferedWriter br = new BufferedWriter(fr);
                PrintWriter pr = new PrintWriter(br);
                pr.println(dtf.format(now) + "," + p2 + "," + sid + ", Check prescription details.");
                pr.close();
                br.close();
                fr.close();
            } catch (IOException e) {
                System.out.println("An error occurred while writing Action.txt in CheckPrescription.");
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred while reading ResidentList.txt.");
            e.printStackTrace();
        }
        return buff;
    }
    // Nurse only
    static void AttachMedicine(String sid, String p2, String rid, String m){  // Bed id, Medicine statement
        Medicine nm = new Medicine(sid, p2, rid, m);
    }
    // Nurse only
    static void UpdateMedicine(String sid, String p2, String rid, String m){
        String n = "";
        try {
            File myObj = new File("./Archive/Medicine.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                // search for the specific Resident id
                // modify the prescription
                String a[] = data.split(",");
                n = n + a[0] + "," ;
                if (a[0].equals(rid)) {
                    n = n + m + "\n";
                } else {
                    n = n + a[1] + "\n";
                }
            }
            myReader.close();
            try {
                FileWriter fw = new FileWriter("./Archive/Medicine.txt");
                fw.write(n); // 將字串寫到檔案裡
                fw.close();

                // Record in Action.txt
                try {
                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
                    LocalDateTime now = LocalDateTime.now();

                    File file = new File("./Archive/Action.txt");
                    FileWriter fr = new FileWriter(file, true);
                    BufferedWriter br = new BufferedWriter(fr);
                    PrintWriter pr = new PrintWriter(br);
                    pr.println(dtf.format(now) + "," + p2 + "," + sid + ", Update resident's prescription");
                    pr.close();
                    br.close();
                    fr.close();
                } catch (IOException e) {
                    System.out.println("An error occurred while writing Action.txt.");
                    e.printStackTrace();
                }
            } catch (IOException e) {
                System.out.println("Updating resident's prescription error.");
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred while updating prescription to Prescription.txt.");
            e.printStackTrace();
        }
    }
    // Medical staff only
    static String CheckAdministeringMedicine(String sid, String p2, String rid){
        String buff = "";
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();

        try {
            File myObj = new File("./Archive/Medicine.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String a[] = data.split(",");
                if(a[0].equals(rid)) {
                    buff = buff + data + "\n";
                }
            }
            myReader.close();
            System.out.println(buff);

            // Record action
            try {
                File file = new File("./Archive/Action.txt");
                FileWriter fr = new FileWriter(file, true);
                BufferedWriter br = new BufferedWriter(fr);
                PrintWriter pr = new PrintWriter(br);
                pr.println(dtf.format(now) + "," + p2 + "," + sid + ", Check medicine details.");
                pr.close();
                br.close();
                fr.close();
            } catch (IOException e) {
                System.out.println("An error occurred while writing Action.txt in CheckAdministeringMedicine.");
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred while reading ResidentList.txt.");
            e.printStackTrace();
        }
        return buff;

    }


    public static void main(String[] args) {
        // Create action file
        try {
            File myObj = new File("./Archive/Action.txt");
            if (myObj.createNewFile()) {
                //System.out.println("File created: " + myObj.getName());
            } else {
                //System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred while creating DoctorList.txt.");
            e.printStackTrace();
        }

        // MENU
        //Menu menu = new Menu();

        // FUNCTIONS
        /*
        AddManager("1","User","W","1", "000", "000");
        AddDoctor("1","Manager", "D1","1","000", "000");
        AddDoctor("1","Manager", "D2","2","000", "000");
        AddDoctor("1","Manager", "D3","3","000", "000");
        AddDoctor("1","Manager", "D4","4","000", "000");
        AddDoctor("1","Manager", "D5","5","000", "000");
        AddNurse("1","Manager", "N1", "1", "000", "000");
        AddNurse("1","Manager", "N1", "4", "000", "000");

        LocalDate d = LocalDate.of(2021, 1, 2);
        AddResident("1","Manager", "John", "M", "1", d);
        AddNewResidentToBed("1","Nurse", "5", "Ward 1", 1);
        */

        /*
        UpdatePassword("1","Manager", "Doctor", "1", "111");
        UpdatePassword("1","Manager", "Nurse", "4", "123");

        AssignShift("1","Manager", "Doctor","1",3,7,15);
        AssignShift("1","Manager", "Nurse","1",3,7,15);

        UpdateShift("1","Manager", "Doctor", "1",1,1,2);
        UpdateShift("1","Manager", "Nurse", "1",2,3,4);

        MoveResident("1", "Nurse", "1", "Ward 1", "1", "5");
        DischargeResident("1","Manager","1");
        */

        /*
        CheckResidentDetails("1","Manager","1");
        AttachNewPrescription("1","Manager","1", "New prescription");
        UpdatePrescription("1","Manager","1", "Update prescription");

        AttachMedicine("1","Manager","1", "New Medicine");
        UpdateMedicine("1","Manager","1", "Update Medicine");
        CheckPrescription("1","Manager", "1");
        CheckAdministeringMedicine("1","Manager", "1");
        */

        // GUI

    }
}
