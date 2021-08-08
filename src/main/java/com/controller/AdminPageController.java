package com.controller;

import com.model.da.PersonDAO;
import com.model.da.PersonDAOImpl;
import com.model.da.ShoeDAO;
import com.model.da.ShoeDAOImpl;
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
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by Maryam Askari
 * Date: 8/2/2021
 * Time: 10:20 AM
 * Project: IntelliJ IDEA
 */
public class AdminPageController implements Initializable {

    private Main main;
    @FXML
    private ImageView labelImage;
    @FXML
    private Label welcomeText;
    @FXML
    private Button editPersonsButton;
    @FXML
    private Button editShoesButton;
    @FXML
    private Button cancelButton;
    @FXML
    private Button backToLoginButton;
    @FXML
    private TableView<Person> personTable;
    @FXML
    private TableView<Shoe> shoeTable;
    @FXML
    private TableColumn<Person, Integer> p_idColumn;
    @FXML
    private TableColumn<Person, String> p_nameColumn;
    @FXML
    private TableColumn<Person, String> p_familyColumn;
    @FXML
    private TableColumn<Person, String> p_usernameColumn;
    @FXML
    private TableColumn<Person, Integer> p_ageColumn;
    @FXML
    private TableColumn<Person, String> p_addressColumn;
    @FXML
    private TableColumn<Person, String> p_phoneNumberColumn;
    @FXML
    private TableColumn<Person, Boolean> p_selectColumn;
    @FXML
    private TableColumn<Shoe, Integer> sh_idColumn;
    @FXML
    private TableColumn<Shoe, String> sh_nameColumn;
    @FXML
    private TableColumn<Shoe, String> sh_colorColumn;
    @FXML
    private TableColumn<Shoe, Integer> sh_sizeColumn;
    @FXML
    private TableColumn<Shoe, String> sh_brandColumn;
    @FXML
    private TableColumn<Shoe, String> sh_typeColumn;
    @FXML
    private TableColumn<Shoe, Double> sh_priseColumn;
    @FXML
    private TableColumn<Shoe, Boolean> sh_selectColumn;



    private ObservableList<Person> personObservableList;
    private ObservableList<Shoe> shoesObservableList;



    public void setWelcomeText(Person person){
        welcomeText.setText("Welcome " + person.getName() + "!");
    }

    /**
     * A method with function for the cancel button in FX.
     * It will close the stage if we click on cancel button.
     *
     * @param event
     */
    public void cancelButtonOnAction(javafx.event.ActionEvent event) {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    /**
     * A method which includes the functions for the back button.
     * When we click on back button the stage in current class will go back to start stage.
     * @param event
     * @throws Exception
     */
    public void backToLoginButtonOnAction(ActionEvent event) throws Exception {
        main.start(main.getStage());
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File imageLogoFile = new File("Images/shieldShoeLogo.jpg");
        Image imageLogo = new Image(imageLogoFile.toURI().toString());
        labelImage.setImage(imageLogo);

        addPersonToObservableList();
        fillPersonTableColumns();

    }




    public void addPersonToObservableList(){
        PersonDAO personDAO = new PersonDAOImpl();
        List <Person> personList = new ArrayList<Person>();
        for(Person p: personDAO.selectPersonList()){
            if (p.getRole().equals("Customer")){
                personList.add(p);
            }
        }


        personObservableList= FXCollections.observableArrayList(personList);
    }




    public void fillPersonTableColumns(){

        p_idColumn.setCellValueFactory(new PropertyValueFactory<Person, Integer>("id"));
        p_nameColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("name"));
        p_familyColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("family"));
        p_usernameColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("userName"));
        p_ageColumn.setCellValueFactory(new PropertyValueFactory<Person, Integer>("age"));
        p_addressColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("address"));
        p_phoneNumberColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("phone"));

        p_selectColumn.setCellValueFactory(new PropertyValueFactory<Person, Boolean>("selectable"));
        p_selectColumn.setCellFactory(CheckBoxTableCell.forTableColumn(p_selectColumn));

        CheckBox select_all = new CheckBox();
        select_all.selectedProperty().addListener(new ChangeListener<Boolean>() {
            public void changed(ObservableValue<? extends Boolean> ov,
                                Boolean old_val, Boolean new_val) {
                if (new_val) {
                    for (Person p : personObservableList) {
                        p.setSelectable(true);
                    }

                } else {
                    for (Person p : personObservableList) {
                        p.setSelectable(false);
                    }
                }


            }
        });
        p_selectColumn.setGraphic(select_all);
        p_selectColumn.setEditable(true);
        personTable.setEditable(true);

        personTable.setItems(personObservableList);
    }


    public void addShoesToObservableList(){
        ShoeDAO shoeDAO = new ShoeDAOImpl();
        List<Shoe> shoesList = shoeDAO.selectShoes();
        shoesObservableList = FXCollections.observableArrayList(shoesList);
    }

    public void fillShoeTableColumn(){
        sh_idColumn.setCellValueFactory(new PropertyValueFactory<Shoe, Integer>("id"));
        sh_nameColumn.setCellValueFactory(new PropertyValueFactory<Shoe,String>("name"));
        sh_colorColumn.setCellValueFactory(new PropertyValueFactory<Shoe, String>("color"));
        sh_typeColumn.setCellValueFactory(new PropertyValueFactory<Shoe, String>("type"));
        sh_brandColumn.setCellValueFactory(new PropertyValueFactory<Shoe, String>("brand"));
        sh_sizeColumn.setCellValueFactory(new PropertyValueFactory<Shoe,Integer>("size"));
        sh_priseColumn.setCellValueFactory(new PropertyValueFactory<Shoe, Double>("prise"));
        sh_selectColumn.setCellValueFactory(new PropertyValueFactory<Shoe, Boolean>("selectable"));
        sh_selectColumn.setCellFactory(CheckBoxTableCell.forTableColumn(sh_selectColumn));

        CheckBox select_all = new CheckBox();
        select_all.selectedProperty().addListener(new ChangeListener<Boolean>() {
            public void changed(ObservableValue<? extends Boolean> ov,
                                Boolean old_val, Boolean new_val) {
                if (new_val) {
                    for (Shoe sh : shoesObservableList) {
                        sh.setSelectable(true);
                    }

                } else {
                    for (Shoe sh : shoesObservableList) {
                        sh.setSelectable(false);
                    }
                }


            }
        });
        sh_selectColumn.setGraphic(select_all);
        sh_selectColumn.setEditable(true);
        shoeTable.setEditable(true);


    }

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

    public void editShoesButtonOnAction(ActionEvent event) {
    }

    public void editPersonsButtonOnAction(ActionEvent event) {
    }
}
