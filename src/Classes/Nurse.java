package Classes;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Nurse extends Staff{
    Nurse(String sid, String p2, String n, String id, String p, String pw){
        super(n, id, p, pw);
        // (ID, NAME, PHONE, PASSWORD)---NurseList.txt
        // open NurseList.txt
        // save information
        // create file
        try {
            File myObj = new File("./src/Archive/NurseList.txt");
            myObj.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        int flag1 = 0;
        // check if the id exist
        try {
            File myObj = new File("./src/Archive/NurseList.txt");
            if(myObj.length() == 0){
                flag1 = 0;
            }
            else {
                Scanner myReader = new Scanner(myObj);
                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    // if id is the same with ID
                    // flag = 1
                    String a[] = data.split(",");
                    if (a[0].equals(id)) {
                        flag1 = 1;
                    }
                }
                myReader.close();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        if(flag1 == 0){
            // ID not exist
            // write file
            try {
                File file = new File("./src/Archive/NurseList.txt");
                FileWriter fr = new FileWriter(file, true);
                BufferedWriter br = new BufferedWriter(fr);
                PrintWriter pr = new PrintWriter(br);
                pr.println(id + "," + n + "," + p + "," + pw);
                pr.close();
                br.close();
                fr.close();
                //System.out.println("Successfully wrote to the file.");
            } catch (IOException e) {
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
                pr.println(dtf.format(now) + "," + p2 + "," + sid + ", Add nurse.");
                pr.close();
                br.close();
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else{
            System.out.println("Doctor ID exist.");
        }
    }
}
