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
    private TextField newmanagername;

    @FXML
    private TextField newmanagerpassword;

    @FXML
    private TextField newmanagerphone;

    @FXML
    private Button newmanagerconfirm;

    @FXML
    private Button Cancel;


    @FXML
    void CancelBT(javafx.event.ActionEvent actionEvent) throws IOException {
        MenuForAbleCareHome m = new MenuForAbleCareHome();
        m.ChangeScene("AfterLogIn.fxml");
    }

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

            // Read the last ID for ManagerList, assign new ID for new manager
            String id = "0";
            int id2 = -1;
            File myObj2 = new File("./src/Archive/ManagerList.txt");
            Scanner myReader2 = new Scanner(myObj2);
            while (myReader2.hasNextLine()) {
                String data = myReader2.nextLine();
                String s[] = data.split(",");
                if(!s[0].equals("root")) {
                    id = s[0];
                }
            }
            id2 = Integer.valueOf(id);
            id2 = id2 + 1;

            AbleCareHome a = new AbleCareHome();
            a.AddManager(sid,sp,newmanagername.getText(),String.valueOf(id2),newmanagerphone.getText(),newmanagerpassword.getText());
            MenuForAbleCareHome m = new MenuForAbleCareHome();
            m.ChangeScene("AfterLogIn.fxml");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
