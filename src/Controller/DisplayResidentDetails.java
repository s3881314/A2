package Controller;

import GUI.MenuForAbleCareHome;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class DisplayResidentDetails {

    @FXML
    private Label showlabel;

    @FXML
    private Button show;

    @FXML
    private Button back;

    @FXML
    void back(javafx.event.ActionEvent actionEvent) throws IOException {
        MenuForAbleCareHome m = new MenuForAbleCareHome();
        m.ChangeScene("AfterLogIn.fxml");
    }

    @FXML
    void show(javafx.event.ActionEvent actionEvent) {
        try {
            // Read username and position
            String s="";
            File myObj = new File("./src/Archive/DisplayResidentDetails.txt");
            Scanner myReader = new Scanner(myObj);
            String sid = "", sp = "";
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                s = s+data;
            }
            showlabel.setText(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
