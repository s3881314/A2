package Controller;

import Classes.AbleCareHome;
import GUI.MenuForAbleCareHome;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class NewReadResidentDetails {

    @FXML
    private TextField readresidentdetailsward;

    @FXML
    private TextField readresidentdetailsbed;

    @FXML
    private TextField readresidentdetailsroom;

    @FXML
    private Button readresidentdetailsconfirm;

    @FXML
    private Button Cancel;

    @FXML
    void CancelBT(javafx.event.ActionEvent actionEvent) throws IOException {
        MenuForAbleCareHome m = new MenuForAbleCareHome();
        m.ChangeScene("AfterLogIn.fxml");
    }

    @FXML
    void ReadResidentDetailsConfirm(javafx.event.ActionEvent actionEvent) {
        String b="";
        try {// Read username and position
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
            b = a.ReadResidentDetails(sid, sp, readresidentdetailsward.getText(), readresidentdetailsroom.getText(), readresidentdetailsbed.getText());
            try {
                FileWriter fileWriter =new FileWriter("./src/Archive/DisplayResidentDetails.txt");
                fileWriter.write(b);
                fileWriter.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            MenuForAbleCareHome m = new MenuForAbleCareHome();
            m.ChangeScene("DisplayResidentDetails.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
