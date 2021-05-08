package Classes;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Shift{
    private int DayOfWeek;
    private int StartTime;
    private int EndTime;

    Shift(String sid, String p2, String p, String id, String dow, String st, String et) throws ShiftException{  // position(doctor/nurse), id
        // (ID, Day Of Week, Start Time, End Time)---DoctorShift.txt
        // (ID, Day Of Week, Start Time, End Time)---NurseShift.txt
        this.DayOfWeek = Integer.parseInt(dow);
        this.StartTime = Integer.parseInt(st);
        this.EndTime = Integer.parseInt(et);

        if(p.equals("Doctor")) {
            try {
                File myObj = new File("./src/Archive/DoctorShift.txt");
                myObj.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }

            // Check the exist shift
            boolean flag = false;
            try {
                File myObj = new File("./src/Archive/DoctorShift.txt");
                if(!(myObj.length() == 0)) {
                    Scanner myReader = new Scanner(myObj);
                    while (myReader.hasNextLine()) {
                        String data = myReader.nextLine();
                        String a[] = data.split(",");
                        if (a[0].equals(id) && a[1].equals(dow) && a[2].equals(st) && a[3].equals(et)) {
                            flag = true;
                        }
                    }
                    myReader.close();
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            if(flag == false) {
                try {
                    File file = new File("./src/Archive/DoctorShift.txt");
                    FileWriter fr = new FileWriter(file, true);
                    BufferedWriter br = new BufferedWriter(fr);
                    PrintWriter pr = new PrintWriter(br);
                    pr.println(id + "," + dow + "," + st + "," + et);
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
                        pr2.println(dtf.format(now) + "," + p2 + "," + sid + ", Assign doctor shift");
                        pr2.close();
                        br2.close();
                        fr2.close();
                    } catch (IOException e) {
                        System.out.println("An error occurred while writing Action.txt.");
                        e.printStackTrace();
                    }
                } catch (IOException e) {
                    System.out.println("An error occurred while writing DoctorList.txt.");
                    e.printStackTrace();
                }
            }
            else{
                System.out.println("Doctor shift exist");
            }
        }
        else if(p.equals("Nurse")) {
            try {
                File myObj = new File("./src/Archive/NurseShift.txt");
                myObj.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }

            // Check the exist shift
            boolean flag = false;
            try {
                File myObj = new File("./src/Archive/NurseShift.txt");
                if(!(myObj.length() == 0)) {
                    Scanner myReader = new Scanner(myObj);
                    while (myReader.hasNextLine()) {
                        String data = myReader.nextLine();
                        String a[] = data.split(",");
                        if (a[0].equals(id) && a[1].equals(dow) && a[2].equals(st) && a[3].equals(et)) {
                            flag = true;
                        }
                    }
                    myReader.close();
                }
            } catch (FileNotFoundException e) {
               e.printStackTrace();
            }
            if (flag == false) {
                try {
                    File file = new File("./src/Archive/NurseShift.txt");
                    FileWriter fr = new FileWriter(file, true);
                    BufferedWriter br = new BufferedWriter(fr);
                    PrintWriter pr = new PrintWriter(br);
                    pr.println(id + "," + dow + "," + st + "," + et);
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
                        pr2.println(dtf.format(now) + "," + p2 + "," + sid + ", Assign nurse shift");
                        pr2.close();
                        br2.close();
                        fr2.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Nurse shift exist");
            }
        }
    }
}
