import java.io.*;
import java.util.*;
import java.time.*;
import java.time.format.*;

public class Doctor extends Staff{
    Doctor(String sid, String p2, String n, String id, String p, String pw){
        super(n, id, p, pw);
        // (ID, NAME, PHONE, PASSWORD)---DoctorList.txt
        // open DoctorList.txt
        // save information
        // create file
        try {
            File myObj = new File("./Archive/DoctorList.txt");
            if (myObj.createNewFile()) {
                //System.out.println("File created: " + myObj.getName());

            } else {
                //System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred while creating DoctorList.txt.");
            e.printStackTrace();
        }
        int flag1 = 0;
        // check if the id exist
        try {
            File myObj = new File("./Archive/DoctorList.txt");
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
            System.out.println("An error occurred while reading DoctorList.txt.");
            e.printStackTrace();
        }

        if(flag1 == 0){
            // ID not exist
            // write file
            try {
                File file = new File("./Archive/DoctorList.txt");
                FileWriter fr = new FileWriter(file, true);
                BufferedWriter br = new BufferedWriter(fr);
                PrintWriter pr = new PrintWriter(br);
                pr.println(id + "," + n + "," + p + "," + pw);
                pr.close();
                br.close();
                fr.close();
                //System.out.println("Successfully wrote to the file.");
            } catch (IOException e) {
                System.out.println("An error occurred while writing DoctorList.txt.");
                e.printStackTrace();
            }
            // Record in Action.txt
            try {
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
                LocalDateTime now = LocalDateTime.now();

                File file = new File("./Archive/Action.txt");
                FileWriter fr = new FileWriter(file, true);
                BufferedWriter br = new BufferedWriter(fr);
                PrintWriter pr = new PrintWriter(br);
                pr.println(dtf.format(now) + "," + p2 + "," + sid + ", Add doctor.");
                pr.close();
                br.close();
                fr.close();
            } catch (IOException e) {
                System.out.println("An error occurred while writing Action.txt.");
                e.printStackTrace();
            }
        }
        else{
            System.out.println("Doctor ID exist.");
        }
    }

}
