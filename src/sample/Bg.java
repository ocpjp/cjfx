package sample;

import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

public class Bg {
    static String red="red";
    public static Background getbg(String color){
        Background back=null;
        if(color.equals(red)){
           back=new Background(new BackgroundFill(Color.rgb(170, 68, 4),CornerRadii.EMPTY.EMPTY, Insets.EMPTY.EMPTY)) ;
        }
        return back;
    }
}
