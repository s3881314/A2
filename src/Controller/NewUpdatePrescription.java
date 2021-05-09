package Controller;

import Classes.AbleCareHome;
import GUI.MenuForAbleCareHome;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class NewUpdatePrescription {

    @FXML
    private TextField Ward;

    @FXML
    private TextField room;

    @FXML
    private TextField bed;

    @FXML
    private TextField prescription;

    @FXML
    private Button bt;

    @FXML
    void ConfirmBT(javafx.event.ActionEvent actionEvent) {
        try {
            // Read username and position
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
            a.UpdatePrescription(sid, sp, Ward.getText(), room.getText(), bed.getText(), prescription.getText());
            MenuForAbleCareHome m = new MenuForAbleCareHome();
            m.ChangeScene("AfterLogIn.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
