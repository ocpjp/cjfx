package sample;
import com.jfoenix.controls.JFXRippler;
import com.jfoenix.controls.JFXTabPane;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {

    static Stage stage;
    @Override
    public void start(Stage primaryStage) throws Exception{

        FXMLLoader loader=new FXMLLoader(getClass().getResource("sample.fxml"));
        Parent root = loader.load();
        Scene scene=new Scene(root, 600, 350);

        primaryStage.setScene(scene);
        primaryStage.show();
        Controller c=loader.getController();

        c.Root.setBackground(Bg.getbg(Bg.red));
        System.out.println(Thread.currentThread());
        stage=primaryStage;
        System.out.println(Thread.activeCount());
        }


    public static void main(String[] args) {
        launch(args);


    }
}
