package Controller;

import Classes.ShiftException;
import GUI.MenuForAbleCareHome;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

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
    private Label loginp; // Log in Position

    @FXML
    private Label loginn;  // Log in name

    @FXML
    private Button showuser;

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
    private Button showwards;

    @FXML
    void ShowUser(javafx.event.ActionEvent actionEvent) throws IOException {
        ReadUsernamePassword();
        loginp.setText(Position);
        loginn.setText(UName);
    }

    @FXML
    void AddDoctorBT(javafx.event.ActionEvent actionEvent) throws IOException, AuthorizationException {
        ReadUsernamePassword();
        CheckAuthorization("AddDoctorBT");
        MenuForAbleCareHome m = new MenuForAbleCareHome();
        m.ChangeScene("NewDoctor.fxml");
    }

    @FXML
    void AddManagerBT(javafx.event.ActionEvent actionEvent) throws IOException, AuthorizationException {
        ReadUsernamePassword();
        CheckAuthorization("AddManagerBT");
        MenuForAbleCareHome m = new MenuForAbleCareHome();
        m.ChangeScene("NewManager.fxml");
    }

    @FXML
    void AddNewResidentToBedBT(javafx.event.ActionEvent actionEvent) throws IOException, AuthorizationException {
        ReadUsernamePassword();
        CheckAuthorization("AddNewResidentToBedBT");
        MenuForAbleCareHome m = new MenuForAbleCareHome();
        m.ChangeScene("NewResidentToBed.fxml");
    }

    @FXML
    void AddNurseBT(javafx.event.ActionEvent actionEvent) throws IOException, AuthorizationException {
        ReadUsernamePassword();
        CheckAuthorization("AddNurseBT");
        MenuForAbleCareHome m = new MenuForAbleCareHome();
        m.ChangeScene("NewNurse.fxml");
    }

    @FXML
    void AddResidentBT(javafx.event.ActionEvent actionEvent) throws IOException, AuthorizationException {
        ReadUsernamePassword();
        CheckAuthorization("AddResidentBT");
        MenuForAbleCareHome m = new MenuForAbleCareHome();
        m.ChangeScene("NewResident.fxml");
    }

    @FXML
    void AdministeringMedicineBT(javafx.event.ActionEvent actionEvent) throws IOException, AuthorizationException {
        ReadUsernamePassword();
        CheckAuthorization("AdministeringMedicineBT");
        MenuForAbleCareHome m = new MenuForAbleCareHome();
        m.ChangeScene("NewAdministeringMedicine.fxml");
    }

    @FXML
    void AssignShiftBT(javafx.event.ActionEvent actionEvent) throws IOException, AuthorizationException {
        ReadUsernamePassword();
        CheckAuthorization("AssignShiftBT");
        MenuForAbleCareHome m = new MenuForAbleCareHome();
        m.ChangeScene("NewAssignShift.fxml");
    }

    @FXML
    void AttachNewPrescriptionBT(javafx.event.ActionEvent actionEvent) throws IOException, AuthorizationException {
        ReadUsernamePassword();
        CheckAuthorization("AttachNewPrescriptionBT");
        MenuForAbleCareHome m = new MenuForAbleCareHome();
        m.ChangeScene("NewAttachNewPrescription.fxml");
    }

    @FXML
    void DischargeResidentBT(javafx.event.ActionEvent actionEvent) throws IOException, AuthorizationException {
        ReadUsernamePassword();
        CheckAuthorization("DischargeResidentBT");
        MenuForAbleCareHome m = new MenuForAbleCareHome();
        m.ChangeScene("NewDischargeResident.fxml");
    }

    @FXML
    void MoveResidentBT(javafx.event.ActionEvent actionEvent) throws IOException, AuthorizationException {
        ReadUsernamePassword();
        CheckAuthorization("MoveResidentBT");
        MenuForAbleCareHome m = new MenuForAbleCareHome();
        m.ChangeScene("NewMoveResident.fxml");
    }

    @FXML
    void ReadAdministeringMedicineBT(javafx.event.ActionEvent actionEvent) throws IOException, AuthorizationException {
        ReadUsernamePassword();
        CheckAuthorization("ReadAdministeringMedicineBT");
        MenuForAbleCareHome m = new MenuForAbleCareHome();
        m.ChangeScene("NewReadAdministeringMedicine.fxml");
    }

    @FXML
    void ReadPrescriptionBT(javafx.event.ActionEvent actionEvent) throws IOException, AuthorizationException {
        ReadUsernamePassword();
        CheckAuthorization("ReadPrescriptionBT");
        MenuForAbleCareHome m = new MenuForAbleCareHome();
        m.ChangeScene("NewReadPrescription.fxml");
    }

    @FXML
    void ReadResidentDetailsBT(javafx.event.ActionEvent actionEvent) throws IOException, AuthorizationException {
        ReadUsernamePassword();
        CheckAuthorization("ReadResidentDetailsBT");
        MenuForAbleCareHome m = new MenuForAbleCareHome();
        m.ChangeScene("NewReadResidentDetails.fxml");
    }

    @FXML
    void UpdatePasswordBT(javafx.event.ActionEvent actionEvent) throws IOException, AuthorizationException {
        ReadUsernamePassword();
        CheckAuthorization("UpdatePasswordBT");
        MenuForAbleCareHome m = new MenuForAbleCareHome();
        m.ChangeScene("NewUpdatePassword.fxml");
    }

    @FXML
    void UpdatePrescriptionBT(javafx.event.ActionEvent actionEvent) throws IOException, AuthorizationException {
        ReadUsernamePassword();
        CheckAuthorization("UpdatePrescriptionBT");
        MenuForAbleCareHome m = new MenuForAbleCareHome();
        m.ChangeScene("NewUpdatePrescription.fxml");
    }

    @FXML
    void UpdateShiftBT(javafx.event.ActionEvent actionEvent) throws IOException, AuthorizationException {
        ReadUsernamePassword();
        CheckAuthorization("UpdateShiftBT");
        MenuForAbleCareHome m = new MenuForAbleCareHome();
        m.ChangeScene("NewUpdateShift.fxml");
    }

    @FXML
    void UserLogOut(javafx.event.ActionEvent actionEvent) throws IOException {
        MenuForAbleCareHome m = new MenuForAbleCareHome();
        m.ChangeScene("GUI.fxml");
    }

    @FXML
    void ShowWards(javafx.event.ActionEvent actionEvent) throws IOException, AuthorizationException {
        ReadUsernamePassword();
        // Record in Action.txt
        try {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();

            File file = new File("./src/Archive/Action.txt");
            FileWriter fr = new FileWriter(file, true);
            BufferedWriter br = new BufferedWriter(fr);
            PrintWriter pr = new PrintWriter(br);
            pr.println(dtf.format(now) + "," + this.Position + "," + this.UName + ", Show beds status.");
            pr.close();
            br.close();
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        MenuForAbleCareHome m = new MenuForAbleCareHome();
        m.ChangeScene("ShowWards.fxml");
    }


    public void ReadUsernamePassword() throws FileNotFoundException {
        File myObj = new File("./src/Archive/LogIn.txt");
        Scanner myReader = new Scanner(myObj);
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            String a[] = data.split(",");
            this.UName=a[0];
            this.PWord=a[1];
            this.Position=a[2];
        }
    }

    public void CheckAuthorization(String action) throws AuthorizationException, FileNotFoundException {
        try {
            File myObj = new File("./src/Archive/AuthorizationList.txt");
            myObj.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try{
            File myObj = new File("./src/Archive/AuthorizationList.txt");
            Scanner myReader = new Scanner(myObj);
            boolean flag = false;
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String a[] = data.split(",");
                if(a[0].equals(this.Position)){
                    for(String s: a){
                        if(s.equals(action)){ flag = true; }
                    }
                }
            }
            if(flag == false){ throw new AuthorizationException(); }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
