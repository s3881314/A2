package Classes;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Bed {
    private int bNum;
    Bed(String sid, String p2, String WName, String rn, String b, String rid, String gender){  // Resident ID, Ward name, Room number, Resident ID, gender
        // (Ward Name, Room Number, Number Of Bed, Resident ID)---Bed.txt
        try {
            File myObj = new File("./src/Archive/Bed.txt");
            myObj.createNewFile();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        int c = 0;
        boolean empty = true;
        // check if the id exist
        try {
            File myObj = new File("./src/Archive/Bed.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String a[] = data.split(",");
                if(a[0].equals(WName) && a[1].equals(rn) && a[2].equals(b)){
                    empty = false;
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        if(empty == true){
            // Resident could be add in vacant bed
            // write file
            try {
                File file = new File("./src/Archive/Bed.txt");
                FileWriter fr = new FileWriter(file, true);
                BufferedWriter br = new BufferedWriter(fr);
                PrintWriter pr = new PrintWriter(br);
                pr.print(WName + "," + rn + "," + b + "," + rid + "," + gender + "\n");
                pr.close();
                br.close();
                fr.close();
            } catch (IOException e) {
                System.out.println("An error occurred.");
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
                pr.println(dtf.format(now) + "," + p2 + "," + sid + ", Add new resident to bed.");
                pr.close();
                br.close();
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else{
            System.out.println("The bed is not empty.");
        }
    }
}
