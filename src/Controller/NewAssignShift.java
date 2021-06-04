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
import java.util.Collections;
import java.util.ResourceBundle;
import java.util.Scanner;

public class NewAssignShift implements Initializable {

    @FXML
    private Button newassignshiftconfirm;

    @FXML
    private Button Cancel;

    @FXML
    private DatePicker DayOfWeek;

    @FXML
    private javafx.scene.control.ChoiceBox<String> ID;

    @FXML
    private javafx.scene.control.ChoiceBox<String> StartTime;

    @FXML
    private javafx.scene.control.ChoiceBox<String> EndTime;


    @FXML
    private javafx.scene.control.ChoiceBox<String> position;
    ObservableList list = FXCollections.observableArrayList();

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

        // set StartTime and EndTime
        ArrayList<String> starr = new ArrayList<String>();
        String[] st = {"8","9","10","11","12","13","14","15","16","17","18","19","20","21"};
        Collections.addAll(starr, st);
        StartTime.getItems().addAll(starr);
        // set choicebox for Time
        ArrayList<String> etarr = new ArrayList<String>();
        String[] tarray = {"9","10","11","12","13","14","15","16","17","18","19","20","21","22"};
        Collections.addAll(etarr, tarray);
        EndTime.getItems().addAll(etarr);
    }

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
            a.AssignShift(sid, sp, position.getValue(), ID.getValue(), DayOfWeek.getValue(), String.valueOf(StartTime.getValue()),String.valueOf(EndTime.getValue()));
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
