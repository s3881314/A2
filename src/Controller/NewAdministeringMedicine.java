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
    private TextField ward;

    @FXML
    private TextField medicine;

    @FXML
    private TextField bed;

    @FXML
    private TextField room;

    @FXML
    private Button ConfirmBT;

    @FXML
    private TextField times;

    @FXML
    private TextField doses;

    @FXML
    void ConfirmBT(javafx.event.ActionEvent actionEvent) throws IOException{
        try {// Read username and position
            File myObj = new File("./src/Archive/LogIn.txt");
            Scanner myReader = new Scanner(myObj);
            String sid="",sp="";
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String s[] = data.split(",");
                sid = s[0];
                sp = s[2];
            }
            AbleCareHome a = new AbleCareHome();
            a.AdministeringMedicine(sid,sp,ward.getText(),room.getText(),bed.getText(),medicine.getText(), doses.getText(), times.getText());
            MenuForAbleCareHome m = new MenuForAbleCareHome();
            m.ChangeScene("AfterLogIn.fxml");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
