import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Prescription {
   // private DateTime dt;
    private int pNo;
    private String reason;

    Prescription(String sid, String p2, String rid, String p){   // Staff ID, position, Resident id, Prescription
        // Create file
        try {
            File myObj = new File("./Archive/Prescription.txt");
            if (myObj.createNewFile()) {
                //System.out.println("File created: " + myObj.getName());
            } else {
                //System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred while creating DoctorList.txt.");
            e.printStackTrace();
        }

        // check if the id exist
        boolean flag = false;
        try {
            File myObj = new File("./Archive/Prescription.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String a[] = data.split(",");
                if(a[0].equals(rid)){ // if ID is the same with ID flag = 1
                    flag = true;
                }
            }
            // if ID exist, attach prescription in Prescription.txt
            if(flag == false){
                // Attach new prescription
                try {
                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
                    LocalDateTime now = LocalDateTime.now();
                    File file = new File("./Archive/Prescription.txt");
                    FileWriter fr = new FileWriter(file, true);
                    BufferedWriter br = new BufferedWriter(fr);
                    PrintWriter pr = new PrintWriter(br);
                    pr.println(rid + "," + p);
                    pr.close();
                    br.close();
                    fr.close();

                    // Record action
                    try {
                        File file2 = new File("./Archive/Action.txt");
                        FileWriter fr2 = new FileWriter(file2, true);
                        BufferedWriter br2 = new BufferedWriter(fr);
                        PrintWriter pr2 = new PrintWriter(br);
                        pr2.println(dtf.format(now) + "," + p2 + "," + sid + ", Attach new prescription.");
                        pr2.close();
                        br2.close();
                        fr2.close();
                    } catch (IOException e) {
                        System.out.println("An error occurred while writing Action.txt in DischargeResident.");
                        e.printStackTrace();
                    }
                } catch (IOException e) {
                    System.out.println("An error occurred while writing Action.txt in DischargeResident.");
                    e.printStackTrace();
                }
            }
            else{
                System.out.println("Resident ID is already exist.");
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred while reading ResidentList.txt.");
            e.printStackTrace();
        }
    }
}
