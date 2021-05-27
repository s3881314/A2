package Controller;

import Classes.AbleCareHome;
import GUI.MenuForAbleCareHome;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;

public class NewMoveResident implements Initializable {

    @FXML
    private Button moveresidentconfirm;

    @FXML
    private Button Cancel;

    @FXML
    private Spinner<Integer> Ward;

    @FXML
    private Spinner<Integer> Room;

    @FXML
    private Spinner<Integer> Bed;

    @FXML
    private javafx.scene.control.ChoiceBox<String> ID;
    ObservableList list = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // set spinner values
        Ward.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 2));
        Room.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 6));
        Bed.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 4));

        // set ID choicebox
        ArrayList<String> arr = new ArrayList<String>();
        try {
            File myObj = new File("./src/Archive/ResidentList.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String a[] = data.split(",");
                arr.add(a[0]);
            }
            list.addAll(arr);
            ID.getItems().addAll(list);
            myReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void CancelBT(javafx.event.ActionEvent actionEvent) throws IOException {
        MenuForAbleCareHome m = new MenuForAbleCareHome();
        m.ChangeScene("AfterLogIn.fxml");
    }

    @FXML
    void MoveResidentConfirm(javafx.event.ActionEvent actionEvent) {
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
            a.MoveResident(sid, sp,String.valueOf(Ward.getValue()), String.valueOf(Room.getValue()), String.valueOf(Bed.getValue()), ID.getValue());
            MenuForAbleCareHome m = new MenuForAbleCareHome();
            m.ChangeScene("AfterLogIn.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
