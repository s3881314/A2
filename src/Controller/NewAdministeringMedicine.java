package Controller;

import Classes.AbleCareHome;
import Classes.Bed;
import GUI.MenuForAbleCareHome;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import java.util.Collections;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;

public class NewAdministeringMedicine implements Initializable {
    private String w="", r="", b="";

    @FXML
    private Button ConfirmBT;

    @FXML
    private Button Cancel;

    @FXML
    private javafx.scene.control.ChoiceBox<String> Medicine;

    @FXML
    private javafx.scene.control.ChoiceBox<String> WardNumber;

    @FXML
    private javafx.scene.control.ChoiceBox<String> RoomNumber;

    @FXML
    private javafx.scene.control.ChoiceBox<String> BedNumber;

    @FXML
    private javafx.scene.control.ChoiceBox<String> Time;

    @FXML
    private Spinner<Integer> Doses;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // set up spinner Doses
        Doses.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1,20));

        // set choicebox for WardNumber
        ArrayList<String> ward = new ArrayList<String>();
        String[] warray = {"1","2"};
        Collections.addAll(ward, warray);
        WardNumber.getItems().addAll(ward);

        // set choicebox for Time
        ArrayList<String> time = new ArrayList<String>();
        String[] tarray = {"0","0.5","1","1.5","2","2.5","3","3.5","4","4.5","5","5.5","6","6.5","7","7.5","8","8.5","9","9.5","10","10.5","11","11.5","12","12.5","13","13.5","14","14.5","15","15.5","16","16.5","17","17.5","18","18.5","19","19.5","20","20.5","21","21.5","22","22.5","23","23.5"};
        Collections.addAll(time, tarray);
        Time.getItems().addAll(time);

        // Listen to choicebox
        WardNumber.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> {
            try {
                ReadR(newValue);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        });
        RoomNumber.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> {
            try {
                ReadB(newValue);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        });
        BedNumber.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> ReadList(newValue));
    }

    @FXML
    void ConfirmBT(javafx.event.ActionEvent actionEvent) throws IOException{
        try {// Read username and position
            File myObj = new File("./src/Archive/LogIn.txt");
            Scanner myReader = new Scanner(myObj);
            String sid="",sp="";
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String s[] = data.split(",");
                sid = s[0];
                sp = s[2];
            }
            AbleCareHome a = new AbleCareHome();
            a.AdministeringMedicine(sid,sp,String.valueOf(WardNumber.getValue()),String.valueOf(RoomNumber.getValue()),String.valueOf(BedNumber.getValue()),Medicine.getValue(), String.valueOf(Doses.getValue()), String.valueOf(Time.getValue()));
            MenuForAbleCareHome m = new MenuForAbleCareHome();
            m.ChangeScene("AfterLogIn.fxml");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void CancelBT(javafx.event.ActionEvent actionEvent) throws IOException {
        MenuForAbleCareHome m = new MenuForAbleCareHome();
        m.ChangeScene("AfterLogIn.fxml");
    }

    public void ReadR(String nv) throws FileNotFoundException {
        this.w = nv;
        RoomNumber.getItems().clear();
        // get Room from bed
        ArrayList<String> rarray = new ArrayList<String>();
        File myObj = new File("./src/Archive/Bed.txt");
        Scanner myReader = new Scanner(myObj);
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            String a[] = data.split(",");
            if(a[0].equals(this.w) && !rarray.contains(a[1])){
                rarray.add(a[1]);
            }
        }
        RoomNumber.getItems().addAll(rarray);
    }
    public void ReadB(String nv) throws FileNotFoundException {
        this.r = nv;
        BedNumber.getItems().clear();
        // get Bed from bed
        ArrayList<String> barray = new ArrayList<String>();
        File myObj = new File("./src/Archive/Bed.txt");
        Scanner myReader = new Scanner(myObj);
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            String a[] = data.split(",");
            if(a[0].equals(this.w) && a[1].equals(this.r) && !barray.contains(a[2])){
                barray.add(a[2]);
            }
        }
        BedNumber.getItems().addAll(barray);
    }
    public void ReadList(String nv){
        this.b = nv;
        Medicine.getItems().clear();
        try {
            // get ID
            String id = "";
            File myObj = new File("./src/Archive/Bed.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String a[] = data.split(",");
                if(a[0].equals(this.w) && a[1].equals(this.r) && a[2].equals(this.b)) {
                    id = a[3];
                }
            }
            // get Prescription
            File myObj2 = new File("./src/Archive/Prescription.txt");
            Scanner myReader2 = new Scanner(myObj2);
            while (myReader2.hasNextLine()) {
                String data = myReader2.nextLine();
                String a[] = data.split(",");
                if(a[0].equals(id)) {
                    Medicine.getItems().addAll(a[1]);
                }
            }
            myReader.close();
            myReader2.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
