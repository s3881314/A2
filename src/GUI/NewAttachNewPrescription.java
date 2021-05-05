package GUI;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class NewAttachNewPrescription {

    @FXML
    private TextField attachnewprescriptionward;

    @FXML
    private TextField attachnewprescriptionroom;

    @FXML
    private TextField attachnewprescriptionbed;

    @FXML
    private TextField attachnewprescriptionprescription;

    @FXML
    private Button attachnewprescriptionconfirm;

    @FXML
    void AttachNewPrescriptionConfirm(javafx.event.ActionEvent actionEvent) throws IOException {
        try {// Read username and position
            File myObj = new File("F:\\Textbook\\MasterOfIT\\COSC1295 Advanced Programming\\Assignment\\Assignment2\\A2_1\\src\\Archive\\LogInData.txt");
            Scanner myReader = new Scanner(myObj);
            String sid = "", sp = "";
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String s[] = data.split(",");
                sid = s[0];
                sp = s[2];
            }
            AbleCareHome a = new AbleCareHome();
            a.AttachNewPrescription(sid, sp, attachnewprescriptionward.getText(), attachnewprescriptionroom.getText(), attachnewprescriptionbed.getText(), attachnewprescriptionprescription.getText());
            MenuForAbleCareHome m = new MenuForAbleCareHome();
            m.ChangeScene("AfterLogIn.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
