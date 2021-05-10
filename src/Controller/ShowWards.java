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
import java.util.Scanner;

public class ShowWards {
    @FXML
    private Button back;
    @FXML
    private Rectangle w2r1;
    @FXML
    private Rectangle w2r2;
    @FXML
    private Rectangle w2r3;
    @FXML
    private Rectangle w4r4;
    @FXML
    private Rectangle w1r1;
    @FXML
    private Rectangle w1r2;
    @FXML
    private Rectangle w1r3;
    @FXML
    private Rectangle w1r4;
    @FXML
    private Rectangle w1r1b1;
    @FXML
    private Rectangle w1r1b4;
    @FXML
    private Rectangle w1r1b2;
    @FXML
    private Rectangle w1r1b3;
    @FXML
    private Rectangle w1r2b1;
    @FXML
    private Rectangle w1r2b4;
    @FXML
    private Rectangle w1r2b2;
    @FXML
    private Rectangle w1r2b3;
    @FXML
    private Rectangle w1r3b1;
    @FXML
    private Rectangle w1r3b4;
    @FXML
    private Rectangle w1r3b2;
    @FXML
    private Rectangle w1r3b3;
    @FXML
    private Rectangle w1r4b1;
    @FXML
    private Rectangle w1r4b4;
    @FXML
    private Rectangle w1r4b2;
    @FXML
    private Rectangle w1r4b3;
    @FXML
    private Rectangle w2r1b1;
    @FXML
    private Rectangle w2r1b4;
    @FXML
    private Rectangle w2r1b2;
    @FXML
    private Rectangle w2r1b3;
    @FXML
    private Rectangle w2r2b1;
    @FXML
    private Rectangle w2r2b4;
    @FXML
    private Rectangle w2r2b2;
    @FXML
    private Rectangle w2r2b3;
    @FXML
    private Rectangle w2r3b1;
    @FXML
    private Rectangle w2r3b4;
    @FXML
    private Rectangle w2r3b2;
    @FXML
    private Rectangle w2r3b3;
    @FXML
    private Rectangle w2r4b1;
    @FXML
    private Rectangle w2r4b4;
    @FXML
    private Rectangle w2r4b2;
    @FXML
    private Rectangle w2r4b3;

    @FXML
    void Display(ActionEvent event) {
        try {
            // Read username and position
            File myObj = new File("./src/Archive/Bed.txt");
            Scanner myReader = new Scanner(myObj);
            String sid = "", sp = "";
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String s[] = data.split(",");
               if(s[4].equals("M") ){
                    if(s[0].equals("1") && s[1].equals("1") && s[2].equals("1")){
                        w1r1b1.setStroke(Color.BLUE);
                    }
                    else if(s[0].equals("1") && s[1].equals("1") && s[2].equals("2")){
                        w1r1b2.setStroke(Color.BLUE);
                    }
                    else if(s[0].equals("1") && s[1].equals("1") && s[2].equals("3")){
                        w1r1b3.setStroke(Color.BLUE);
                    }
                    else if(s[0].equals("1") && s[1].equals("1") && s[2].equals("4")){
                        w1r1b4.setStroke(Color.BLUE);
                    }
                    else if(s[0].equals("1") && s[1].equals("2") && s[2].equals("1")){
                        w1r2b1.setStroke(Color.BLUE);
                    }
                    else if(s[0].equals("1") && s[1].equals("2") && s[2].equals("2")){
                        w1r2b2.setStroke(Color.BLUE);
                    }
                    else if(s[0].equals("1") && s[1].equals("2") && s[2].equals("3")){
                        w1r2b3.setStroke(Color.BLUE);
                    }
                    else if(s[0].equals("1") && s[1].equals("2") && s[2].equals("4")){
                        w1r2b4.setStroke(Color.BLUE);
                    }
                    else if(s[0].equals("1") && s[1].equals("3") && s[2].equals("1")){
                        w1r3b1.setStroke(Color.BLUE);
                    }
                    else if(s[0].equals("1") && s[1].equals("3") && s[2].equals("2")){
                        w1r3b2.setStroke(Color.BLUE);
                    }
                    else if(s[0].equals("1") && s[1].equals("3") && s[2].equals("3")){
                        w1r3b3.setStroke(Color.BLUE);
                    }
                    else if(s[0].equals("1") && s[1].equals("3") && s[2].equals("4")){
                        w1r3b4.setStroke(Color.BLUE);
                    }
                    else if(s[0].equals("1") && s[1].equals("4") && s[2].equals("1")){
                        w1r4b1.setStroke(Color.BLUE);
                    }
                    else if(s[0].equals("1") && s[1].equals("4") && s[2].equals("2")){
                        w1r4b2.setStroke(Color.BLUE);
                    }
                    else if(s[0].equals("1") && s[1].equals("4") && s[2].equals("3")){
                        w1r4b3.setStroke(Color.BLUE);
                    }
                    else if(s[0].equals("1") && s[1].equals("4") && s[2].equals("4")){
                        w1r4b4.setStroke(Color.BLUE);
                    }
               }
               else if(s[4].equals("F")){
                   if(s[0].equals("2") && s[1].equals("1") && s[2].equals("1")){
                       w2r1b1.setStroke(Color.RED);
                   }
                   else if(s[0].equals("2") && s[1].equals("1") && s[2].equals("2")){
                       w2r1b2.setStroke(Color.RED);
                   }
                   else if(s[0].equals("2") && s[1].equals("1") && s[2].equals("3")){
                       w2r1b3.setStroke(Color.RED);
                   }
                   else if(s[0].equals("2") && s[1].equals("1") && s[2].equals("4")){
                       w2r1b4.setStroke(Color.RED);
                   }
                   else if(s[0].equals("2") && s[1].equals("2") && s[2].equals("1")){
                       w2r2b1.setStroke(Color.RED);
                   }
                   else if(s[0].equals("2") && s[1].equals("2") && s[2].equals("2")){
                       w2r2b2.setStroke(Color.RED);
                   }
                   else if(s[0].equals("2") && s[1].equals("2") && s[2].equals("3")){
                       w2r2b3.setStroke(Color.RED);
                   }
                   else if(s[0].equals("2") && s[1].equals("2") && s[2].equals("4")){
                       w2r2b4.setStroke(Color.RED);
                   }
                   else if(s[0].equals("2") && s[1].equals("3") && s[2].equals("1")){
                       w2r3b1.setStroke(Color.RED);
                   }
                   else if(s[0].equals("2") && s[1].equals("3") && s[2].equals("2")){
                       w2r3b2.setStroke(Color.RED);
                   }
                   else if(s[0].equals("2") && s[1].equals("3") && s[2].equals("3")){
                       w2r3b3.setStroke(Color.RED);
                   }
                   else if(s[0].equals("2") && s[1].equals("3") && s[2].equals("4")){
                       w2r3b4.setStroke(Color.RED);
                   }
                   else if(s[0].equals("2") && s[1].equals("4") && s[2].equals("1")){
                       w2r4b1.setStroke(Color.RED);
                   }
                   else if(s[0].equals("2") && s[1].equals("4") && s[2].equals("2")){
                       w2r4b2.setStroke(Color.RED);
                   }
                   else if(s[0].equals("2") && s[1].equals("4") && s[2].equals("3")){
                       w2r4b3.setStroke(Color.RED);
                   }
                   else if(s[0].equals("2") && s[1].equals("4") && s[2].equals("4")){
                       w2r4b4.setStroke(Color.RED);
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
