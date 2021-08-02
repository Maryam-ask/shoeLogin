package com.model.to;

/**
 * Created by Maryam Askari
 * Date: 5/19/2021
 * Time: 11:43 AM
 * Project: IntelliJ IDEA
 */
public class Person {

    private int id;
    private String name;
    private String family;
    private String userName;
    private String password;
    private String address;
    private String phone;
    private int age;
    private String role;

    public Person(){}

    public Person(String name, String family, String userName, String password, String address, String phone, int age, String role) {
        this.name = name;
        this.family = family;
        this.userName = userName;
        this.password = password;
        this.address = address;
        this.phone = phone;
        this.age = age;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
