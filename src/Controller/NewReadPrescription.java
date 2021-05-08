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

public class NewReadPrescription {

    @FXML
    private TextField readprescriptionward;

    @FXML
    private TextField readprescriptionroom;

    @FXML
    private TextField readprescriptionbed;

    @FXML
    private Button readprescriptionconfirm;

    @FXML
    void ReadPrescriptionConfirm(javafx.event.ActionEvent actionEvent) {
        String b="";
        try {// Read username and position
            File myObj = new File("./src/Archive/LogInData.txt");
            Scanner myReader = new Scanner(myObj);
            String sid = "", sp = "";
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String s[] = data.split(",");
                sid = s[0];
                sp = s[2];
            }

            AbleCareHome a = new AbleCareHome();
            b = a.ReadPrescription(sid, sp, readprescriptionward.getText(), readprescriptionroom.getText(), readprescriptionbed.getText());
            try {
                FileWriter fileWriter =new FileWriter("./src/Archive/DisplayPrescription.txt");
                fileWriter.write(b);
                fileWriter.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            MenuForAbleCareHome m = new MenuForAbleCareHome();
            m.ChangeScene("DisplayPrescription.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
