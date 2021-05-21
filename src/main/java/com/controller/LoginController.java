package com.controller;

import com.model.da.PersonDAOImpl;
import com.model.to.Person;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import com.model.da.DatabaseConnection;
import sample.Main;
import sample.PasswordSecurity;

import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    private Button cancelButton;
    @FXML
    private Label loginMessageLabel;
    @FXML
    private ImageView brandingImageView;
    @FXML
    private ImageView lockImageView;
    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField enterPasswordField;


    public void cancelButtonOnAction(ActionEvent event) { // the cancel button and its action
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    public void loginButtonOnAction(ActionEvent event) { // the Login Button and its action
        String userName = usernameTextField.getText();
        //String password = PasswordSecurity.shaHashing(enterPasswordField.getText());
        String password = enterPasswordField.getText();

        if (!usernameTextField.getText().isBlank() && !enterPasswordField.getText().isBlank()) {
            //validateLogin();
            PersonDAOImpl personDAO = new PersonDAOImpl();
            Person person = personDAO.selectValidPerson(userName, password);

            if (person.getUserName().equals(userName) && person.getPassword().equals(password)){
                loginMessageLabel.setText("congratulation!");
            }else {
                loginMessageLabel.setText("Invalid login. Please try again");
            }

        } else {
            loginMessageLabel.setText("Please enter username and password");
        }
    }

    public void registerButtonOnAction(ActionEvent event) {
        creatAccountForm();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {  // For the picture to initiate the images
        File brandingFile = new File("Images/shoeLogo.jpg");
        Image barndingImage = new Image(brandingFile.toURI().toString());
        brandingImageView.setImage(barndingImage);

        File lockFile = new File("Images/lockIcon.png");
        Image lockImage = new Image(lockFile.toURI().toString());
        lockImageView.setImage(lockImage);
    }

    public void validateLogin() { // To connect to my DB

        String password = PasswordSecurity.shaHashing(enterPasswordField.getText());

        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        String verifyLogin = "select count(1) from person where username ='" + usernameTextField.getText() + "' and password='" + password + "'";
        try {

            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(verifyLogin);

            while (queryResult.next()) {
                if (queryResult.getInt(1) == 1) {//TODO get  person object
                    loginMessageLabel.setText("congratulation!");
                    //TODO go to next page

                } else {
                    loginMessageLabel.setText("Invalid login. Please try again");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }


    public void creatAccountForm() {
        try {
            // Parent root = FXMLLoader.load(getClass().getResource("/resources/register.fxml"));


            Main.getStage().close();

            FXMLLoader loader = new FXMLLoader(new File("D:\\Java_Home(training)\\shoeLogin\\src\\main\\resources\\register.fxml").toURI().toURL());
            Parent root = loader.load();
            Stage registerStage = new Stage();
            registerStage = new Stage();
            registerStage.setTitle("Login page");
            registerStage.setScene(new Scene(root, 520, 567));
            registerStage.show();
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }


}
