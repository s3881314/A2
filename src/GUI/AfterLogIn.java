package GUI;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.awt.event.ActionEvent;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


public class AfterLogIn {
    private String Position="";
    private String UName="";
    private String PWord="";

    @FXML
    private Button Logout;

    @FXML
    private Button addmanager;

    @FXML
    private Button addresident;

    @FXML
    private Button adddoctor;

    @FXML
    private Button addnurse;

    @FXML
    private Button addnewresidenttobed;

    @FXML
    private Button updatepassword;

    @FXML
    private Button assignshift;

    @FXML
    private Button updateshift;

    @FXML
    private Button moveresident;

    @FXML
    private Button attachnewprescription;

    @FXML
    private Button dischargeresident;

    @FXML
    private Button readresidentdetails;

    @FXML
    private Button updateprescription;

    @FXML
    private Button readprescription;

    @FXML
    private Button administeringmedicine;

    @FXML
    private Button readadministeringmedicine;

    @FXML
    void AddDoctorBT(javafx.event.ActionEvent actionEvent) throws IOException {
        ReadUsernamePassword();
        MenuForAbleCareHome m = new MenuForAbleCareHome();
        m.ChangeScene("NewDoctor.fxml");
    }

    @FXML
    void AddManagerBT(javafx.event.ActionEvent actionEvent) throws IOException {
        ReadUsernamePassword();
        MenuForAbleCareHome m = new MenuForAbleCareHome();
        m.ChangeScene("NewManager.fxml");
    }

    @FXML
    void AddNewResidentToBedBT(javafx.event.ActionEvent actionEvent) throws IOException {
        ReadUsernamePassword();
        MenuForAbleCareHome m = new MenuForAbleCareHome();
        m.ChangeScene("NewResidentToBed.fxml");
    }

    @FXML
    void AddNurseBT(javafx.event.ActionEvent actionEvent) throws IOException {
        ReadUsernamePassword();
        MenuForAbleCareHome m = new MenuForAbleCareHome();
        m.ChangeScene("NewNurse.fxml");
    }

    @FXML
    void AddResidentBT(javafx.event.ActionEvent actionEvent) throws IOException {
        ReadUsernamePassword();
        MenuForAbleCareHome m = new MenuForAbleCareHome();
        m.ChangeScene("NewResident.fxml");
    }

    @FXML
    void AdministeringMedicineBT(javafx.event.ActionEvent actionEvent) throws IOException {
        ReadUsernamePassword();
        MenuForAbleCareHome m = new MenuForAbleCareHome();
        m.ChangeScene("NewAdministeringMedicine.fxml");
    }

    @FXML
    void AssignShiftBT(javafx.event.ActionEvent actionEvent) throws IOException {
        ReadUsernamePassword();
        MenuForAbleCareHome m = new MenuForAbleCareHome();
        m.ChangeScene("NewAssignShift.fxml");
    }

    @FXML
    void AttachNewPrescriptionBT(javafx.event.ActionEvent actionEvent) throws IOException {
        ReadUsernamePassword();
        MenuForAbleCareHome m = new MenuForAbleCareHome();
        m.ChangeScene("NewAttachNewPrescription.fxml");
    }

    @FXML
    void DischargeResidentBT(javafx.event.ActionEvent actionEvent) throws IOException {
        ReadUsernamePassword();
        MenuForAbleCareHome m = new MenuForAbleCareHome();
        m.ChangeScene("NewDischargeResident.fxml");
    }

    @FXML
    void MoveResidentBT(javafx.event.ActionEvent actionEvent) throws IOException {
        ReadUsernamePassword();
        MenuForAbleCareHome m = new MenuForAbleCareHome();
        m.ChangeScene("NewMoveResident.fxml");
    }

    @FXML
    void ReadAdministeringMedicineBT(javafx.event.ActionEvent actionEvent) throws IOException {
        ReadUsernamePassword();
        MenuForAbleCareHome m = new MenuForAbleCareHome();
        m.ChangeScene("NewReadAdministeringMedicine.fxml");
    }

    @FXML
    void ReadPrescriptionBT(javafx.event.ActionEvent actionEvent) throws IOException {
        ReadUsernamePassword();
        MenuForAbleCareHome m = new MenuForAbleCareHome();
        m.ChangeScene("NewReadPrescription.fxml");
    }

    @FXML
    void ReadResidentDetailsBT(javafx.event.ActionEvent actionEvent) throws IOException {
        ReadUsernamePassword();
        MenuForAbleCareHome m = new MenuForAbleCareHome();
        m.ChangeScene("NewReadResidentDetails.fxml");
    }

    @FXML
    void UpdatePasswordBT(javafx.event.ActionEvent actionEvent) throws IOException {
        ReadUsernamePassword();
        MenuForAbleCareHome m = new MenuForAbleCareHome();
        m.ChangeScene("NewUpdatePassword.fxml");
    }

    @FXML
    void UpdatePrescriptionBT(javafx.event.ActionEvent actionEvent) throws IOException {
        ReadUsernamePassword();
        MenuForAbleCareHome m = new MenuForAbleCareHome();
        m.ChangeScene("NewUpdatePrescription.fxml");
    }

    @FXML
    void UpdateShiftBT(javafx.event.ActionEvent actionEvent) throws IOException {
        ReadUsernamePassword();
        MenuForAbleCareHome m = new MenuForAbleCareHome();
        m.ChangeScene("NewUpdateShift.fxml");
    }

    @FXML
    void UserLogOut(javafx.event.ActionEvent actionEvent) throws IOException {
        MenuForAbleCareHome m = new MenuForAbleCareHome();
        m.ChangeScene("MenuForAbleCareHome.fxml");
    }

    public void ReadUsernamePassword() throws FileNotFoundException {
        File myObj = new File("F:\\Textbook\\MasterOfIT\\COSC1295 Advanced Programming\\Assignment\\Assignment2\\A2_1\\src\\Archive\\LogInData.txt");
        Scanner myReader = new Scanner(myObj);
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            String a[] = data.split(",");
            this.UName=a[0];
            this.PWord=a[1];
            this.Position=a[2];
        }
    }
}
