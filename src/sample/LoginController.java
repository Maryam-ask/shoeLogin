package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

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



    public void cancelButtonOnAction(ActionEvent event){ // the cancel button and its action
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    public void loginButtonOnAction(ActionEvent event){ // the Login Button and its action

        if(!usernameTextField.getText().isBlank() && !enterPasswordField.getText().isBlank()){
            validateLogin();
        }else {
            loginMessageLabel.setText("Please enter username and password");
        }
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

    public void validateLogin(){ // To connect to my DB
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        String verifyLogin = "select count(1) from person where username ='"+usernameTextField.getText()+"' and password='"+enterPasswordField.getText()+"'";
        try{

            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(verifyLogin);

            while (queryResult.next()){
                if(queryResult.getInt(1)==1){
                    loginMessageLabel.setText("congratulation!");

                }else {
                    loginMessageLabel.setText("Invalid login. Please try again");
                }
            }

        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }
}
