package Controller;

import Classes.AbleCareHome;
import GUI.MenuForAbleCareHome;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;
import java.util.Scanner;

public class NewReadResidentDetails implements Initializable {
    private String w="", r="", b="";

    @FXML
    private javafx.scene.control.ChoiceBox<String> WardNumber;

    @FXML
    private javafx.scene.control.ChoiceBox<String> RoomNumber;

    @FXML
    private javafx.scene.control.ChoiceBox<String> BedNumber;

    @FXML
    private Button readresidentdetailsconfirm;

    @FXML
    private Button Cancel;

    @Override
    public void initialize(URL url, ResourceBundle rb){
        // set choicebox for WardNumber
        ArrayList<String> ward = new ArrayList<String>();
        String[] warray = {"1","2"};
        Collections.addAll(ward, warray);
        WardNumber.getItems().addAll(ward);

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
    }

    @FXML
    void CancelBT(javafx.event.ActionEvent actionEvent) throws IOException {
        MenuForAbleCareHome m = new MenuForAbleCareHome();
        m.ChangeScene("AfterLogIn.fxml");
    }

    @FXML
    void ReadResidentDetailsConfirm(javafx.event.ActionEvent actionEvent) {
        String b="";
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
            b = a.ReadResidentDetails(sid, sp, WardNumber.getValue(), RoomNumber.getValue(), BedNumber.getValue());
            try {
                FileWriter fileWriter =new FileWriter("./src/Archive/DisplayResidentDetails.txt");
                fileWriter.write(b);
                fileWriter.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            MenuForAbleCareHome m = new MenuForAbleCareHome();
            m.ChangeScene("DisplayResidentDetails.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
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
}
