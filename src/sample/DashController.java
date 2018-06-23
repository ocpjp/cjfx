package sample;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXScrollPane;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.SplitPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class DashController  {
    public Background getBackground(int r,int g,int b){
        return new Background(new BackgroundFill(Color.rgb(r, g, b),CornerRadii.EMPTY.EMPTY, Insets.EMPTY.EMPTY));
    }
    public void init(){
        ap.setBackground(getBackground(209,163,12));
        vb.setBackground(getBackground(68,150,170));
        vb1.setBackground(getBackground(60,60,60));


       event();
       test();

        AnchorPane.setLeftAnchor(vb,0.0);
        AnchorPane.setRightAnchor(vb1,0.0);
    }

    public void test(){
        if(prev!=null){
            setbg(prev,lblue);
        }
        prev=current;
        System.out.println("previous current");
        setbg(current,dblue);

    }
    public void test1(){
        if(prev!=null){
            System.out.println("inside completed clicked if");
            setbg(prev,lblue);
        }
        System.out.println("outside completed if");
        prev=completed;
        setbg(completed,dblue);

    }
    public void test2(){
        if(prev!=null){
            System.out.println("inside completed clicked if");
            setbg(prev,lblue);
        }
        System.out.println("outside completed if");
        prev=performance;
        setbg(performance,dblue);

    }
    public void test3(){
        if(prev!=null){
            System.out.println("inside completed clicked if");
            setbg(prev,lblue);
        }
        System.out.println("outside completed if");
        prev=profile;
        setbg(profile,dblue);

    }
    public void test4(){
        if(prev!=null){
            System.out.println("inside completed clicked if");
            setbg(prev,lblue);
        }
        System.out.println("outside completed if");
        prev=ask;
        setbg(ask,dblue);

    }
    public void test5(){
        if(prev!=null){
            System.out.println("inside completed clicked if");
            setbg(prev,lblue);
        }
        System.out.println("outside completed if");
        prev=about;
        setbg(about,dblue);

    }

        private void event(){
            current.onMouseEnteredProperty().setValue((ev)->{
                current.setBackground(getBackground(67,100,169));
            });
            current.onMouseExitedProperty().setValue((ev)->{
                if(prev!=current)
                    current.setBackground(getBackground(68,150,170));
            });



            completed.onMouseEnteredProperty().setValue((ev)->{
                completed.setBackground(getBackground(67,100,169));
            });
            completed.onMouseExitedProperty().setValue((ev)->{
                if(prev!=completed)
                completed.setBackground(getBackground(68,150,170));
            });



            profile.onMouseEnteredProperty().setValue((ev)->{
                profile.setBackground(getBackground(67,100,169));
            });
            profile.onMouseExitedProperty().setValue((ev)->{
                if(prev!=profile)
                profile.setBackground(getBackground(68,150,170));
            });



            performance.onMouseEnteredProperty().setValue((ev)->{
                performance.setBackground(getBackground(67,100,169));
            });
            performance.onMouseExitedProperty().setValue((ev)->{
                if(prev!=performance)
                performance.setBackground(getBackground(68,150,170));
            });



            ask.onMouseEnteredProperty().setValue((ev)->{
                ask.setBackground(getBackground(67,100,169));
            });
            ask.onMouseExitedProperty().setValue((ev)->{
                if (prev!=ask)
                ask.setBackground(getBackground(68,150,170));
            });


            about.onMouseEnteredProperty().setValue((ev)->{
                about.setBackground(getBackground(67,100,169));
            });
            about.onMouseExitedProperty().setValue((ev)->{
                if(prev!=about)
                about.setBackground(getBackground(68,150,170));
            });


        }
        public void setbg(JFXButton bt,String color){
            if(color.equals(dblue)){
                System.out.println("DARK BACKGROUND FOR:"+bt.getId());
                bt.setBackground(getBackground(67,100,169));
            }
            else if(color.equals(lblue)){
                System.out.println("light background for:"+bt.getId());
                bt.setBackground(getBackground(68,150,170));
            }
        }


    @FXML
    JFXButton current;
@FXML
HBox ap;
@FXML
    public VBox vb;
@FXML
    public JFXButton completed;

    @FXML
    public JFXButton about;

@FXML
    public JFXButton performance;

    @FXML
    public JFXButton profile;

    @FXML
    public JFXButton ask;

    public JFXButton prev;
    @FXML public AnchorPane vb1;
    String lblue="lblue";
    String dblue="dblue";

}
