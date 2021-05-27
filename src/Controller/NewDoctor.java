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

public class NewDoctor {

    @FXML
    private TextField newdoctorname;

    @FXML
    private TextField newdoctorpassword;

    @FXML
    private TextField newdoctorphone;

    @FXML
    private Button newdoctorconfirm;

    @FXML
    private Button Cancel;

    @FXML
    void CancelBT(javafx.event.ActionEvent actionEvent) throws IOException {
        MenuForAbleCareHome m = new MenuForAbleCareHome();
        m.ChangeScene("AfterLogIn.fxml");
    }

    @FXML
    void NewDoctorConfirm(javafx.event.ActionEvent actionEvent) throws IOException {
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
            // Read the last ID for DoctorList, assign new ID for new doctor
            String id = "0";
            int id2 = -1;
            File myObj2 = new File("./src/Archive/DoctorList.txt");
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
            a.AddDoctor(sid,sp,newdoctorname.getText(),String.valueOf(id2),newdoctorphone.getText(),newdoctorpassword.getText());
            MenuForAbleCareHome m = new MenuForAbleCareHome();
            m.ChangeScene("AfterLogIn.fxml");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
