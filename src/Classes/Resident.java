package Classes;

import java.io.*;
import java.time.format.DateTimeFormatter;
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

    Resident(String sid, String p2, String n, String g, String id, LocalDate dob){
        try {
            File myObj = new File("./src/Archive/Bed.txt");
            myObj.createNewFile();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        // (Resident ID, NAME, GENDER, Day Of Birth, ADMITTED)---Bed.txt
        LocalDate ld = LocalDate.now(); // Create a date object
        this.Name = n;
        this.Gender = g;
        this.ID = id;
        this.DateOfBirthday = dob;
        this.Admitted = ld;

        try {
            File myObj = new File("./src/Archive/ResidentList.txt");
            myObj.createNewFile();
        } catch (IOException e) {
            System.out.println("An error occurred while creating ResidentList.txt.");
            e.printStackTrace();
        }
        int flag1 = 0;
        // check if the id exist
        try {
            File myObj = new File("./src/Archive/ResidentList.txt");
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
                File file = new File("./src/Archive/ResidentList.txt");
                FileWriter fr = new FileWriter(file, true);
                BufferedWriter br = new BufferedWriter(fr);
                PrintWriter pr = new PrintWriter(br);
                pr.println(id + "," + n + "," + g + "," + dob + "," + ld);  //  ld = Admitted
                pr.close();
                br.close();
                fr.close();
            } catch (IOException e) {
                System.out.println("An error occurred while writing ResidentList.txt.");
                e.printStackTrace();
            }
            // Record in Action.txt
            try {
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
                LocalDateTime now = LocalDateTime.now();

                File file = new File("./src/Archive/Action.txt");
                FileWriter fr = new FileWriter(file, true);
                BufferedWriter br = new BufferedWriter(fr);
                PrintWriter pr = new PrintWriter(br);
                pr.println(dtf.format(now) + "," + p2 + "," + sid + ", Add new resident.");
                pr.close();
                br.close();
                fr.close();
            } catch (IOException e) {
                System.out.println("An error occurred while writing Action.txt.");
                e.printStackTrace();
            }
        }
        else{
            System.out.println("Resident ID exist.");
        }
    }
}
