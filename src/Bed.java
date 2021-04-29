import java.io.*;
import java.util.Scanner;

public class Bed {
    private int bNum;
    Bed(String rid, String WName, int rn){  // Resident ID, Ward name, Room number
        // (Ward Name, Room Number, Number Of Bed, Resident ID)---Bed.txt
        try {
            File myObj = new File("./Archive/Bed.txt");
            if (myObj.createNewFile()) {
                //System.out.println("File created: " + myObj.getName());

            } else {
                //System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        int c = 0;
        // check if the id exist
        try {
            File myObj = new File("./Archive/Bed.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String a[] = data.split(",");
                if(a[0].equals(WName) && a[1].equals(String.valueOf(rn))){
                    c++;
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        if(c < 4){
            // Resident could be add in vacant bed
            // write file
            try {
                File file = new File("./Archive/Bed.txt");
                FileWriter fr = new FileWriter(file, true);
                BufferedWriter br = new BufferedWriter(fr);
                PrintWriter pr = new PrintWriter(br);
                pr.println(WName + "," + rn + "," + (c+1) + "," + rid);
                pr.close();
                br.close();
                fr.close();
                //System.out.println("Successfully wrote to the file.");
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }
        else{
            System.out.println("The room is not empty.");
        }
    }
}
