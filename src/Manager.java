import java.io.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

/*
LocalDateTime ct = LocalDateTime.now();  // get current date time
DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");  // formatting
        String formattedDate = ct.format(myFormatObj);*/

public class Manager extends Staff{
    Manager(String sid, String p2, String n, String id, String p, String pw){
        // (ID, NAME, PHONE, PASSWORD)---ManagerList.txt
        super(n, id, p, pw);
        try {
            File myObj = new File("./Archive/ManagerList.txt");
            if (myObj.createNewFile()) {
                //System.out.println("File created: " + myObj.getName());

            } else {
                //System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred while creating ManagerList.txt.");
            e.printStackTrace();
        }
        int flag1 = 0;
        // check if the id exist
        try {
            File myObj = new File("./Archive/ManagerList.txt");
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
            System.out.println("An error occurred while reading ManagerList.txt.");
            e.printStackTrace();
        }

        if(flag1 == 0){
            // ID not exist
            // write file
            try {
                File file = new File("./Archive/ManagerList.txt");
                FileWriter fr = new FileWriter(file, true);
                BufferedWriter br = new BufferedWriter(fr);
                PrintWriter pr = new PrintWriter(br);
                pr.println(id + "," + n + "," + p + "," + pw);
                pr.close();
                br.close();
                fr.close();
                //System.out.println("Successfully wrote to the file.");
            } catch (IOException e) {
                System.out.println("An error occurred while writing ManagerList.txt.");
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
                pr.println(dtf.format(now) + "," + p2 + "," + sid + ", Add new manager.");
                pr.close();
                br.close();
                fr.close();
            } catch (IOException e) {
                System.out.println("An error occurred while writing Action.txt.");
                e.printStackTrace();
            }
        }
        else{
            System.out.println("Manager ID exist.");
        }
    }
}
