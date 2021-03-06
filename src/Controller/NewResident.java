package Controller;

import Classes.AbleCareHome;
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

public class NewResident implements Initializable {


    @FXML
    private TextField newresidentname;

    @FXML
    private TextField newresidentid;

    @FXML
    private Button newresidentconfirm;

    @FXML
    private Button Cancel;

    @FXML
    private DatePicker DoB;

    @FXML
    private javafx.scene.control.ChoiceBox<String> Gender;
    ObservableList list = FXCollections.observableArrayList();


    @FXML
    void NewResidentConfirm(javafx.event.ActionEvent actionEvent) {
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
            // Read the last ID for ResidentList, assign new ID for new Resident
            String id = "0";
            int id2 = -1;
            File myObj2 = new File("./src/Archive/ResidentList.txt");
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
            a.AddResident(sid, sp, newresidentname.getText(), Gender.getValue(), String.valueOf(id2), DoB.getValue());
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

    @Override
    public void initialize(URL url, ResourceBundle rb){
        list.removeAll(list);
        String a = "Male";
        String b = "Female";
        list.addAll(a,b);
        Gender.getItems().addAll(list);
    }
}
