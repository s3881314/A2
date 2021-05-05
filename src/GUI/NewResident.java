package GUI;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class NewResident {

    @FXML
    private TextField newresidentname;

    @FXML
    private TextField newresidentdob;

    @FXML
    private TextField newresidentid;

    @FXML
    private TextField newresidentgender;

    @FXML
    private Button newresidentconfirm;

    @FXML
    void NewResidentConfirm(javafx.event.ActionEvent actionEvent) {
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
            a.AddResident(sid, sp, newresidentname.getText(), newresidentgender.getText(), newresidentid.getText(), newresidentdob.getText());
            MenuForAbleCareHome m = new MenuForAbleCareHome();
            m.ChangeScene("AfterLogIn.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
