package Controller;

import Classes.AbleCareHome;
import GUI.MenuForAbleCareHome;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.*;
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
    private Button Cancel;

    @FXML
    void CancelBT(javafx.event.ActionEvent actionEvent) throws IOException {
        MenuForAbleCareHome m = new MenuForAbleCareHome();
        m.ChangeScene("AfterLogIn.fxml");
    }


    @FXML
    void ReadAdministeringMedicineConfirm(javafx.event.ActionEvent actionEvent) {
        String b="";
        try {// Read username and position
            File myObj = new File("./src/Archive/LogIn.txt");
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
            String s[] = b.split(",");
            String s2[] = s[1].split("-");
            String ns = s[0] + ", Medicine:" + s2[0] + " Doses:" + s2[1] + " Times:" + s2[2];
            try {
                FileWriter fileWriter =new FileWriter("./src/Archive/DisplayAdministeringMedicine.txt");
                fileWriter.write(ns);
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
