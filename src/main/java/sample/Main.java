package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;


public class Main extends Application {


    private static Stage stage;

    public static void main(String[] args) {
        launch(args);
    }

    //Stage stage;

    public static Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        Main.stage = stage;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        //Parent root = FXMLLoader.load(getClass().getResource("D:\\Java_Home(training)\\shoeLogin\\src\\main\\resources\\login.fxml"));
        FXMLLoader loader = new FXMLLoader(new File("D:\\Java_Home(training)\\shoeLogin\\src\\main\\resources\\login.fxml").toURI().toURL());
        Parent root = loader.load();
        stage.setTitle("Login page");
        stage.setScene(new Scene(root, 550, 400));
        stage.show();
    }

    public void registerStage() {
        try {
            stage.close();

            FXMLLoader loader = new FXMLLoader(new File("D:\\Java_Home(training)\\shoeLogin\\src\\main\\resources\\register.fxml").toURI().toURL());
            Parent root = loader.load();
            stage = new Stage();
            stage.setTitle("Login page");
            stage.setScene(new Scene(root, 520, 600));
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }

    public void shoeTableView(){
        try {
            stage.close();

            FXMLLoader loader = new FXMLLoader(new File("D:\\Java_Home(training)\\shoeLogin\\src\\main\\resources\\shoesTable.fxml").toURI().toURL());
            Parent root = loader.load();
            stage = new Stage();
            stage.setTitle("Login page");
            stage.setScene(new Scene(root, 520, 600));
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }

    }
}
