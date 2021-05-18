package Controller;

import Classes.AbleCareHome;
import GUI.MenuForAbleCareHome;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

public class NewUpdatePassword implements Initializable {

    @FXML
    private TextField id;

    @FXML
    private TextField newpd;

    @FXML
    private Button bt;

    @FXML
    private Button Cancel;

    @FXML
    private javafx.scene.control.ChoiceBox<String> position;
    ObservableList list = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb){
        list.removeAll(list);
        String b = "Doctor";
        String c = "Nurse";
        list.addAll(b,c);
        position.getItems().addAll(list);
    }

    @FXML
    void CancelBT(javafx.event.ActionEvent actionEvent) throws IOException {
        MenuForAbleCareHome m = new MenuForAbleCareHome();
        m.ChangeScene("AfterLogIn.fxml");
    }

    @FXML
    void ConfirmBT(javafx.event.ActionEvent actionEvent) {
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
            a.UpdatePassword(sid, sp, position.getValue(), id.getText(), newpd.getText());
            MenuForAbleCareHome m = new MenuForAbleCareHome();
            m.ChangeScene("AfterLogIn.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
