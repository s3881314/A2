import java.io.*;
import java.util.Scanner;

public class Nurse extends Staff{
    Nurse(String n, String id, String p, String pw){
        // (ID, NAME, PHONE, PASSWORD)---NurseList.txt
        super(n, id, p, pw);
        // open DoctorList.txt
        // save information
        // create file
        try {
            File myObj = new File("./Archive/NurseList.txt");
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
            File myObj = new File("./Archive/NurseList.txt");
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
                File file = new File("./Archive/NurseList.txt");
                FileWriter fr = new FileWriter(file, true);
                BufferedWriter br = new BufferedWriter(fr);
                PrintWriter pr = new PrintWriter(br);
                pr.println(id + "," + n + "," + p + "," + pw);
                pr.close();
                br.close();
                fr.close();
                //System.out.println("Successfully wrote to the file.");
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
