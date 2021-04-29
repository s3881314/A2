import java.io.*;
import java.time.*;
import java.time.format.*;
import java.util.*;

/*
LocalDateTime ct = LocalDateTime.now();  // get current date time
DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");  // formatting
        String formattedDate = ct.format(myFormatObj);*/

public class Manager extends Staff{
    Manager(String n, String id, String p, String pw){
        super(n, id, p, pw);
        try {
            File myObj = new File("./Archive/ManagerList.txt");
            if (myObj.createNewFile()) {
                //System.out.println("File created: " + myObj.getName());

            } else {
                //System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred while creating ManagerList.txt.");
            e.printStackTrace();
        }
        int flag1 = 0;
        // check if the id exist
        try {
            File myObj = new File("./Archive/ManagerList.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                // if id is the same with ID
                // flag = 1
                String a[] = data.split(",");
                for(int i = 0 ; i < data.length(); i++){
                    if(a[0].equals(id)){
                        flag1 = 1;
                    }
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred while reading ManagerList.txt.");
            e.printStackTrace();
        }

        if(flag1 == 0){
            // ID not exist
            // write file
            try {
                File file = new File("./Archive/ManagerList.txt");
                FileWriter fr = new FileWriter(file, true);
                BufferedWriter br = new BufferedWriter(fr);
                PrintWriter pr = new PrintWriter(br);
                pr.println(id + "," + n + "," + p + "," + pw);
                pr.close();
                br.close();
                fr.close();
                //System.out.println("Successfully wrote to the file.");
            } catch (IOException e) {
                System.out.println("An error occurred while writing ManagerList.txt.");
                e.printStackTrace();
            }
        }
        else{
            System.out.println("Manager ID exist.");
        }
    }

    public void AddDoctor(String n, String id, String p, String pw){
        Doctor ne = new Doctor(n, id, p, pw);
    }

    public void AddNurse(String n, String id, String p, String pw){
        Nurse ne = new Nurse(n, id, p, pw);
    }

    public void AddResident(String n, String g, String id, LocalDate dob){
        Resident ne = new Resident(n, g, id, dob);
    }

    public void AddNewResidentToBed(String rid, String WName, int rn){  // Resident ID, Ward name, Room number
        Bed bed = new Bed(rid, WName, rn);
    }

    public void UpdateDoctorPassword(String id, String np){  // Staff ID, new Password
        String n = "";
        try {
            File myObj = new File("./Archive/DoctorList.txt");
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
                FileWriter fw = new FileWriter("./Archive/DoctorList.txt");
                fw.write(n); // 將字串寫到檔案裡
                fw.close();
            }
            catch (IOException e) {
                System.out.println("Updating Doctor password error.");
                e.printStackTrace();
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred while updating password to DoctorList.txt.");
            e.printStackTrace();
        }
    }

    public void UpdateNursePassword(String id, String np){  // Staff ID, new Password
        String n = "";
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

    public void UpdateDoctorShift(String id){
    }

    public void UpdateNurseShift(String id){
    }

    public void AssignDoctorShift(String id, String sft){

    }
    public void AssignNurseShift(String id, String sft){

    }
    public void UpdateDoctorShift(String id, String sft){

    }
    public void UpdateNurseShift(String id, String sft){

    }
}
