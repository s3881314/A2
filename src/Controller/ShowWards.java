package Controller;

import Classes.AbleCareHome;
import GUI.MenuForAbleCareHome;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

import javafx.fxml.Initializable;

public class ShowWards implements Initializable{
    @FXML
    private Button back;

    @FXML
    private Rectangle w1r1b1;

    @FXML
    private Rectangle w1r1b4;

    @FXML
    private Rectangle w1r1b3;

    @FXML
    private Rectangle w1r1b6;

    @FXML
    private Rectangle w1r1b2;

    @FXML
    private Rectangle w1r1b5;

    @FXML
    private Rectangle w1r2b1;

    @FXML
    private Rectangle w1r2b4;

    @FXML
    private Rectangle w1r2b3;

    @FXML
    private Rectangle w1r2b6;

    @FXML
    private Rectangle w1r2b2;

    @FXML
    private Rectangle w1r2b5;

    @FXML
    private Rectangle w1r3b1;

    @FXML
    private Rectangle w1r3b4;

    @FXML
    private Rectangle w1r3b3;

    @FXML
    private Rectangle w1r3b6;

    @FXML
    private Rectangle w1r3b2;

    @FXML
    private Rectangle w1r3b5;

    @FXML
    private Rectangle w2r1b1;

    @FXML
    private Rectangle w2r1b4;

    @FXML
    private Rectangle w2r1b3;

    @FXML
    private Rectangle w2r1b6;

    @FXML
    private Rectangle w2r1b2;

    @FXML
    private Rectangle w2r1b5;

    @FXML
    private Rectangle w2r2b1;

    @FXML
    private Rectangle w2r2b4;

    @FXML
    private Rectangle w2r2b3;

    @FXML
    private Rectangle w2r2b6;

    @FXML
    private Rectangle w2r2b2;

    @FXML
    private Rectangle w2r2b5;

    @FXML
    private Rectangle w2r3b1;

    @FXML
    private Rectangle w2r3b4;

    @FXML
    private Rectangle w2r3b3;

    @FXML
    private Rectangle w2r3b6;

    @FXML
    private Rectangle w2r3b2;

    @FXML
    private Rectangle w2r3b5;

