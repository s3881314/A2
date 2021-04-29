import java.io.*;
import java.util.*;
import java.time.*;
import java.text.*;

public class Resident {
    private String Name;
    private String Gender;
    private String ID;
    private LocalDate DateOfBirthday;
    private LocalDate Admitted;
    private LocalDate Discharged = null;

    Resident(String n, String g, String id, LocalDate dob){
        LocalDate ld = LocalDate.now(); // Create a date object
        this.Name = n;
        this.Gender = g;
        this.ID = id;
        this.DateOfBirthday = dob;
        this.Admitted = ld;

        try {
            File myObj = new File("./Archive/ResidentList.txt");
            if (myObj.createNewFile()) {
               // System.out.println("File created: " + myObj.getName());

            } else {
               // System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred while creating ResidentList.txt.");
            e.printStackTrace();
        }
        int flag1 = 0;
        // check if the id exist
        try {
            File myObj = new File("./Archive/ResidentList.txt");
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
            System.out.println("An error occurred while reading ResidentList.txt.");
            e.printStackTrace();
        }

        if(flag1 == 0){
            // ID not exist
            // write file
            try {
                File file = new File("./Archive/ResidentList.txt");
                FileWriter fr = new FileWriter(file, true);
                BufferedWriter br = new BufferedWriter(fr);
                PrintWriter pr = new PrintWriter(br);
                pr.println(id + "," + n + "," + g + "," + dob + "," + ld);  //  ld = Admitted
                pr.close();
                br.close();
                fr.close();
                //System.out.println("Successfully wrote to the file.");
            } catch (IOException e) {
                System.out.println("An error occurred while writing ResidentList.txt.");
                e.printStackTrace();
            }
        }
        else{
            System.out.println("Resident ID exist.");
        }
    }

    // Doctor and Nurse only
    // medical staff is able to check resident's detail
    public void CheckResidentDetail(String id){
        System.out.println("Resident ID: " + this.ID);
        System.out.println("Resident Gender: " + this.Gender);
    }

    // Nurse only
    public void MovingResident(String id1, String id2){ // Resident id, bed id
        // check the status of the bed
        // if it is empty, move resident
        // else print message
    }

    // Doctor only
    // Attach prescription
    public void AttachPrescription(String id, String p){  // Bed id, Prescription

    }

    // Nurse only
    // Administer medication, Updating the details of medicines administered for a resident in the selected bed
    public void UpdateMedicine(String id, String m){  // Bed id, Medicine statement

    }

    // Doctor and Nurse only
    // Check administering medicine
    public void CheckAdministeringMedicine(String id){

    }
}
