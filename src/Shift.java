import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Shift{
    private int DayOfWeek;
    private int StartTime;
    private int EndTime;

    Shift(String sid, String p2, String p, String id, int dow, int st, int et){  // position(doctor/nurse), id
        // (ID, Day Of Week, Start Time, End Time)---DoctorShift.txt
        // (ID, Day Of Week, Start Time, End Time)---NurseShift.txt
        this.DayOfWeek = dow;
        this.StartTime = st;
        this.EndTime = et;

        if(p.equals("Doctor")) {
            try {
                File myObj = new File("./Archive/DoctorShift.txt");
                if (myObj.createNewFile()) {
                    //System.out.println("File created: " + myObj.getName());

                } else {
                    //System.out.println("File already exists.");
                }
            } catch (IOException e) {
                System.out.println("An error occurred while creating DoctorShift.txt.");
                e.printStackTrace();
            }
            try {
                File myObj = new File("./Archive/DoctorShift.txt");
                Scanner myReader = new Scanner(myObj);
                int FlagExistShift = 0;
                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    String a[] = data.split(",");
                    if(a[1].equals(String.valueOf(dow)) && a[2].equals(String.valueOf(st)) && a[3].equals(String.valueOf(et))){
                        FlagExistShift = 1;
                        break;
                    }
                }
                if(FlagExistShift == 1){
                    System.out.println("Shift exist.");
                }
                else {
                    try {
                        File file = new File("./Archive/DoctorShift.txt");
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

                            File file2 = new File("./Archive/Action.txt");
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
                myReader.close();
            } catch (FileNotFoundException e) {
                System.out.println("An error occurred while assign shift to DoctorShift.txt.");
                e.printStackTrace();
            }
        }
        else if(p.equals("Nurse")){
            try {
                File myObj = new File("./Archive/NurseShift.txt");
                if (myObj.createNewFile()) {
                    //System.out.println("File created: " + myObj.getName());

                } else {
                    //System.out.println("File already exists.");
                }
            } catch (IOException e) {
                System.out.println("An error occurred while creating NurseShift.txt.");
                e.printStackTrace();
            }
            try {
                File myObj = new File("./Archive/NurseShift.txt");
                Scanner myReader = new Scanner(myObj);
                int FlatExistShift = 0;
                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    String a[] = data.split(",");
                    if(a[1].equals(String.valueOf(dow)) && a[2].equals(String.valueOf(st)) && a[3].equals(String.valueOf(et))){
                        FlatExistShift = 1;
                        break;
                    }
                }
                if(FlatExistShift == 1){
                    System.out.println("Shift exist.");
                }
                else {
                    try {
                        File file = new File("./Archive/NurseShift.txt");
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

                            File file2 = new File("./Archive/Action.txt");
                            FileWriter fr2 = new FileWriter(file, true);
                            BufferedWriter br2 = new BufferedWriter(fr);
                            PrintWriter pr2 = new PrintWriter(br);
                            pr2.println(dtf.format(now) + "," + p2 + "," + sid + ", Assign nurse shift");
                            pr2.close();
                            br2.close();
                            fr2.close();
                        } catch (IOException e) {
                            System.out.println("An error occurred while writing Action.txt.");
                            e.printStackTrace();
                        }
                    } catch (IOException e) {
                        System.out.println("An error occurred while writing NurseShift.txt.");
                        e.printStackTrace();
                    }
                }
                myReader.close();
            } catch (FileNotFoundException e) {
                System.out.println("An error occurred while assign shift to NurseShift.txt.");
                e.printStackTrace();
            }
        }
    }
}
