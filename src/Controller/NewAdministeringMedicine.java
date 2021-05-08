package Controller;

import Classes.AbleCareHome;
import GUI.MenuForAbleCareHome;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class NewAdministeringMedicine {

    @FXML
    private TextField newadministeringmedicineward;

    @FXML
    private TextField newadministeringmedicinemedicine;

    @FXML
    private TextField newadministeringmedicinebed;

    @FXML
    private TextField newadministeringmedicineroom;

    @FXML
    private Button newadministeringmedicineconfirm;

    @FXML
    void NewAdministeringMedicineConfirm(javafx.event.ActionEvent actionEvent) throws IOException {
        try {// Read username and position
            File myObj = new File("./src/Archive/LogInData.txt");
            Scanner myReader = new Scanner(myObj);
            String sid="",sp="";
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String s[] = data.split(",");
                sid = s[0];
                sp = s[2];
            }
            AbleCareHome a = new AbleCareHome();
            a.AdministeringMedicine(sid,sp,newadministeringmedicineward.getText(),newadministeringmedicineroom.getText(),newadministeringmedicinebed.getText(),newadministeringmedicinemedicine.getText());
            MenuForAbleCareHome m = new MenuForAbleCareHome();
            m.ChangeScene("AfterLogIn.fxml");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
