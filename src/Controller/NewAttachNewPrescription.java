package Controller;

import Classes.AbleCareHome;
import GUI.MenuForAbleCareHome;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

public class NewAttachNewPrescription implements Initializable {

    @FXML
    private Spinner<Integer> WardNumber;

    @FXML
    private Spinner<Integer> RoomNumber;

    @FXML
    private Spinner<Integer> BedNumber;

    @FXML
    private TextField attachnewprescriptionprescription;

    @FXML
    private Button attachnewprescriptionconfirm;

    @FXML
    private Button Cancel;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // set spinner values
        WardNumber.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 2));
        RoomNumber.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 6));
        BedNumber.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 4));
    }

    @FXML
    void AttachNewPrescriptionConfirm(javafx.event.ActionEvent actionEvent) throws IOException {
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
            a.AttachNewPrescription(sid, sp, String.valueOf(WardNumber.getValue()), String.valueOf(RoomNumber.getValue()), String.valueOf(BedNumber.getValue()), attachnewprescriptionprescription.getText());
            MenuForAbleCareHome m = new MenuForAbleCareHome();
            m.ChangeScene("AfterLogIn.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void CancelBT(javafx.event.ActionEvent actionEvent) throws IOException {
        MenuForAbleCareHome m = new MenuForAbleCareHome();
        m.ChangeScene("AfterLogIn.fxml");
    }

}
