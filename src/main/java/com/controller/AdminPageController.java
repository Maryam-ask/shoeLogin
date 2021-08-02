package com.controller;

import com.model.to.Person;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Maryam Askari
 * Date: 8/2/2021
 * Time: 10:20 AM
 * Project: IntelliJ IDEA
 */
public class AdminPageController implements Initializable {
    @FXML
    private ImageView labelImage;
    @FXML
    private Label welcomeText;




    public void setWelcomeText(Person person){
        welcomeText.setText("Welcome " + person.getName() + "!");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File imageLogoFile = new File("Images/shieldShoeLogo.jpg");
        Image imageLogo = new Image(imageLogoFile.toURI().toString());
        labelImage.setImage(imageLogo);

    }

}
