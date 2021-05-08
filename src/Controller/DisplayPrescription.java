package Controller;

import GUI.MenuForAbleCareHome;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class DisplayPrescription {

    @FXML
    private Label displayprescriptionlabel;

    @FXML
    private Button show;

    @FXML
    private Button back;

    @FXML
    void Back(javafx.event.ActionEvent actionEvent) throws IOException{
        MenuForAbleCareHome m = new MenuForAbleCareHome();
        m.ChangeScene("AfterLogIn.fxml");
    }

    @FXML
    void Show(javafx.event.ActionEvent actionEvent) {
        try {
            // Read username and position
            String s="";
            File myObj = new File("./src/Archive/DisplayPrescription.txt");
            Scanner myReader = new Scanner(myObj);
            String sid = "", sp = "";
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                s = s+data;
            }
            displayprescriptionlabel.setText(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
