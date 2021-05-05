package GUI;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class NewAssignShift {

    @FXML
    private TextField newassignshiftp;

    @FXML
    private TextField newassignshiftid;

    @FXML
    private TextField newassignshiftdow;

    @FXML
    private TextField newassignshiftst;

    @FXML
    private TextField newassignshiftet;

    @FXML
    private Button newassignshiftconfirm;

    @FXML
    void NewAssignShiftConfirm(javafx.event.ActionEvent actionEvent) {
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
            a.AssignShift(sid, sp, newassignshiftp.getText(), newassignshiftid.getText(), newassignshiftdow.getText(), newassignshiftst.getText(),newassignshiftet.getText());
            MenuForAbleCareHome m = new MenuForAbleCareHome();
            m.ChangeScene("AfterLogIn.fxml");
        } catch (IOException | ShiftException e) {
            e.printStackTrace();
        }
    }

}