    @Override
    public void initialize(URL url, ResourceBundle rb){
        try {
            // Read username and position
            File myObj = new File("./src/Archive/Bed.txt");
            Scanner myReader = new Scanner(myObj);
            String sid = "", sp = "";
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String s[] = data.split(",");
                boolean male = false;
                for(int i = 0; i < s.length; i++){
                    if(s[i].equals("Male") ) {
                        male = true;
                    }
                }

                if(male == true){
                    if(s[0].equals("1") && s[1].equals("1") && s[2].equals("1")){
                        w1r1b1.setFill(Color.BLUE);
                    }
                    else if(s[0].equals("1") && s[1].equals("1") && s[2].equals("2")){
                        w1r1b2.setFill(Color.BLUE);
                    }
                    else if(s[0].equals("1") && s[1].equals("1") && s[2].equals("3")){
                        w1r1b3.setFill(Color.BLUE);
                    }
                    else if(s[0].equals("1") && s[1].equals("1") && s[2].equals("4")){
                        w1r1b4.setFill(Color.BLUE);
                    }
                    else if(s[0].equals("1") && s[1].equals("1") && s[2].equals("5")){
                        w1r1b5.setFill(Color.BLUE);
                    }
                    else if(s[0].equals("1") && s[1].equals("1") && s[2].equals("6")){
                        w1r1b6.setFill(Color.BLUE);
                    }
                    else if(s[0].equals("1") && s[1].equals("2") && s[2].equals("1")){
                        w1r2b1.setFill(Color.BLUE);
                    }
                    else if(s[0].equals("1") && s[1].equals("2") && s[2].equals("2")){
                        w1r2b2.setFill(Color.BLUE);
                    }
                    else if(s[0].equals("1") && s[1].equals("2") && s[2].equals("3")){
                        w1r2b3.setFill(Color.BLUE);
                    }
                    else if(s[0].equals("1") && s[1].equals("2") && s[2].equals("4")){
                        w1r2b4.setFill(Color.BLUE);
                    }
                    else if(s[0].equals("1") && s[1].equals("2") && s[2].equals("5")){
                        w1r2b6.setFill(Color.BLUE);
                    }
                    else if(s[0].equals("1") && s[1].equals("2") && s[2].equals("6")){
                        w1r2b5.setFill(Color.BLUE);
                    }
                    else if(s[0].equals("1") && s[1].equals("3") && s[2].equals("1")){
                        w1r3b1.setFill(Color.BLUE);
                    }
                    else if(s[0].equals("1") && s[1].equals("3") && s[2].equals("2")){
                        w1r3b2.setFill(Color.BLUE);
                    }
                    else if(s[0].equals("1") && s[1].equals("3") && s[2].equals("3")){
                        w1r3b3.setFill(Color.BLUE);
                    }
                    else if(s[0].equals("1") && s[1].equals("3") && s[2].equals("4")){
                        w1r3b4.setFill(Color.BLUE);
                    }
                    else if(s[0].equals("1") && s[1].equals("3") && s[2].equals("5")){
                        w1r3b5.setFill(Color.BLUE);
                    }
                    else if(s[0].equals("1") && s[1].equals("3") && s[2].equals("6")){
                        w1r3b6.setFill(Color.BLUE);
                    }
                    else if(s[0].equals("2") && s[1].equals("1") && s[2].equals("1")){
                        w2r1b1.setFill(Color.BLUE);
                    }
                    else if(s[0].equals("2") && s[1].equals("1") && s[2].equals("2")){
                        w2r1b2.setFill(Color.BLUE);
                    }
                    else if(s[0].equals("2") && s[1].equals("1") && s[2].equals("3")){
                        w2r1b3.setFill(Color.BLUE);
                    }
                    else if(s[0].equals("2") && s[1].equals("1") && s[2].equals("4")){
                        w2r1b4.setFill(Color.BLUE);
                    }
                    else if(s[0].equals("2") && s[1].equals("1") && s[2].equals("5")){
                        w2r1b5.setFill(Color.BLUE);
                    }
                    else if(s[0].equals("2") && s[1].equals("1") && s[2].equals("6")){
                        w2r1b6.setFill(Color.BLUE);
                    }
                    else if(s[0].equals("2") && s[1].equals("2") && s[2].equals("1")){
                        w2r2b1.setFill(Color.BLUE);
                    }
                    else if(s[0].equals("2") && s[1].equals("2") && s[2].equals("2")){
                        w2r2b2.setFill(Color.BLUE);
                    }
                    else if(s[0].equals("2") && s[1].equals("2") && s[2].equals("3")){
                        w2r2b3.setFill(Color.BLUE);
                    }
                    else if(s[0].equals("2") && s[1].equals("2") && s[2].equals("4")){
                        w2r2b4.setFill(Color.BLUE);
                    }
                    else if(s[0].equals("2") && s[1].equals("2") && s[2].equals("5")){
                        w2r2b5.setFill(Color.BLUE);
                    }
                    else if(s[0].equals("2") && s[1].equals("2") && s[2].equals("6")){
                        w2r2b6.setFill(Color.BLUE);
                    }
                    else if(s[0].equals("2") && s[1].equals("3") && s[2].equals("1")){
                        w2r3b1.setFill(Color.BLUE);
                    }
                    else if(s[0].equals("2") && s[1].equals("3") && s[2].equals("2")){
                        w2r3b2.setFill(Color.BLUE);
                    }
                    else if(s[0].equals("2") && s[1].equals("3") && s[2].equals("3")){
                        w2r3b3.setFill(Color.BLUE);
                    }
                    else if(s[0].equals("2") && s[1].equals("3") && s[2].equals("4")){
                        w2r3b4.setFill(Color.BLUE);
                    }
                    else if(s[0].equals("2") && s[1].equals("3") && s[2].equals("5")){
                        w2r3b5.setFill(Color.BLUE);
                    }
                    else if(s[0].equals("2") && s[1].equals("3") && s[2].equals("6")){
                        w2r3b6.setFill(Color.BLUE);
                    }
                }
                else{
                    if(s[0].equals("1") && s[1].equals("1") && s[2].equals("1")){
                        w1r1b1.setFill(Color.RED);
                    }
                    else if(s[0].equals("1") && s[1].equals("1") && s[2].equals("2")){
                        w1r1b2.setFill(Color.RED);
                    }
                    else if(s[0].equals("1") && s[1].equals("1") && s[2].equals("3")){
                        w1r1b3.setFill(Color.RED);
                    }
                    else if(s[0].equals("1") && s[1].equals("1") && s[2].equals("4")){
                        w1r1b4.setFill(Color.RED);
                    }
                    else if(s[0].equals("1") && s[1].equals("1") && s[2].equals("5")){
                        w1r1b5.setFill(Color.RED);
                    }
                    else if(s[0].equals("1") && s[1].equals("1") && s[2].equals("6")){
                        w1r1b6.setFill(Color.RED);
                    }
                    else if(s[0].equals("1") && s[1].equals("2") && s[2].equals("1")){
                        w1r2b1.setFill(Color.RED);
                    }
                    else if(s[0].equals("1") && s[1].equals("2") && s[2].equals("2")){
                        w1r2b2.setFill(Color.RED);
                    }
                    else if(s[0].equals("1") && s[1].equals("2") && s[2].equals("3")){
                        w1r2b3.setFill(Color.RED);
                    }
                    else if(s[0].equals("1") && s[1].equals("2") && s[2].equals("4")){
                        w1r2b4.setFill(Color.RED);
                    }
                    else if(s[0].equals("1") && s[1].equals("2") && s[2].equals("5")){
                        w1r2b5.setFill(Color.RED);
                    }
                    else if(s[0].equals("1") && s[1].equals("2") && s[2].equals("6")){
                        w1r2b6.setFill(Color.RED);
                    }
                    else if(s[0].equals("1") && s[1].equals("3") && s[2].equals("1")){
                        w1r3b1.setFill(Color.RED);
                    }
                    else if(s[0].equals("1") && s[1].equals("3") && s[2].equals("2")){
                        w1r3b2.setFill(Color.RED);
                    }
                    else if(s[0].equals("1") && s[1].equals("3") && s[2].equals("3")){
                        w1r3b3.setFill(Color.RED);
                    }
                    else if(s[0].equals("1") && s[1].equals("3") && s[2].equals("4")){
                        w1r3b4.setFill(Color.RED);
                    }
                    else if(s[0].equals("1") && s[1].equals("3") && s[2].equals("5")){
                        w1r3b5.setFill(Color.RED);
                    }
                    else if(s[0].equals("1") && s[1].equals("3") && s[2].equals("6")){
                        w1r3b6.setFill(Color.RED);
                    }
                    else if(s[0].equals("2") && s[1].equals("1") && s[2].equals("1")){
                        w2r1b1.setFill(Color.RED);
                    }
                    else if(s[0].equals("2") && s[1].equals("1") && s[2].equals("2")){
                        w2r1b2.setFill(Color.RED);
                    }
                    else if(s[0].equals("2") && s[1].equals("1") && s[2].equals("3")){
                        w2r1b3.setFill(Color.RED);
                    }
                    else if(s[0].equals("2") && s[1].equals("1") && s[2].equals("4")){
                        w2r1b4.setFill(Color.RED);
                    }
                    else if(s[0].equals("2") && s[1].equals("1") && s[2].equals("5")){
                        w2r1b5.setFill(Color.RED);
                    }
                    else if(s[0].equals("2") && s[1].equals("1") && s[2].equals("6")){
                        w2r1b6.setFill(Color.RED);
                    }
                    else if(s[0].equals("2") && s[1].equals("2") && s[2].equals("1")){
                        w2r2b1.setFill(Color.RED);
                    }
                    else if(s[0].equals("2") && s[1].equals("2") && s[2].equals("2")){
                        w2r2b2.setFill(Color.RED);
                    }
                    else if(s[0].equals("2") && s[1].equals("2") && s[2].equals("3")){
                        w2r2b3.setFill(Color.RED);
                    }
                    else if(s[0].equals("2") && s[1].equals("2") && s[2].equals("4")){
                        w2r2b4.setFill(Color.RED);
                    }
                    else if(s[0].equals("2") && s[1].equals("2") && s[2].equals("5")){
                        w2r2b5.setFill(Color.RED);
                    }
                    else if(s[0].equals("2") && s[1].equals("2") && s[2].equals("6")){
                        w2r2b6.setFill(Color.RED);
                    }
                    else if(s[0].equals("2") && s[1].equals("3") && s[2].equals("1")){
                        w2r3b1.setFill(Color.RED);
                    }
                    else if(s[0].equals("2") && s[1].equals("3") && s[2].equals("2")){
                        w2r3b2.setFill(Color.RED);
                    }
                    else if(s[0].equals("2") && s[1].equals("3") && s[2].equals("3")){
                        w2r3b3.setFill(Color.RED);
                    }
                    else if(s[0].equals("2") && s[1].equals("3") && s[2].equals("4")){
                        w2r3b4.setFill(Color.RED);
                    }
                    else if(s[0].equals("2") && s[1].equals("3") && s[2].equals("5")){
                        w2r3b5.setFill(Color.RED);
                    }
                    else if(s[0].equals("2") && s[1].equals("3") && s[2].equals("6")){
                        w2r3b6.setFill(Color.RED);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void BackBT(javafx.event.ActionEvent actionEvent) throws IOException {
        MenuForAbleCareHome m = new MenuForAbleCareHome();
        m.ChangeScene("AfterLogIn.fxml");
    }
}
