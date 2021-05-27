package Controller;

import GUI.MenuForAbleCareHome;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.*;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Observable;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.event.ActionEvent.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import javafx.fxml.Initializable;


public class LogIn implements Initializable{
    private String Position="";
    private String id="";

    @FXML
    private PasswordField Password;

    @FXML
    private javafx.scene.control.ChoiceBox<String> ID;

    @FXML
    private Label WrongLogIn;

    @FXML
    private javafx.scene.control.ChoiceBox<String> ChoiceBox;
    ObservableList list = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb){
        list.removeAll(list);
        String a = "Manager";
        String b = "Doctor";
        String c = "Nurse";
        list.addAll(a,b,c);
        ChoiceBox.getItems().addAll(list);

        // Listen to choicebox
        ChoiceBox.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> ReadList(newValue));

    }

    @FXML
    public void LogInBT(javafx.event.ActionEvent actionEvent) {
        Position = ChoiceBox.getValue();
        id = ID.getValue();
        CheckLogIn();
    }

    private void CheckLogIn() {
        MenuForAbleCareHome m = new MenuForAbleCareHome();
        if (id.equals("") && Password.getText().isEmpty()) {
            WrongLogIn.setText("Please enter your data.");
        }
        else {
            if (Position.equals("Doctor")) {
                try {
                    boolean login = false;
                    File myObj = new File("./src/Archive/DoctorList.txt");
                    Scanner myReader = new Scanner(myObj);
                    while (myReader.hasNextLine()) {
                        String data = myReader.nextLine();
                        String a[] = data.split(",");
                        if (a[0].equals(id) && a[3].equals(Password.getText())) {
                            login = true;
                        }
                    }

                    if (login == true) {
                        WrongLogIn.setText("Success!");
                        LogInFile(id, Password.getText());  // Record log in data
                        m.ChangeScene("AfterLogIn.fxml");
                    } else {
                        WrongLogIn.setText("Wrong Username or Password.");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else if (Position.equals("Manager")) {
                try {
                    boolean login = false;
                    File myObj = new File("./src/Archive/ManagerList.txt");
                    Scanner myReader = new Scanner(myObj);
                    while (myReader.hasNextLine()) {
                        String data = myReader.nextLine();
                        String a[] = data.split(",");
                        if (a[0].equals(id) && a[3].equals(Password.getText())) {
                            login = true;
                        }
                    }
                    if (login == true) {
                        WrongLogIn.setText("Success!");
                        LogInFile(id, Password.getText());  // Record log in data
                        m.ChangeScene("AfterLogIn.fxml");
                    } else {
                        WrongLogIn.setText("Wrong Username or Password.");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else if (Position.equals("Nurse")) {
                try {
                    boolean login = false;
                    File myObj = new File("./src/Archive/NurseList.txt");
                    Scanner myReader = new Scanner(myObj);
                    while (myReader.hasNextLine()) {
                        String data = myReader.nextLine();
                        String a[] = data.split(",");
                        if (a[0].equals(id) && a[3].equals(Password.getText())) {
                            login = true;
                        }
                    }

                    if (login == true) {
                        WrongLogIn.setText("Success!");
                        LogInFile(id, Password.getText());  // Record log in data
                        m.ChangeScene("AfterLogIn.fxml");
                    } else {
                        WrongLogIn.setText("Wrong Username or Password.");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void LogInFile(String u, String p){
        // Username = Staff ID
        try {
            File myObj = new File("./src/Archive/LogIn.txt");
            myObj.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();

            // Write log in data in LogIn.txt
            String LogInData = u + "," + p + "," + Position;
            FileWriter fw = new FileWriter("./src/Archive/LogIn.txt");
            fw.write(LogInData); // 將字串寫到檔案裡
            fw.close();

            // Record in Action.txt
            try {
                File file = new File("./src/Archive/Action.txt");
                FileWriter fr = new FileWriter(file, true);
                BufferedWriter br = new BufferedWriter(fr);
                PrintWriter pr = new PrintWriter(br);
                pr.println(dtf.format(now) + "," + Position + "," + u + ", Log in system.");
                pr.close();
                br.close();
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
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
