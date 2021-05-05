package GUI;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Nurse extends Staff{
    Nurse(String sid, String p2, String n, String id, String p, String pw){
        // (ID, NAME, PHONE, PASSWORD)---NurseList.txt
        super(n, id, p, pw);
        // open DoctorList.txt
        // save information
        // create file
        try {
            File myObj = new File("F:\\Textbook\\MasterOfIT\\COSC1295 Advanced Programming\\Assignment\\Assignment2\\A2_1\\src\\Archive\\NurseList.txt");
            if (myObj.createNewFile()) {
                //System.out.println("File created: " + myObj.getName());

            } else {
               // System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred while creating NurseList.txt.");
            e.printStackTrace();
        }
        int flag1 = 0;
        // check if the id exist
        try {
            File myObj = new File("F:\\Textbook\\MasterOfIT\\COSC1295 Advanced Programming\\Assignment\\Assignment2\\A2_1\\src\\Archive\\NurseList.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                // if id is the same with ID
                // flag = 1
                String a[] = data.split(",");
                if(a[0].equals(id)){
                        flag1 = 1;
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred while reading NurseList.txt.");
            e.printStackTrace();
        }

        if(flag1 == 0){
            // ID not exist
            // write file
            try {
                File file = new File("F:\\Textbook\\MasterOfIT\\COSC1295 Advanced Programming\\Assignment\\Assignment2\\A2_1\\src\\Archive\\NurseList.txt");
                FileWriter fr = new FileWriter(file, true);
                BufferedWriter br = new BufferedWriter(fr);
                PrintWriter pr = new PrintWriter(br);
                pr.println(id + "," + n + "," + p + "," + pw);
                pr.close();
                br.close();
                fr.close();

                // Record in Action.txt
                try {
                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
                    LocalDateTime now = LocalDateTime.now();

                    File file2 = new File("F:\\Textbook\\MasterOfIT\\COSC1295 Advanced Programming\\Assignment\\Assignment2\\A2_1\\src\\Archive\\Action.txt");
                    FileWriter fr2 = new FileWriter(file, true);
                    BufferedWriter br2 = new BufferedWriter(fr);
                    PrintWriter pr2 = new PrintWriter(br);
                    pr2.println(dtf.format(now) + "," + p2 + "," + sid + ", Add nurse.");
                    pr2.close();
                    br2.close();
                    fr2.close();
                } catch (IOException e) {
                    System.out.println("An error occurred while writing Action.txt.");
                    e.printStackTrace();
                }
            } catch (IOException e) {
                System.out.println("An error occurred while writing NurseList.txt.");
                e.printStackTrace();
            }
        }
        else{
            System.out.println("Nurse ID exist.");
        }
    }
}
