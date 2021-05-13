package Controller;

import GUI.MenuForAbleCareHome;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

import javafx.fxml.Initializable;

public class DisplayAdministeringMedicine implements Initializable{

    @FXML
    private Label AdministeringMedicine;

    @FXML
    private Button back;

    @FXML
    private Label rid;

    @Override
    public void initialize(URL url, ResourceBundle rb){
        try {// Read username and position
            String s="";
            File myObj = new File("./src/Archive/DisplayAdministeringMedicine.txt");
            Scanner myReader = new Scanner(myObj);
            String sid = "", sp = "";
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                s = s+data;
            }
            String[] s2 = s.split(",");
            rid.setText(s2[0]);
            AdministeringMedicine.setText(s2[1]);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void Getback(javafx.event.ActionEvent actionEvent) throws IOException {
        MenuForAbleCareHome m = new MenuForAbleCareHome();
        m.ChangeScene("AfterLogIn.fxml");
    }
}
