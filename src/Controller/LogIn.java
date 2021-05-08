package Controller;

import GUI.MenuForAbleCareHome;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import javafx.event.ActionEvent.*;

public class LogIn {

    @FXML
    private TextField Position;

    @FXML
    private TextField Username;

    @FXML
    private PasswordField Password;

    @FXML
    private Button LogInBT;

    @FXML
    private Label WrongLogIn;

    @FXML
    public void LogInBT(javafx.event.ActionEvent actionEvent) {
        CheckLogIn();
    }

    private void CheckLogIn() {
        MenuForAbleCareHome m = new MenuForAbleCareHome();
        if (Position.getText().isEmpty() &&Username.getText().isEmpty() && Password.getText().isEmpty()) {
            WrongLogIn.setText("Please enter your data.");
        }
        else {
            if (Position.getText().equals("Doctor")) {
                try {
                    boolean login = false;
                    File myObj = new File("./src/Archive/DoctorList.txt");
                    Scanner myReader = new Scanner(myObj);
                    while (myReader.hasNextLine()) {
                        String data = myReader.nextLine();
                        String a[] = data.split(",");
                        if (a[0].equals(Username.getText()) && a[3].equals(Password.getText())) {
                            login = true;
                        }
                    }

                    if (login == true) {
                        WrongLogIn.setText("Success!");
                        LogInFile(Username.getText(), Password.getText());  // Record log in data
                        m.ChangeScene("AfterLogIn.fxml");
                    } else {
                        WrongLogIn.setText("Wrong Username or Password.");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else if (Position.getText().equals("Manager")) {
                try {
                    boolean login = false;
                    File myObj = new File("./src/Archive/ManagerList.txt");
                    Scanner myReader = new Scanner(myObj);
                    while (myReader.hasNextLine()) {
                        String data = myReader.nextLine();
                        String a[] = data.split(",");
                        if (a[0].equals(Username.getText()) && a[3].equals(Password.getText())) {
                            login = true;
                        }
                    }
                    if (login == true) {
                        WrongLogIn.setText("Success!");
                        LogInFile(Username.getText(), Password.getText());  // Record log in data
                        m.ChangeScene("AfterLogIn.fxml");
                    } else {
                        WrongLogIn.setText("Wrong Username or Password.");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else if (Position.getText().equals("Nurse")) {
                try {
                    boolean login = false;
                    File myObj = new File("./src/Archive/NurseList.txt");
                    Scanner myReader = new Scanner(myObj);
                    while (myReader.hasNextLine()) {
                        String data = myReader.nextLine();
                        String a[] = data.split(",");
                        if (a[0].equals(Username.getText()) && a[3].equals(Password.getText())) {
                            login = true;
                        }
                    }

                    if (login == true) {
                        WrongLogIn.setText("Success!");
                        LogInFile(Username.getText(), Password.getText());  // Record log in data
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
            String LogInData = u + "," + p + "," + Position.getText();
            FileWriter fw = new FileWriter("./src/Archive/LogIn.txt");
            fw.write(LogInData); // 將字串寫到檔案裡
            fw.close();

            // Record in Action.txt
            try {
                File file = new File("./src/Archive/Action.txt");
                FileWriter fr = new FileWriter(file, true);
                BufferedWriter br = new BufferedWriter(fr);
                PrintWriter pr = new PrintWriter(br);
                pr.println(dtf.format(now) + "," + Position.getText() + "," + u + ", Log in system.");
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

}
