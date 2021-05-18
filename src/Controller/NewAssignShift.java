package Controller;

import Classes.AbleCareHome;
import Classes.ShiftException;
import GUI.MenuForAbleCareHome;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

public class NewAssignShift implements Initializable {

    @FXML
    private TextField newassignshiftid;

    @FXML
    private TextField newassignshiftst;

    @FXML
    private TextField newassignshiftet;

    @FXML
    private Button newassignshiftconfirm;

    @FXML
    private Button Cancel;

    @FXML
    private javafx.scene.control.ChoiceBox<String> position;
    ObservableList list = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb){
        list.removeAll(list);
        String b = "Doctor";
        String c = "Nurse";
        list.addAll(b,c);
        position.getItems().addAll(list);
    }

    @FXML
    private DatePicker DayOfWeek;


    @FXML
    void CancelBT(javafx.event.ActionEvent actionEvent) throws IOException {
        MenuForAbleCareHome m = new MenuForAbleCareHome();
        m.ChangeScene("AfterLogIn.fxml");
    }

    @FXML
    void NewAssignShiftConfirm(javafx.event.ActionEvent actionEvent) {
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
            a.AssignShift(sid, sp, position.getValue(), newassignshiftid.getText(), DayOfWeek.getValue(), newassignshiftst.getText(),newassignshiftet.getText());
            MenuForAbleCareHome m = new MenuForAbleCareHome();
            m.ChangeScene("AfterLogIn.fxml");
        } catch (IOException | ShiftException e) {
            e.printStackTrace();
        }
    }

}
