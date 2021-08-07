package com.controller;

import com.model.da.PersonDAO;
import com.model.da.PersonDAOImpl;
import com.model.to.IdGenerator;
import com.model.to.Person;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import sample.Main;
import sample.PasswordSecurity;

import java.io.File;
import java.net.URL;
import java.time.LocalDate;
import java.time.Period;
import java.util.ResourceBundle;


/**
 * Created by Maryam Askari
 * Date: 5/16/2021
 * Time: 7:49 PM
 * Project: IntelliJ IDEA
 */
public class RegisterController implements Initializable {

    private Main main;
    @FXML
    private ImageView shieldImageView;
    @FXML
    private DatePicker birthdayDatePicker;
    @FXML
    private Label registrationMessageLabel;
    @FXML
    private Label confirmedPasswordLabel;
    @FXML
    private Label userNameCheckMessage;
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
    @FXML
    private RadioButton customerButton;
    @FXML
    private RadioButton adminButton;

    private Person person;


    /**
     * a method to return Main object which declared in current Class.
     * @return MainClass Value
     */
    public Main getMain() {
        return main;
    }

    /**
     * A method to set a MainClass Object into MainClass object which declared in current Class.
     * @param main
     */
    public void setMain(Main main) {
        this.main = main;
    }

    /**
     * A method which includes the functions for the back button.
     * When we click on back button the stage in current class will go back to start stage.
     * @param event
     * @throws Exception
     */
    @FXML
    public void backButtonOnAction(ActionEvent event) throws Exception {

        main.start(main.getStage());
    }

    /**
     *A method which includes the functions for the register button.
     * when we click on register button it will set the person information into database
     * with help of method registerUser() and will trow the person Object into ShoeTableView in the Main Class.
     *It will also check if the password and confirmed password are equals.
     * @param event
     */
    @FXML
    public void registerButtonOnAction(ActionEvent event) {
        if(! new PersonDAOImpl().userNameCheck(usernameTextField.getText())) {
            if (setPasswordField.getText().equals(confirmPasswordField.getText())) {
                confirmedPasswordLabel.setText("Password is set!");
                registerUser();
                registrationMessageLabel.setText("User has been registered successfully!");
                //Main main = new Main();
                if (person.getRole().equals("Customer")) {
                    getMain().shoeTableView(getPerson());
                } else if (person.getRole().equals("Admin")) {
                    getMain().adminPageStage(getPerson());
                }

            } else {
                confirmedPasswordLabel.setText("Password does not match!");
            }
        }else {
            userNameCheckMessage.setText("This username already exist!");
        }

    }

    /**
     * An Override method initialize() which is and abstract method in interface Initializable that we implement in our Class.
     * We use this method to shoe our pictures in FX.
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File shieldImageFile = new File("Images/shieldShoeLogo.jpg");
        Image shieldImage = new Image(shieldImageFile.toURI().toString());
        shieldImageView.setImage(shieldImage);
    }

    /**
     * A Method that get information from all TextFiled boxes in the register stage
     * and add this information to person Object
     * and insert person to the database with PersonDAO object and method insertRegisteredPerson(Person).
     */
    public void registerUser() {
        person = new Person();

        person.setId(IdGenerator.generateUniqueId());
        person.setName(firstNameTextField.getText());
        person.setFamily(lastNameTextField.getText());
        person.setUserName(usernameTextField.getText());
        person.setPassword(PasswordSecurity.shaHashing(setPasswordField.getText()));
        person.setPhone(phoneNumberTextField.getText());
        person.setAddress(addressTextField.getText());
        //TODO if bithdate != null
        if (birthdayDatePicker.getValue()!= null) {
            person.setAge(getBirthdayDateToAge());
        }else {
            person.setAge(1);
        }
        person.setRole(getRole());




        PersonDAO personDAO = new PersonDAOImpl();
        personDAO.insertRegisteredPerson(person);
    }

    /**
     * a method to return the Person Object which declared in current Class
     *
     * @return Person Object
     */
    public Person getPerson() {
        return person;
    }

    /**
     * A method to set a person Object into the person object which declared in this Class.
     *
     * @param person
     */
    public void setPerson(Person person) {
        this.person = person;
    }

    /**
     * A method to get the person's birthday date and return the age of the person
     * @return int age of the person
     */
    public int getBirthdayDateToAge(){
        LocalDate birthDay = birthdayDatePicker.getValue();
        LocalDate nowDate = LocalDate.now();

        int age = Period.between(birthDay,nowDate).getYears();
        return age;
    }

    /**
     * A method to get role from selected RadioButton
     * @return String
     */
    @FXML
    public String getRole(){
        String role="";
        if(customerButton.isSelected()){
            role = "Customer";
        }else if (adminButton.isSelected()){
            role = "Admin";
        }
        return role;
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
