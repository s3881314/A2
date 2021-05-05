package GUI;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.awt.event.ActionEvent;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
            File myObj = new File("F:\\Textbook\\MasterOfIT\\COSC1295 Advanced Programming\\Assignment\\Assignment2\\A2_1\\src\\Archive\\LogInData.txt");
            Scanner myReader = new Scanner(myObj);
            String sid="",sp="";
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
