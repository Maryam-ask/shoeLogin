package com.model.to;


import javafx.beans.property.*;

/**
 * Created by Maryam Askari
 * Date: 5/31/2021
 * Time: 12:35 PM
 * Project: IntelliJ IDEA
 */
public class PersonProperty {

    private final IntegerProperty id = new SimpleIntegerProperty();
    private final StringProperty name = new SimpleStringProperty();
    private final StringProperty family = new SimpleStringProperty();
    private final StringProperty userName = new SimpleStringProperty();
    private final StringProperty password = new SimpleStringProperty();
    private final StringProperty address = new SimpleStringProperty();
    private final StringProperty phone = new SimpleStringProperty();
    private final IntegerProperty age = new SimpleIntegerProperty();

    public int getId() {
        return idProperty().get();
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        idProperty().set(id);
    }

    public String getName() {
        return nameProperty().get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        nameProperty().set(name);
    }

    public String getFamily() {
        return familyProperty().get();
    }

    public StringProperty familyProperty() {
        return family;
    }

    public void setFamily(String family) {
        familyProperty().set(family);
    }

    public String getUserName() {
        return userNameProperty().get();
    }

    public StringProperty userNameProperty() {
        return userName;
    }

    public void setUserName(String userName) {
        userNameProperty().set(userName);
    }

    public String getPassword() {
        return passwordProperty().get();
    }

    public StringProperty passwordProperty() {
        return password;
    }

    public void setPassword(String password) {
        passwordProperty().set(password);
    }

    public String getAddress() {
        return addressProperty().get();
    }

    public StringProperty addressProperty() {
        return address;
    }

    public void setAddress(String address) {
        addressProperty().set(address);
    }

    public String getPhone() {
        return phoneProperty().get();
    }

    public StringProperty phoneProperty() {
        return phone;
    }

    public void setPhone(String phone) {
        phoneProperty().set(phone);
    }

    public int getAge() {
        return ageProperty().get();
    }

    public IntegerProperty ageProperty() {
        return age;
    }

    public void setAge(int age) {
        ageProperty().set(age);
    }
}
