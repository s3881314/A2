package Controller;

import Classes.AbleCareHome;
import GUI.MenuForAbleCareHome;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.*;
import java.util.Scanner;

public class NewManager {

    @FXML
    private TextField newmanagerid;

    @FXML
    private TextField newmanagername;

    @FXML
    private TextField newmanagerpassword;

    @FXML
    private TextField newmanagerphone;

    @FXML
    private Button newmanagerconfirm;

    @FXML
    void NewManageConfirm(javafx.event.ActionEvent actionEvent) throws IOException {
        try {// Read username and position
            String sid="", sp="";
            File myObj = new File("./src/Archive/LogIn.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String s[] = data.split(",");
                sid = s[0];
                sp = s[2];
            }
            AbleCareHome a = new AbleCareHome();
            a.AddManager(sid,sp,newmanagername.getText(),newmanagerid.getText(),newmanagerphone.getText(),newmanagerpassword.getText());
            MenuForAbleCareHome m = new MenuForAbleCareHome();
            m.ChangeScene("AfterLogIn.fxml");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
