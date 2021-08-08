package com.controller;

import com.model.to.Person;
import com.model.to.Shoe;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import sample.Main;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by Maryam Askari
 * Date: 5/21/2021
 * Time: 5:56 PM
 * Project: IntelliJ IDEA
 */
public class ShoesTableController implements Initializable {

    // private Person selectedPerson;

    /*   public Person getSelectedPerson() {
           return selectedPerson;
       }

       public void setSelectedPerson(Person selectedPerson) {
           this.selectedPerson = selectedPerson;
       }*/
    @FXML
    private Button cancelButton;
    @FXML
    private Button backToLonginButton;
    @FXML
    private ImageView labelImage;
    @FXML
    private Label welcomeText;
    @FXML
    private TableView<Shoe> shoeTableView;
    @FXML
    private TableColumn<Shoe, Integer> shoeIdColumn;
    @FXML
    private TableColumn<Shoe, String> shoeNameColumn;
    @FXML
    private TableColumn<Shoe, String> shoeColorColumn;
    @FXML
    private TableColumn<Shoe, String> shoeBrandColumn;
    @FXML
    private TableColumn<Shoe, Integer> shoeSizeColumn;
    @FXML
    private TableColumn<Shoe, String> shoeTypeColumn;
    @FXML
    private TableColumn<Shoe, Double> shoePriseColumn;
    @FXML
    private TableColumn<Shoe, Boolean> selectedCol;

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    private Main main;
    // @FXML
    //private TableColumn shoeCheckBoxColumn;


    private ObservableList<Shoe> shoeList;

    public ShoesTableController() {
    }

    @FXML
    public void cancelButtonOnAction(ActionEvent event) { // the cancel button and its action
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    public void backToLonginButtonOnAction(ActionEvent event) throws Exception {
        main.start(main.getStage());
    }

    public void setWelcomeText(Person person) throws IOException {
        //getPersonInfo();
        System.out.println("person.getId() : " + person.getId());
        welcomeText.setText("Welcome " + person.getName() + "!");
    }

    /**
     * An Override method initialize() which is and abstract method in interface Initializable that we implement in current Class.
     * We use this method to shoe our pictures in FX.
     *
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File shieldImageFile = new File("Images/shieldShoeLogo.jpg");
        Image shieldImage = new Image(shieldImageFile.toURI().toString());
        labelImage.setImage(shieldImage);


        //Adding ColumnsToTableView();
        addShoeToList();

        shoeIdColumn.setCellValueFactory(new PropertyValueFactory<Shoe, Integer>("id"));
        shoeNameColumn.setCellValueFactory(new PropertyValueFactory<Shoe, String>("name"));
        shoeColorColumn.setCellValueFactory(new PropertyValueFactory<Shoe, String>("color"));
        shoeBrandColumn.setCellValueFactory(new PropertyValueFactory<Shoe, String>("brand"));
        shoeSizeColumn.setCellValueFactory(new PropertyValueFactory<Shoe, Integer>("size"));
        shoeTypeColumn.setCellValueFactory(new PropertyValueFactory<Shoe, String>("type"));
        shoePriseColumn.setCellValueFactory(new PropertyValueFactory<Shoe, Double>("prise"));
        //shoeCheckBoxColumn.setCellFactory(new PropertyValueFactory<Shoe, String>("checkbox"));

        selectedCol.setCellValueFactory(new PropertyValueFactory<Shoe, Boolean>("selectable"));
        selectedCol.setCellFactory(CheckBoxTableCell.forTableColumn(selectedCol));

        CheckBox select_all = new CheckBox();
        select_all.selectedProperty().addListener(new ChangeListener<Boolean>() {
            public void changed(ObservableValue<? extends Boolean> ov,
                                Boolean old_val, Boolean new_val) {
                if (new_val) {
                    for (Shoe p : shoeList) {
                        p.setSelectable(true);
                    }

                } else {
                    for (Shoe p : shoeList) {
                        p.setSelectable(false);
                    }
                }


            }
        });
        selectedCol.setGraphic(select_all);
        selectedCol.setEditable(true);
        shoeTableView.setEditable(true);

        shoeTableView.setItems(shoeList);
    }


    public void addShoeToList() {
    /*    ShoeDAO shoeDAO = new ShoeDAOImpl();
        List<Shoe> shoesInDB = shoeDAO.selectShoes();

        shoeList = FXCollections.observableArrayList(shoesInDB);*/

        List<Shoe> list = new ArrayList<>();
        Shoe s1 = new Shoe(1, "test1", "red", 24, "Nike", "hhh", 10.0);
        //s1.setSelectable(false);
        list.add(s1);
        Shoe s2 = new Shoe(1, "test1", "red", 24, "Nike", "hhh", 10.0);
        //s2.setSelectable(false);
        list.add(s2);
        Shoe s3 = new Shoe(1, "test1", "red", 24, "Nike", "hhh", 10.0);
        //s3.setSelectable(false);
        list.add(s3);
        Shoe s4 = new Shoe(1, "test1", "red", 24, "Nike", "hhh", 10.0);
        //s4.setSelectable(true);
        list.add(s4);
        shoeList = FXCollections.observableArrayList(list);
    }

}
