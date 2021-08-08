package com.controller;

import com.model.da.PersonDAOImpl;
import com.model.to.Person;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import sample.Main;
import sample.PasswordSecurity;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    private Main main;

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

    private Person person;


    /**
     * A method with function for the cancel button in FX.
     * It will close the stage if we click on cancel button.
     *
     * @param event
     */
    public void cancelButtonOnAction(ActionEvent event) { // the cancel button and its action
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    /**
     * A method for login button function.
     * First it will check if the TextFiled are empty or not
     * and then will select the person with given username and password
     * and check if this person exist or not.
     * it will also write some information for user in loginMessageLabel.
     *
     * @param event
     * @throws IOException
     */
    public void loginButtonOnAction(ActionEvent event) throws IOException { // the Login Button and its action

        if (!usernameTextField.getText().isBlank() && !enterPasswordField.getText().isBlank()) {

            String userName = usernameTextField.getText();
            String password = PasswordSecurity.shaHashing(enterPasswordField.getText());

            // validateLogin();
            PersonDAOImpl personDAO = new PersonDAOImpl();
            person = personDAO.selectValidPerson(userName, password);

            if (userName.equals(person.getUserName()) && password.equals(person.getPassword())) {
                if (person != null) {

                    loginMessageLabel.setText("congratulation!");
                    // Go to Shoes Table Page
                    if (person.getRole().equals("Customer")) {
                        //Main.getStage().getScene().setUserData(person);
                        getMain().shoeTableView(person);
                    } else if (person.getRole().equals("Admin")) {
                        getMain().adminPageStage(person);
                    }

                }
            } else {
                loginMessageLabel.setText("Invalid login. Please try again");
            }
        } else {
            loginMessageLabel.setText("Please enter username and password");
        }
    }

    /**
     * With clicking on register button it will connect to register stage in Main Class.
     *
     * @param event
     */
    public void registerButtonOnAction(ActionEvent event) {
        main.registerStage();
    }

    /**
     * An Override method initialize() which is and abstract method in interface Initializable that we implement in our Class.
     * We use this method to shoe our pictures in FX.
     *
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {  // For the picture to initiate the images
        File brandingFile = new File("Images/shoeLogo.jpg");
        Image barndingImage = new Image(brandingFile.toURI().toString());
        brandingImageView.setImage(barndingImage);

        File lockFile = new File("Images/lockIcon.png");
        Image lockImage = new Image(lockFile.toURI().toString());
        lockImageView.setImage(lockImage);
    }


    /**
     * When this method called, it will pass the selected person object to
     * the detailed view
     *
     * @param event
     * @throws IOException
     */
    public void sendPersonInfoToNewScene(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("resource\\shoesTable.fxml")); // loader will look at this file
        Parent loginViewParent = loader.load();
        Scene loginViewScene = new Scene(loginViewParent);

        // Access the controller and call a method.
        //ShoesTableController controller = loader.getController(); // access the controller in that file
        //controller.initData(getPerson());

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(loginViewScene);
        window.show();


    }

    /**
     * A method to get the declared main object in current Class
     *
     * @return
     */

    public Main getMain() {
        return main;
    }

    /**
     * A method to select a main object and add it to the current main object which declared in this Class.
     *
     * @param main
     */
    public void setMain(Main main) {
        this.main = main;
    }


    /*public void validateLogin() { // To connect to my DB

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

     */

    /*public boolean validateLogin(String username, String password){
        PersonDAO personDAO = new PersonDAOImpl();
        person = personDAO.selectValidPerson(username,password);
        if (username.equals(person.getUserName()) && password.equals(person.getPassword()))
            return true;
        return false;

    }*/


    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
