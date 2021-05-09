package Controller;

import Classes.AbleCareHome;
import Classes.ShiftException;
import GUI.MenuForAbleCareHome;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class NewUpdateShift {

    @FXML
    private TextField p;

    @FXML
    private TextField id;

    @FXML
    private TextField dow;

    @FXML
    private TextField st;

    @FXML
    private TextField et;

    @FXML
    private Button BT;

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
            a.UpdateShift(sid, sp, p.getText(), id.getText(), dow.getText(), st.getText(), et.getText());
            MenuForAbleCareHome m = new MenuForAbleCareHome();
            m.ChangeScene("AfterLogIn.fxml");
        } catch (IOException | ShiftException e) {
            e.printStackTrace();
        }
    }

}
