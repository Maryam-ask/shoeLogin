package com.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Maryam Askari
 * Date: 5/21/2021
 * Time: 5:56 PM
 * Project: IntelliJ IDEA
 */
public class ShoesTableContoller implements Initializable {

    @FXML
    private ImageView labelImage;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File shieldImageFile = new File("Images/shieldShoeLogo.jpg");
        Image shieldImage = new Image(shieldImageFile.toURI().toString());
        labelImage.setImage(shieldImage);
    }

}
