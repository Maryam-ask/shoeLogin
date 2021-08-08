package sample;

import com.controller.AdminPageController;
import com.controller.LoginController;
import com.controller.RegisterController;
import com.controller.ShoesTableController;
import com.model.to.Person;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;


public class Main extends Application {


    private Stage stage;

    public static void main(String[] args) {
        launch(args);
    }

    //Stage stage;

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        //Parent root = FXMLLoader.load(getClass().getResource("D:\\Java_Home(training)\\shoeLogin\\src\\main\\resources\\login.fxml"));
        FXMLLoader loader = new FXMLLoader(new File("D:\\Java_Home(training)\\shoeLogin\\src\\main\\resources\\login.fxml").toURI().toURL());
        Parent root = loader.load();

        LoginController controller = loader.getController();
        controller.setMain(this); // Baraye Controller Login()---> Main ra set mikonim

        stage.setTitle("Login page");
        stage.setScene(new Scene(root, 550, 400));
        stage.show();
    }

    public void registerStage() {
        try {

            stage.close();
            stage = new Stage();

            FXMLLoader loader = new FXMLLoader(new File("D:\\Java_Home(training)\\shoeLogin\\src\\main\\resources\\register.fxml").toURI().toURL());
            Parent root = loader.load();

            RegisterController controller=loader.getController();
            controller.setMain(this);



            //stage = new Stage();
            stage.setTitle("registering page");
            stage.setScene(new Scene(root, 520, 600));
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }

    public void shoeTableView(Person person){
        try {


            FXMLLoader loader = new FXMLLoader(new File("D:\\Java_Home(training)\\shoeLogin\\src\\main\\resources\\shoesTable.fxml").toURI().toURL());
            Parent root = loader.load();

            //Get controller.
            //ShoesTableContoller shoeTable = loader.getController();
            //System.out.println(shoeTable.setWelcomeText());
            ShoesTableController shoeTable = loader.getController();
            shoeTable.setMain(this);
           // shoeTable.setSelectedPerson((Person) stage.getScene().getUserData());
            //shoeTable.setSelectedPerson(person);
            shoeTable.setWelcomeText(person);
            stage.close();
            stage = new Stage();
            stage.setTitle("List of shoes page");
            stage.setScene(new Scene(root, 520, 600));
            stage.show();


        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }

    }

    public void adminPageStage(Person person){
        try {
            FXMLLoader loader = new FXMLLoader(new File("D:\\Java_Home(training)\\shoeLogin\\src\\main\\resources\\adminPage.fxml").toURI().toURL());
            Parent root = loader.load();

            AdminPageController adminPage = loader.getController();
            adminPage.setMain(this);
            adminPage.setWelcomeText(person);

            stage.close();
            stage = new Stage();
            stage.setTitle("Admin page");
            stage.setScene(new Scene(root,604,620));
            stage.show();


        }catch (Exception e){
            e.getMessage();
            e.printStackTrace();
            e.getCause();
        }
    }
}
