package Controller;

import GUI.MenuForAbleCareHome;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

import javafx.fxml.Initializable;

public class DisplayResidentDetails implements Initializable{

    @FXML
    private Button back;

    @FXML
    private Label ResidentID;

    @FXML
    private Label ResidentName;

    @FXML
    private Label Gender;

    @FXML
    private Label DayOfBirth;

    @FXML
    private Label DischargeDate;

    @Override
    public void initialize(URL url, ResourceBundle rb){
        try {
            // Read username and position
            String s="";
            File myObj = new File("./src/Archive/DisplayResidentDetails.txt");
            Scanner myReader = new Scanner(myObj);
            String Rid = "";
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                s = s+data;
            }
            String[] s2 = s.split(",");
            ResidentID.setText(s2[0]);
            ResidentName.setText(s2[1]);
            Gender.setText(s2[2]);
            DayOfBirth.setText(s2[3]);
            if(s2.length > 4) {
                DischargeDate.setText(s2[4]);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void back(javafx.event.ActionEvent actionEvent) throws IOException {
        MenuForAbleCareHome m = new MenuForAbleCareHome();
        m.ChangeScene("AfterLogIn.fxml");
    }
}
