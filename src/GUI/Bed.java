import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Bed {
    private int bNum;
    Bed(String sid, String p2, String WName, String rn, String b, String rid){  // Resident ID, Ward name, Room number
        // (Ward Name, Room Number, Number Of Bed, Resident ID)---Bed.txt
        try {
            File myObj = new File("./Archive/Bed.txt");
            myObj.createNewFile();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        int c = 0;
        boolean empty = true;
        // check if the id exist
        try {
            File myObj = new File("./Archive/Bed.txt");
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
                File file = new File("./Archive/Bed.txt");
                FileWriter fr = new FileWriter(file, true);
                BufferedWriter br = new BufferedWriter(fr);
                PrintWriter pr = new PrintWriter(br);
                pr.print(WName + "," + rn + "," + b + "," + rid + "\n");
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
                    pr2.println(dtf.format(now) + "," + p2 + "," + sid + ", Add new Resident to bed.");
                    pr2.close();
                    br2.close();
                    fr2.close();
                } catch (IOException e) {
                    System.out.println("An error occurred while writing Action.txt.");
                    e.printStackTrace();
                }
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }
        else{
            System.out.println("The bed is not empty.");
        }
    }
}