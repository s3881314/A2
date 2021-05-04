// each action should be noted with day+time and id of staff member
// exception should be raised if staff is not authorized to do the action or is not rostered in for that day+time
// 2 wards and 6 rooms, each room has 1 to 4 beds

import java.io.*;
import java.time.LocalDate;
import java.util.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class AbleCareHome {
    // Manager only
    void AddManager(String sid, String p2, String n, String id, String p, String pw){
        Manager m = new Manager(sid,p2, n,id, p, pw);
    }
    // Manager only
    void AddDoctor(String sid, String p2, String n, String id, String p, String pw){
        Doctor ne = new Doctor(sid, p2, n, id, p, pw);
    }
    // Manager only
    void AddNurse(String sid, String p2, String n, String id, String p, String pw){
        Nurse ne = new Nurse(sid, p2, n, id, p, pw);
    }

    void AddResident(String sid, String p2, String n, String g, String id, LocalDate dob){
        Resident ne = new Resident(sid, p2, n, g, id, dob);
    }

    void AddNewResidentToBed(String sid, String p2, String ward, String room, String bed, String rid){  // Resident ID, Ward name, Room number
        try {
            // check if the id exist in Bed.txt
            boolean flag = false;
            File myObj = new File("./Archive/Bed.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String a[] = data.split(",");
                if (a[3].equals(rid)) {
                    flag = true;
                }
            }
            if(flag == false){
                Bed nbed = new Bed(sid, p2, ward, room, bed, rid);
            }
            else{
                System.out.println("Resident exist. Please use MoveResident function.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading Bed.txt in ReadResidentDetails.");
            e.printStackTrace();
        }

    }
    // Manager only
    void UpdatePassword(String sid, String p2, String p, String id, String np){  // Staff ID, new Password
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

    void AssignShift(String sid, String p2, String p, String id, String dow, String st, String et) throws ShiftException {
        // Position, id, give 24hr time
        if(checkComplience(p, dow, st, et)){
            boolean flag = false;
            if(p.equals("Doctor")) {
                try {
                    File myObj = new File("./Archive/DoctorShift.txt");
                    Scanner myReader = new Scanner(myObj);
                    while (myReader.hasNextLine()) {
                        String data = myReader.nextLine();
                        String a[] = data.split(",");
                        if (a[0].equals(id) && a[1].equals(dow) && a[2].equals(st) && a[3].equals(et)) {
                            flag = true;
                        }
                    }
                } catch (FileNotFoundException e) {
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
                        if (a[0].equals(id) && a[1].equals(dow) && a[2].equals(st) && a[3].equals(et)) {
                            flag = true;
                        }
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
            if(flag == false) {
                Shift ne = new Shift(sid, p2, p, id, dow, st, et);
            }
            else{
                System.out.println("Shift exist");
            }
        }
        else{
            throw new ShiftException();
        }
    }

    // error: I can't overwrite the file. The old data is not able to be deleted.
    void UpdateShift(String sid, String p2, String p, String id, String dow, String st, String et) throws ShiftException {
        if(checkComplience(p,dow,st,et)) {
            if (p.equals("Doctor")) {
                boolean exist = false;
                try {
                    File myObj = new File("./Archive/DoctorShift.txt");
                    Scanner myReader = new Scanner(myObj);
                    while (myReader.hasNextLine()) {
                        String data = myReader.nextLine();
                        String a[] = data.split(",");
                        if (a[0].equals(id) && a[1].equals(dow) && a[2].equals(st) && a[3].equals(et)) {
                            exist = true;
                        }
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

                if(exist == false) {
                    String n = "";
                    try {
                        File myObj = new File("./Archive/DoctorShift.txt");
                        Scanner myReader = new Scanner(myObj);
                        while (myReader.hasNextLine()) {
                            String data = myReader.nextLine();
                            String a[] = data.split(",");
                            if (a[0].equals(id)) {
                                n = n + id + "," + dow + "," + st + "," + et + "\n";
                            } else {
                                n = n + data + "\n";
                            }
                        }
                        try {
                            FileWriter fileWriter =new FileWriter("./Archive/DoctorShift.txt");
                            fileWriter.write(n);
                            fileWriter.close();


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
                        } catch (IOException e) {
                            System.out.println("Updating Doctor shift error.");
                            e.printStackTrace();
                        }
                        myReader.close();
                    } catch (FileNotFoundException e) {
                        System.out.println("An error occurred while updating shift to Doctorshift.txt.");
                        e.printStackTrace();
                    }
                }
                else{
                    System.out.println("Doctor shift exist.");
                }
            } else if (p.equals("Nurse")) {
                boolean exist = false;
                try {
                    File myObj = new File("./Archive/NurseShift.txt");
                    Scanner myReader = new Scanner(myObj);
                    while (myReader.hasNextLine()) {
                        String data = myReader.nextLine();
                        String a[] = data.split(",");
                        if (a[0].equals(id) && a[1].equals(dow) && a[2].equals(st) && a[3].equals(et)) {
                            exist = true;
                        }
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                if(exist == false) {
                    try {
                        String n = "";
                        File myObj = new File("./Archive/NurseShift.txt");
                        Scanner myReader = new Scanner(myObj);
                        while (myReader.hasNextLine()) {
                            String data = myReader.nextLine();
                            String a[] = data.split(",");
                            if (a[0].equals(id)) {
                                n = n + id + "," + dow + "," + st + "," + et + "\n";
                            } else {
                                n = n + data + "\n";
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
                        } catch (IOException e) {
                            System.out.println("Updating Nurse shift error.");
                            e.printStackTrace();
                        }
                        myReader.close();
                    } catch (FileNotFoundException e) {
                        System.out.println("An error occurred while updating shift to NurseList.txt.");
                        e.printStackTrace();
                    }
                }
                else{
                    System.out.println("Nurse shift exist");
                }
            }
        }
        else{
            throw new ShiftException();
        }
    }
    boolean checkComplience(String p, String dow, String st, String et) throws ShiftException {
        int ndow,nst,net;
        ndow = Integer.parseInt(dow);
        nst = Integer.parseInt(st);
        net = Integer.parseInt(et);
        if(p.equals(("Doctor"))){
            if(nst< 8 || net > 22 || (net-nst) != 1 || ndow < 1 || ndow > 7){  // Assign 1 hour for doctor to write prescription
                return false;
            }
            else{
                return true;
            }
        }
        else if(p.equals("Nurse")) {
            if (nst < 8 || net > 22 || !((nst == 8 && net == 16) || (nst == 14 && net == 22)) || ndow < 1 || ndow > 7) {  // Assign 1 hour for doctor to write prescription
                return false;
            } else {
                return true;
            }
        }
        else{
            System.out.println("Wrong position");
            return false;
        }
    }

    // Nurse only
    void MoveResident(String sid, String p2, String w, String r, String b, String rid){
        // Staff position, Staff ID, Resident ID, Ward Name, Room, Bed
        // Check the status of bed to be empty
        boolean empty = true;
        try {
            File myObj = new File("./Archive/Bed.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String a[] = data.split(",");
                if (a[0].equals(w) && a[1].equals(String.valueOf(r)) && a[2].equals(b)) {
                    empty = false;
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        if(empty == true){
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

    void DischargeResident(String sid, String p2, String rid){
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
                if(a[0].equals(rid) && a.length == 5){  // if the resident hasn't benn discharged
                    flag = 1;
                    buff = buff + "," + dtf.format(now)+  "\n";
                }
                else{
                    buff = buff + "\n";
                }
            }
            if(flag == 1){
                // Replace old resident data
                try {
                    FileWriter myWriter = new FileWriter("./Archive/ResidentList.txt");
                    myWriter.write(buff);
                    myWriter.close();
                } catch (IOException e) {
                    System.out.println("An error occurred while writing ResidentList.txt.");
                    e.printStackTrace();
                }
                // delete old bed data
                buff ="";
                File myObj2 = new File("./Archive/Bed.txt");
                Scanner myReader2 = new Scanner(myObj2);
                while (myReader2.hasNextLine()) {
                    String data = myReader2.nextLine();
                    String a[] = data.split(",");
                    if(!a[3].equals(rid)){ // if ID is the same with ID flag = 1
                        buff = buff + data + "\n";
                    }
                }
                try {
                    FileWriter myWriter = new FileWriter("./Archive/Bed.txt");
                    myWriter.write(buff);
                    myWriter.close();
                } catch (IOException e) {
                    System.out.println("An error occurred while writing Bed.txt.");
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

    String ReadResidentDetails(String sid, String p2, String ward, String room, String bed){
        String rid ="";
        // get resident id via bed
        try {
            // check if the id exist in Prescription.txt
            boolean flag = false;
            File myObj = new File("./Archive/Bed.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String a[] = data.split(",");
                if (a[0].equals(ward) && a[1].equals(room) && a[2].equals(bed)) {
                    rid = a[3];
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading Bed.txt in ReadResidentDetails.");
            e.printStackTrace();
        }

        String buff = "";
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();

        try {
            File myObj = new File("./Archive/ResidentList.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String a[] = data.split(",");
                if (!a[3].equals(rid)) {  // Use Resident ID to skip the original bed data
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
    // error: skip the first line while reading Bed.txt
    void AttachNewPrescription(String sid, String p2, String ward, String room, String bed, String p){
        try {
            File myObj = new File("./Archive/Prescription.txt");
            myObj.createNewFile();
        } catch (IOException e) {
            System.out.println("An error occurred while creating Prescription.txt.");
            e.printStackTrace();
        }

        String rid ="";
        // get resident id via bed
        try {
            File myObj = new File("./Archive/Bed.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String a[] = data.split(",");
                if (a[0].equals(ward) && a[1].equals(room) && a[2].equals(bed)) {
                    rid = a[3];
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading Bed.txt in ReadAdministeringMedicine.");
            e.printStackTrace();
        }
        if(!rid.equals("")) {
            Prescription pre = new Prescription(sid, p2, rid, p);
        }
        else{
            System.out.println("The bed is empty.");
        }
    }
    // Doctor only
    // error: Only read first line while reading Bed.txt
    void UpdatePrescription(String sid, String p2, String ward, String room, String bed, String p) {
        String rid="";
        // get resident id via bed
        try {
            File myObj = new File("./Archive/Bed.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String a[] = data.split(",");
                if (a[0].equals(ward) && a[1].equals(room) && a[2].equals(bed)) {
                    rid = a[3];
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        String n = "";
        try {
            File myObj = new File("./Archive/Prescription.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                // search for the specific Resident id
                // modify the prescription
                String a[] = data.split(",");
                if (a[0].equals(rid)) {
                    n = n + a[0] +"," +  p + "\n";
                } else {
                    n = n + data + "\n";
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
    String ReadPrescription(String sid, String p2, String ward, String room, String bed){
        String rid="";
        // get resident id via bed
        try {
            // check if the id exist in Prescription.txt
            boolean flag = false;
            File myObj = new File("./Archive/Bed.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String a[] = data.split(",");
                if (a[0].equals(ward) && a[1].equals(room) && a[2].equals(bed)) {
                    rid = a[3];
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading Bed.txt in ReadPrescription.");
            e.printStackTrace();
        }

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
                System.out.println("An error occurred while writing Action.txt in ReadPrescription.");
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred while reading ResidentList.txt.");
            e.printStackTrace();
        }
        return buff;
    }

    // Nurse only
    void AdministeringMedicine(String sid, String p2, String ward, String room, String bed, String m){
        String rid="";
        // get resident id via bed
        try {
            File myObj = new File("./Archive/Bed.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String a[] = data.split(",");
                if (a[0].equals(ward) && a[1].equals(room) && a[2].equals(bed)) {
                    rid = a[3];
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading Bed.txt in ReadAdministeringMedicine.");
            e.printStackTrace();
        }

        if(checkMedicineWithPrescription(rid, m)) {
            Medicine nm = new Medicine(sid, p2, rid, m);
        }
        else{
            System.out.println("It has some medicines which is not listed in prescription.");
        }
    }
    boolean checkMedicineWithPrescription(String rid, String m){
        try {
            String b[] = m.split(",");

            File myObj = new File("./Archive/Prescription.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                boolean flag = false;
                String data = myReader.nextLine();
                String a[] = data.split(",");
                if(a[0].equals(rid)) {
                    for (int i = 0; i < b.length; i++) {
                        flag = false;
                        for(int j = 1; j < a.length; j++){
                            if(b[i].equals(a[j])){
                                flag = true;
                            }
                        }
                        if(flag == false){
                            return flag;
                        }
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading Prescription.txt in checkMedicineWithPrescription.");
            e.printStackTrace();
        }
        return true;
    }
    // Medical staff only
    String ReadAdministeringMedicine(String sid, String p2, String ward, String room, String bed){
        String rid="";
        // get resident id via bed
        try {
            // check if the id exist in Prescription.txt
            boolean flag = false;
            File myObj = new File("./Archive/Bed.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String a[] = data.split(",");
                if (a[0].equals(ward) && a[1].equals(room) && a[2].equals(bed)) {
                    rid = a[3];
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading Bed.txt in ReadAdministeringMedicine.");
            e.printStackTrace();
        }

        String buff = "";
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();

        try {
            File myObj = new File("./Archive/AdministeringMedicine.txt");
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
                System.out.println("An error occurred while writing Action.txt in ReadAdministeringMedicine.");
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred while reading ResidentList.txt.");
            e.printStackTrace();
        }
        return buff;

    }
}
