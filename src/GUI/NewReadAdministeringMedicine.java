package GUI;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.awt.event.ActionEvent;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class NewReadAdministeringMedicine {

    @FXML
    private TextField readadministeringmedicineward;

    @FXML
    private TextField readadministeringmedicineroom;

    @FXML
    private TextField readadministeringmedicinebed;

    @FXML
    private Button readadministeringmedicineconfirm;

    @FXML
    void ReadAdministeringMedicineConfirm(javafx.event.ActionEvent actionEvent) {
        String b="";
        try {// Read username and position
            File myObj = new File("F:\\Textbook\\MasterOfIT\\COSC1295 Advanced Programming\\Assignment\\Assignment2\\A2_1\\src\\Archive\\LogInData.txt");
            Scanner myReader = new Scanner(myObj);
            String sid = "", sp = "";
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String s[] = data.split(",");
                sid = s[0];
                sp = s[2];
            }

            AbleCareHome a = new AbleCareHome();
            b = a.ReadAdministeringMedicine(sid, sp, readadministeringmedicineward.getText(), readadministeringmedicineroom.getText(), readadministeringmedicinebed.getText());
            try {
                FileWriter fileWriter =new FileWriter("./Archive/DisplayAdministeringMedicine.txt");
                fileWriter.write(b);
                fileWriter.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            MenuForAbleCareHome m = new MenuForAbleCareHome();
            m.ChangeScene("DisplayAdministeringMedicine.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
