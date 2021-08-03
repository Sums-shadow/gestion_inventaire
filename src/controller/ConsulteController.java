/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.effect.BoxBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import zunayedhassan.AnimateFX.FadeInUpAnimation;
import zunayedhassan.AnimateFX.FlipInXAnimation;

/**
 * FXML Controller class
 *
 * @author User
 */
public class ConsulteController implements Initializable {
    @FXML
    private AnchorPane root;
    @FXML
    private ImageView logo;
    @FXML
    private Pane p1;
    @FXML
    private ImageView i1;
    @FXML
    private Pane btnRtm;
    @FXML
    private ImageView i2;
    @FXML
    private StackPane rot;
    @FXML
    private AnchorPane first;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initImage();
        initAnim();
    }    

    @FXML
    private void onBd(MouseEvent event) {
        gotos("/vue/departement/bd.fxml");
    }

    @FXML
    private void onRTM(MouseEvent event) {
          gotos("/vue/departement/rtm.fxml");
    }

    private void initImage() {
       logo.setImage(new Image("/images/logo1.png"));
       i1.setImage(new Image("/images/bg.jpg"));
              i2.setImage(new Image("/images/bg.jpg"));

        BoxBlur bb = new BoxBlur();
        bb.setWidth(10);
       
        bb.setIterations(1);
        i1.setEffect(bb);
        i2.setEffect(bb);
    }

    private void initAnim() {
        
        FlipInXAnimation b1=new FlipInXAnimation(p1);
                FlipInXAnimation b2=new FlipInXAnimation(btnRtm);
                FadeInUpAnimation b3=new FadeInUpAnimation(logo);
                
                b1.Play();b2.Play();b3.Play();

    }
    
        public void gotos(String path) {
        try {
            FXMLLoader fXMLLoader = new FXMLLoader();
            fXMLLoader.load(getClass().getResource(path).openStream());
            AnchorPane anchorPane = fXMLLoader.getRoot();
            root.getChildren().clear();
            root.getChildren().add(anchorPane);
        } catch (IOException ex) {
            System.err.println("error occured " + ex);
        }
    }

    
}
