package com.controller;

import com.model.da.PersonDAO;
import com.model.da.PersonDAOImpl;
import com.model.to.Person;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import com.model.da.DatabaseConnection;
import sample.PasswordSecurity;

import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ResourceBundle;
import java.util.UUID;


/**
 * Created by Maryam Askari
 * Date: 5/16/2021
 * Time: 7:49 PM
 * Project: IntelliJ IDEA
 */
public class RegisterController implements Initializable {

    @FXML
    private ImageView shieldImageView;
    @FXML
    private Button closeButton;
    @FXML
    private Label registrationMessageLabel;
    @FXML
    private Label confirmedPasswordLabel;
    @FXML
    private TextField firstNameTextField;
    @FXML
    private TextField lastNameTextField;
    @FXML
    private TextField usernameTextField;
    @FXML
    private TextField addressTextField;
    @FXML
    private TextField phoneNumberTextField;
    @FXML
    private PasswordField setPasswordField;
    @FXML
    private PasswordField confirmPasswordField;

    Person person = new Person();



    public void closeButtonOnAction(ActionEvent event) { // the close button and its action
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
        Platform.exit();
    }

    public void registerButtonOnAction(ActionEvent event) {
        if (setPasswordField.getText().equals(confirmPasswordField.getText())) {
            registerUser();
            confirmedPasswordLabel.setText("Password is set!");
            registrationMessageLabel.setText("User has been registered successfully!");
        } else {
            confirmedPasswordLabel.setText("Password does not match!");
        }

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File shieldImageFile = new File("Images/shieldShoeLogo.jpg");
        Image shieldImage = new Image(shieldImageFile.toURI().toString());
        shieldImageView.setImage(shieldImage);
    }

    public void registerUser(){
        person.setId(1);
        person.setName(firstNameTextField.getText());
        person.setFamily(lastNameTextField.getText());
        person.setUserName(usernameTextField.getText());
        person.setPassword(PasswordSecurity.shaHashing(setPasswordField.getText()));
        person.setPhone(phoneNumberTextField.getText());
        person.setAddress(addressTextField.getText());

        PersonDAO personDAO = new PersonDAOImpl();
        personDAO.insertRegisteredPerson(person);

    }


    /* public void registerUser() {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connection = connectNow.getConnection();

        String firstName = firstNameTextField.getText();
        String lastName = lastNameTextField.getText();
        String userName = usernameTextField.getText();
        String password = PasswordSecurity.shaHashing(phoneNumberTextField.getText());
        String address = addressTextField.getText();
        String phoneNumber = phoneNumberTextField.getText();

        String insertFields = "insert into person (name, family, username, password, address, phone) values(''";
        String insertValues = firstName + "','" + lastName + "','" + userName + "','" + password + "','" + address + "'," + phoneNumber + ")";
        String insertToRegister = insertFields + insertValues;

        try {
            PreparedStatement preparedStatement= connection.prepareStatement(insertToRegister);


            registrationMessageLabel.setText("User has been registered successfully!");

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }
     */

}
