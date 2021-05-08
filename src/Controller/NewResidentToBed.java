package Controller;

import Classes.AbleCareHome;
import GUI.MenuForAbleCareHome;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class NewResidentToBed {

    @FXML
    private TextField newresidenttobedward;

    @FXML
    private TextField newresidenttobedroom;

    @FXML
    private TextField newresidenttobedbed;

    @FXML
    private TextField newresidenttobedid;

    @FXML
    private Button newresidenttobedconfirm;

    @FXML
    void NewResidentToBedConfirm(javafx.event.ActionEvent actionEvent) {
        try {// Read username and position
            File myObj = new File("./src/Archive/LogInData.txt");
            Scanner myReader = new Scanner(myObj);
            String sid = "", sp = "";
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String s[] = data.split(",");
                sid = s[0];
                sp = s[2];
            }
            AbleCareHome a = new AbleCareHome();
            a.AddNewResidentToBed(sid, sp, newresidenttobedward.getText(), newresidenttobedroom.getText(), newresidenttobedbed.getText(), newresidenttobedid.getText());
            MenuForAbleCareHome m = new MenuForAbleCareHome();
            m.ChangeScene("AfterLogIn.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
