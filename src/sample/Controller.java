package sample;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.json.JSONObject;

import java.awt.*;
import java.io.IOException;

public class Controller {
    @FXML private JFXPasswordField pswd;
    @FXML
    private Label status;
    @FXML
    private JFXButton login;
    @FXML
    private JFXTextField htno;
    @FXML
    public   GridPane Root;


    @FXML
    private void handleButtonClick(ActionEvent event) {
        if (event.getSource() ==  login) {
            String ht=htno.getText();
            String ps=pswd.getText();

            new Thread(() -> {
                String ret=User.login(ht,ps);
                try {
                    JSONObject jsonObject = new JSONObject(ret);
                    if(jsonObject.getString("message").equals("success")){
                        User.userdata=jsonObject;
                        Platform.runLater(()->{
                            status.setText(" ");

                            FXMLLoader loader=new FXMLLoader(getClass().getResource("dash.fxml"));
                            Parent root=null;
                            try {
                                root= loader.load();

                            }
                            catch (IOException ioe){
                                System.out.println("fuck");
                            }

                            Root.getScene().setRoot(root);
                            DashController dsh=(DashController) loader.getController();
                            dsh.init();
                            Main.stage.setMaximized(true);

                        });
                        }
                    else{
                        Platform.runLater(()->{
                            status.setText("htno or password incorrect");
                        });
                    }
                }
                catch (Exception e){

                }
            }).start();

        }
    }
}
