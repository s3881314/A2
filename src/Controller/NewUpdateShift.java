package Controller;

import Classes.AbleCareHome;
import Classes.ShiftException;
import GUI.MenuForAbleCareHome;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;

public class NewUpdateShift implements Initializable {
    @FXML
    private Button BT;

    @FXML
    private Button Cancel;

    @FXML
    private javafx.scene.control.ChoiceBox<String> ID;

    @FXML
    private Spinner<Integer> StartTime;

    @FXML
    private Spinner<Integer> EndTime;

    @FXML
    private javafx.scene.control.ChoiceBox<String> position;
    ObservableList list = FXCollections.observableArrayList();

    @FXML
    private DatePicker DayOfWeek;

    @Override
    public void initialize(URL url, ResourceBundle rb){
        // set position choicebox
        list.removeAll(list);
        String b = "Doctor";
        String c = "Nurse";
        list.addAll(b,c);
        position.getItems().addAll(list);

        // Listen to position choicebox to set ID choicebox
        position.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> ReadList(newValue));

        // set spinners value
        StartTime.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(8,21));
        EndTime.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(9,22));
    }

    @FXML
    void CancelBT(javafx.event.ActionEvent actionEvent) throws IOException {
        MenuForAbleCareHome m = new MenuForAbleCareHome();
        m.ChangeScene("AfterLogIn.fxml");
    }

    @FXML
    void ConfirmBT(javafx.event.ActionEvent actionEvent) {
        try {
            // Read username and position
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
            a.UpdateShift(sid, sp, position.getValue(), ID.getValue(), DayOfWeek.getValue(), String.valueOf(StartTime.getValue()), String.valueOf(EndTime.getValue()));
            MenuForAbleCareHome m = new MenuForAbleCareHome();
            m.ChangeScene("AfterLogIn.fxml");
        } catch (IOException | ShiftException e) {
            e.printStackTrace();
        }
    }

    public void ReadList(String nv){
        ID.getItems().clear();
        list.removeAll(list);
        ArrayList<String> arr = new ArrayList<String>();
        if(nv.equals("Doctor")) {
            try {
                File myObj = new File("./src/Archive/DoctorList.txt");
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
        else if(nv.equals("Nurse")){
            try {
                File myObj = new File("./src/Archive/NurseList.txt");
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
        else{
            try {
                File myObj = new File("./src/Archive/ManagerList.txt");
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
    }

}
