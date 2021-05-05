package GUI;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Medicine {
    private String Name;
    private int doseAmt;
    private String doseUnit;

    Medicine(String sid, String p2, String rid, String m) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        // Create file
        try {
            File myObj = new File("./Archive/AdministeringMedicine.txt");
            myObj.createNewFile();
        } catch (IOException e) {
            System.out.println("An error occurred while creating AdministeringMedicine.txt.");
            e.printStackTrace();
        }

        try {
            // check if the id exist in Prescription.txt
            boolean flag = false;
            File myObj = new File("./Archive/Prescription.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String a[] = data.split(",");
                if (a[0].equals(rid)) { // if ID is the same with ID flag = 1
                    flag = true;
                }
            }
            // if ID is exist, attach medicine in AdministeringMedicine.txt
            if (flag == true) {
                // Attach new medicine
                // if the resident has old medicine, update it
                try{
                    String n = "";
                    boolean flag2 = false;

                    File myObj2 = new File("./Archive/AdministeringMedicine.txt");
                    Scanner myReader2 = new Scanner(myObj2);
                    while (myReader2.hasNextLine()) {
                        String data = myReader2.nextLine();
                        String a[] = data.split(",");
                        String b[] = m.split(",");
                        n = n + data;
                        if (a[0].equals(rid)) { // if ID is the same with ID flag = 1
                            flag2 = true;
                            // match the new medicine data with old medicine data
                            for(int i = 1; i < b.length; i++){
                                flag = false;
                                for(int j = i; j < a.length; j++){
                                    if(b[i].equals(a[j])){
                                        flag = true;
                                    }
                                }
                                if(flag == false){
                                    n = n + b[i] + ",";
                                }
                            }
                            n = n + "\n";
                        }
                        else{
                            n = n + data + "\n";
                        }
                    }
                    // if it has old medicine data
                    if(flag2 == true) {
                        // Update old data
                        FileWriter fw = new FileWriter("./Archive/AdministeringMedicine.txt");
                        fw.write(n); // 將字串寫到檔案裡
                        fw.close();
                    }
                    // create new administering medicine data
                    else{
                        File file = new File("./Archive/AdministeringMedicine.txt");
                        FileWriter fr = new FileWriter(file, true);
                        BufferedWriter br = new BufferedWriter(fr);
                        PrintWriter pr = new PrintWriter(br);
                        pr.println(rid + "," + m + ",");
                        pr.close();
                        br.close();
                        fr.close();
                    }
                    // Record action
                    try {

                        File file2 = new File("./Archive/Action.txt");
                        FileWriter fr2 = new FileWriter(file2, true);
                        BufferedWriter br2 = new BufferedWriter(fr2);
                        PrintWriter pr2 = new PrintWriter(br2);
                        pr2.println(dtf.format(now) + "," + p2 + "," + sid + ", Administering medicine.");
                        pr2.close();
                        br2.close();
                        fr2.close();
                    } catch (IOException e) {
                        System.out.println("An error occurred while writing Action.txt in AdministeringMedicine.");
                        e.printStackTrace();
                    }
                } catch (IOException e) {
                    System.out.println("An error occurred while reading AdministeringMedicine.txt.");
                    e.printStackTrace();
                }
            } else {
                System.out.println("Resident ID is not exist.");
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred while reading AdministeringMedicine.txt.");
            e.printStackTrace();
        }
    }
}
