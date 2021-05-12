package Classes;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Prescription {
   // private DateTime dt;
    private int pNo;
    private String reason;

    Prescription(String sid, String p2, String rid, String p){   // Staff ID, position, Resident id, Prescription
        // check if the id exist
        boolean exist = false;
        try {
            File myObj = new File("./src/Archive/Prescription.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String a[] = data.split(",");
                if(a[0].equals(rid)){
                    exist = true;
                }
            }

            if(exist == false) {
                // Attach new prescription
                try {
                    File file = new File("./src/Archive/Prescription.txt");
                    FileWriter fr = new FileWriter(file, true);
                    BufferedWriter br = new BufferedWriter(fr);
                    PrintWriter pr = new PrintWriter(br);
                    pr.println(rid + "," + p);
                    pr.close();
                    br.close();
                    fr.close();

                    // Record in Action.txt
                    try {
                        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
                        LocalDateTime now = LocalDateTime.now();

                        File file2 = new File("./src/Archive/Action.txt");
                        FileWriter fr2 = new FileWriter(file, true);
                        BufferedWriter br2 = new BufferedWriter(fr);
                        PrintWriter pr2 = new PrintWriter(br);
                        pr2.println(dtf.format(now) + "," + p2 + "," + sid + ", Attach prescription.");
                        pr2.close();
                        br2.close();
                        fr2.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else{
                System.out.println("Resident ID and Prescription are already exist.");
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
